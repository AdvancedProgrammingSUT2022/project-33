package Model;

public class MeleeMilitaryUnit extends MilitaryUnit{





    ////methods////
    public MeleeMilitaryUnit(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                             int attackDamage, boolean isCavalry, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        super(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn, attackDamage,
                isCavalry, technologyRequired, resourceRequired, era);
    }



    public MeleeMilitaryUnit(MeleeUnits unit, Coordinates coordinates)
    {
        super(unit.unit, coordinates);
    }
}
