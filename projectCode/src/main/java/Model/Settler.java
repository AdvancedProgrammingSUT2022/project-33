package Model;

public class Settler extends Unit{





    public Settler(Coordinates coordinates, Colors color)
    {
        super("Settler" , 5, 2, 2, 89, 0, 100);
        /* health = 5
        visibilityRange =2
        maxMovements = 2
        price = 89
        maintenancePricePerTurn = 0
        productionNeededForBeingMade = 100 */

        super.setCoordinates(coordinates);
        super.setBelongsToPlayer(true);
        super.setColor(color);

        //TODO:
    }



    public Settler(Coordinates coordinates, NonPlayerColors color){

        super("Settler", 5, 2, 2, 89, 0, 100);
        /* health = 5
        visibilityRange =2
        maxMovements = 2
        price = 89
        maintenancePricePerTurn = 0
        productionNeededForBeingMade = 100 */

        super.setCoordinates(coordinates);
        super.setBelongsToPlayer(false);
        super.setNonPlayerColor(color);


        //TODO:
    }
}
