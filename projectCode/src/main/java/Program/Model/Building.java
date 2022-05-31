package Program.Model;

public class Building {
    private String gameName;
    private int cost;
    private int productionNeeded;
    private int maintenance;
    private int foodPerTurn;
    private int productionPerTurn;
    private int happinessPerTurn;
    private int goldPerTurn;
    private int goldEffect;
    private int sciencePerTwoCitizen;
    private int scienceEffect;
    private int defenceEffect;
    private int unitsXpBonus;
    private Technologies technologyNeeded;
    private BuildingTypes RequiredBuildings;
    private boolean needsRiver;
    private boolean needsHorse;
    private Eras era;





    ////methods////

    public Building(String gameName, int cost, int productionNeeded, int maintenance, int foodPerTurn, int productionPerTurn,
                    int happinessPerTurn, int goldPerTurn, int goldEffect, int sciencePerTwoCitizen, int scienceEffect, int defenceEffect, int unitsXpBonus,
                    Technologies technologyNeeded, BuildingTypes requiredBuildings, boolean needsRiver, boolean needsHorse, Eras era) {
        this.gameName = gameName;
        this.cost = cost;
        this.productionNeeded  = productionNeeded;
        this.maintenance = maintenance;
        this.foodPerTurn = foodPerTurn;
        this.productionPerTurn = productionPerTurn;
        this.happinessPerTurn = happinessPerTurn;
        this.goldPerTurn = goldPerTurn;
        this.goldEffect = goldEffect;
        this.sciencePerTwoCitizen = sciencePerTwoCitizen;
        this.scienceEffect = scienceEffect;
        this.defenceEffect = defenceEffect;
        this.unitsXpBonus = unitsXpBonus;
        this.technologyNeeded = technologyNeeded;
        this.RequiredBuildings = requiredBuildings;
        this.needsRiver = needsRiver;
        this.needsHorse = needsHorse;
        this.era = era;
    }



    public Building (BuildingTypes building)
    {
        this.gameName = building.building.gameName;
        this.cost = building.building.cost;
        this.productionNeeded  = building.building.productionNeeded;
        this.maintenance = building.building.maintenance;
        this.foodPerTurn = building.building.foodPerTurn;
        this.productionPerTurn = building.building.productionPerTurn;
        this.happinessPerTurn = building.building.happinessPerTurn;
        this.goldPerTurn = building.building.goldPerTurn;
        this.goldEffect = building.building.goldEffect;
        this.sciencePerTwoCitizen = building.building.sciencePerTwoCitizen;
        this.scienceEffect = building.building.scienceEffect;
        this.defenceEffect = building.building.defenceEffect;
        this.unitsXpBonus = building.building.unitsXpBonus;
        this.technologyNeeded = building.building.technologyNeeded;
        this.RequiredBuildings = building.building.getRequiredBuildings();
        this.needsRiver = building.building.needsRiver;
        this.needsHorse = building.building.needsHorse;
        this.era = building.building.era;
    }



    //getters
    public String getGameName() {
        return gameName;
    }


    public int getCost() {
        return cost;
    }


    public int getProductionNeeded() {
        return productionNeeded;
    }


    public int getMaintenance() {
        return maintenance;
    }


    public int getFoodPerTurn() {
        return foodPerTurn;
    }


    public int getProductionPerTurn() {
        return productionPerTurn;
    }


    public int getHappinessPerTurn() {
        return happinessPerTurn;
    }


    public int getGoldPerTurn() {
        return goldPerTurn;
    }


    public int getGoldEffect() {
        return goldEffect;
    }


    public int getSciencePerTwoCitizen() {
        return sciencePerTwoCitizen;
    }


    public int getScienceEffect() {
        return scienceEffect;
    }


    public int getDefenceEffect() {
        return defenceEffect;
    }


    public int getUnitsXpBonus() {
        return unitsXpBonus;
    }


    public Technologies getTechnologyNeeded() {
        return technologyNeeded;
    }


    public BuildingTypes getRequiredBuildings() {
        return RequiredBuildings;
    }


    public boolean isNeedsRiver() {
        return needsRiver;
    }


    public boolean isNeedsHorse() {
        return needsHorse;
    }


    public Eras getEra() {
        return era;
    }
}
