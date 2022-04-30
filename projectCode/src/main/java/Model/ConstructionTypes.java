package Model;

import java.util.ArrayList;
import java.util.Arrays;

public enum ConstructionTypes {
    CAMP(new ArrayList<String>(Arrays.asList("JUNGLE", "TUNDRA", "PLAIN", "HILLS")), te),
    FARM(),
    LUMBER_MILL(),
    MINE(),
    PASTURE(),
    FARMHOUSE(),
    STONE_MINE(),
    TRADING_POST(),
    FACTORY();


    final Construction construction;

    ConstructionTypes(ArrayList<String> availableLandTypes, Technologies neededTechnology, int constructionTime, int foodEffect, int productionEffect, int goldEffect)
    {
        construction = new Construction(availableLandTypes, neededTechnology, constructionTime, foodEffect, productionEffect, goldEffect);
    }
}
