package Program.Model;

import java.util.ArrayList;

public class Map {
    private ArrayList<Terrain> terrains;
    private ArrayList<PlayerCity> playerCities;
    private ArrayList<DefaultCity> defaultCities;
    private ArrayList<BarbarianBase> barbarianBases;
    private ArrayList<NaturalWonder> naturalWanders;
    private ArrayList<Ruin> ruins;
    private ArrayList<River> rivers;
    private MapSizes size;
    private UnitList units;





    ////methods////
    public Map(MapSizes size)
    {
        terrains = new ArrayList<>();
        playerCities = new ArrayList<>();
        defaultCities = new ArrayList<>();
        barbarianBases = new ArrayList<>();
        naturalWanders = new ArrayList<>();
        ruins = new ArrayList<>();
        rivers = new ArrayList<>();
        this.size = size;
        units = new UnitList();


    }



    public Map(Map map){
        this.terrains = map.terrains;
        this.defaultCities = map.defaultCities;
        this.barbarianBases = map.barbarianBases;
        this.naturalWanders = map.naturalWanders;
        this.ruins = map.ruins;
        this.rivers = map.rivers;
        this.size = map.size;
        this.units = map.units;
        this.playerCities = map.playerCities;
    }



    public void addTerrain(Terrain terrain)
    {
        terrains.add(terrain);
    }



    public void addDefaultCity(DefaultCity city)
    {
        defaultCities.add(city);
        getTerrainFromCoordinates(city.getCoordinates()).setTerritory(true, city.getColor().toString());

        Coordinates landCoordinates1 = new Coordinates(city.getCoordinates().getX(), city.getCoordinates().getY() + 2, city.getCoordinates().getZ());
        Coordinates landCoordinates2 = new Coordinates(city.getCoordinates().getX() + 1, city.getCoordinates().getY() + 1, city.getCoordinates().getZ());
        Coordinates landCoordinates3 = new Coordinates(city.getCoordinates().getX() + 1, city.getCoordinates().getY() - 1, city.getCoordinates().getZ());
        Coordinates landCoordinates4 = new Coordinates(city.getCoordinates().getX(), city.getCoordinates().getY() - 2, city.getCoordinates().getZ());
        Coordinates landCoordinates5 = new Coordinates(city.getCoordinates().getX() - 1, city.getCoordinates().getY() + 1, city.getCoordinates().getZ());
        Coordinates landCoordinates6 = new Coordinates(city.getCoordinates().getX() - 1, city.getCoordinates().getY() - 1, city.getCoordinates().getZ());

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
            CityLand land = new CityLand(getTerrainFromCoordinates(coordinates));
            city.addLand(land);
            getTerrainFromCoordinates(coordinates).setTerritory(true, city.getColor().toString());
        }
    }



    public void addBarbarianBase(BarbarianBase barbarianBase)
    {
        barbarianBases.add(barbarianBase);
    }



    public void addNaturalWander(NaturalWonder naturalWander)
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



    public void addPlayerCity(PlayerCity city)
    {
        playerCities.add(city);
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


    public UnitList getUnits()
    {
        return units;
    }


    public DefaultCity getDefaultCityFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < defaultCities.size(); i++){
            if (coordinates.equals(defaultCities.get(i).getCoordinates())){
                return defaultCities.get(i);
            }
        }

        return null;
    }


    public PlayerCity getPlayerCityFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < playerCities.size(); i++){
            if (coordinates.equals(playerCities.get(i).getCoordinates())){
                return playerCities.get(i);
            }
        }

        return null;
    }


    public boolean isUnitInTheCoordinates(Coordinates coordinates){
        if (units.getWorkerFromCoordinates(coordinates) != null || units.getSettlerFromCoordinates(coordinates) != null ||
        units.getMeleeMilitaryUnitFromCoordinates(coordinates) != null || units.getRangedMilitaryUnitFromCoordinates(coordinates) != null
        || units.getHeavyRangedMilitaryUnitFromCoordinates(coordinates) != null){
            return true;
        }

        return false;
    }



    public ArrayList<Coordinates> getUnavailableTerrainsForMoving()
    {
        ArrayList<Coordinates> unavailableCoordinates = new ArrayList<>();

        for (int i = 0; i < terrains.size(); i++){
            if (!terrains.get(i).isCanBeCrossed()){
                unavailableCoordinates.add(terrains.get(i).getCenterCoordinates());
            }
        }

        return unavailableCoordinates;
    }



    //setters
}
