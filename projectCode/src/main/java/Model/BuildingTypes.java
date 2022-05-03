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
    ARMORY("Armory", 130, 115, 3, 0, 0, 0, 0, 0,
            0, 0, 15, Technologies.IRON_WORKING, BuildingTypes.BARRACKS, false, false, Eras.CLASSICAL),
    BURIAL_TOMB("Burial Tomb", 120, 120, 0, 0, 0, 2, 0, 0,
            0, 0, 0, Technologies.PHILOSOPHY, null, false, false, Eras.CLASSICAL),
    CIRCUS("Circus", 150, 140, 3, 0, 0, 3, 0, 0,
            0, 0, 0, Technologies.HORSEBACK_RIDING, null, false, true, Eras.CLASSICAL),
    COLOSSEUM("Colosseum", 150, 165, 3, 0, 0, 4, 0, 0,
            0, 0, 0, Technologies.CONSTRUCTION, null, false, false, Eras.CLASSICAL),
    COURTHOUSE("Courthouse", 200, 190, 5, 0, 0, 0, 0, 0,
            0, 0, 0, Technologies.MATHEMATICS, null, false, false, Eras.CLASSICAL),
    STABLE("Stable", 100, 110, 1, 0, 2, 0, 0, 0,
            0, 0, 0, Technologies.HORSEBACK_RIDING, null, false, true, Eras.CLASSICAL),
    TEMPLE("Temple", 120, 140, 2, 0, 1, 0, 0, 0,
            0, 0, 0, Technologies.PHILOSOPHY, BuildingTypes.MONUMENT, false, false, Eras.CLASSICAL),

    //Medieval buildings
    


    ;


    final Building building;

    BuildingTypes(String gameName, int cost, int productionNeeded, int maintenance, int foodPerTurn, int productionPerTurn,
                  int happinessPerTurn, int goldPerTurn, int sciencePerTwoCitizen, int scienceEffect, int defenceEffect, int unitsXpBonus,
                  Technologies technologyNeeded, BuildingTypes requiredBuildings, boolean needsRiver, boolean needsHorse, Eras era)
    {
        building  = new Building(gameName, cost, productionNeeded, maintenance, foodPerTurn, productionPerTurn, happinessPerTurn, goldPerTurn,
                sciencePerTwoCitizen, scienceEffect, defenceEffect, unitsXpBonus, technologyNeeded, requiredBuildings, needsRiver, needsHorse, era);
    }
}
