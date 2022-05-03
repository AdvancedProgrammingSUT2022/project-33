package Model;

public class HeavyRangedMilitaryUnits extends RangedMilitaryUnit{
    int turnsNeededToSetUp;





    ////methods////
    public HeavyRangedMilitaryUnits(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                              int attackDamage, int rangedAttackDamage, boolean isCavalry, int attackRange, int turnsNeededToSetUp, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        super(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, rangedAttackDamage, isCavalry, attackRange, technologyRequired, resourceRequired, era);
        this.turnsNeededToSetUp = turnsNeededToSetUp;
    }



    public HeavyRangedMilitaryUnits(HeavyRangedMilitaryUnits unit, Coordinates coordinates, Colors color, Player player)
    {
        super(unit, coordinates, color, player);
    }



    public HeavyRangedMilitaryUnits(HeavyRangedMilitaryUnits unit, Coordinates coordinates, NonPlayerColors color)
    {
        super(unit, coordinates, color);
    }
}
