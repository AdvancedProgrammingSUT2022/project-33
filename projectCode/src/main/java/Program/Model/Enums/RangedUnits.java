package Program.Model.Enums;

import Program.Model.Models.RangedMilitaryUnit;

public enum RangedUnits {
    //Ancient units
    Archer("Archer", 9, 2, 2, 70, 40,
            1, 4, 6, false, 2, Technologies.ARCHERY, null, Eras.ANCIENT),

    //Ancient units
    CHARIOT_ARCHER("Chariot Archer", 10, 2, 4, 60, 60,
            1, 3, 6, true, 2, Technologies.THE_WHEEL, StrategicResourceTypes.HORSE, Eras.ANCIENT),

    //medieval units
    CROSSBOWMAN("Crossbowman", 22, 2, 2, 120, 120,
            1, 6, 12, false, 2, Technologies.MACHINERY, null, Eras.MEDIEVAL);


    public final RangedMilitaryUnit unit;

    RangedUnits(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
               int attackDamage, int rangedAttackDamage, boolean isCavalry, int attackRange, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        unit = new RangedMilitaryUnit(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, rangedAttackDamage, isCavalry, attackRange, technologyRequired, resourceRequired, era);
    }
}
