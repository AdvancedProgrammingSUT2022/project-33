package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LuxuryResourceTypes {
    COTTON(0, 0, 2, "FARMHOUSE", new ArrayList<String>(Arrays.asList("PLAIN", "DESERT", "GRASSLAND"))),
    COLOR(0, 0, 2, "FARMHOUSE", new ArrayList<String>(Arrays.asList("JUNGLE", "DENSE_FOREST"))),
    FUR(0, 0, 2 , "CAMP", new ArrayList<String>(Arrays.asList("JUNGLE", "TUNDRA"))),
    GEMSTONE(0, 0, 3, "MINE",
            new ArrayList<String>(Arrays.asList("DENSE_FOREST", "TUNDRA", "GRASSLAND", "PLAIN", "DESERT", "HILLS"))),
    GOLD(0, 0, 2, "MINE", new ArrayList<String>(Arrays.asList("PLAIN", "DESERT", "GRASSLAND", "HILLS"))),
    INCENSE(0, 0, 2, "FARMHOUSE", new ArrayList<String>(Arrays.asList("PLAIN", "DESERT"))),
    IVORY(0, 0, 2, "CAMP", new ArrayList<String>(List.of("PLAIN"))),
    MARBLE(0, 0, 2, "STONE_MINE",
            new ArrayList<String>(Arrays.asList("TUNDRA", "PLAIN", "DESERT", "GRASSLAND", "HILLS"))),
    SILK(0, 0, 2, "FARMHOUSE", new ArrayList<String>(List.of("JUNGLE"))),
    SILVER(0, 0, 2, "MINE", new ArrayList<String>(Arrays.asList("TUNDRA", "DESERT", "HILLS"))),
    SUGAR(0, 0, 2, "FARMHOUSE", new ArrayList<String>(Arrays.asList("FLOOD_PLAIN", "SWAMP")));


    final LuxuryResource resource;

    LuxuryResourceTypes(int food, int production, int gold, String constructionNeeded, ArrayList<String> landsThatCanBeFound)
    {
        resource = new LuxuryResource(food, production, gold, constructionNeeded, landsThatCanBeFound);
    }
}
