package Model;

import java.util.ArrayList;

public class Map {
    private ArrayList<Terrain> terrains;
    private ArrayList<DefaultCity> defaultCities;





    ////methods////
    public Map()
    {
        terrains = new ArrayList<>();
        defaultCities = new ArrayList<>();


    }



    public void addTerrain(Terrain terrain)
    {
        terrains.add(terrain);
    }



    public void addDefaultCity(DefaultCity city)
    {
        defaultCities.add(city);
        getTerrainFromCoordinates(city.coordinates).setTerritory(true);

        Coordinates landCoordinates1 = new Coordinates(city.coordinates.getX(), city.coordinates.getY() + 2, city.coordinates.getZ());
        Coordinates landCoordinates2 = new Coordinates(city.coordinates.getX() + 1, city.coordinates.getY() + 1, city.coordinates.getZ());
        Coordinates landCoordinates3 = new Coordinates(city.coordinates.getX() + 1, city.coordinates.getY() - 1, city.coordinates.getZ());
        Coordinates landCoordinates4 = new Coordinates(city.coordinates.getX(), city.coordinates.getY() - 2, city.coordinates.getZ());
        Coordinates landCoordinates5 = new Coordinates(city.coordinates.getX() - 1, city.coordinates.getY() + 1, city.coordinates.getZ());
        Coordinates landCoordinates6 = new Coordinates(city.coordinates.getX() - 1, city.coordinates.getY() - 1, city.coordinates.getZ());

        addDefaultCityLand(city, landCoordinates1);
        addDefaultCityLand(city, landCoordinates2);
        addDefaultCityLand(city, landCoordinates3);
        addDefaultCityLand(city, landCoordinates4);
        addDefaultCityLand(city, landCoordinates5);
        addDefaultCityLand(city, landCoordinates6);
    }



    private void addDefaultCityLand(DefaultCity city, Coordinates coordinates)
    {
        if (!getTerrainFromCoordinates(coordinates).getIsTerritory()){
            city.addLand(getTerrainFromCoordinates(coordinates));
            getTerrainFromCoordinates(coordinates).setTerritory(true);
        }
    }



    //getters
    public int getNumberOfDefaultCities()
    {
        return defaultCities.size();
    }


    public Terrain getTerrainFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0 ; i < terrains.size(); i++){
            if (coordinates.getX() == terrains.get(i).getCenterCoordinates().getX() && coordinates.getY() == terrains.get(i).getCenterCoordinates().getY()){
                return terrains.get(i);
            }
        }

        return null;
    }



    //setters
}
