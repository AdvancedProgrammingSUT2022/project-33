package Model;

import java.util.ArrayList;

public class Map {
    private ArrayList<Terrain> terrains;
    private ArrayList<DefaultCity> defaultCities;
    private ArrayList<BarbarianBase> barbarianBases;
    private ArrayList<NaturalWander> naturalWanders;
    private ArrayList<Ruin> ruins;
    private ArrayList<River> rivers;
    private MapSizes size;





    ////methods////
    public Map(MapSizes size)
    {
        terrains = new ArrayList<>();
        defaultCities = new ArrayList<>();
        barbarianBases = new ArrayList<>();
        naturalWanders = new ArrayList<>();
        ruins = new ArrayList<>();
        rivers = new ArrayList<>();
        this.size = size;


    }



    public Map(Map map){
        this.terrains = map.terrains;
        this.defaultCities = map.defaultCities;
        this.barbarianBases = map.barbarianBases;
        this.naturalWanders = map.naturalWanders;
        this.ruins = map.ruins;
        this.rivers = map.rivers;
        this.size = map.size;
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



    public void addBarbarianBase(BarbarianBase barbarianBase)
    {
        barbarianBases.add(barbarianBase);
    }



    public void addNaturalWander(NaturalWander naturalWander)
    {
        naturalWanders.add(naturalWander);
    }



    public void addRuin(Ruin ruin)
    {
        ruins.add(ruin);
    }



    public void addRiver(River river)
    {
        if (river != null) {
            rivers.add(river);
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

    public ArrayList<BarbarianBase> getBarbarianBases()
    {
        return barbarianBases;
    }


    public ArrayList<Terrain> getTerrains()
    {
        return terrains;
    }


    public int getMapSize()
    {
        return size.size;
    }



    //setters
}
