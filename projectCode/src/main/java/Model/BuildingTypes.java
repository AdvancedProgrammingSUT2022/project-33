package Model;

public enum BuildingTypes {
    //Ancient Buildings
    BARRACKS("Barracks", 80,  75, 1, 0, 0, 0,
            0, 0, 0, 0, 0, 15,
            Technologies.BRONZE_WORKING, null, false, false, Eras.ANCIENT),
    GRANARY("Granary", 100, 85, 1, 2, 0, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.POTTERY, null, false, false, Eras.ANCIENT),
    LIBRARY("Library", 80, 90, 1, 0, 0, 0,
            0, 0, 1, 0, 0, 0,
            Technologies.WRITING, null, false, false, Eras.ANCIENT),
    MONUMENT("Monument", 60, 75, 1, 0, 1, 0,
            0, 0, 0, 0, 0, 0,
            null, null, false, false, Eras.ANCIENT),
    WALLS("Walls", 100, 100, 1, 0, 0, 0,
            0, 0,0 , 0, 5, 0,
            Technologies.MASONRY, null, false, false, Eras.ANCIENT),
    WATER_MILL("Water Mill", 120, 110, 2, 2, 1, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.THE_WHEEL, null, true, false, Eras.ANCIENT),

    //Classical Buildings
    ARMORY("Armory", 130, 115, 3, 0, 0, 0,
            0, 0,  0, 0, 0, 15,
            Technologies.IRON_WORKING, BuildingTypes.BARRACKS, false, false, Eras.CLASSICAL),
    BURIAL_TOMB("Burial Tomb", 120, 120, 0, 0, 0, 2,
            0, 0,  0, 0, 0, 0,
            Technologies.PHILOSOPHY, null, false, false, Eras.CLASSICAL),
    CIRCUS("Circus", 150, 140, 3, 0, 0, 3,
            0, 0, 0, 0, 0, 0,
            Technologies.HORSEBACK_RIDING, null, false, true, Eras.CLASSICAL),
    COLOSSEUM("Colosseum", 150, 165, 3, 0, 0, 4,
            0, 0, 0, 0, 0, 0,
            Technologies.CONSTRUCTION, null, false, false, Eras.CLASSICAL),
    COURTHOUSE("Courthouse", 200, 190, 5, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.MATHEMATICS, null, false, false, Eras.CLASSICAL),
    STABLE("Stable", 100, 110, 1, 0, 2, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.HORSEBACK_RIDING, null, false, true, Eras.CLASSICAL),
    TEMPLE("Temple", 120, 140, 2, 0, 1, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.PHILOSOPHY, BuildingTypes.MONUMENT, false, false, Eras.CLASSICAL),

    //Medieval buildings
     CASTLE("Castle", 200, 210, 3, 0, 0, 0,
            0, 0, 0, 0, 8, 0,
            Technologies.CHIVALRY, BuildingTypes.WALLS, false, false, Eras.MEDIEVAL),
    FORGE("Forge", 150, 135, 2, 0, 1, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.METAL_CASTING, null, false, false, Eras.MEDIEVAL),
    GARDEN("Garden", 120, 110, 2, 0, 1, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.THEOLOGY, null, true, false, Eras.MEDIEVAL),
    MARKET("Market", 120, 115, 0, 0, 0, 0,
            0, 25, 0, 0, 0, 0,
            Technologies.CURRENCY, null, false, false, Eras.MEDIEVAL),
    MINT("Mint", 120, 110, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.CURRENCY, null, false, false, Eras.MEDIEVAL),
    MONASTERY("Monastery", 120, 110, 2, 0, 0, 1,
            0, 0, 0, 0, 0, 0,
            Technologies.THEOLOGY, null, false, false, Eras.MEDIEVAL),
    UNIVERSITY("University", 200, 190, 3, 0, 0, 0,
            0, 0, 1, 50, 0, 0,
            Technologies.EDUCATION, BuildingTypes.LIBRARY, false, false, Eras.MEDIEVAL),
    WORKSHOP("Workshop", 100, 110, 2, 0, 5, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.METAL_CASTING, null, false, false, Eras.MEDIEVAL),

    //Renaissance buildings
    BANK("Bank", 220, 200, 0, 0, 0, 0,
            0, 25, 0, 0, 0, 0,
            Technologies.BANKING, BuildingTypes.MARKET, false, false, Eras.RENAISSANCE),
   MILITARY_ACADEMY("Military Academy", 350, 330, 3, 0, 0, 0,
           0, 0, 0, 0, 0, 15,
           Technologies.MILITARY_SCIENCE, null, false, false, Eras.RENAISSANCE),
    OPERA_HOUSE("Opera House", 220, 220, 3, 0, 0, 2,
            0, 0, 0, 0, 0, 0,
            Technologies.ACOUSTICS, BuildingTypes.TEMPLE, false, false, Eras.RENAISSANCE),
    MUSEUM("Museum", 350, 360, 3, 0, 1, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.ARCHAEOLOGY, BuildingTypes.OPERA_HOUSE, false, false, Eras.RENAISSANCE),
    PUBLIC_SCHOOL("Public School", 350, 320, 3, 0, 0, 0,
            0, 0, 0, 50, 0, 0,
            Technologies.SCIENTIFIC_THEORY, BuildingTypes.UNIVERSITY, false, false, Eras.RENAISSANCE),
    SATRAP_COURT("Satrap's Court", 220, 200, 0, 0, 0, 2,
            0, 25, 0, 0, 0, 0,
            Technologies.BANKING, BuildingTypes.MARKET, false, false, Eras.RENAISSANCE),
    THEATER("Theater", 300, 280, 5, 0, 0, 4,
            0, 0, 0, 0, 0, 0,
            Technologies.PRINTING_PRESS, BuildingTypes.COLOSSEUM, false, false, Eras.RENAISSANCE),
    WINDMILL("Windmill", 180, 170, 2, 0, 4, 0,
            0, 0, 0, 0, 0, 0,
            Technologies.ECONOMICS, null, false, false, Eras.RENAISSANCE),

    //Industrial Buildings



    ;


    final Building building;

    BuildingTypes(String gameName, int cost, int productionNeeded, int maintenance, int foodPerTurn, int productionPerTurn,
                  int happinessPerTurn, int goldPerTurn, int goldEffect, int sciencePerTwoCitizen, int scienceEffect, int defenceEffect, int unitsXpBonus,
                  Technologies technologyNeeded, BuildingTypes requiredBuildings, boolean needsRiver, boolean needsHorse, Eras era)
    {
        building  = new Building(gameName, cost, productionNeeded, maintenance, foodPerTurn, productionPerTurn, happinessPerTurn, goldPerTurn, goldEffect,
                sciencePerTwoCitizen, scienceEffect, defenceEffect, unitsXpBonus, technologyNeeded, requiredBuildings, needsRiver, needsHorse, era);
    }
}
