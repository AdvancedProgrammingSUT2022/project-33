package Model;

public enum BuildingTypes {
    //Ancient Buildings
    BARRACKS("Barracks", 80,  75, 1, 0, 0, 0, 0, 0,
            0, 0, 15, Technologies.BRONZE_WORKING, null, false, false, Eras.ANCIENT),
    GRANARY("Granary", 100, 85, 1, 2, 0, 0, 0, 0,
            0, 0, 0, Technologies.POTTERY, null, false, false, Eras.ANCIENT),
    LIBRARY("Library", 80, 90, 1, 0, 0, 0, 0, 1,
            0, 0, 0, Technologies.WRITING, null, false, false, Eras.ANCIENT),
    MONUMENT("Monument", 60, 75, 1, 0, 1, 0, 0, 0,
            0, 0, 0, null, null, false, false, Eras.ANCIENT),
    WALLS("Walls", 100, 100, 1, 0, 0, 0, 0,0 ,
            0, 5, 0, Technologies.MASONRY, null, false, false, Eras.ANCIENT),
    WATER_MILL("Watter Mill", 120, 110, 2, 2, 1, 0, 0, 0,
            0, 0, 0, Technologies.THE_WHEEL, null, true, false, Eras.ANCIENT),

    //Classical Buildings
    



    ;


    final Building building;

    BuildingTypes(String gameName, int cost, int productionNeeded, int maintenance, int foodPerTurn, int productionPurTurn,
                  int happinessPurTurn, int goldPurTurn, int sciencePurTwoCitizen, int scienceEffect, int defenceEffect, int unitsXpBonus,
                  Technologies technologyNeeded, BuildingTypes requiredBuildings, boolean needsRiver, boolean needsHorse, Eras era)
    {
        building  = new Building(gameName, cost, productionNeeded, maintenance, foodPerTurn, productionPurTurn, happinessPurTurn, goldPurTurn,
                sciencePurTwoCitizen, scienceEffect, defenceEffect, unitsXpBonus, technologyNeeded, requiredBuildings, needsRiver, needsHorse, era);
    }
}
