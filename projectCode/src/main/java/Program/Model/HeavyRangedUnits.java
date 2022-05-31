package Program.Model;

public enum HeavyRangedUnits {
    //classical units
    CATAPULT("Catapult", 11, 2, 2, 100, 75, 1, 4,
            14, false, 2, 1, Technologies.MATHEMATICS, StrategicResourceTypes.IRON, Eras.CLASSICAL),

    //medieval units
    TREBUCHET("Trebuchet", 14, 2, 2, 170, 170, 1, 6,
            20, false, 2, 2, Technologies.PHYSICS, StrategicResourceTypes.IRON, Eras.MEDIEVAL),

    //renaissance units
    CANNON("Cannon", 20, 2,  2, 250, 235, 2, 10,
            26, false, 2, 1, Technologies.CHEMISTRY, null, Eras.RENAISSANCE),

    //Industrial units
    ARTILLERY("Artillery", 30, 2, 2, 420, 400, 2, 16,
            32, false, 3, 1, Technologies.DYNAMITE, null, Eras.INDUSTRIAL);

    public final HeavyRangedMilitaryUnits unit;

    HeavyRangedUnits(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                int attackDamage, int rangedAttackDamage, boolean isCavalry, int attackRange, int turnsNeededToSetUp, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        unit = new HeavyRangedMilitaryUnits(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, rangedAttackDamage, isCavalry, attackRange, turnsNeededToSetUp, technologyRequired, resourceRequired, era);
    }
}
