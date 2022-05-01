package Model;

public enum HeavyRangedUnits {
    CATAPULT("Catapult", 14, 2, 2, 100, 75, 1, 4,
            14, false, 3, 1, Technologies.MATHEMATICS, StrategicResourceTypes.IRON, Eras.CLASSICAL);

    //TODO:


    final HeavyRangedMilitaryUnits unit;

    HeavyRangedUnits(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                int attackDamage, int rangedAttackDamage, boolean isCavalry, int attackRange, int turnsNeededToSetUp, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        unit = new HeavyRangedMilitaryUnits(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, rangedAttackDamage, isCavalry, attackRange, turnsNeededToSetUp, technologyRequired, resourceRequired, era);
    }
}
