package Controller;

import Model.*;
import View.CityView;

import java.util.ArrayList;
import java.util.Arrays;


public class CityController {
    Player player;
    PlayerCity city;
    CityView view;





    ////methods////
    public CityController(Player player, PlayerCity city)
    {
        this.city = city;
        this.player = player;
        this.view = new CityView(city.getCityName());

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.STATS)){
                view.showCityStats(city);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.SHOW_CITIZENS)){
                view.showCitizens(city);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.ADD_CITIZEN_CHEAT)){
                addCitizenCheat();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.ASSIGN_WORK_BUILDING)){
                assignWorkerToBuilding(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.ASSIGN_WORK_LAND1) ||
                    UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.ASSIGN_WORK_LAND2)){
                assignWorkerToLand(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.FIRE_CITIZEN_BUILDING)){
                fireWorkerFromBuilding(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.FIRE_CITIZEN_LAND1) ||
                    UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.FIRE_CITIZEN_LAND2)){
                fireWorkerFromLand(input);
            }
            else if (UserInput.doesMatchMultipleRegex(input, MatchingStrings.CityControllerStrings.SHOW_BUILDINGS.toString(),
                    new ArrayList<>(Arrays.asList(MatchingStrings.CityControllerStrings.BUILT_BUILDINGS_FLAG,
                            MatchingStrings.CityControllerStrings.AVAILABLE_FLAG, MatchingStrings.CityControllerStrings.UNAVAILABLE_FLAG)))){
                showBuildings(input);
            }
            else if (UserInput.doesMatchMultipleRegex(input, MatchingStrings.CityControllerStrings.SHOW_WONDERS.toString(),
                    new ArrayList<>(Arrays.asList(MatchingStrings.CityControllerStrings.AVAILABLE_FLAG, MatchingStrings.CityControllerStrings.BUILT_BUILDINGS)))){
                showWonders(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.SHOW_LANDS)){
                view.showLands(city);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.SHOW_MENU)){
                view.showCurrentMenu(city.getCityName());
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.BACK)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void addCitizenCheat()
    {
        if (city.getCitizens().size() >= 40){
            view.showMaximumCitizens();
            return;
        }

        city.addCitizenCheat();
        view.showNewCitizen(city.getCitizens().get(city.getCitizens().size() - 1));
    }



    private void assignWorkerToBuilding(String input)
    {
        String workBuilding = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.Building);

        for (int i = 0; i < city.getBuildings().size(); i++){
            if (city.getBuildings().get(i).getGameName().equalsIgnoreCase(workBuilding)){
                if (city.isWorkerInBuilding(city.getBuildings().get(i))){
                   view.showWorkerIsInBuilding();
                }
                else if (!city.isWorkerFree()){
                    view.showNoAvailableWorker();
                }
                else {
                    city.assignWorkerToBuilding(city.getBuildings().get(i));
                    view.showWorkerIsAssignedToBuilding(city.getBuildings().get(i));
                }

                return;
            }
        }

        view.showInvalidBuildingName(workBuilding);
    }



    private void assignWorkerToLand(String input)
    {
        int xValue = Integer.parseInt(UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.CityControllerStrings.X_VALUE).split(" ")[1]);
        int yValue = Integer.parseInt(UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.CityControllerStrings.Y_VALUE).split(" ")[1]);

        Coordinates coordinates = new Coordinates(xValue, yValue, 0);

        for (int i = 0; i < city.getWorkableLandsWithoutCentralLand().size(); i++){
            if (city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates().equals(coordinates)){
                if (city.isWorkerInLand(coordinates)){
                    view.showWorkerIsInLand();
                }
                else if (!city.isWorkerFree()){
                    view.showNoAvailableWorker();
                }
                else {
                    city.assignWorkerToLand(coordinates);
                    view.showWorkerIsAssignedToLand(coordinates);
                }

                return;
            }
        }

    }



    private void fireWorkerFromBuilding(String input)
    {
        String workBuilding = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.Building);

        for (int i = 0; i < city.getBuildings().size(); i++){
            if (city.getBuildings().get(i).getGameName().equalsIgnoreCase(workBuilding)){
                if (city.isWorkerInBuilding(city.getBuildings().get(i)) && getConfirmationForFiringWorker()){
                    city.fireWorkerFromBuilding(city.getBuildings().get(i));
                }
                else {
                    view.showNoWorker();
                }

                return;
            }
        }

        view.showInvalidBuildingName(workBuilding);
    }



    private void fireWorkerFromLand(String input)
    {
        int xValue = Integer.parseInt(UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.CityControllerStrings.X_VALUE).split(" ")[1]);
        int yValue = Integer.parseInt(UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.CityControllerStrings.Y_VALUE).split(" ")[1]);

        Coordinates coordinates = new Coordinates(xValue, yValue, 0);

        for (int i = 0; i < city.getWorkableLandsWithoutCentralLand().size(); i++){
            if (city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates().equals(coordinates)){
                if (city.isWorkerInLand(coordinates) && getConfirmationForFiringWorker()){
                    city.fireWorkerFromLand(coordinates);
                }
                else {
                    view.showNoWorker();

                }

                return;
            }
        }

    }



    private boolean getConfirmationForFiringWorker()
    {
        view.showConfirmationForFiringCitizen();

        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (input.equalsIgnoreCase("yes")){
                return true;
            }
            else if (input.equals("no")){
                return false;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void showBuildings(String input)
    {
        boolean builtFlag = MatchingStrings.CityControllerStrings.BUILT_BUILDINGS.matcher(input).find();
        boolean availableFlag = MatchingStrings.CityControllerStrings.AVAILABLE.matcher(input).find();
        boolean unavailableFlag = MatchingStrings.CityControllerStrings.UNAVAILABLE.matcher(input).find();

        view.showBuildings(city, builtFlag, availableFlag, unavailableFlag);
    }



    private void showWonders(String input)
    {
        boolean builtFlag = MatchingStrings.CityControllerStrings.BUILT_BUILDINGS.matcher(input).find();
        boolean availableFlag = MatchingStrings.CityControllerStrings.AVAILABLE.matcher(input).find();

        view.showWonders(city, builtFlag, availableFlag);
    }
}
