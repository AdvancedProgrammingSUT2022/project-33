package Program.Model.Enums;

import Program.Model.Models.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ResourceTypes {
    BANANA("Banana", 1, 0, 0,  "FARMHOUSE", new ArrayList<String>(List.of("JUNGLE"))),
    COW("Cow", 1, 0, 0, "PASTURE", new ArrayList<String>(List.of("GRASSLAND"))),
    DEER("Deer", 1, 0, 0, "CAMP", new ArrayList<String>(Arrays.asList("JUNGLE", "TUNDRA", "HILLS"))),
    SHEEP("Sheep", 2, 0, 0, "PASTURE", new ArrayList<String>(Arrays.asList("PLAIN", "GRASSLAND", "DESERT", "HILLS"))),
    WHEAT("Wheat", 1, 0, 0, "FARM", new ArrayList<String>(Arrays.asList("PLAIN", "FLOOD_PLAIN")));


    public final Resource resource;

    ResourceTypes(String gameName, int food, int production, int gold, String constructionNeeded, ArrayList<String> landsThatCanBeFound)
    {
        resource = new Resource(gameName, food, production, gold, constructionNeeded, landsThatCanBeFound);
    }
}
