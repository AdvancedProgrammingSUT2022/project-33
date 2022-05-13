package Controller;

import Model.*;
import View.CityView;


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
                //TODO:
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
                else {
                    city.assignWorkerToBuilding(city.getBuildings().get(i));
                    view.showWorkerIsAssignedToBuilding(city.getBuildings().get(i));
                }

                return;
            }
        }

        view.showInvalidBuildingName(workBuilding);
    }



    private boolean getConfirmationForFiringWorkerFromBuilding()
    {
        view.showWorkerIsInBuilding();

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




}
