package Model;

import View.MilitaryView;

import java.util.ArrayList;
import java.util.Random;

public class MilitaryUnit extends Unit{
    private int attackDamage;
    private int level;
    private Technologies technologyRequired;
    private StrategicResourceTypes resourceRequired;
    private Eras era;
    private int turnsAfterStartingToFortify;
    boolean isFortifying;
    boolean isFortified;
    private int defenceBonus;
    private int attackBonus;
    private boolean isCavalry;
    private boolean isInCity;
    private boolean isAttacking;
    private Coordinates attackingUnitCoordinates;
    private Coordinates attackDestination;






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
        this.isCavalry = isCavalry;
    }



    public MilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates)
    {
        super(unit.getGameName(), unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(),
                unit.getProductionNeededForBeingMade(), unit.getMaintenancePricePerTurn());
        super.setCoordinates(coordinates);
        this.attackDamage = unit.getAttackDamage();
        this.technologyRequired = unit.getTechnologyRequired();
        this.resourceRequired = unit.getResourceRequired();
        this.era = unit.getEra();
        this.level = 1;
        this.isCavalry = unit.getIsCavalry();
    }



    public MilitaryUnit(RangedMilitaryUnit unit, Coordinates coordinates)
    {
        super(unit.getGameName(), unit.getHealth(), unit.getVisibilityRange(), unit.getMaxMovements(), unit.getPrice(),
                unit.getProductionNeededForBeingMade(), unit.getMaintenancePricePerTurn());
        super.setCoordinates(coordinates);
    }



    public void moveUnit(ArrayList<Terrain> terrains, MiniMap miniMap, MilitaryView view)
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

        getOwner().getMap().updateMap();

        if (getCoordinates().equals(getDestinationCoordinates())){
            setMoving(false);
        }
    }



    public void updateFortifying()
    {
        if (isFortifying){
            turnsAfterStartingToFortify++;
        }
        else {
            return;
        }

        if (turnsAfterStartingToFortify >= 2){
            isFortified = true;
            isFortifying = false;
            turnsAfterStartingToFortify = 0;
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
        if (getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty() != null) {
            return ((100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) *
                    (100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty().getFightChangePercentage()) *
                    (getAttackDamage())) / 10000;
        }
        else {
            return ((100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) * (getAttackDamage())) / 100;
        }
    }



    public double getOverallDefence()
    {
        if (getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty() != null) {
            if (isFortified){
                return (double)((110 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) *
                        (100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty().getFightChangePercentage())) / 10000;
            }
            return (double)((100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) *
                    (100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getProperty().getFightChangePercentage())) / 10000;
        }
        else {
            return (double)(100 + getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getFightChangePercentage()) / 100;
        }
    }


    public int getLevel() {
        return level;
    }


    public int getTurnsAfterStartingToFortify() {
        return turnsAfterStartingToFortify;
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


    public boolean isFortifying() {
        return isFortifying;
    }


    public boolean isFortified() {
        return isFortified;
    }


    public boolean isAttacking() {
        return isAttacking;
    }


    public Coordinates getAttackingUnitCoordinates() {
        return attackingUnitCoordinates;
    }


    public Coordinates getAttackDestination() {
        return attackDestination;
    }



    //setters:

    public void setFortifying(boolean fortifying) {
        isFortifying = fortifying;
    }


    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }


    public void setAttackingUnitCoordinates(Coordinates attackingUnitCoordinates) {
        this.attackingUnitCoordinates = attackingUnitCoordinates;
    }


    public void setAttackDestination(Coordinates attackDestination) {
        this.attackDestination = attackDestination;
    }



    public void fightMeleeToRanged(MeleeMilitaryUnit meleeUnit, RangedMilitaryUnit rangedUnit)
    {
        int unit1AttackDamage = meleeUnit.getOverallDamage();
        int unit2AttackDamage = rangedUnit.getOverallDamage();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            unit1AttackDamage += rand.nextInt(unit1AttackDamage / 15);
        }
        else {
            unit1AttackDamage -= rand.nextInt(unit1AttackDamage / 15);
        }

        if (rand.nextInt(2) == 0){
            unit2AttackDamage += rand.nextInt(unit2AttackDamage / 15);
        }
        else {
            unit2AttackDamage -= rand.nextInt(unit2AttackDamage / 15);
        }

        unit1AttackDamage /= rangedUnit.getOverallDefence();
        unit2AttackDamage /= meleeUnit.getOverallDefence();

        meleeUnit.setHealth(getHealth() - unit2AttackDamage);
        rangedUnit.setHealth(getHealth() - unit1AttackDamage);

        if (meleeUnit.getHealth() <= 0){
            meleeUnit.getOwner().getPlayerUnits().getMeleeMilitaryUnits().remove(meleeUnit);
            meleeUnit.getOwner().getMap().getUnits().getMeleeMilitaryUnits().remove(meleeUnit);
            meleeUnit.getOwner().getMap().getOriginalMap().getUnits().getMeleeMilitaryUnits().remove(meleeUnit);
            new MilitaryView().showUnitDied(meleeUnit.getGameName(), meleeUnit.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(rangedUnit.getGameName(), rangedUnit.getCoordinates());
        }

        if (rangedUnit.getHealth() <= 0){
            rangedUnit.getOwner().getPlayerUnits().getRangedMilitaryUnits().remove(rangedUnit);
            rangedUnit.getOwner().getMap().getUnits().getRangedMilitaryUnits().remove(rangedUnit);
            rangedUnit.getOwner().getMap().getOriginalMap().getUnits().getRangedMilitaryUnits().remove(rangedUnit);
            new MilitaryView().showUnitDied(rangedUnit.getGameName(), rangedUnit.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(meleeUnit.getGameName(), meleeUnit.getCoordinates());

        }
    }



    public void fightMeleeToMelee(MeleeMilitaryUnit meleeUnit1, MeleeMilitaryUnit meleeUnit2)
    {
        int unit1AttackDamage = meleeUnit1.getOverallDamage();
        int unit2AttackDamage = meleeUnit2.getOverallDamage();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            unit1AttackDamage += rand.nextInt(unit1AttackDamage / 15);
        }
        else {
            unit1AttackDamage -= rand.nextInt(unit1AttackDamage / 15);
        }

        if (rand.nextInt(2) == 0){
            unit2AttackDamage += rand.nextInt(unit2AttackDamage / 15);
        }
        else {
            unit2AttackDamage -= rand.nextInt(unit2AttackDamage / 15);
        }

        unit1AttackDamage /= meleeUnit2.getOverallDefence();
        unit2AttackDamage /= meleeUnit1.getOverallDefence();

        meleeUnit1.setHealth(getHealth() - unit2AttackDamage);
        meleeUnit2.setHealth(getHealth() - unit1AttackDamage);

        if (meleeUnit1.getHealth() <= 0){
            meleeUnit1.getOwner().getPlayerUnits().getMeleeMilitaryUnits().remove(meleeUnit1);
            meleeUnit1.getOwner().getMap().getUnits().getMeleeMilitaryUnits().remove(meleeUnit1);
            meleeUnit1.getOwner().getMap().getOriginalMap().getUnits().getMeleeMilitaryUnits().remove(meleeUnit1);
            new MilitaryView().showUnitDied(meleeUnit1.getGameName(), meleeUnit1.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(meleeUnit2.getGameName(), meleeUnit2.getCoordinates());

        }

        if (meleeUnit2.getHealth() <= 0){
            meleeUnit2.getOwner().getPlayerUnits().getMeleeMilitaryUnits().remove(meleeUnit2);
            meleeUnit2.getOwner().getMap().getUnits().getMeleeMilitaryUnits().remove(meleeUnit2);
            meleeUnit2.getOwner().getMap().getOriginalMap().getUnits().getMeleeMilitaryUnits().remove(meleeUnit2);
            new MilitaryView().showUnitDied(meleeUnit2.getGameName(), meleeUnit2.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(meleeUnit1.getGameName(), meleeUnit1.getCoordinates());
        }
    }



    public void fightMeleeToHeavy(MeleeMilitaryUnit meleeUnit, HeavyRangedMilitaryUnits heavyUnit)
    {
        int unit1AttackDamage = meleeUnit.getOverallDamage();
        int unit2AttackDamage = heavyUnit.getOverallDamage();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            unit1AttackDamage += rand.nextInt(unit1AttackDamage / 15);
        }
        else {
            unit1AttackDamage -= rand.nextInt(unit1AttackDamage / 15);
        }

        if (rand.nextInt(2) == 0){
            unit2AttackDamage += rand.nextInt(unit2AttackDamage / 15);
        }
        else {
            unit2AttackDamage -= rand.nextInt(unit2AttackDamage / 15);
        }

        unit1AttackDamage /= heavyUnit.getOverallDefence();
        unit2AttackDamage /= meleeUnit.getOverallDefence();

        meleeUnit.setHealth(getHealth() - unit2AttackDamage);
        heavyUnit.setHealth(getHealth() - unit1AttackDamage);

        if (meleeUnit.getHealth() <= 0){
            meleeUnit.getOwner().getPlayerUnits().getMeleeMilitaryUnits().remove(meleeUnit);
            meleeUnit.getOwner().getMap().getUnits().getMeleeMilitaryUnits().remove(meleeUnit);
            meleeUnit.getOwner().getMap().getOriginalMap().getUnits().getMeleeMilitaryUnits().remove(meleeUnit);
            new MilitaryView().showUnitDied(meleeUnit.getGameName(), meleeUnit.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(heavyUnit.getGameName(), heavyUnit.getCoordinates());
        }

        if (heavyUnit.getHealth() <= 0){
            heavyUnit.getOwner().getPlayerUnits().getHeavyRangedUnits().remove(heavyUnit);
            heavyUnit.getOwner().getMap().getUnits().getHeavyRangedUnits().remove(heavyUnit);
            heavyUnit.getOwner().getMap().getOriginalMap().getUnits().getHeavyRangedUnits().remove(heavyUnit);
            new MilitaryView().showUnitDied(heavyUnit.getGameName(), heavyUnit.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(meleeUnit.getGameName(), meleeUnit.getCoordinates());
        }
    }



    public void fightRangedToMelee(RangedMilitaryUnit attacker, MeleeMilitaryUnit defender)
    {
        int attackDamage = attacker.getOverallRangedAttackDamage();
        attackDamage /= defender.getOverallDefence();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            attackDamage += rand.nextInt(attackDamage / 15);
        }
        else {
            attackDamage -= rand.nextInt(attackDamage / 15);
        }

        defender.setHealth(defender.getHealth() - attackDamage);

        if (defender.getHealth() <= 0){
            defender.getOwner().getPlayerUnits().getMeleeMilitaryUnits().remove(defender);
            defender.getOwner().getMap().getUnits().getMeleeMilitaryUnits().remove(defender);
            defender.getOwner().getMap().getOriginalMap().getUnits().getMeleeMilitaryUnits().remove(defender);
            new MilitaryView().showUnitDied(defender.getGameName(), defender.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(attacker.getGameName(), attacker.getCoordinates());
        }
    }



    public void fightRangedToRanged(RangedMilitaryUnit attacker, RangedMilitaryUnit defender)
    {
        int attackDamage = attacker.getOverallRangedAttackDamage();
        attackDamage /= defender.getOverallDefence();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            attackDamage += rand.nextInt(attackDamage / 15);
        }
        else {
            attackDamage -= rand.nextInt(attackDamage / 15);
        }

        defender.setHealth(defender.getHealth() - attackDamage);

        if (defender.getHealth() <= 0){
            defender.getOwner().getPlayerUnits().getRangedMilitaryUnits().remove(defender);
            defender.getOwner().getMap().getUnits().getRangedMilitaryUnits().remove(defender);
            defender.getOwner().getMap().getOriginalMap().getUnits().getRangedMilitaryUnits().remove(defender);
            new MilitaryView().showUnitDied(defender.getGameName(), defender.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(attacker.getGameName(), attacker.getCoordinates());
        }
    }



    public void fightRangedToHeavy(RangedMilitaryUnit attacker, HeavyRangedMilitaryUnits defender)
    {
        int attackDamage = attacker.getOverallRangedAttackDamage();
        attackDamage /= defender.getOverallDefence();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            attackDamage += rand.nextInt(attackDamage / 15);
        }
        else {
            attackDamage -= rand.nextInt(attackDamage / 15);
        }

        defender.setHealth(defender.getHealth() - attackDamage);

        if (defender.getHealth() <= 0){
            defender.getOwner().getPlayerUnits().getHeavyRangedUnits().remove(defender);
            defender.getOwner().getMap().getUnits().getHeavyRangedUnits().remove(defender);
            defender.getOwner().getMap().getOriginalMap().getUnits().getHeavyRangedUnits().remove(defender);
            new MilitaryView().showUnitDied(defender.getGameName(), defender.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(attacker.getGameName(), attacker.getCoordinates());
        }
    }



    public void fightHeavyToMelee(HeavyRangedMilitaryUnits attacker, MeleeMilitaryUnit defender)
    {
        int attackDamage = attacker.getOverallRangedAttackDamage();
        attackDamage /= defender.getOverallDefence();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            attackDamage += rand.nextInt(attackDamage / 15);
        }
        else {
            attackDamage -= rand.nextInt(attackDamage / 15);
        }

        defender.setHealth(defender.getHealth() - attackDamage);

        if (defender.getHealth() <= 0){
            defender.getOwner().getPlayerUnits().getMeleeMilitaryUnits().remove(defender);
            defender.getOwner().getMap().getUnits().getMeleeMilitaryUnits().remove(defender);
            defender.getOwner().getMap().getOriginalMap().getUnits().getMeleeMilitaryUnits().remove(defender);
            new MilitaryView().showUnitDied(defender.getGameName(), defender.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(attacker.getGameName(), attacker.getCoordinates());
        }
    }



    public void fightHeavyToRanged(HeavyRangedMilitaryUnits attacker, RangedMilitaryUnit defender)
    {
        int attackDamage = attacker.getOverallRangedAttackDamage();
        attackDamage /= defender.getOverallDefence();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            attackDamage += rand.nextInt(attackDamage / 15);
        }
        else {
            attackDamage -= rand.nextInt(attackDamage / 15);
        }

        defender.setHealth(defender.getHealth() - attackDamage);

        if (defender.getHealth() <= 0){
            defender.getOwner().getPlayerUnits().getRangedMilitaryUnits().remove(defender);
            defender.getOwner().getMap().getUnits().getRangedMilitaryUnits().remove(defender);
            defender.getOwner().getMap().getOriginalMap().getUnits().getRangedMilitaryUnits().remove(defender);
            new MilitaryView().showUnitDied(defender.getGameName(), defender.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(attacker.getGameName(), attacker.getCoordinates());
        }
    }



    public void fightHeavyToHeavy(HeavyRangedMilitaryUnits attacker, HeavyRangedMilitaryUnits defender)
    {
        int attackDamage = attacker.getOverallRangedAttackDamage();
        attackDamage /= defender.getOverallDefence();

        Random rand = new Random();

        if (rand.nextInt(2) == 0){
            attackDamage += rand.nextInt(attackDamage / 15);
        }
        else {
            attackDamage -= rand.nextInt(attackDamage / 15);
        }

        defender.setHealth(defender.getHealth() - attackDamage);

        if (defender.getHealth() <= 0){
            defender.getOwner().getPlayerUnits().getHeavyRangedUnits().remove(defender);
            defender.getOwner().getMap().getUnits().getHeavyRangedUnits().remove(defender);
            defender.getOwner().getMap().getOriginalMap().getUnits().getHeavyRangedUnits().remove(defender);
            new MilitaryView().showUnitDied(defender.getGameName(), defender.getCoordinates());
            new MilitaryView().showUnitKilledEnemy(attacker.getGameName(), attacker.getCoordinates());
        }
    }
}
