package Model;

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
        //TODO:
        return 0;
    }



    public  int getOverallDefence()
    {
        //TODO:
        return 0;
    }
}
