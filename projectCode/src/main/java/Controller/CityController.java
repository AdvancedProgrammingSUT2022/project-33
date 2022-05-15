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
                    new ArrayList<>(Arrays.asList(MatchingStrings.CityControllerStrings.AVAILABLE_FLAG, MatchingStrings.CityControllerStrings.BUILT_BUILDINGS_FLAG)))){
                showWonders(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.SHOW_LANDS)){
                view.showLands(city);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.START_TASK_UNIT)){
                makeUnit(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.START_TASK_BUILDING)){
                buildBuilding(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.START_TASK_Wonder)){
                buildWonder(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.FOOD_FOCUS)){
                focusFood();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.GOLD_FOCUS)){
                focusGold();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.PRODUCTION_FOCUS)){
                focusProduction();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.TASK_FINISHING_CHEAT)){
                finishTaskCheat();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.PURCHASE_BUILDING)){
                purchaseBuilding(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.BUILDING_CHEAT)){
                BuildingCheat(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.PURCHASE_UNIT)){
                purchaseUnit(input);
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
        String workBuilding = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.BUILDING);

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
        String workBuilding = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.BUILDING);

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

        return confirmation();
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



    private void makeUnit(String input)
    {
        String unitGameName = input.substring(4);
        CityTask task = new CityTask(unitGameName, true, false, false);

        if (!task.isTaskValid() || (task.getUnitNeededTechnology() != null && !player.getTechnologies().contains(task.getUnitNeededTechnology()))){
            view.showInvalidUnitName(unitGameName);
            return;
        }

        if (task.getResourceNeeded() != null && !city.getOwner().getStrategicResources().contains(task.getResourceNeeded())){
            view.showNoResource(task.getResourceNeeded().name());
            return;
        }

        if (city.isWorkingOnTask() && !getTaskConfirmation()){
            return;
        }

        if (city.isOhHold() && !getTaskConfirmationToRemoveOnHoldUnit()){
            return;
        }

        city.setOhHold(false);
        city.setTask(task);
    }



    private void buildBuilding(String input)
    {
        String buildingGameName = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.BUILDING);
        CityTask task = new CityTask(buildingGameName, false, true, false);

        if (!task.isTaskValid() || (task.getBuildingNeededTechnology() != null && !player.getTechnologies().contains(task.getBuildingNeededTechnology()))){
            view.showInvalidBuildingName(buildingGameName);
            return;
        }

        if (task.getBuildingNeededBuildings() != null && !city.doesContainBuildingType(task.getBuildingNeededBuildings())){
            view.showNeedAnotherBuilding(task.getBuildingNeededBuildings().building.getGameName());
        }

        if (city.doesContainBuildingType(task.getBuilding())){
            view.showCityHasBuilding();
        }

        if (city.isWorkingOnTask() && !getTaskConfirmation()){
            return;
        }

        if (city.isOhHold() && !getTaskConfirmationToRemoveOnHoldUnit()){
            return;
        }

        city.setTask(task);
    }



    private void buildWonder(String input)
    {
        String wonderGameName = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.WONDER);
        CityTask task = new CityTask(wonderGameName, false, false, true);

        if (!task.isTaskValid() || (task.getWonderNeededTechnology() != null && !player.getTechnologies().contains(task.getBuildingNeededTechnology()))){
            view.showInvalidWonderName(wonderGameName);
            return;
        }

        if (!task.getWonder().wonder.isIsfree()){
            view.showUnavailableWonder();
        }

        if (city.isWorkingOnTask() && !getTaskConfirmation()){
            return;
        }

        if (city.isOhHold() && !getTaskConfirmationToRemoveOnHoldUnit()){
            return;
        }

        city.setTask(task);
    }



    private boolean getTaskConfirmation()
    {
        view.showTaskConfirmation(city.getTask().getGameName(), city.getTask().getProductionNeeded(), city.getProduction());

        return confirmation();
    }



    private boolean getTaskConfirmationToRemoveOnHoldUnit()
    {
        view.showUnitOnHoldConfirmation(city.getTask().getGameName());

        return confirmation();
    }



    private boolean confirmation()
    {
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



    private void focusFood()
    {
        city.setFocusFood();
        view.showFoodFocus(city);
    }



    private void focusGold()
    {
        city.setFocusGold();
        view.showGoldFocus(city);
    }



    private void focusProduction()
    {
        city.setFocusProduction();
        view.showProductionFocus(city);
    }



    private void finishTaskCheat()
    {
        if (!city.isWorkingOnTask()){
            view.showNoTaskForFinishingCheat();
            return;
        }

        city.finishTask();
    view.showTaskFinished(city.getTask().getGameName());
    }



    private void purchaseBuilding(String input)
    {
        String buildingName = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.BUILDING);

        if (getBuildingFromName(buildingName) == null || (getBuildingFromName(buildingName).building.getTechnologyNeeded() != null &&
                        city.getOwner().getTechnologies().contains(getBuildingFromName(buildingName).building.getTechnologyNeeded()))){
            view.showInvalidBuildingName(buildingName);
            return;
        }

        if (!city.doesContainBuildingType(getBuildingFromName(buildingName).building.getRequiredBuildings())){
            view.showNeedAnotherBuilding(getBuildingFromName(buildingName).building.getRequiredBuildings().building.getGameName());
            return;
        }

        if (city.doesContainBuildingType(getBuildingFromName(buildingName))){
            view.showCityHasBuilding();
            return;
        }

        if (city.getOwner().getGold() < getBuildingFromName(buildingName).building.getCost()){
            view.showNotEnoughMoney(getBuildingFromName(buildingName).building.getCost() - city.getOwner().getGold());
            return;
        }

        city.addBuildingCheat(getBuildingFromName(buildingName));
        view.showBuildingFinished(getBuildingFromName(buildingName).building.getGameName());
    }



    private void BuildingCheat(String input)
    {
        String buildingName = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.BUILDING);

        if (getBuildingFromName(buildingName) == null || (getBuildingFromName(buildingName).building.getTechnologyNeeded() != null &&
                        city.getOwner().getTechnologies().contains(getBuildingFromName(buildingName).building.getTechnologyNeeded()))){
            view.showInvalidBuildingName(buildingName);
            return;
        }

        if (city.doesContainBuildingType(getBuildingFromName(buildingName))){
            view.showCityHasBuilding();
            return;
        }

        city.addBuildingCheat(getBuildingFromName(buildingName));
        view.showBuildingFinished(getBuildingFromName(buildingName).building.getGameName());
    }



    private BuildingTypes getBuildingFromName(String name)
    {
        for (int i = 0; i < BuildingTypes.values().length; i++){
            if (name.equalsIgnoreCase(BuildingTypes.values()[i].building.getGameName())){
                return BuildingTypes.values()[i];
            }
        }

        return null;
    }



    private void purchaseUnit(String input)
    {
        String unitName = UserInput.getSpecificInputFromPatternWithOneSpace(input, MatchingStrings.CityControllerStrings.UNIT);

        CityTask temporarilyTask = new CityTask(unitName, true, false, false);

        if (!temporarilyTask.isTaskValid() || (temporarilyTask.getUnitNeededTechnology() != null &&
                !player.getTechnologies().contains(temporarilyTask.getUnitNeededTechnology()))){
            view.showInvalidUnitName(unitName);
            return;
        }

        if (temporarilyTask.getResourceNeeded() != null && !city.getOwner().getStrategicResources().contains(temporarilyTask.getResourceNeeded())){
            view.showNoResource(temporarilyTask.getResourceNeeded().name());
            return;
        }

        if (city.getOwner().getGold() < temporarilyTask.getGoldNeeded()){
            view.showNotEnoughMoney(temporarilyTask.getGoldNeeded() - city.getOwner().getGold());
            return;
        }

        if (!city.getOwner().isCoordinatesFreeForNewUnit(city.getCoordinates(),
                !(unitName.equalsIgnoreCase("Settler") || unitName.equalsIgnoreCase("Worker")))){
            view.showUnitIsInCityCoordinates();
            return;
        }


        finishUnitTaskCheat(temporarilyTask);
    }



    private void finishUnitTaskCheat(CityTask task)
    {
        if (task.isMeleeUnit()){
            MeleeMilitaryUnit unit = new MeleeMilitaryUnit(task.getMeleeUnit().unit, city.getCoordinates(), city.getOwner().getColor(), city.getOwner());
            city.getOwner().getPlayerUnits().addMeleeMilitaryUnit(unit);
        }
        else if (task.isRangedUnit()){
            RangedMilitaryUnit unit = new RangedMilitaryUnit(task.getRangedUnit().unit, city.getCoordinates(), city.getOwner().getColor(), city.getOwner());

            city.getOwner().getPlayerUnits().addRangedMilitaryUnit(unit);
        }
        else if (task.isHeavyUnit()){
            HeavyRangedMilitaryUnits unit = new HeavyRangedMilitaryUnits(city.getTask().getHeavyUnit().unit, city.getCoordinates(), city.getOwner().getColor(), city.getOwner());

            city.getOwner().getPlayerUnits().addHeavyRangedMilitaryUnit(unit);
        }
        else if (task.getGameName().equalsIgnoreCase("Settler")){
            Settler unit = new Settler(city.getCoordinates(), city.getOwner().getColor(), city.getOwner());

            city.getOwner().getPlayerUnits().addSettler(unit);
        }
        else if (task.getGameName().equalsIgnoreCase("Worker")){
            Worker unit = new Worker(city.getCoordinates(), city.getOwner().getColor(), city.getOwner());

            city.getOwner().getPlayerUnits().addWorker(unit);
        }
    }
}
