package Model;

import java.util.ArrayList;

public class City {
    private Coordinates coordinates;
    private int population;
    private int food;
    private int production;
    private int happiness;
    private int health;
    private int maxHealth;
    private boolean isUnitInTheCity;
    private int attackDamage;
    private ArrayList<BuildingTypes> buildings;
    private ArrayList<CityLand> landsOwned;
    private int goldPerTurn;
    private boolean isCapital;
    private ArrayList<City> connectedCities;
    private boolean isWorking;





    ////methods////
    public City(boolean isCapital, CityLand cityLand)
    {
        this.isCapital = isCapital;
        this.coordinates = cityLand.getTerrain().getCenterCoordinates();

        this.population = 1;
        this.isUnitInTheCity = false;
        this.buildings = new ArrayList<>();
        this.landsOwned = new ArrayList<>();
        landsOwned.add(cityLand);
        cityLand.getTerrain().setTerritory(true);
        this.isWorking = false;
        this.maxHealth = 20;

        //TODO:
    }



    public void updateCity()
    {
        calculateGold();
        calculateFood();
        calculateProduction();
     //TODO:
    }



    public void addLand(CityLand cityLand)
    {
        landsOwned.add(cityLand);
    }



    private void calculateGold()
    {
        int goldIncome = 0;
        double goldIncreasePercentage = 1;

        for (int i = 0; i < getBuildings().size(); i++){
            goldIncome += getBuildings().get(i).building.getGoldPerTurn() - getBuildings().get(i).building.getMaintenance();
            goldIncreasePercentage *= 1 + (double) getBuildings().get(i).building.getGoldEffect() / 100;
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            goldIncome += workableLands.get(i).getLandGold();
        }

        goldIncome *= goldIncreasePercentage;

        setGoldPerTurn(goldIncome);
    }



    private void calculateFood()
    {
        int foodRemaining = 0;

        for (int i = 0; i < getBuildings().size(); i++){
            foodRemaining += getBuildings().get(i).building.getFoodPerTurn();
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            foodRemaining += workableLands.get(i).getLandFood();
        }

        foodRemaining -= population * 2;

        setFood(foodRemaining);
    }



    private void calculateProduction()
    {
        int production  = 0;

        for (int i = 0; i < getBuildings().size(); i++){
            production += getBuildings().get(i).building.getProductionPerTurn();
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            production += workableLands.get(i).getLandProduction();
        }

        setProduction(production);
    }



    //getters
    public Coordinates getCoordinates() {
        return coordinates;
    }


    public int getPopulation() {
        return population;
    }


    public int getFood() {
        return food;
    }


    public int getProduction() {
        return production;
    }


    public int getHappiness() {
        return happiness;
    }


    public int getHealth() {
        return health;
    }


    public int getMaxHealth() {
        return maxHealth;
    }


    public boolean isUnitInTheCity() {
        return isUnitInTheCity;
    }


    public int getAttackDamage() {
        return attackDamage;
    }


    public ArrayList<BuildingTypes> getBuildings() {
        return buildings;
    }


    public ArrayList<CityLand> getLandsOwned() {
        return landsOwned;
    }


    public int getGoldPerTurn() {
        return goldPerTurn;
    }


    public boolean isCapital() {
        return isCapital;
    }


    public ArrayList<City> getConnectedCities() {
        return connectedCities;
    }


    public boolean isWorking() {
        return isWorking;
    }


    public ArrayList<CityLand> getWorkableLands()
    {
        ArrayList<CityLand> workableLands = new ArrayList<>();

        for (int j = -2; j < 2; j++){
            for (int i = Math.abs(j) - 2; i < 2 - Math.abs(j); i++){
                if (getCityLandFromCoordinates(new Coordinates(coordinates.getX() + i, coordinates.getY() + j, 0)) != null){
                    workableLands.add(getCityLandFromCoordinates(new Coordinates(coordinates.getX() + i, coordinates.getY() + j, 0)));
                }
            }
        }

        return workableLands;
    }



    private CityLand getCityLandFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < landsOwned.size(); i++){
            if (landsOwned.get(i).getTerrain().getCenterCoordinates().equals(coordinates)){
                return landsOwned.get(i);
            }
        }

        return null;
    }


    //setters
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setPopulation(int population) {
        this.population = population;
    }


    public void setFood(int food) {
        this.food = food;
    }


    public void setProduction(int production) {
        this.production = production;
    }


    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


    public void setUnitInTheCity(boolean unitInTheCity) {
        isUnitInTheCity = unitInTheCity;
    }


    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }


    public void setBuildings(ArrayList<BuildingTypes> buildings) {
        this.buildings = buildings;
    }


    public void setLandsOwned(ArrayList<CityLand> landsOwned) {
        this.landsOwned = landsOwned;
    }


    public void setGoldPerTurn(int goldPerTurn) {
        this.goldPerTurn = goldPerTurn;
    }


    public void setCapital(boolean capital) {
        isCapital = capital;
    }


    public void setConnectedCities(ArrayList<City> connectedCities) {
        this.connectedCities = connectedCities;
    }


    public void setWorking(boolean working) {
        isWorking = working;
    }
}
