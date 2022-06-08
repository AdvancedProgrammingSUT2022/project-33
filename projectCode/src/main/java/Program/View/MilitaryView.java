package Program.View;

import Program.Model.Models.Coordinates;

public class MilitaryView {





    ////methods////
    public void showCurrentMenu(String gameName)
    {
        System.out.println(gameName + " menu");
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



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showInaccessible()
    {
        System.out.println("destination coordinates is inaccessible");
    }



    public void showCheckRemovingMessage()
    {
        System.out.println("are you sure you want to remove this unit? ");
    }



    public void showUnitRemoved()
    {
        System.out.println("unit removed successfully");
    }



    public void showAlreadyFortifying(int turnsNeeded)
    {
        System.out.println("this units is already fortifying and will be finished in " + turnsNeeded + " turns");
    }



    public void showAlreadyFortified()
    {
        System.out.println("this unis is already fortified");
    }



    public void showNotEnoughGoldToFortify(int goldNeeded)
    {
        System.out.println("you don't have enough money to fortify this unit. you need " + goldNeeded + " more gold to fortify this unit");
    }



    public void showUnitIsFortifying(String unitName)
    {
        System.out.println(unitName + " is now fortifying and will be finished in 2 turns");
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



    public void showFriendlyUnitInAttackingCoordinates()
    {
        System.out.println("there is friendly units in the given coordinates");
    }



    public void showNoUnitInAttackingCoordinates()
    {
        System.out.println("there in no enemy unit in the given coordinates");
    }



    public void showUnitIsUnderAttack(String unitName, Coordinates coordinates)
    {
        System.out.println(unitName + " is under attack by another unit on (" + coordinates.getX() + ", " + coordinates.getY() +")");
    }



    public void showUnitIsAttacking(String unitName, Coordinates coordinates)
    {
        System.out.println(unitName + " is attacking another unit on (" + coordinates.getX() + ", " + coordinates.getY() +")");
    }



    public void showUnitKilledEnemy(String unitName, Coordinates coordinates)
    {
        System.out.println(unitName + " defeated another enemy on (" + coordinates.getX() + ", " + coordinates.getY() +")");
    }



    public void showUnitDied(String unitName, Coordinates coordinates)
    {
        System.out.println(unitName + " got defeated by another enemy on (" + coordinates.getX() + ", " + coordinates.getY() +")");
    }
}
