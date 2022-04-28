package Model;

public class RangedMilitaryUnit extends MilitaryUnit{
    private int attackRange;





    ////methods////
    public RangedMilitaryUnit(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                             int attackDamage, int attackRange, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        super(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn, attackDamage, technologyRequired, resourceRequired, era);
        this.attackRange = attackRange;
    }



    public RangedMilitaryUnit(RangedUnits unit, Coordinates coordinates)
    {
        super(unit.unit, coordinates);
    }



    public RangedMilitaryUnit(HeavyRangedMilitaryUnits units)
    {
        super(units.getHealth(), units.getVisibilityRange(), units.getMaxMovements(), units.getPrice(), units.getProductionNeededForBeingMade(), units.getMaintenancePricePerTurn()
        , units.getAt);
    }
}
