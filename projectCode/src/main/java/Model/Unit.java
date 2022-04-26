package Model;

public class Unit {
    String type;
    int health;
    int visibilityRange;
    int maxMovements;
    int remainingMovements;
    Coordinates coordinates;
    Coordinates destinationCoordinates;
    int price;
    int timeRequiredForBeingMade;
    int maintenancePricePerTurn;





    ////methods////
    public Unit(int health, int visibilityRange, int maxMovements, Coordinates coordinates, int price, int timeRequiredForBeingMade, int maintenancePricePerTurn)
    {
        this.health = health;
        this.visibilityRange = visibilityRange;
        this.maxMovements = maxMovements;
        this.coordinates = coordinates;
        this.price = price;
        this.timeRequiredForBeingMade = timeRequiredForBeingMade;
        this.maintenancePricePerTurn = maintenancePricePerTurn;


    }



    public void updateUnit()
    {

    }



    private void moveUnit()
    {
        if (coordinates.equals(destinationCoordinates)){
            return;
        }


    }
}
