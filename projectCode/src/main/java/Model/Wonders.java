package Model;

public enum Wonders {
    //TODO:

    ;
    final Wonder wonder;

    Wonders(int goldPerTurn, int happinessPerTurn, int productionPerTurn, int foodPerTurn, int goldEffect,
            int happinessEffect, int productionEffect, int foodEffect, int productionNeeded)
    {
        wonder = new Wonder(goldPerTurn, happinessPerTurn, productionPerTurn, foodPerTurn, goldEffect,
        happinessEffect, productionEffect, foodEffect, productionNeeded);
    }
}
