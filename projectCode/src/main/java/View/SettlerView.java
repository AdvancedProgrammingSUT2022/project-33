package View;

import Model.Coordinates;
import Model.MatchingStrings;
import Model.Settler;

public class SettlerView {





    ////methods////
    public SettlerView()
    {
        System.out.println("you are now controlling settler");
    }



    public void showCurrentMenu()
    {
        System.out.println("settler menu");
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showStats(Settler settler)
    {
        System.out.println("health: " + settler.getHealth());

        if (settler.isMoving()){
            System.out.println("destination: (" + settler.getDestinationCoordinates().getX() + ", " + settler.getDestinationCoordinates().getY() + ")");
        }
        else {
            System.out.println("move point: " + settler.getRemainingMovements());
        }
    }



    public void showCoordinatesOutOfBoundary(int value, String axis, int mapSize)
    {
        System.out.println(axis + "axis value is out of boundaries: " + value);
        System.out.println("value must be between 0 and " +( mapSize - 1));
    }



    public void showOccupiedCoordinates(boolean isDestination, Coordinates coordinates)
    {
        if (isDestination) {
            System.out.println("destination is occupied by another unit");
        }
        else {
            System.out.println("next tile is occupies by another unit. coordinates: (" + coordinates.getX() + ", " + coordinates.getY() + ")");
        }
    }



    public void showEnterCityName()
    {
        System.out.print("city name: ");
    }



    public void showCanNotBuildCity()
    {
        System.out.println("can not build city in this tile");
    }



    public void showCityNameIsNotValid()
    {
        System.out.println("city name is not valid");
    }



    public void showCheckRemovingMessage()
    {
        System.out.println("are you sure you want to remove this unit? ");
    }



    public void showUnitRemoved()
    {
        System.out.println("unit removed successfully");
    }



    public void showInaccessible()
    {
        System.out.println("destination coordinates is inaccessible");
    }
}
