package Program.View;

import Program.Model.RangedMilitaryUnit;

public class RangedView extends MilitaryView{





    ////methods////
    public RangedView(String unitType)
    {
        System.out.println("you are now controlling " + unitType);
    }




    public void showStats(RangedMilitaryUnit unit)
    {
        System.out.println(unit.getGameName() + ": ");

        System.out.println("health: " + unit.getHealth());

        if (unit.isMoving()){
            System.out.println("destination: (" + unit.getDestinationCoordinates().getX() + ", " + unit.getDestinationCoordinates().getY() + ")");
        }
        else {
            System.out.println("move point: " + unit.getRemainingMovements());
        }

        System.out.println("range: " + unit.getAttackRange());
        System.out.println("overall ranged attack damage: " + unit.getOverallRangedAttackDamage());
        System.out.println("overall attack damage: " + unit.getOverallDamage());
        System.out.println("overall defence: " + String.format("%.2f", unit.getOverallDefence()));
        System.out.println("level: " + unit.getLevel());
        System.out.println("era: " + unit.getEra());
    }

}
