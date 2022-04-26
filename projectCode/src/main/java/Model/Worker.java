package Model;

public class Worker extends Unit{
    boolean isWorking;
    int turnsRemaining;





    public Worker (int health, int visibilityRange, int maxMovements, Coordinates coordinates, int price, int timeRequiredForBeingMade, int maintenancePricePerTurn)
    {
        super(health, visibilityRange, maxMovements, coordinates, price, timeRequiredForBeingMade, maintenancePricePerTurn);
    }
}
