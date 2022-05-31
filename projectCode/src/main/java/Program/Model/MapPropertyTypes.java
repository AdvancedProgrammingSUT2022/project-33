package Program.Model;

public enum MapPropertyTypes {
    FLOOD_PLAIN(2, 0, 0, -33, 1, true),
    JUNGLE(1, 1, 0, 25, 1, true),
    ICE(0, 0, 0, 0, 0, false),
    DENSE_FOREST(1, -1, 0, 25, 2, true),
    SWAMP(-1, 0, 0, -33, 2, true),
    OASIS(3, 0, 1, -33, 1, true);


    public final MapLandElement property;

    MapPropertyTypes(int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean isMovable)
    {
        property = new MapLandElement(food, production, gold, fightChangePercentage, movementPrice, isMovable);
    }
}
