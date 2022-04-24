package Model;

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

        for (int j = 0; j < mapSize.size; j++){
            for (int i = 0; i < mapSize.size; i++){
                String name;

                for (int k = 0; k < map.terrains.size(); k++){
                    if (map.terrains.get(k).getCenterCoordinates().getX() == i && map.terrains.get(k).getCenterCoordinates().getY() == j){
                        System.out.print(map.terrains.get(k).getType().toString().charAt(0) + " ");
                        break;
                    }
                }
            }

            System.out.println(" ");
        }
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
        if (mainY + 2 < mapSize.size) {
            spreadTerrain(newTerrain, new Coordinates(mainX, mainY + 2, mainZ), chance, maxChance);
        }
        if (mainY + 1 < mapSize.size) {
            if (mainX + 1 < mapSize.size) {
                spreadTerrain(newTerrain, new Coordinates(mainX + 1, mainY + 1, mainZ), chance, maxChance);
            }
            else {
                spreadTerrain(newTerrain, new Coordinates(0, mainY + 1, mainZ), chance, maxChance);
            }

            if (mainX - 1 >= 0){
                spreadTerrain(newTerrain, new Coordinates(mainX - 1, mainY + 1, mainZ), chance, maxChance);
            }
            else {
                spreadTerrain(newTerrain, new Coordinates(mapSize.size - 1, mainY + 1, mainZ), chance, maxChance);
            }
        }
        if (mainY - 1 >= 0){
            if (mainX + 1 < mapSize.size) {
                spreadTerrain(newTerrain, new Coordinates(mainX + 1, mainY - 1, mainZ), chance, maxChance);
            }
            else {
                spreadTerrain(newTerrain, new Coordinates(0, mainY - 1, mainZ), chance, maxChance);
            }

            if (mainX - 1 >= 0){
                spreadTerrain(newTerrain, new Coordinates(mainX - 1, mainY - 1 , mainZ), chance, maxChance);
            }
            else {
                spreadTerrain(newTerrain, new Coordinates(mapSize.size - 1, mainY - 1 , mainZ), chance, maxChance);
            }
        }
        if (mainY - 2 >= 0) {
            spreadTerrain(newTerrain, new Coordinates(mainX, mainY - 2, mainZ), chance, maxChance);
        }
    }
}
