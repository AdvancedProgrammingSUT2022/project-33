package Model;

public class MilitaryUnit extends Unit{
    int attackDamage;
    int level;





    public MilitaryUnit (int health, int visibilityRange, int maxMovements, int price, int timeRequiredForBeingMade, int maintenancePricePerTurn)
    {
        super(health, visibilityRange, maxMovements, price, timeRequiredForBeingMade, maintenancePricePerTurn);
    }



    public MilitaryUnit(MilitaryUnit unit, Coordinates coordinates)
    {
        super(unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(),
                unit.getTimeRequiredForBeingMade(), unit.getMaintenancePricePerTurn());
        super.setCoordinates(coordinates);
    }
}
