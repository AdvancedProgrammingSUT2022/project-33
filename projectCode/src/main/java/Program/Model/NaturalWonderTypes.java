package Program.Model;

public enum NaturalWonderTypes {
    FIRE_TEMPLE(2, 2, 0, "Fire Temple"),
    ANCIENT_RUIN(1, 0, 100, "Ancient Ruin"),
    VOLCANO(3, 0, 0, "Volcano"),
    HOT_SPRING(2, 1, 0, "Hot Spring"),
    DEEP_CAVE(1, 1, 0, "Deep Caves"),
    OLD_CASTLE(1, 1, 100, "Old Castle"),


    //TODO:
    ;

    final NaturalWonder naturalWonder;

    NaturalWonderTypes(int happiness, int gold, int instantGold, String name)
    {
        this.naturalWonder = new NaturalWonder(happiness, gold, instantGold, name);
    }
}
