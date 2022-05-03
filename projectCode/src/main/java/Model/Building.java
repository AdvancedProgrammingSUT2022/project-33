package Model;

public class Building {
    String gameName;
    int cost;
    int maintenance;
    int foodPerTurn;
    int productionPurTurn;
    int happinessPurTurn;
    int goldPurTurn;
    int sciencePurTurn;
    int defenceEffect;
    int unitsXpBonus;
    Technologies technologyNeeded;
    BuildingTypes RequiredBuildings;
    boolean needsRiver;
    boolean needsHorse;





    ////methods////

    public Building(String gameName, int cost, int maintenance, int foodPerTurn, int productionPurTurn,
                    int happinessPurTurn, int goldPurTurn, int sciencePurTurn, int defenceEffect, int unitsXpBonus,
                    Technologies technologyNeeded, BuildingTypes requiredBuildings, boolean needsRiver, boolean needsHorse) {
        this.gameName = gameName;
        this.cost = cost;
        this.maintenance = maintenance;
        this.foodPerTurn = foodPerTurn;
        this.productionPurTurn = productionPurTurn;
        this.happinessPurTurn = happinessPurTurn;
        this.goldPurTurn = goldPurTurn;
        this.sciencePurTurn = sciencePurTurn;
        this.defenceEffect = defenceEffect;
        this.unitsXpBonus = unitsXpBonus;
        this.technologyNeeded = technologyNeeded;
        RequiredBuildings = requiredBuildings;
        this.needsRiver = needsRiver;
        this.needsHorse = needsHorse;
    }
}
