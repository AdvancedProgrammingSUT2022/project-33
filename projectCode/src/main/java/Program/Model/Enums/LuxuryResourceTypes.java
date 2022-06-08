package Program.Model.Enums;

import Program.Model.Models.LuxuryResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LuxuryResourceTypes {
    COTTON("Cotton", 0, 0, 2, "FARMHOUSE", new ArrayList<String>(Arrays.asList("PLAIN", "DESERT", "GRASSLAND"))),
    DYE("Dye", 0, 0, 2, "FARMHOUSE", new ArrayList<String>(Arrays.asList("JUNGLE", "DENSE_FOREST"))),
    FUR("Fur", 0, 0, 2 , "CAMP", new ArrayList<String>(Arrays.asList("JUNGLE", "TUNDRA"))),
    GEMSTONE("Gemstone", 0, 0, 3, "MINE",
            new ArrayList<String>(Arrays.asList("DENSE_FOREST", "TUNDRA", "GRASSLAND", "PLAIN", "DESERT", "HILLS"))),
    GOLD("Gold", 0, 0, 2, "MINE", new ArrayList<String>(Arrays.asList("PLAIN", "DESERT", "GRASSLAND", "HILLS"))),
    INCENSE("Incense", 0, 0, 2, "FARMHOUSE", new ArrayList<String>(Arrays.asList("PLAIN", "DESERT"))),
    IVORY("Ivory", 0, 0, 2, "CAMP", new ArrayList<String>(List.of("PLAIN"))),
    MARBLE("Marble", 0, 0, 2, "STONE_MINE",
            new ArrayList<String>(Arrays.asList("TUNDRA", "PLAIN", "DESERT", "GRASSLAND", "HILLS"))),
    SILK("Silk", 0, 0, 2, "FARMHOUSE", new ArrayList<String>(List.of("JUNGLE"))),
    SILVER("Silver", 0, 0, 2, "MINE", new ArrayList<String>(Arrays.asList("TUNDRA", "DESERT", "HILLS"))),
    SUGAR("Sugar", 0, 0, 2, "FARMHOUSE", new ArrayList<String>(Arrays.asList("FLOOD_PLAIN", "SWAMP")));


    public final LuxuryResource resource;

    LuxuryResourceTypes(String gameName, int food, int production, int gold, String constructionNeeded, ArrayList<String> landsThatCanBeFound)
    {
        resource = new LuxuryResource(gameName, food, production, gold, constructionNeeded, landsThatCanBeFound);
    }
}
