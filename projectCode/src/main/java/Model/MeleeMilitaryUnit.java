package Model;

public class MeleeMilitaryUnit extends MilitaryUnit{





    ////methods////
    public MeleeMilitaryUnit(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                             int attackDamage, boolean isCavalry, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        super(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn, attackDamage,
                isCavalry, technologyRequired, resourceRequired, era);
    }



    public MeleeMilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates, Colors color)
    {
        super(unit, coordinates);
        super.setColor(color);
        super.setBelongsToPlayer(true);
    }



    public MeleeMilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates, NonPlayerColors color)
    {
        super(unit, coordinates);
        super.setNonPlayerColor(color);
        super.setBelongsToPlayer(false);
    }
}
