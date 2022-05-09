package Controller;

import Model.Coordinates;
import Model.MeleeMilitaryUnit;

public class MeleeView {





    ////methods////
    public MeleeView(String unitType)
    {
        System.out.println("you are now controlling " + unitType);
    }



    public void showStats(MeleeMilitaryUnit unit)
    {
        System.out.println(unit.getGameName() + ": ");

        System.out.println("health: " + unit.getHealth());

        if (unit.isMoving()){
            System.out.println("destination: (" + unit.getDestinationCoordinates().getX() + ", " + unit.getDestinationCoordinates().getY() + ")");
        }
        else {
            System.out.println("move point: " + unit.getRemainingMovements());
        }

        System.out.println("overall attack damage: " + unit.getOverallDamage());
        System.out.println("overall defence: " + unit.getOverallDefence());
        System.out.println("level: " + unit.getLevel());
        System.out.println("era: " + unit.getEra());
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
}
