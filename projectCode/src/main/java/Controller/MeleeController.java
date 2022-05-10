package Controller;

import Model.Coordinates;
import Model.MatchingStrings;
import Model.MeleeMilitaryUnit;
import Model.UserInput;
import View.MeleeView;

public class MeleeController {
    MeleeMilitaryUnit unit;
    MeleeView view;





    ////methods////
    public MeleeController(MeleeMilitaryUnit unit)
    {
        this.unit = unit;
        this.view = new MeleeView(unit.getGameName());

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.MeleeUnitStrings.SHOW_STATS)){
                view.showStats(unit);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.MeleeUnitStrings.MOVE_UNIT1) ||
                    UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.MeleeUnitStrings.MOVE_UNIT2)){
                moveUnit(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.MeleeUnitStrings.SHOW_MENU)){
                view.showCurrentMenu(unit.getGameName());
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.MeleeUnitStrings.FINISH)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void moveUnit(String input)
    {
        String XString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.UnitsControllerStrings.Settler.X_VALUE).split(" ")[1];
        String YString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.UnitsControllerStrings.Settler.Y_VALUE).split(" ")[1];

        int x = Integer.parseInt(XString);
        int y = Integer.parseInt(YString);

        if (x < 0 || x > unit.getOwner().getMap().getMapSize()){
            view.showCoordinatesOutOfBoundary(x, "x", unit.getOwner().getMap().getMapSize());
            return;
        }
        else if (y < 0 || y > unit.getOwner().getMap().getMapSize()){
            view.showCoordinatesOutOfBoundary(y, "y", unit.getOwner().getMap().getMapSize());
            return;
        }

        if (isDestinationOccupied(new Coordinates(x, y, 0))){
            view.showOccupiedCoordinates(true, new Coordinates(x, y, 0));
            return;
        }

        unit.setDestinationCoordinates(new Coordinates(x, y, 0), unit.getOwner().getMap().getUnavailableTerrainsForMoving(), unit.getOwner().getMap().getMapSize());
        unit.moveUnit(unit.getOwner().getMap().getOriginalMap().getTerrains(), unit.getOwner().getMap(), view);
    }



    private boolean isDestinationOccupied(Coordinates coordinates)
    {
        return unit.getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(coordinates) != null ||
                unit.getOwner().getMap().getUnits().getRangedMilitaryUnitFromCoordinates(coordinates) != null ||
                unit.getOwner().getMap().getUnits().getHeavyRangedMilitaryUnitFromCoordinates(coordinates) != null;
    }
}
