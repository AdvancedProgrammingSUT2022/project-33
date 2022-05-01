package Model;

public enum MeleeUnits {
    WARRIOR("Warrior", 10, 2, 2, 40, 40,
            1, 6, false, null, null, Eras.ANCIENT),
    SCOUT("Scout", 8, 3, 3, 25, 25,
            0, 4, false, null, null, Eras.ANCIENT),
    SPEARMAN("Spearman" , 10, 2, 2, 50, 60,
            1, 7, false, Technologies.BRONZE_WORKING, null, Eras.ANCIENT),
    HORSEMAN("Horseman", 10, 2, 4, 80, 70,
            1, 12, true, Technologies.HORSEBACK_RIDING, StrategicResourceTypes.HORSE, Eras.CLASSICAL),
    SWORDSMAN("Swordsman", 11, 2, 2, 80, 70,
            1, 11, false, Technologies.IRON_WORKING, StrategicResourceTypes.IRON, Eras.CLASSICAL),


    //CHARIOT_ARCHER("Chariot Archer", )


    ;
    //TODO:


    final MeleeMilitaryUnit unit;

    MeleeUnits(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                      int attackDamage, boolean isCavalry, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        unit = new MeleeMilitaryUnit(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, isCavalry, technologyRequired, resourceRequired, era);
    }
}
