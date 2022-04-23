package Model;

public enum BiomesDefaultChance {
    DESERT(35, 12, 15, 15, 4, 12, 2, 5),
    FOREST(5, 20, 10, 10, 15, 20, 6, 14)  ,
    GRASSLAND(2, 35, 10, 5, 15, 20, 3, 10),
    TUNDRA(2, 4, 15, 15, 10, 4, 20, 30),
    FRESHWATER(5, 15, 5, 10, 25, 15, 10, 15);


    final Biomes biomesChance;

    BiomesDefaultChance(int desertChance, int grasslandChance, int hillsChance, int mountainChance, int oceanChance,
                        int plainChance, int snowChance, int tundraChance)
    {
        biomesChance = new Biomes(desertChance, grasslandChance, hillsChance, mountainChance, oceanChance,
                plainChance, snowChance, tundraChance);
    }
}
