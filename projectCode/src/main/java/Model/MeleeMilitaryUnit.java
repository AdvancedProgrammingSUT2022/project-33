package Model;

import View.MeleeView;
import View.MilitaryView;

import java.util.ArrayList;

public class MeleeMilitaryUnit extends MilitaryUnit{





    ////methods////
    public MeleeMilitaryUnit(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                             int attackDamage, boolean isCavalry, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        super(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn, attackDamage,
                isCavalry, technologyRequired, resourceRequired, era);
    }



    public MeleeMilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates, Colors color, Player player)
    {
        super(unit, coordinates);
        super.setColor(color);
        super.setBelongsToPlayer(true);
        super.setOwner(player);
    }



    public MeleeMilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates, NonPlayerColors color)
    {
        super(unit, coordinates);
        super.setNonPlayerColor(color);
        super.setBelongsToPlayer(false);
    }



    public void updateUnit(ArrayList<Terrain> terrains)
    {
        setRemainingMovements(getMaxMovements());

        if (isMoving()) {
            moveUnit(terrains, getOwner().getMap(), new MilitaryView());
        }

        if (isAttacking() && getCoordinates().isNextToCoordinates(getAttackingUnitCoordinates())){
            attackUnit();
            setAttacking(false);
            setMoving(false);
        }

        heal();


        //TODO:
    }



    public void removeUnit()
    {
        getOwner().addGold(getPrice() * getHealth() / 10);

        getOwner().getPlayerUnits().getMeleeMilitaryUnits().remove(this);
        getOwner().getMap().getUnits().getMeleeMilitaryUnits().remove(this);
        getOwner().getMap().getOriginalMap().getUnits().getMeleeMilitaryUnits().remove(this);
    }



    public void moveAndAttackUnit(Coordinates coordinates)
    {
        setDestinationCoordinates(coordinates, getOwner().getMap().getUnavailableTerrainsForMoving(), getOwner().getMap().getMapSize());

        if (!getCoordinates().isNextToCoordinates(coordinates)) {
            setDestinationCoordinates(getPath().get(getPath().size() - 2), getOwner().getMap().getUnavailableTerrainsForMoving(), getOwner().getMap().getMapSize());
        }
        else {
            attackUnit();
        }

        setMoving(true);
        setAttacking(true);
        setAttackingUnitCoordinates(coordinates);
        setAttackDestination(getPath().get(getPath().size() - 1));


        moveUnit(getOwner().getMap().getOriginalMap().getTerrains(), getOwner().getMap(), new MilitaryView());
    }



    private void attackUnit()
    {
        if (getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()) != null){
            new MilitaryView().showUnitIsAttacking(getGameName(), getCoordinates());
            new MilitaryView().showUnitIsUnderAttack(
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getGameName(),
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getCoordinates());
            fightMeleeToMelee(this, getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
        else if (getOwner().getMap().getUnits().getRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()) != null){
            new MilitaryView().showUnitIsAttacking(getGameName(), getCoordinates());
            new MilitaryView().showUnitIsUnderAttack(
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getGameName(),
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getCoordinates());
            fightMeleeToRanged(this, getOwner().getMap().getUnits().getRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
        else if (getOwner().getMap().getUnits().getHeavyRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()) != null){
            new MilitaryView().showUnitIsAttacking(getGameName(), getCoordinates());
            new MilitaryView().showUnitIsUnderAttack(
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getGameName(),
                    getOwner().getMap().getUnits().getMeleeMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()).getCoordinates());
            fightMeleeToHeavy(this, getOwner().getMap().getUnits().getHeavyRangedMilitaryUnitFromCoordinates(getAttackingUnitCoordinates()));
        }
    }
}
