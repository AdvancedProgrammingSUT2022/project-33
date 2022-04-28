package Model;

public class HeavyRangedMilitaryUnits extends RangedMilitaryUnit{
    int turnsNeededToSetUp;





    ////methods////
    public HeavyRangedMilitaryUnits(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                              int attackDamage, int attackRange, int turnsNeededToSetUp, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        super(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, attackRange, technologyRequired, resourceRequired, era);
        this.turnsNeededToSetUp = turnsNeededToSetUp;
    }



    public HeavyRangedMilitaryUnits(HeavyRangedUnits unit, Coordinates coordinates)
    {
        super(unit.unit, coordinates);
    }
}
