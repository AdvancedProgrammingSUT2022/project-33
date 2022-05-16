package Controller;

import Model.*;
import View.MeleeView;

public class MeleeController {
    private MeleeMilitaryUnit unit;
    private MeleeView view;





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

            if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.SHOW_STATS)){
                view.showStats(unit);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.MOVE_UNIT1) ||
                    UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.MOVE_UNIT2)){
                moveUnit(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.MeleeUnitStrings.FORTIFY)){
                fortify();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.SLEEP)){
                sleep();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.ALERT)){
                alert();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.HEAL)){
                heal();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.SHOW_MENU)){
                view.showCurrentMenu(unit.getGameName());
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.REMOVE_UNIT)){
                if (removeUnit()){
                    return;
                }
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.FINISH)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void moveUnit(String input)
    {
        String XString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.UnitsControllerStrings.AllUnits.X_VALUE).split(" ")[1];
        String YString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.UnitsControllerStrings.AllUnits.Y_VALUE).split(" ")[1];

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

        if (unit.setDestinationCoordinates(new Coordinates(x, y, 0),
                unit.getOwner().getMap().getUnavailableTerrainsForMoving(), unit.getOwner().getMap().getMapSize())){
            view.showInaccessible();
            return;
        }

        unit.moveUnit(unit.getOwner().getMap().getOriginalMap().getTerrains(), unit.getOwner().getMap(), view);
    }



    private boolean isDestinationOccupied(Coordinates coordinates)
    {
        return unit.getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(coordinates) != null ||
                unit.getOwner().getMap().getUnits().getRangedMilitaryUnitFromCoordinates(coordinates) != null ||
                unit.getOwner().getMap().getUnits().getHeavyRangedMilitaryUnitFromCoordinates(coordinates) != null;
    }



    private boolean removeUnit()
    {
        view.showCheckRemovingMessage();

        while (true) {
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (input.equalsIgnoreCase("yes")){
                unit.removeUnit();
                view.showUnitRemoved();
                return true;
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.AllUnits.CANCEL) || input.equalsIgnoreCase("no")) {
                return false;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void fortify()
    {
        if (unit.isFortifying()){
            view.showAlreadyFortifying(2 - unit.getTurnsAfterStartingToFortify());
            return;
        }

        if (unit.isFortified()){
            view.showAlreadyFortified();
            return;
        }

        if (unit.getOwner().getGold() < unit.getPrice() / 10){
            view.showNotEnoughGoldToFortify(unit.getPrice() / 10 - unit.getOwner().getGold());
            return;
        }

        unit.getOwner().decreaseGold(unit.getPrice() / 10);
        unit.setFortifying(true);
        view.showUnitIsFortifying(unit.getGameName());
    }



    private void sleep()
    {
        if (unit.isSleep()){
            view.showUnitIsAlreadySleeping();
            return;
        }

        unit.setSleep(true);
        view.showUnitIsNowSleeping();
    }



    private void alert()
    {
        if (unit.isOnAlert()){
            view.showUnitIsAlreadyOnAlert();
            return;
        }

        unit.setOnAlert(true);
        view.showUnitIsNowOnAlert();
    }



    private void heal()
    {
        if (unit.isHealing()){
            view.showUnitIsAlreadyHealing();
            return;
        }

        if (unit.getHealth() == unit.getMaxHealth()){
            view.showUnitHealthIsFull();
            return;
        }

        unit.setHealing(true);
        view.showUnitIsHealing(unit.getTurnsNeededToFullyHeal());
    }
}
