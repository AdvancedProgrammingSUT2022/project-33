package Model;

public enum LuxuryResourceTypes {
    COTTON(0, 0, 2, "FARMHOUSE"),
    COLOR(0, 0, 2, "FARMHOUSE"),
    FUR(0, 0, 2 , "CAMP"),
    GEMSTONE(0, 0, 3, "MINE"),
    GOLD(0, 0, 2, "MINE"),
    INCENSE(0, 0, 2, "FARMHOUSE"),
    IVORY(0, 0, 2, "CAMP"),
    MARBLE(0, 0, 2, "STONE_MINE"),
    SILK(0, 0, 2, "FARMHOUSE"),
    SILVER(0, 0, 2, "MINE"),
    SUGAR(0, 0, 2, "FARMHOUSE");


    final LuxuryResource resource;

    LuxuryResourceTypes(int food, int production, int gold, String constructionNeeded)
    {
        resource = new LuxuryResource(food, production, gold, constructionNeeded);
    }
}
