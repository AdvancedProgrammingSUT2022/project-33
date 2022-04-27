package Model;

public enum MeleeUnits {
    WARRIOR(10, 2, 2, 40, 40, 1, 6, null, null, Eras.ANCIENT),
    SCOUT(8, 3, 2, 25, 25, 0, 4, null, null, Eras.ANCIENT),
    //SPEARMAN(10, 2, 2, 50, 60, 1, 7, )

    ;
    //TODO:


    final MeleeMilitaryUnit unit;

    MeleeUnits(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                      int attackDamage, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        unit = new MeleeMilitaryUnit(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn, attackDamage,
                technologyRequired, resourceRequired, era);
    }
}
