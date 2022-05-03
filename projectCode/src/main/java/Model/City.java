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
    private ArrayList<Building> buildings;
    private ArrayList<Terrain> landsOwned;
    private int goldPerTurn;
    private boolean isCapital;
    private ArrayList<City> connectedCities;
    private boolean isWorking;





    ////methods////
    public City(boolean isCapital, Terrain terrain)
    {
        this.isCapital = isCapital;
        this.coordinates = terrain.getCenterCoordinates();

        this.population = 1;
        this.isUnitInTheCity = false;
        this.buildings = new ArrayList<>();
        this.landsOwned = new ArrayList<>();
        landsOwned.add(terrain);
        terrain.setTerritory(true);
        this.isWorking = false;
        this.maxHealth = 20;

        //TODO:
    }



    public void updateCity()
    {
     //TODO:
    }



    public void addLand(Terrain terrain)
    {
        landsOwned.add(terrain);
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


    public ArrayList<Building> getBuildings() {
        return buildings;
    }


    public ArrayList<Terrain> getLandsOwned() {
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


    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }


    public void setLandsOwned(ArrayList<Terrain> landsOwned) {
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
