package Model;

public enum BuildingTypes {
    //Ancient Buildings


    ;


    final Building building;

    BuildingTypes(String gameName, int cost, int maintenance, int foodPerTurn, int productionPurTurn,
                  int happinessPurTurn, int goldPurTurn, int sciencePurTurn, int defenceEffect, int unitsXpBonus,
                  Technologies technologyNeeded, BuildingTypes requiredBuildings, boolean needsRiver, boolean needsHorse)
    {
        building  = new Building(gameName, cost, maintenance, foodPerTurn, productionPurTurn, happinessPurTurn, goldPurTurn,
                sciencePurTurn, defenceEffect, unitsXpBonus, technologyNeeded, requiredBuildings, needsRiver, needsHorse);
    }
}
