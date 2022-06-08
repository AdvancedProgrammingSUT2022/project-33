package Program.Model.Enums;

import Program.Model.Models.Wonder;

public enum Wonders {
    //TODO:

    ;
    public final Wonder wonder;

    Wonders(String gameName, int goldPerTurn, int happinessPerTurn, int productionPerTurn, int foodPerTurn, int goldEffect,
            int happinessEffect, int productionEffect, int foodEffect, int productionNeeded, Technologies technologyNeeded)
    {
        wonder = new Wonder(gameName, goldPerTurn, happinessPerTurn, productionPerTurn, foodPerTurn, goldEffect,
        happinessEffect, productionEffect, foodEffect, productionNeeded, technologyNeeded);
    }
}
