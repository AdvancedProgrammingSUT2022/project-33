package Controller;

import Model.*;
import View.SettlerView;

import java.util.regex.Pattern;

public class SettlerController {
    private Settler settler;
    private SettlerView view;






    ////methods////
    public SettlerController(Settler settler)
    {
        this.settler = settler;
        this.view = new SettlerView();

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.SHOW_STATS)){
                view.showStats(settler);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.MOVE_UNIT1) ||
                    UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.MOVE_UNIT2)){
                moveUnit(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.CREATE_CITY)){
                if (createCity()){
                    return;
                }
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.FINISH)){
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

        if (x < 0 || x > settler.getOwner().getMap().getMapSize()){
            view.showCoordinatesOutOfBoundary(x, "x", settler.getOwner().getMap().getMapSize());
            return;
        }
        else if (y < 0 || y > settler.getOwner().getMap().getMapSize()){
            view.showCoordinatesOutOfBoundary(y, "y", settler.getOwner().getMap().getMapSize());
            return;
        }

        settler.setDestinationCoordinates(new Coordinates(x, y, 0), settler.getOwner().getMap().getUnavailableTerrainsForMoving(), settler.getOwner().getMap().getMapSize());
        settler.moveUnit(settler.getOwner().getMap().getOriginalMap().getTerrains(),
                settler.getOwner().getPlayerUnits().getSettlers(), settler.getOwner().getPlayerUnits().getWorkers(), view);
    }



    private boolean createCity()
    {
        return settler.createCity(view, this);
    }



    public String getCityName()
    {
        view.showEnterCityName();

        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.CANCEL)){
                return null;
            }
            else if (isCityNameValid(input)){
                return input;
            }
            else {
                view.showCityNameIsNotValid();
            }
        }
    }



    private boolean isCityNameValid(String input)
    {
        if (input.length() > 15 || input.length() < 3){
            return false;
        }

        return UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.VALID_CITY_NAME);
    }
}