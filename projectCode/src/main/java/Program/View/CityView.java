package Program.View;

import Program.Model.Enums.Wonders;
import Program.Model.Models.Building;
import Program.Model.Models.Citizen;
import Program.Model.Models.Coordinates;
import Program.Model.Models.PlayerCity;

public class CityView {





    ////methods////
    public CityView(String cityName)
    {
        System.out.println("you are now controlling city: " + cityName);
    }



    public void showCityStats(PlayerCity city)
    {
        System.out.println("city name: " + city.getCityName());
        System.out.println("city health: " + city.getHealth() + " of " + city.getMaxHealth());
        System.out.println("attack damage: " + city.getAttackDamage());
        System.out.println("population: " + city.getPopulation());

        if (city.isCityStarving()){
            System.out.println("city is starving");
            System.out.println("turns until a citizen dies: " + city.getTurnsUntilACitizenDies());
        }
        else {
            System.out.println("food per turn: " + city.getFood());

            if (city.getFood() != 0) {
                System.out.println("turns until new citizen is born: " + city.getFoodUntilNewCitizen() / city.getFood());
            }
            else {
                System.out.println("there is not enough food for population to grow");
            }
        }

        System.out.println("production per turn: " + city.getProduction());
        System.out.println("gold income: " + city.getGoldPerTurn());
        System.out.println("science: " + city.getScience());

        if (city.isWorkingOnTask()){
            System.out.println("currently working on " + city.getTask().getGameName());
        }
        else {
            System.out.println("city is working on nothing right now");
        }
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showCurrentMenu(String cityName)
    {
        System.out.println("you are now in city menu for " + cityName);
    }



    public void showCitizens(PlayerCity city)
    {
        System.out.println("working citizens: ");

        System.out.println("land workers: ");

        for (int i = 0; i < city.getCitizens().size(); i++){
            if (city.getCitizens().get(i).isWorking() && !city.getCitizens().get(i).isInside()){
                System.out.print((i + 1) + ") worker name: " + city.getCitizens().get(i).getCitizenName());
                System.out.print(", land: coordinates: (" + city.getCitizens().get(i).getCoordinates().getX() + ", " +
                        city.getCitizens().get(i).getCoordinates().getY() + ")");
                System.out.print(", food: " + city.getOwnedLandFromCoordinates(city.getCitizens().get(i).getCoordinates()).getLandFood());
                System.out.print(", production: " + city.getOwnedLandFromCoordinates(city.getCitizens().get(i).getCoordinates()).getLandProduction());
                System.out.print(", gold: " + city.getOwnedLandFromCoordinates(city.getCitizens().get(i).getCoordinates()).getLandGold());
                System.out.println();
            }
        }

        System.out.println("specialists: ");

        for (int i = 0; i < city.getCitizens().size(); i++){
            if (city.getCitizens().get(i).isWorking() && city.getCitizens().get(i).isInside()){
                System.out.print((i + 1) + ") worker name: " + city.getCitizens().get(i).getCitizenName());
                System.out.print(", building: " + city.getCitizens().get(i).getBuilding().getGameName());
                System.out.print(", food: " + city.getCitizens().get(i).getBuilding().getFoodPerTurn());
                System.out.print(", production: " + city.getCitizens().get(i).getBuilding().getProductionPerTurn());
                System.out.print(", gold: " + city.getCitizens().get(i).getBuilding().getGoldPerTurn());
                System.out.print(", gold effect: " + city.getCitizens().get(i).getBuilding().getGoldEffect());
                System.out.print(", science: " + city.getCitizens().get(i).getBuilding().getSciencePerTwoCitizen());
                System.out.print(", science effect: " + city.getCitizens().get(i).getBuilding().getScienceEffect());
                System.out.println();
            }
        }

        System.out.println("free citizens: ");

        for (int i = 0; i < city.getCitizens().size(); i++){
            if (!city.getCitizens().get(i).isWorking()) {
                System.out.println((i + 1) + ") worker name: " + city.getCitizens().get(i).getCitizenName());
            }
        }

    }



    public void showMaximumCitizens()
    {
        System.out.println("city population is at its limit and can not be increased");
    }



    public void showNewCitizen(Citizen citizen)
    {
        System.out.println(citizen.getCitizenName() + "is now a new citizen of the city");

        if (citizen.isWorking() && citizen.isInside()) {
            System.out.println(citizen.getCitizenName() + "now is working in " + citizen.getBuilding().getGameName());
        }
        else if (citizen.isWorking() && !citizen.isInside()){
            System.out.println(citizen.getCitizenName() + "now is working on the land with (" +
                    citizen.getCoordinates().getX() + ", " + citizen.getCoordinates().getY() + ") coordinates");
        }
        else {
            System.out.println(citizen.getCitizenName() + "is now working on anything right now");
        }
    }



    public void showInvalidBuildingName(String buildingName)
    {
        System.out.println("no building with the name " + buildingName + " exist");
    }



    public void showWorkerIsInBuilding()
    {
        System.out.println("there is already a specialist working in this building.");
    }



    public void showWorkerIsInLand()
    {
        System.out.println("there is already a worker working in this land");
    }



    public void showWorkerIsAssignedToBuilding(Building building)
    {
        System.out.println("a new specialist is now working in " + building.getGameName());
    }



    public void showWorkerIsAssignedToLand(Coordinates coordinates)
    {
        System.out.println("a new worker is now working on the land with (" + coordinates.getX() + ", " + coordinates.getY() + ") coordinates");
    }



    public void showNoAvailableWorker()
    {
        System.out.println("there is now available citizen to do the job right now");
    }



    public void showConfirmationForFiringCitizen()
    {
        System.out.println("are you sure you want to fire this citizen?");
    }



    public void showNoWorker()
    {
        System.out.println("there is no citizen working here");
    }



    public void showBuildings(PlayerCity city, boolean builtFlag, boolean availableFlag, boolean unavailableFlag)
    {
        if (!builtFlag && !availableFlag && !unavailableFlag){
            showBuiltBuildings(city);
            showAvailableBuildings(city);
            showUnavailableBuildings(city);
            return;
        }

        if (builtFlag){
            showBuiltBuildings(city);
        }

        if (availableFlag){
            showAvailableBuildings(city);
        }

        if (unavailableFlag){
            showUnavailableBuildings(city);
        }
    }



    private void showBuiltBuildings(PlayerCity city)
    {
        System.out.println("city buildings: ");

        for (int i = 0; i < city.getBuildings().size(); i++){
            System.out.print((i + 1) + ") " + city.getBuildings().get(i).getGameName() + ":");

            if (city.getBuildings().get(i).getFoodPerTurn() != 0) {
                System.out.print(", food: " + city.getBuildings().get(i).getFoodPerTurn());
            }

            if (city.getBuildings().get(i).getProductionPerTurn() != 0) {
                System.out.print(", production: " + city.getBuildings().get(i).getProductionPerTurn());
            }

            if (city.getBuildings().get(i).getGoldPerTurn() != 0) {
                System.out.print(", gold per turn: " + city.getBuildings().get(i).getGoldPerTurn());
            }

            if (city.getBuildings().get(i).getGoldEffect() != 0) {
                System.out.print(", gold effect: " + city.getBuildings().get(i).getGoldEffect() + "%");
            }

            if (city.getBuildings().get(i).getSciencePerTwoCitizen() != 0) {
                System.out.print(", science: " + city.getBuildings().get(i).getSciencePerTwoCitizen());
            }

            if (city.getBuildings().get(i).getScienceEffect() != 0) {
                System.out.print(", science effect: " + city.getBuildings().get(i).getFoodPerTurn() + "%");
            }

            if (city.getBuildings().get(i).getDefenceEffect() != 0) {
                System.out.print(", defence effect: " + city.getBuildings().get(i).getDefenceEffect() + "%");
            }

            if (city.getBuildings().get(i).getUnitsXpBonus() != 0) {
                System.out.print(", xp bonus: " + city.getBuildings().get(i).getUnitsXpBonus());
            }

            System.out.println(", era: " + city.getBuildings().get(i).getEra());
        }
    }



    private void showAvailableBuildings(PlayerCity city)
    {
        System.out.println("available buildings to build in city: ");

        for (int i = 0; i < city.getAvailableBuildings().size(); i++){
            System.out.print((i + 1) + ") " + city.getAvailableBuildings().get(i).getGameName());

            showBuilding(city.getAvailableBuildings().get(i));

            System.out.print(", cost: " + city.getAvailableBuildings().get(i).getCost());
            if (city.getProduction() != 0) {
                System.out.print(", turns needed: " + city.getAvailableBuildings().get(i).getProductionNeeded() / city.getProduction());
            }
            else {
                System.out.println("there is not enough production in the city to build this building");
            }

            System.out.println(", era: " + city.getAvailableBuildings().get(i).getEra());
        }
    }



    private void showUnavailableBuildings(PlayerCity city)
    {
        System.out.println("unavailable buildings: ");

        for (int i = 0; i < city.getUnavailableBuildings().size(); i++){
            System.out.print((i + 1) + ") " + city.getUnavailableBuildings().get(i).getGameName());

            if (city.getUnavailableBuildings().get(i).getRequiredBuildings() != null) {
                System.out.print(", building needed: " + city.getUnavailableBuildings().get(i).getRequiredBuildings().building.getGameName());
            }
            else {
                System.out.print("does not need any building");
            }

            System.out.print(", cost: " + city.getUnavailableBuildings().get(i).getCost());

            if (city.getProduction() != 0) {
                System.out.print(", turns needed: " + city.getUnavailableBuildings().get(i).getProductionNeeded() / city.getProduction());
            }
            else {
                System.out.println("there is not enough production in the city to build this building");
            }
            System.out.println(", era: " + city.getUnavailableBuildings().get(i).getEra());
        }
    }



    private void showBuilding(Building building)
    {
        if (building.getFoodPerTurn() != 0) {
            System.out.print(", food: " + building.getFoodPerTurn());
        }

        if (building.getProductionPerTurn() != 0) {
            System.out.print(", production: " + building.getProductionPerTurn());
        }

        if (building.getGoldPerTurn() != 0) {
            System.out.print(", gold per turn: " + building.getGoldPerTurn());
        }

        if (building.getGoldEffect() != 0) {
            System.out.print(", gold effect: " + building.getGoldEffect() + "%");
        }

        if (building.getSciencePerTwoCitizen() != 0) {
            System.out.print(", science: " + building.getSciencePerTwoCitizen());
        }

        if (building.getScienceEffect() != 0) {
            System.out.print(", science effect: " + building.getFoodPerTurn() + "%");
        }

        if (building.getDefenceEffect() != 0) {
            System.out.print(", defence effect: " + building.getDefenceEffect() + "%");
        }

        if (building.getUnitsXpBonus() != 0) {
            System.out.print(", xp bonus: " + building.getUnitsXpBonus());
        }
    }



    public void showWonders(PlayerCity city, boolean buildFlag, boolean availableFlag)
    {
        if (buildFlag) {
            System.out.println("city wonders: ");

            if (city.getWonders().size() == 0) {
                System.out.println("there is no wonder in this city");
                return;
            }

            for (int i = 0; i < city.getWonders().size(); i++) {
                System.out.print((i + 1) + ") " + city.getWonders().get(i).wonder.getGameName());

                showWonder(city.getWonders().get(i));
                System.out.println();
            }
        }

        if (availableFlag) {
            System.out.println("available wonders: ");

            for (int i = 0; i < Wonders.values().length; i++) {
                if (Wonders.values()[i].wonder.isIsfree() && city.getOwner().getTechnologies().contains(Wonders.values()[i].wonder.getTechnologyNeeded())) {
                    System.out.print((i + 1) + ") " + Wonders.values()[i].wonder.getGameName());

                    showWonder(Wonders.values()[i]);

                    if (city.getProduction() != 0) {
                        System.out.println("turns needed: " + Wonders.values()[i].wonder.getProductionNeeded() / city.getProduction());
                    } else {
                        System.out.println("there is not enough production to build this wonder right now");
                    }
                }
            }
        }

        if (!availableFlag && !buildFlag){
            System.out.println("city wonders: ");

            if (city.getWonders().size() == 0) {
                System.out.println("there is no wonder in this city");
                return;
            }

            for (int i = 0; i < city.getWonders().size(); i++) {
                System.out.print((i + 1) + ") " + city.getWonders().get(i).wonder.getGameName());

                showWonder(city.getWonders().get(i));
                System.out.println();
            }

            System.out.println("available wonders: ");

            for (int i = 0; i < Wonders.values().length; i++) {
                if (Wonders.values()[i].wonder.isIsfree() && city.getOwner().getTechnologies().contains(Wonders.values()[i].wonder.getTechnologyNeeded())) {
                    System.out.print((i + 1) + ") " + Wonders.values()[i].wonder.getGameName());

                    showWonder(Wonders.values()[i]);

                    if (city.getProduction() != 0) {
                        System.out.println("turns needed: " + Wonders.values()[i].wonder.getProductionNeeded() / city.getProduction());
                    } else {
                        System.out.println("there is not enough production to build this wonder right now");
                    }
                }
            }
        }
    }



    private void showWonder(Wonders wonder)
    {
        if (wonder.wonder.getFoodPerTurn() != 0){
            System.out.print(", food: " + wonder.wonder.getFoodPerTurn());
        }

        if (wonder.wonder.getFoodEffect() != 0){
            System.out.print(", food effect: " + wonder.wonder.getFoodEffect());
        }

        if (wonder.wonder.getProductionPerTurn() != 0){
            System.out.print(", production: " + wonder.wonder.getProductionPerTurn());
        }

        if (wonder.wonder.getProductionEffect() != 0){
            System.out.print(", production effect: " + wonder.wonder.getProductionEffect());
        }

        if (wonder.wonder.getGoldPerTurn() != 0){
            System.out.print(", gold: " + wonder.wonder.getGoldPerTurn());
        }

        if (wonder.wonder.getGoldEffect() != 0){
            System.out.print(", gold effect: " + wonder.wonder.getGoldEffect());
        }

        if (wonder.wonder.getHappinessPerTurn() != 0){
            System.out.print(", happiness: " + wonder.wonder.getHappinessPerTurn());
        }

        if (wonder.wonder.getHappinessEffect() != 0){
            System.out.print(", happiness: " + wonder.wonder.getHappinessEffect());
        }
    }



    public void showLands(PlayerCity city)
    {
        System.out.println("city lands: ");

        for (int i = 0; i < city.getLandsOwned().size(); i++){
            System.out.print((i + 1) + ") coordinates: " + city.getLandsOwned().get(i).getTerrain().getCenterCoordinates().toString());

            System.out.print(", land type: " + city.getLandsOwned().get(i).getTerrain().getType());

            if (city.getLandsOwned().get(i).getTerrain().isHasProperty()){
                System.out.print(", land property: " + city.getLandsOwned().get(i).getTerrain().getProperty().getType());
            }

            if (city.getLandsOwned().get(i).getTerrain().isHasResource()){
                System.out.print(", resource: " + city.getLandsOwned().get(i).getTerrain().getResourceTypeString());
            }

            System.out.print(", food: " + city.getLandsOwned().get(i).getLandFood());
            System.out.print(", production: " + city.getLandsOwned().get(i).getLandProduction());
            System.out.print(", gold: " + city.getLandsOwned().get(i).getLandGold());

            if (city.getLandsOwned().get(i).getImprovement() != null) {
                System.out.print(", improvement: " + city.getLandsOwned().get(i).getImprovement());
            }
            else {
                System.out.println(", improvement: this land does not have any improvement");
            }
        }
    }



    public void showInvalidUnitName(String unitName)
    {
        System.out.println("there is no unit called: " + unitName);
    }



    public void showInvalidWonderName(String name)
    {
        System.out.println("there is no wonder called: " + name);
    }



    public void showTaskConfirmation(String taskName, int productionNeeded, int cityProduction)
    {
        if (cityProduction != 0) {
            System.out.println("city is already working on making " + taskName + " and will be finished in " + productionNeeded / cityProduction + " turns");
        }
        else {
            System.out.println("city is already working on making " + taskName + " and can not be finished with current city production");
        }

        System.out.println("are you sure you want to cancel it?");
    }



    public void showUnitOnHoldConfirmation(String unitName)
    {
        System.out.println("there is a " + unitName + " waiting for free space. if you start this task, last task will get cancelled");
        System.out.println("are you sure you want to continue?");
    }



    public void showNeedAnotherBuilding(String buildingName)
    {
        System.out.println("you have to build " + buildingName + " first to make this building");
    }



    public void showCityHasBuilding()
    {
        System.out.println("this city already has this building");
    }



    public void showUnavailableWonder()
    {
        System.out.println("this wonder is unavailable");
    }



    public void showFoodFocus(PlayerCity city)
    {
        System.out.println("city is now focusing on food.");
        System.out.println("stats: ");
        showCityStats(city);
    }



    public void showGoldFocus(PlayerCity city)
    {
        System.out.println("city is now focusing on gold.");
        System.out.println("stats: ");
        showCityStats(city);
    }



    public void showProductionFocus(PlayerCity city)
    {
        System.out.println("city is now focusing on production.");
        System.out.println("stats: ");
        showCityStats(city);
    }



    public void showNoTaskForFinishingCheat()
    {
        System.out.println("the city is not working on anything right now");
    }



    public void showTaskFinished(String taskName)
    {
        System.out.println("making " + taskName + " has been finished");
    }



    public void showBuildingFinished(String buildingName)
    {
        System.out.println("building of " + buildingName + " is now finished");
    }



    public void showNoResource(String resourceName)
    {
        System.out.println("you need " + resourceName + " to be able to build this unit in this city.");
    }



    public void showUnitIsInCityCoordinates()
    {
        System.out.println("can not make unit while another unit is in city tile");
    }



    public void showNotEnoughMoney(int goldNeeded)
    {
        System.out.println("you do not have enough money. you need " + goldNeeded + " more gold");
    }



    public void showCoordinatesOutOfBoundaries(String axis)
    {
        System.out.println("the value for " + axis + " is out of boundary");
    }



    public void showMustBeNextToBorder()
    {
        System.out.println("land must be near the border");
    }



    public void showMaximumBorder()
    {
        System.out.println("this city is at its maximum land limit and can not grow larger");
    }



    public void showAlreadyOwnLand()
    {
        System.out.println("this land already belongs to this city");
    }



    public void showOwnedByAnotherCity()
    {
        System.out.println("this lands is already owned by another city");
    }
}

