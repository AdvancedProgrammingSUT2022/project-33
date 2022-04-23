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
                    //TODO: spread the land
                }
            }
        }
    }



    private TerrainTypes getBiomeType(Coordinates coordinates)
    {
        biomes.snowChance *= (int) (Math.pow(coordinates.getY() / mapSize.size, 9) * 40);

        Random rand = new Random();
        int maxChance = biomes.getMaxChance();
        int randomBiomeChance = rand.nextInt(maxChance);

        ArrayList<Integer> chancesList = biomes.getChancesList();

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
}
