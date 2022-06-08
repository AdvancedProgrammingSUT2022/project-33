package Program.Model.Models;

import Program.Model.Enums.*;

import java.util.ArrayList;
import java.util.Random;

public class MapMaker {
    private Map map;
    private GeneralBiomes generalBiome;
    private MapSizes mapSize;
    private Biomes biomes;
    private ArrayList<Coordinates> unavailableCoordinates;





    ////methods////
    public MapMaker(Map map, GeneralBiomes generalBiome, MapSizes mapSize)
    {
        this.map = map;
        this.generalBiome = generalBiome;
        this.mapSize = mapSize;
        unavailableCoordinates = new ArrayList<>();

        switch (generalBiome){
            case DESERT:
                biomes = new Biomes(BiomesDefaultChance.DESERT.biomesChance);
                break;
            case FOREST:
                biomes = new Biomes(BiomesDefaultChance.FOREST.biomesChance);
                break;
            case GRASSLAND:
                biomes = new Biomes(BiomesDefaultChance.GRASSLAND.biomesChance);
                break;
            case TUNDRA:
                biomes = new Biomes(BiomesDefaultChance.TUNDRA.biomesChance);
                break;
            case FRESHWATER:
                biomes = new Biomes(BiomesDefaultChance.FRESHWATER.biomesChance);
                break;
        }

        generateTerrains();
        buildDefaultCities();
        placeBarbarians();
        placeRuinsAndNaturalWanders();
        digRiver();
    }



    private void generateTerrains()
    {
        for (int j = 0; j < mapSize.size; j++){
            for (int i = 0; i < mapSize.size; i++){
                Coordinates coordinates = new Coordinates(i, j, 0);

                if (isCoordinateAvailable(coordinates)) {
                    TerrainTypes type = getBiomeType(coordinates);
                    Terrain terrain = new Terrain(type.toString(), type.land);
                    terrain.setCoordinates(coordinates);
                    map.addTerrain(terrain);
                    unavailableCoordinates.add(coordinates);
                    callSpreadFunctions(terrain, coordinates.getX(), coordinates.getY(), coordinates.getZ(), 100, 100);
                }
            }
        }
    }



    private TerrainTypes getBiomeType(Coordinates coordinates)
    {
        double y = coordinates.getY();
        double yColdnessEffect = 1 + ((Math.pow(1 - y / mapSize.size * 2, 10)) * 400);
        int snowChance = biomes.getSnowChance() * (int) yColdnessEffect;
        Biomes temporaryBiomes = new Biomes(biomes);
        temporaryBiomes.setSnowChance(snowChance);


        Random rand = new Random();
        int maxChance = temporaryBiomes.getMaxChance();
        int randomBiomeChance = rand.nextInt(maxChance);

        ArrayList<Integer> chancesList = temporaryBiomes.getChancesList();

        for (int i = 0; i < chancesList.size(); i++){
            if (randomBiomeChance < chancesList.get(i)){
                switch (i){
                    case 0:
                        return TerrainTypes.DESERT;
                    case 1:
                        return TerrainTypes.GRASSLAND;
                    case 2:
                        return TerrainTypes.HILLS;
                    case 3:
                        return TerrainTypes.MOUNTAIN;
                    case 4:
                        return TerrainTypes.OCEAN;
                    case 5:
                        return TerrainTypes.PLAIN;
                    case 6:
                        return TerrainTypes.SNOW;
                    case 7:
                        return TerrainTypes.TUNDRA;
                }
            }

            randomBiomeChance -= chancesList.get(i);
        }

        return TerrainTypes.OCEAN;
    }



    private boolean isCoordinateAvailable(Coordinates coordinates)
    {
        for (int i = 0; i < unavailableCoordinates.size(); i++){
            if (unavailableCoordinates.get(i).getX() == coordinates.getX() && unavailableCoordinates.get(i).getY() == coordinates.getY()){
                return false;
            }
        }

        return true;
    }



