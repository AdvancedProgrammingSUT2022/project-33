package Program.View;

import Program.Model.Models.Coordinates;
import Program.Model.Models.Settler;

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



    public void showUnitIsAlreadySleeping()
    {
        System.out.println("this unit is already sleeping");
    }



    public void showUnitIsNowSleeping()
    {
        System.out.println("unit is now sleeping");
    }



    public void showUnitIsAlreadyOnAlert()
    {
        System.out.println("this uit is already on alert");
    }



    public void showUnitIsNowOnAlert()
    {
        System.out.println("unit is now on alert");
    }



    public void showUnitIsAlreadyHealing()
    {
        System.out.println("this unit is already healing");
    }



    public void showUnitHealthIsFull()
    {
        System.out.println("this unit is at its maximum health");
    }



    public void showUnitIsHealing(int turnsNeeded)
    {
        System.out.println("unit is now healing and will fully heal in " + turnsNeeded + " turns");
    }



    public void showUnitIsFullyHealed()
    {
        System.out.println("unit is fully healed");
    }
}
