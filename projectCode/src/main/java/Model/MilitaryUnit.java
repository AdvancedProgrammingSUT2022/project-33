package Model;

public class MilitaryUnit extends Unit{
    int attackDamage;
    int level;





    public MilitaryUnit (int health, int visibilityRange, int maxMovements, Coordinates coordinates, int price, int timeRequiredForBeingMade, int maintenancePricePerTurn)
    {
        super(health, visibilityRange, maxMovements, coordinates, price, timeRequiredForBeingMade, maintenancePricePerTurn);
    }
}
