package Model;

public enum HeavyRangedUnits {
    ;
    //TODO:


    final HeavyRangedMilitaryUnits unit;

    HeavyRangedUnits(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                int attackDamage, int attackRange, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        unit = new HeavyRangedUnits(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, attackRange, technologyRequired, resourceRequired, era);
    }
}
