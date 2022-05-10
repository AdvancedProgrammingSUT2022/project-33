package Model;

import View.MeleeView;
import View.MilitaryView;
import View.RangedView;

import java.util.ArrayList;

public class RangedMilitaryUnit extends MilitaryUnit{
    private int attackRange;
    private int rangedAttackDamage;





    ////methods////
    public RangedMilitaryUnit(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                             int attackDamage, int rangedAttackDamage, boolean isCavalry, int attackRange, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        super(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn, attackDamage,
                isCavalry, technologyRequired, resourceRequired, era);
        this.attackRange = attackRange;
        this.rangedAttackDamage = rangedAttackDamage;
    }



    public RangedMilitaryUnit(RangedMilitaryUnit unit, Coordinates coordinates, Colors color, Player player)
    {
        super(unit, coordinates);
        super.setColor(color);
        super.setBelongsToPlayer(true);
        super.setOwner(player);
    }



    public RangedMilitaryUnit(RangedMilitaryUnit unit, Coordinates coordinates, NonPlayerColors color)
    {
        super(unit, coordinates);
        super.setNonPlayerColor(color);
        super.setBelongsToPlayer(false);
    }



    public RangedMilitaryUnit(HeavyRangedMilitaryUnits unit, Coordinates coordinates)
    {
        super(unit.getGameName(), unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(), unit.getProductionNeededForBeingMade()
                , unit.getMaintenancePricePerTurn(), unit.getAttackDamage(), unit.getIsCavalry(), unit.getTechnologyRequired(), unit.getResourceRequired(), unit.getEra());
        this.attackRange = unit.getAttackRange();
        this.rangedAttackDamage = unit.getRangedAttackDamage();
    }



    public void updateUnit(ArrayList<Terrain> terrains)
    {
        setRemainingMovements(getMaxMovements());

        if (isMoving()) {
            moveUnit(terrains, getOwner().getMap(), new MilitaryView());
        }

        //TODO:
    }



    //getters
    public int getAttackRange() {
        return attackRange;
    }


    public int getRangedAttackDamage() {
        return rangedAttackDamage;
    }
}
