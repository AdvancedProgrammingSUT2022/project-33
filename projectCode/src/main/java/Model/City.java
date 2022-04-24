package Model;

import java.util.ArrayList;

public class City {
    Coordinates coordinates;
    int population;
    int food;
    int production;
    int happiness;
    int health;
    int maxHealth;
    boolean isUnitInTheCity;
    int attackDamage;
    ArrayList<Building> buildings;
    ArrayList<Terrain> landsOwned;
    int goldPerTurn;
    boolean isCapital;
    ArrayList<City> connectedCities;
    boolean isWorking;





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
        this.isWorking = false;

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
}
