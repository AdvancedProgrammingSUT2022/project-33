package Program.View;

import Program.Model.Models.HeavyRangedMilitaryUnits;

public class HeavyView extends RangedView{





    ////methods////
    public HeavyView(String unitType)
    {
        super(unitType);
    }



    public void showStats(HeavyRangedMilitaryUnits unit)
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

        if (unit.isSettingUp()){
            System.out.println("unti is getting ready to attack. turns remaining: " + (unit.getTurnsNeededToSetUp() - unit.getTurnsSinceStartingToSetUp()));
        }
        else if (unit.isSetUp()){
            System.out.println("unit is ready to attack");
        }
        else {
            System.out.println("unit is ready to move");
        }

        System.out.println("");
        System.out.println("level: " + unit.getLevel());
        System.out.println("era: " + unit.getEra());
    }
}
