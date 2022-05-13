package Model;

import java.util.Random;

public class Citizen {
    private String citizenName;
    private City city;
    private boolean isWorking;
    private boolean isInside;
    private Coordinates coordinates;
    private Building building;





    ////methods////
    public Citizen(City city)
    {
        this.city = city;
        this.isInside = false;
        this.isWorking = false;

        Random rand = new Random();
        this.citizenName = CitizenNames.values()[rand.nextInt(CitizenNames.values().length)].name;

        findWorkForFood();
    }



    public void findWorkForFood()
    {
        int maxFood = 0;
        Coordinates bestCoordinates = city.getCoordinates();

        for (int i = 0; i < city.getWorkableLandsWithoutCentralLand().size(); i++){
            if (!city.isCitizenWorkingInLand(city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates())){
                if (city.getWorkableLandsWithoutCentralLand().get(i).getLandFood() > maxFood){
                    maxFood = city.getWorkableLandsWithoutCentralLand().get(i).getLandFood();
                    bestCoordinates = city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates();
                }
            }
        }

        if (maxFood != 0){
            isWorking = true;
            isInside = false;
            coordinates = bestCoordinates;
            return;
        }

        Building bestBuilding = null;

        for (int i = 0; i < city.getBuildings().size(); i++){
            if (!city.isCitizenWorkingInBuilding(city.getBuildings().get(i))){
                if (city.getBuildings().get(i).getFoodPerTurn() > maxFood){
                    maxFood = city.getBuildings().get(i).getFoodPerTurn();
                    bestBuilding = city.getBuildings().get(i);
                }
            }
        }

        if (maxFood != 0 && bestBuilding != null){
            building = bestBuilding;
            isWorking =true;
            isInside = true;
            return;
        }

        findAnyWork();
    }



    public void findWorkForProduction()
    {
        int maxProduction = 0;
        Coordinates bestCoordinates = city.getCoordinates();

        for (int i = 0; i < city.getWorkableLandsWithoutCentralLand().size(); i++){
            if (!city.isCitizenWorkingInLand(city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates())){
                if (city.getWorkableLandsWithoutCentralLand().get(i).getLandProduction() > maxProduction){
                    maxProduction = city.getWorkableLandsWithoutCentralLand().get(i).getLandProduction();
                    bestCoordinates = city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates();
                }
            }
        }

        if (maxProduction != 0){
            isWorking = true;
            isInside = false;
            coordinates = bestCoordinates;
            return;
        }

        Building bestBuilding = null;

        for (int i = 0; i < city.getBuildings().size(); i++){
            if (!city.isCitizenWorkingInBuilding(city.getBuildings().get(i))){
                if (city.getBuildings().get(i).getProductionPerTurn() > maxProduction){
                    maxProduction = city.getBuildings().get(i).getProductionPerTurn();
                    bestBuilding = city.getBuildings().get(i);
                }
            }
        }

        if (maxProduction != 0 && bestBuilding != null){
            building = bestBuilding;
            isWorking =true;
            isInside = true;
            return;
        }
        
        findAnyWork();
    }



    public void findWorkForGold()
    {
        int maxGold = 0;
        Coordinates bestCoordinates = city.getCoordinates();

        for (int i = 0; i < city.getWorkableLandsWithoutCentralLand().size(); i++){
            if (!city.isCitizenWorkingInLand(city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates())){
                if (city.getWorkableLandsWithoutCentralLand().get(i).getLandGold() > maxGold){
                    maxGold = city.getWorkableLandsWithoutCentralLand().get(i).getLandGold();
                    bestCoordinates = city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates();
                }
            }
        }

        if (maxGold != 0){
            isWorking = true;
            isInside = false;
            coordinates = bestCoordinates;
            return;
        }

        Building bestBuilding = null;
        Building bestBuildingBonus = null;
        int maxGoldBonus = 0;


        for (int i = 0; i < city.getBuildings().size(); i++){
            if (!city.isCitizenWorkingInBuilding(city.getBuildings().get(i))){
                if (city.getBuildings().get(i).getGoldPerTurn() > maxGold){
                    maxGold = city.getBuildings().get(i).getGoldPerTurn();
                    bestBuilding = city.getBuildings().get(i);
                }
                else if (city.getBuildings().get(i).getGoldEffect() > maxGoldBonus){
                    maxGoldBonus = city.getBuildings().get(i).getGoldEffect();
                    bestBuildingBonus = city.getBuildings().get(i);
                }
            }
        }

        if (bestBuilding != null && bestBuildingBonus == null){
            isWorking = true;
            isInside = true;
            building = bestBuilding;
            return;
        }
        else  if (bestBuilding == null && bestBuildingBonus != null){
            isWorking = true;
            isInside = true;
            building = bestBuildingBonus;
            return;
        }
        else if (bestBuilding != null && bestBuildingBonus != null){
            isWorking = true;
            isInside =true;

            if (maxGold + city.getGoldPerTurn() > (100 + maxGoldBonus) * city.getGoldPerTurn() / 100 ){
                building = bestBuilding;
            }
            else {
                building = bestBuildingBonus;
            }

            return;
        }


        findAnyWork();
    }
    
    
    
    private void findAnyWork()
    {
        for (int i = 0; i < city.getWorkableLandsWithoutCentralLand().size(); i++){
            if (!city.isCitizenWorkingInLand(city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates())){
                coordinates = city.getWorkableLandsWithoutCentralLand().get(i).getTerrain().getCenterCoordinates();
                isWorking = true;
                isInside = false;
                return;
            }
        }

        for (int i = 0; i < city.getBuildings().size(); i++){
            if (!city.isCitizenWorkingInBuilding(city.getBuildings().get(i))){
                building = city.getBuildings().get(i);
                isWorking = true;
                isInside = true;
                return;
            }
        }

        isWorking = false;
    }



    //getters
    public boolean isWorking() {
        return isWorking;
    }


    public boolean isInside() {
        return isInside;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }


    public Building getBuilding() {
        return building;
    }


    public String getCitizenName() {
        return citizenName;
    }



    //setters
    public void setWorking(boolean working) {
        isWorking = working;
    }


    public void setInside(boolean inside) {
        isInside = inside;
    }


    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setBuilding(Building building) {
        this.building = building;
    }
}
