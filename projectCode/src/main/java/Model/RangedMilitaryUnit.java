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



    public void removeUnit()
    {
        getOwner().addGold(getPrice() * getHealth() / 10);

        getOwner().getPlayerUnits().getRangedMilitaryUnits().remove(this);
        getOwner().getMap().getUnits().getRangedMilitaryUnits().remove(this);
        getOwner().getMap().getOriginalMap().getUnits().getRangedMilitaryUnits().remove(this);
    }



    //getters
    public int getAttackRange() {
        return attackRange;
    }


    public int getRangedAttackDamage() {
        return rangedAttackDamage;
    }



    public int getOverallRangedAttackDamage()
    {
        if (getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty() != null) {
            return ((100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) *
                    (100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty().getFightChangePercentage()) *
                    (getRangedAttackDamage())) / 10000;
        }
        else {
            return ((100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) * (getRangedAttackDamage())) / 100;
        }
    }



    public void moveAndAttackUnit(Coordinates coordinates)
    {
        setPath(coordinates);
        getPath().remove(getPath().size() - 1);
        setMoving(true);
        setAttacking(true);
        setAttackingUnitCoordinates(coordinates);
        setAttackDestination(getPath().get(getPath().size() - 1));


        moveUnit(getOwner().getMap().getOriginalMap().getTerrains(), getOwner().getMap(), new MilitaryView());

        if (getCoordinates().equals(getAttackDestination())){
            attackUnit();
        }
    }



    private void attackUnit()
    {
        if (getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()) != null){
            new MilitaryView().showUnitIsAttacking(getGameName(), getCoordinates());
            new MilitaryView().showUnitIsUnderAttack(
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getGameName(),
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getCoordinates());
            fightRangedToMelee(this, getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
        else if (getOwner().getMap().getUnits().getRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()) != null){
            new MilitaryView().showUnitIsAttacking(getGameName(), getCoordinates());
            new MilitaryView().showUnitIsUnderAttack(
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getGameName(),
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getCoordinates());
            fightRangedToRanged(this, getOwner().getMap().getUnits().getRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
        else if (getOwner().getMap().getUnits().getHeavyRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()) != null){
            new MilitaryView().showUnitIsAttacking(getGameName(), getCoordinates());
            new MilitaryView().showUnitIsUnderAttack(
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getGameName(),
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getCoordinates());
            fightRangedToHeavy(this, getOwner().getMap().getUnits().getHeavyRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
    }
}
