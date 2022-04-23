package Model;

import java.util.ArrayList;
import java.util.Arrays;

public enum StrategicResourceTypes {
    COAL(0, 1, 0, "MINE", "SCIENTIFIC_THEORY", new ArrayList<String>(Arrays.asList("PLAIN", "HILLS", "GRASSLAND"))),
    HORSE(0, 1, 0, "PASTURE", "LIVESTOCK", new ArrayList<String>(Arrays.asList("TUNDRA", "PLAIN", "GRASSLAND"))),
    IRON(0, 1, 0, "MINE", "IRON_WORKING", new ArrayList<String>(Arrays.asList("TUNDRA", "PLAIN", "DESERT", "HILLS", "GRASSLAND", "SNOW")));


    final StrategicResource resource;

    StrategicResourceTypes(int food, int production, int gold, String constructionNeeded, String technologyNeeded, ArrayList<String> landsThatCanBeFound)
    {
        resource = new StrategicResource(food, production, gold, constructionNeeded, technologyNeeded, landsThatCanBeFound);
    }
}
