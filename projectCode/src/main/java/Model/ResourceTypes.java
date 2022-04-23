package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ResourceTypes {
    BANANA(1, 0, 0,  "FARMHOUSE", new ArrayList<String>(List.of("JUNGLE"))),
    COW(1, 0, 0, "PASTURE", new ArrayList<String>(List.of("GRASSLAND"))),
    DEER(1, 0, 0, "CAMP", new ArrayList<String>(Arrays.asList("JUNGLE", "TUNDRA", "HILLS"))),
    SHEEP(2, 0, 0, "PASTURE", new ArrayList<String>(Arrays.asList("PLAIN", "GRASSLAND", "DESERT", "HILLS"))),
    WHEAT(1, 0, 0, "FARM", new ArrayList<String>(Arrays.asList("PLAIN", "FLOOD_PLAIN")));


    final Resource resource;

    ResourceTypes(int food, int production, int gold, String constructionNeeded, ArrayList<String> landsThatCanBeFound)
    {
        resource = new Resource(food, production, gold, constructionNeeded, landsThatCanBeFound);
    }
}
