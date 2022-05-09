package View;

import Model.MatchingStrings;
import Model.Settler;

public class SettlerView {





    ////methods////
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
}
