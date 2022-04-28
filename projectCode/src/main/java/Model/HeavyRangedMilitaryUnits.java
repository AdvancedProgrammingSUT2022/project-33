package Model;

public class HeavyRangedMilitaryUnits extends RangedMilitaryUnit{
    int turnsNeededToEstablish;





    ////methods////
    public HeavyRangedMilitaryUnits(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                              int attackDamage, int attackRange, int turnsNeededToEstablish, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        super(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, attackRange, technologyRequired, resourceRequired, era);
        this.turnsNeededToEstablish = turnsNeededToEstablish;
    }



    public HeavyRangedMilitaryUnits(MeleeUnits unit, Coordinates coordinates)
    {
        super(unit.unit, coordinates);
    }
}
