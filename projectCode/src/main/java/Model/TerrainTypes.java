package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TerrainTypes {
    DESERT(0, 0, 0, -33, 1, true, new ArrayList<String>(Arrays.asList("FLOOD_PLAIN", "OASIS"))),
    GRASSLAND(2, 0, 0 , -33, 1, true, new ArrayList<String>(Arrays.asList("JUNGLE", "SWAMP"))),
    HILLS(0, 2, 0, 25, 2, true, new ArrayList<String>(Arrays.asList("JUNGLE", "DENSE_FOREST"))),
    MOUNTAIN(0, 0, 0, 0, 0, false, new ArrayList<String>()),
    OCEAN(0, 0, 0, 0, 0, false, new ArrayList<String>()),
    PLAIN(1, 1, 0, -33, 1, true, new ArrayList<String>(Arrays.asList("JUNGLE", "DENSE_FOREST"))),
    SNOW(0, 0, 0, -33, 1, true, new ArrayList<String>()),
    TUNDRA(1, 0, 0, -33, 1, true, new ArrayList<String>(List.of("JUNGLE")));


    public final MapLandElement land;

    TerrainTypes(int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean isMovable, ArrayList<String> availableProperties)
    {
        land = new Terrain(food, production, gold, fightChangePercentage, movementPrice, isMovable, availableProperties);
    }
}
