package Program.View;

import Program.Model.MeleeMilitaryUnit;

public class MeleeView extends MilitaryView {





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
        System.out.println("overall defence: " + String.format("%.2f", unit.getOverallDefence()));
        System.out.println("level: " + unit.getLevel());
        System.out.println("era: " + unit.getEra());
    }
}
