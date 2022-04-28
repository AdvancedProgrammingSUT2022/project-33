package Model;

public class RangedMilitaryUnit extends MilitaryUnit{
    private int attackRange;





    ////methods////
    public RangedMilitaryUnit(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                             int attackDamage, boolean isCavalry, int attackRange, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        super(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn, attackDamage,
                isCavalry, technologyRequired, resourceRequired, era);
        this.attackRange = attackRange;
    }



    public RangedMilitaryUnit(RangedMilitaryUnit unit, Coordinates coordinates, Colors color)
    {
        super(unit, coordinates);
        super.setColor(color);
        super.setBelongsToPlayer(true);
    }



    public RangedMilitaryUnit(RangedMilitaryUnit unit, Coordinates coordinates, NonPlayerColors color)
    {
        super(unit, coordinates);
        super.setNonPlayerColor(color);
        super.setBelongsToPlayer(false);
    }



    public RangedMilitaryUnit(HeavyRangedMilitaryUnits unit, Coordinates coordinates)
    {
        super(unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(), unit.getProductionNeededForBeingMade()
                , unit.getMaintenancePricePerTurn(), unit.getAttackDamage(), unit.getIsCavalry(), unit.getTechnologyRequired(), unit.getResourceRequired(), unit.getEra());
        this.attackRange = unit.getAttackRange();
    }



    //getters
    public int getAttackRange() {
        return attackRange;
    }
}
