package Model;

public enum HeavyRangedUnits {
    ;
    //TODO:


    final HeavyRangedMilitaryUnits unit;

    HeavyRangedUnits(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                int attackDamage, boolean isCavalry, int attackRange, int turnsNeededToSetUp, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        unit = new HeavyRangedMilitaryUnits(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, isCavalry, attackRange, turnsNeededToSetUp, technologyRequired, resourceRequired, era);
    }
}
