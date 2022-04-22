package Model;

import java.io.StreamTokenizer;

public enum LandElementType {
    //land types
    DESERT(0, 0, 0, -33, 1, true),
    GRASSLAND(2, 0, 0 , -33, 1, true),
    HILLS(0, 2, 0, 25, 2, true),
    MOUNTAIN(0, 0, 0, 0, 0, false),
    OCEAN(0, 0, 0, 0, 0, false),
    PLAIN(1, 1, 0, -33, 1, true),
    SNOW(0, 0, 0, -33, 1, true),
    TUNDRA(1, 0, 0, -33, 1, true),

    //property types
    FLOOD_PLAIN(2, 0, 0, -33, 1, true),
    JUNGLE(1, 1, 0, 25, 1, true),
    ICE(0, 0, 0, 0, 0, false),
    DENSE_FOREST(1, -1, 0, 25, 2, true),
    SWAMP(-1, 0, 0, -33, 2, true),
    OASIS(3, 0, 1, -33, 1, true);


    public final LandElementTypeEffect effect;

    LandElementType(int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean isMovable)
    {
        effect = new LandElementTypeEffect(food, production, gold, fightChangePercentage, movementPrice, isMovable);
    }
}
