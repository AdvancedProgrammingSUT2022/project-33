package View;

import Model.Building;
import Model.Citizen;
import Model.Coordinates;
import Model.PlayerCity;

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
            System.out.println("turns until new citizen is born: " + city.getFoodUntilNewCitizen() / city.getFood());
        }

        System.out.println("production per turn: " + city.getProduction());
        System.out.println("gold income: " + city.getGoldPerTurn());

        if (city.isWorkingOnTask()){
            System.out.println("currently working on " + city.getTaskGameName());
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
                System.out.print((i + 1) + "worker name: " + city.getCitizens().get(i).getCitizenName());
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
                System.out.print((i + 1) + "worker name: " + city.getCitizens().get(i).getCitizenName());
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
            System.out.println((i + 1) + "worker name: " + city.getCitizens().get(i).getCitizenName());
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
}