    private void spreadTerrain(Terrain terrain, Coordinates coordinates, int chance, int maxChance)
    {
        chance /= 3;

        if (!isCoordinateAvailable(coordinates)){
             return;
        }

        Random rand = new Random();
        int chanceNumber = rand.nextInt(maxChance);


        if (!terrain.getType().equals(TerrainTypes.SNOW.toString())) {
            double y = coordinates.getY();
            double yColdnessEffect = 1 + ((Math.pow(1 - y / mapSize.size * 2, 10)) * 2000);
            int snowChance = biomes.getSnowChance() * (int) yColdnessEffect;

            chanceNumber = rand.nextInt(maxChance + snowChance);
        }


        if (chanceNumber < chance){
            Terrain newTerrain = new Terrain(terrain.getType(), terrain);
            newTerrain.setCoordinates(coordinates);
            map.addTerrain(newTerrain);
            unavailableCoordinates.add(coordinates);

            int mainX = coordinates.getX();
            int mainY = coordinates.getY();
            int mainZ = coordinates.getZ();

            callSpreadFunctions(newTerrain, mainX, mainY, mainZ, chance, maxChance);
        }
        else if (!terrain.getType().equals(TerrainTypes.SNOW.toString()) && chanceNumber > maxChance){
            Terrain newTerrain = new Terrain(TerrainTypes.SNOW.toString(), TerrainTypes.SNOW.land);
            newTerrain.setCoordinates(coordinates);
            map.addTerrain(newTerrain);
            unavailableCoordinates.add(coordinates);
        }
    }



    private void callSpreadFunctions(Terrain newTerrain, int mainX, int mainY, int mainZ, int chance, int maxChance)
    {
        if (mainY + 1 < mapSize.size) {
            spreadTerrain(newTerrain, new Coordinates(mainX, mainY + 1, mainZ), chance, maxChance);
        }
        if (mainX + 1 < mapSize.size) {
            spreadTerrain(newTerrain, new Coordinates(mainX + 1, mainY, mainZ), chance, maxChance);
        }
        if (mainX - 1 >= 0){
            spreadTerrain(newTerrain, new Coordinates(mainX - 1, mainY, mainZ), chance, maxChance);
        }

        if (mainY - 1 >= 0){
            spreadTerrain(newTerrain, new Coordinates(mainX, mainY = 1, mainZ), chance, maxChance);

            if (mainX + 1 < mapSize.size) {
                spreadTerrain(newTerrain, new Coordinates(mainX + 1, mainY - 1, mainZ), chance, maxChance);
            }
            if (mainX - 1 >= 0){
                spreadTerrain(newTerrain, new Coordinates(mainX - 1, mainY - 1 , mainZ), chance, maxChance);
            }
        }
    }



    private void buildDefaultCities()
    {
        Random rand = new Random();
        int maxCityNumber = (mapSize.size - 10) / 5 + 1;
        int chance = (rand.nextInt(maxCityNumber) + maxCityNumber) / 2;
        int maxChance = mapSize.size * mapSize.size;

        for (int j = 0; j < mapSize.size; j++){
            for (int i = 0; i < mapSize.size; i++){
                if (rand.nextInt(maxChance) < chance){
                    Coordinates cityCoordinates = new Coordinates(i, j, 0);

                    if (!map.getTerrainFromCoordinates(cityCoordinates).getIsTerritory()) {
                        DefaultCity newDefaultCity = new DefaultCity(new CityLand(map.getTerrainFromCoordinates(cityCoordinates))
                                , NonPlayerColors.values()[map.getNumberOfDefaultCities()], DefaultCityNames.values()[map.getNumberOfDefaultCities()]);
                        map.addDefaultCity(newDefaultCity);
                        newDefaultCity.addCityLand(giveBordersToDefaultCity(cityCoordinates, newDefaultCity.getColor().toString()));

                        if (map.getNumberOfDefaultCities() > maxCityNumber) {
                            return;
                        }
                    }
                }
            }
        }
    }



    private void placeBarbarians()
    {
        Random rand = new Random();
        int chance = 2;
        int maxChance = 100;

        for (int j = 0; j < mapSize.size; j++){
            for (int i = 0; i < mapSize.size; i++){
                if (rand.nextInt(maxChance) < chance){
                    Coordinates baseCoordinates = new Coordinates(i, j, 0);

                    if (!map.getTerrainFromCoordinates(baseCoordinates).getIsTerritory()) {
                        BarbarianBase barbarianBase = new BarbarianBase(baseCoordinates);
                        map.addBarbarianBase(barbarianBase);
                        map.getTerrainFromCoordinates(baseCoordinates).setTerritory(true, "Barbarian");
                    }
                }
            }
        }
    }



