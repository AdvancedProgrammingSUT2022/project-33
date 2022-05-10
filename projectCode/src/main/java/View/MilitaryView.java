package View;

import Model.Coordinates;

public class MilitaryView {





    ////methods////
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



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showInaccessible()
    {
        System.out.println("destination coordinates is inaccessible");
    }
}
