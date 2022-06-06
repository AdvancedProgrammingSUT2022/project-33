package Program.Model.Enums;

import Program.Model.Improvement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ImprovementTypes {
    CAMP("Camp", new ArrayList<>(Arrays.asList(TerrainTypes.TUNDRA.name(), TerrainTypes.PLAIN.name(),
            TerrainTypes.HILLS.name(), MapPropertyTypes.JUNGLE.name())), Technologies.TRAPPING, 0, 0, 0),
    FARM("Farm", new ArrayList<>(Arrays.asList(TerrainTypes.PLAIN.name(), TerrainTypes.DESERT.name(), TerrainTypes.GRASSLAND.name())),
            Technologies.AGRICULTURE, 1, 0, 0),
    LUMBER_MILL("Lumber Mill", new ArrayList<>(List.of(MapPropertyTypes.JUNGLE.name())), Technologies.CONSTRUCTION, 0, 1, 0),
    MINE("Mine", new ArrayList<>(Arrays.asList(TerrainTypes.PLAIN.name(), TerrainTypes.DESERT.name(),
            TerrainTypes.GRASSLAND.name(), TerrainTypes.TUNDRA.name(), TerrainTypes.SNOW.name(), TerrainTypes.HILLS.name(),
            MapPropertyTypes.JUNGLE.name(), MapPropertyTypes.DENSE_FOREST.name(), MapPropertyTypes.SWAMP.name())), Technologies.MINING, 0, 1, 0),
    PASTURE("Pasture", new ArrayList<>(Arrays.asList(TerrainTypes.PLAIN.name(), TerrainTypes.DESERT.name(),
            TerrainTypes.GRASSLAND.name(), TerrainTypes.TUNDRA.name(), TerrainTypes.HILLS.name())), Technologies.ANIMAL_HUSBANDRY, 0, 0, 0),
    PLANTATION("Plantation", new ArrayList<>(Arrays.asList(TerrainTypes.PLAIN.name(), TerrainTypes.DESERT.name(),
            TerrainTypes.GRASSLAND.name(), MapPropertyTypes.JUNGLE.name(), MapPropertyTypes.DENSE_FOREST.name(),
            MapPropertyTypes.SWAMP.name(), MapPropertyTypes.FLOOD_PLAIN.name())), Technologies.CALENDER, 0, 0, 0),
    STONE_MINE("Stone Mine", new ArrayList<>(Arrays.asList(TerrainTypes.PLAIN.name(), TerrainTypes.DESERT.name(), TerrainTypes.GRASSLAND.name(),
            TerrainTypes.TUNDRA.name(), TerrainTypes.HILLS.name())), Technologies.MASONRY, 0, 0, 0),
    TRADING_POST("Trading Post", new ArrayList<>(Arrays.asList(TerrainTypes.PLAIN.name(), TerrainTypes.DESERT.name(),
            TerrainTypes.GRASSLAND.name(), TerrainTypes.TUNDRA.name())), Technologies.TRAPPING, 0, 0, 1),
    FACTORY("Factory", new ArrayList<>(Arrays.asList(TerrainTypes.PLAIN.name(), TerrainTypes.DESERT.name(), TerrainTypes.GRASSLAND.name(),
            TerrainTypes.SNOW.name(), TerrainTypes.TUNDRA.name())), Technologies.ENGINEERING, 0, 2, 0);


    public final Improvement improvement;

    ImprovementTypes(String gameName, ArrayList<String> availableLandTypes, Technologies neededTechnology, int foodEffect, int productionEffect, int goldEffect)
    {
        improvement = new Improvement(gameName, availableLandTypes, neededTechnology, foodEffect, productionEffect, goldEffect);
    }
}
