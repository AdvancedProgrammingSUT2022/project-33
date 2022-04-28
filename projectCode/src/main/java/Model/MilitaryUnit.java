package Model;

public class MilitaryUnit extends Unit{
    int attackDamage;
    int level;
    Technologies technologyRequired;
    ResourceTypes resourceRequired;
    Eras era;
    int turnsAfterStartingToStabilize;
    int defenceBonus;
    int attackBonus;





    ////methods////
    public MilitaryUnit (int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                         int attackDamage, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        super(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn);
        this.attackDamage = attackDamage;
        this.technologyRequired = technologyRequired;
        this.resourceRequired = resourceRequired;
        this.era = era;
        this.level = 1;
    }



    public MilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates)
    {
        super(unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(),
                unit.getProductionNeededForBeingMade(), unit.getMaintenancePricePerTurn());
        super.setCoordinates(coordinates);
    }



    public MilitaryUnit(RangedMilitaryUnit unit, Coordinates coordinates)
    {
        super(unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(),
                unit.getProductionNeededForBeingMade(), unit.getMaintenancePricePerTurn());
        super.setCoordinates(coordinates);
    }
}