    private void placeRuinsAndNaturalWanders()
    {
        Random rand = new Random();
        int naturalWanderChance = 1;
        int naturalWanderMaxChance = 300;

        for (int j = 0; j < mapSize.size; j++){
            for (int i = 0; i < mapSize.size; i++){
                Coordinates coordinates = new Coordinates(i, j, 0);

                if (rand.nextInt(naturalWanderMaxChance) < naturalWanderChance && !map.getTerrainFromCoordinates(coordinates).getIsTerritory()){
                    map.getTerrainFromCoordinates(coordinates).setTerritory(true, "natural wonder");
                    NaturalWonder naturalWander = new NaturalWonder(NaturalWonderTypes.values()[rand.nextInt(NaturalWonderTypes.values().length)], coordinates);
                    map.addNaturalWander(naturalWander);
                }
            }
        }

        int ruinChance = 1;
        int ruinMaxChance = 100;

        for (int j = 0; j < mapSize.size; j++){
            for (int i = 0;i < mapSize.size; i++){
                Coordinates coordinates = new Coordinates(i, j, 0);

                if (rand.nextInt(ruinMaxChance) < ruinChance && !map.getTerrainFromCoordinates(coordinates).getIsTerritory()){
                    map.getTerrainFromCoordinates(coordinates).setTerritory(true, "Ruin");
                    Ruin ruin = new Ruin(coordinates, map.getBarbarianBases(), mapSize.size);
                    map.addRuin(ruin);
                }
            }
        }
    }



    private void digRiver()
    {
        Random rand = new Random();
        int riverChance = 5;

        for (int j = 0; j < mapSize.size; j++){
            for (int i = 0; i < mapSize.size; i++){
                Coordinates coordinates = new Coordinates(i, j, 0);

                if (!getUnavailableRiverCoordinates().contains(coordinates)) {
                    if (map.getTerrainFromCoordinates(coordinates).isHasRiver() && rand.nextInt(100) < 5) {
                        River river = new River(getRiverDirectionByCoordinates(coordinates), coordinates, mapSize.size, getUnavailableRiverCoordinates());
                        map.addRiver(river);
                    } else if (rand.nextInt(200) < riverChance) {
                        River river = new River(coordinates, mapSize.size, getUnavailableRiverCoordinates());
                        map.addRiver(river);
                    }
                }
            }
        }
    }



    private ArrayList<Coordinates> getUnavailableRiverCoordinates()
    {
        ArrayList<Terrain> terrains = map.getTerrains();
        ArrayList<Coordinates> unmovableCoordinates = new ArrayList<>();

        for (int i = 0; i < terrains.size(); i++){
            if (!terrains.get(i).isCanBeCrossed()){
                unmovableCoordinates.add(terrains.get(i).getCenterCoordinates());
            }
        }

        return unmovableCoordinates;
    }



    private ArrayList<CityLand> giveBordersToDefaultCity(Coordinates coordinates, String color)
    {
        int x = coordinates.getX();
        int y = coordinates.getY();
        ArrayList<CityLand> cityLands = new ArrayList<>();

        if (y > 0){
            tryAddingBorder(x, y - 1, cityLands, color);
        }

        if (y < mapSize.size - 1){
            tryAddingBorder(x, y + 1, cityLands, color);
        }

        if (x % 2 == 0){
            if (x > 0){
                tryAddingBorder(x - 1, y, cityLands, color);

                if (y > 0) {
                    tryAddingBorder(x - 1, y - 1, cityLands, color);
                }
            }

            if (x < mapSize.size - 1){
                tryAddingBorder(x + 1, y, cityLands, color);

                if (y > 0){
                    tryAddingBorder(x + 1, y - 1, cityLands, color);
                }
            }
        }
        else {
            if (x > 0){
                tryAddingBorder(x - 1, y, cityLands, color);

                if (y < mapSize.size - 1) {
                    tryAddingBorder(x - 1, y + 1, cityLands, color);
                }
            }

            if (x < mapSize.size - 1){
                tryAddingBorder(x + 1, y, cityLands, color);

                if (y < mapSize.size - 1){
                    tryAddingBorder(x + 1, y + 1, cityLands, color);
                }
            }
        }

        return cityLands;
    }



    private void tryAddingBorder(int x, int y, ArrayList<CityLand> lands, String color)
    {
        Coordinates coordinates = new Coordinates(x, y, 0);

        if (map.getTerrainFromCoordinates(coordinates) != null && !map.getTerrainFromCoordinates(coordinates).getIsTerritory()){
            Terrain terrain = map.getTerrainFromCoordinates(coordinates);
            CityLand cityLand = new CityLand(terrain);
            lands.add(cityLand);
            terrain.setTerritory(true, color);
        }
    }



    private TileDirections getRiverDirectionByCoordinates(Coordinates checkingCoordinates)
    {
        for (River river: map.getRivers()){
            for (Coordinates coordinates: river.getRiverCoordinates()){
                if (checkingCoordinates.equals(coordinates)){
                    return river.getMainDirection();
                }
            }
        }

        return TileDirections.DOWN;
    }
}
