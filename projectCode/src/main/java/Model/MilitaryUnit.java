package Model;

import Controller.MeleeView;
import View.SettlerView;

import java.util.ArrayList;

public class MilitaryUnit extends Unit{
    private int attackDamage;
    private int level;
    private Technologies technologyRequired;
    private StrategicResourceTypes resourceRequired;
    private Eras era;
    private int turnsAfterStartingToStabilize;
    private int defenceBonus;
    private int attackBonus;
    private boolean isCavalry;





    ////methods////
    public MilitaryUnit (String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                         int attackDamage, boolean isCavalry, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        super(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn);
        this.attackDamage = attackDamage;
        this.technologyRequired = technologyRequired;
        this.resourceRequired = resourceRequired;
        this.era = era;
        this.level = 1;
        this.isCavalry = true;
    }



    public MilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates)
    {
        super(unit.getGameName(), unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(),
                unit.getProductionNeededForBeingMade(), unit.getMaintenancePricePerTurn());
        super.setCoordinates(coordinates);
    }



    public MilitaryUnit(RangedMilitaryUnit unit, Coordinates coordinates)
    {
        super(unit.getGameName(), unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(),
                unit.getProductionNeededForBeingMade(), unit.getMaintenancePricePerTurn());
        super.setCoordinates(coordinates);
    }



    public void moveUnit(ArrayList<Terrain> terrains, MiniMap miniMap, MeleeView view)
    {
        ArrayList<Coordinates> remainingPath = new ArrayList<>();

        int i = 0;

        while(!getPath().get(i).equals(getCoordinates())){
            i++;
        }

        i++;

        while (i < getPath().size()){
            remainingPath.add(getPath().get(i));
            i++;
        }

        i = 0;

        while (!getCoordinates().equals(getDestinationCoordinates()) &&
                getRemainingMovements() >= getTerrainFromCoordinates(terrains, remainingPath.get(i)).getMovementPrice()){
            if (miniMap.getUnits().getMeleeMilitaryUnitFromCoordinates(remainingPath.get(i)) != null){
                view.showOccupiedCoordinates(false, remainingPath.get(i));
                resetDestinationCoordinates();
                setMoving(false);
                return;
            }
            else if (miniMap.getUnits().getRangedMilitaryUnitFromCoordinates(remainingPath.get(i)) != null){
                view.showOccupiedCoordinates(false, remainingPath.get(i));
                resetDestinationCoordinates();
                setMoving(false);
                return;
            }
            else if (miniMap.getUnits().getHeavyRangedMilitaryUnitFromCoordinates(remainingPath.get(i)) != null){
                view.showOccupiedCoordinates(false, remainingPath.get(i));
                resetDestinationCoordinates();
                setMoving(false);
                return;
            }


            setRemainingMovements(getRemainingMovements() - getTerrainFromCoordinates(terrains, remainingPath.get(i)).getMovementPrice());
            setCoordinates(remainingPath.get(i));
            i++;
        }


        if (getCoordinates().equals(getDestinationCoordinates())){
            setMoving(false);
        }
    }



    //getters
    public int getAttackDamage() {
        return attackDamage;
    }


    public Technologies getTechnologyRequired() {
        return technologyRequired;
    }


    public StrategicResourceTypes getResourceRequired() {
        return resourceRequired;
    }


    public Eras getEra() {
        return era;
    }


    public boolean getIsCavalry()
    {
        return isCavalry;
    }



    public int getOverallDamage()
    {
        return ((100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) *
                (100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty().getFightChangePercentage()) *
                (getAttackDamage())) / 10000;
    }



    public  int getOverallDefence()
    {
        return ((100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) *
                (100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty().getFightChangePercentage())) / 10000;
    }


    public int getLevel() {
        return level;
    }


    public int getTurnsAfterStartingToStabilize() {
        return turnsAfterStartingToStabilize;
    }


    public int getDefenceBonus() {
        return defenceBonus;
    }


    public int getAttackBonus() {
        return attackBonus;
    }


    public boolean isCavalry() {
        return isCavalry;
    }
}
