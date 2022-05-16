package Model;

import View.MilitaryView;

public class HeavyRangedMilitaryUnits extends RangedMilitaryUnit{
    private int turnsNeededToSetUp;
    private int turnsSinceStartingToSetUp;
    private boolean isSettingUp;
    private boolean isSetUp;





    ////methods////
    public HeavyRangedMilitaryUnits(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                              int attackDamage, int rangedAttackDamage, boolean isCavalry, int attackRange, int turnsNeededToSetUp, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        super(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, rangedAttackDamage, isCavalry, attackRange, technologyRequired, resourceRequired, era);
        this.turnsNeededToSetUp = turnsNeededToSetUp;
    }



    public HeavyRangedMilitaryUnits(HeavyRangedMilitaryUnits unit, Coordinates coordinates, Colors color, Player player)
    {
        super(unit, coordinates, color, player);
    }



    public HeavyRangedMilitaryUnits(HeavyRangedMilitaryUnits unit, Coordinates coordinates, NonPlayerColors color)
    {
        super(unit, coordinates, color);
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
            fightHeavyToMelee(this, getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
        else if (getOwner().getMap().getUnits().getRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()) != null){
            new MilitaryView().showUnitIsAttacking(getGameName(), getCoordinates());
            new MilitaryView().showUnitIsUnderAttack(
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getGameName(),
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getCoordinates());
            fightHeavyToRanged(this, getOwner().getMap().getUnits().getRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
        else if (getOwner().getMap().getUnits().getHeavyRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()) != null){
            new MilitaryView().showUnitIsAttacking(getGameName(), getCoordinates());
            new MilitaryView().showUnitIsUnderAttack(
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getGameName(),
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getCoordinates());
            fightHeavyToHeavy(this, getOwner().getMap().getUnits().getHeavyRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
    }


    public int getTurnsNeededToSetUp() {
        return turnsNeededToSetUp;
    }


    public boolean isSetUp() {
        return isSetUp;
    }


    public int getTurnsSinceStartingToSetUp() {
        return turnsSinceStartingToSetUp;
    }


    public boolean isSettingUp() {
        return isSettingUp;
    }
}
