package Model;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Technologies {
    //Ancient Technologies
    AGRICULTURE("Agriculture" ,20, new ArrayList<>(), Eras.ANCIENT),
    ANIMAL_HUSBANDRY("Animal Husbandry" ,35, new ArrayList<>(List.of(Technologies.AGRICULTURE)), Eras.ANCIENT),
    ARCHERY("Archery", 35, new ArrayList<>(List.of(Technologies.AGRICULTURE)), Eras.ANCIENT),
    MINING("Mining", 35, new ArrayList<>(List.of(Technologies.AGRICULTURE)), Eras.ANCIENT),
    POTTERY("Pottery", 35, new ArrayList<>(List.of(Technologies.AGRICULTURE)), Eras.ANCIENT),
    BRONZE_WORKING("Bronze Working", 55, new ArrayList<>(List.of(Technologies.MINING)), Eras.ANCIENT),
    MASONRY("Masonry", 55, new ArrayList<>(List.of(Technologies.MINING)), Eras.ANCIENT),
    THE_WHEEL("The Wheel", 55, new ArrayList<>(List.of(Technologies.ANIMAL_HUSBANDRY)), Eras.ANCIENT),
    TRAPPING("Trapping", 55, new ArrayList<>(List.of(Technologies.ANIMAL_HUSBANDRY)), Eras.ANCIENT),
    WRITING("Writing", 55, new ArrayList<>(List.of(Technologies.POTTERY)), Eras.ANCIENT),
    CALENDER("Calender", 70, new ArrayList<>(List.of(Technologies.POTTERY)), Eras.ANCIENT),

    //Classical technologies
    CONSTRUCTION("Construction", 100, new ArrayList<>(List.of(Technologies.MASONRY)), Eras.CLASSICAL),
    HORSEBACK_RIDING("Horseback Riding", 100, new ArrayList<>(List.of(Technologies.THE_WHEEL)), Eras.CLASSICAL),
    MATHEMATICS("Mathematics", 100, new ArrayList<>(Arrays.asList(Technologies.THE_WHEEL, Technologies.ARCHERY)), Eras.CLASSICAL),
    PHILOSOPHY("Philosophy", 100, new ArrayList<>(List.of(Technologies.WRITING)), Eras.CLASSICAL),
    IRON_WORKING("Iron Working", 150, new ArrayList<>(List.of(Technologies.BRONZE_WORKING)), Eras.CLASSICAL),

    //Medieval technologies
    METAL_CASTING("Metal Casting", 250, new ArrayList<>(List.of(Technologies.IRON_WORKING)), Eras.MEDIEVAL),
    CURRENCY("Currency", 250, new ArrayList<>(List.of(Technologies.MATHEMATICS)), Eras.MEDIEVAL),
    ENGINEERING("Engineering", 250, new ArrayList<>(Arrays.asList(Technologies.MATHEMATICS, Technologies.CONSTRUCTION)), Eras.MEDIEVAL),
    THEOLOGY("Theology", 250, new ArrayList<>(Arrays.asList(CALENDER, PHILOSOPHY)), Eras.MEDIEVAL),
    CIVIL_SERVICE("Civil Service", 400, new ArrayList<>(Arrays.asList(PHILOSOPHY, TRAPPING)), Eras.MEDIEVAL),
    CHIVALRY("Chivalry", 440, new ArrayList<>(Arrays.asList(CIVIL_SERVICE, HORSEBACK_RIDING, CURRENCY)), Eras.MEDIEVAL),
    EDUCATION("Education", 440, new ArrayList<>(List.of(THEOLOGY)), Eras.MEDIEVAL),
    MACHINERY("Machinery", 440, new ArrayList<>(List.of(ENGINEERING)), Eras.MEDIEVAL),
    PHYSICS("Physics", 440, new ArrayList<>(Arrays.asList(ENGINEERING, METAL_CASTING)), Eras.MEDIEVAL),
    STEEL("Steel", 440, new ArrayList<>(List.of(METAL_CASTING)), Eras.MEDIEVAL),

    //Renaissance technologies
    ACOUSTICS("Acoustics", 650, new ArrayList<>(List.of(EDUCATION)), Eras.RENAISSANCE),
    BANKING("Banking", 650, new ArrayList<>(Arrays.asList(EDUCATION, CHIVALRY)), Eras.RENAISSANCE),
    PRINTING_PRESS("Printing Press", 650, new ArrayList<>(Arrays.asList(MACHINERY, PHYSICS)), Eras.RENAISSANCE),
    GUNPOWDER("Gunpowder", 680, new ArrayList<>(Arrays.asList(PHYSICS, STEEL)), Eras.RENAISSANCE),
    CHEMISTRY("Chemistry", 900, new ArrayList<>(List.of(GUNPOWDER)), Eras.RENAISSANCE),
    ECONOMICS("Economics", 900, new ArrayList<>(Arrays.asList(BANKING, PRINTING_PRESS)), Eras.RENAISSANCE),
    METALLURGY("Metallurgy", 900, new ArrayList<>(List.of(GUNPOWDER)), Eras.RENAISSANCE),
    ARCHAEOLOGY("Archaeology", 1300, new ArrayList<>(List.of(ACOUSTICS)), Eras.RENAISSANCE),
    FERTILIZER("Fertilizer", 1300, new ArrayList<>(List.of(CHEMISTRY)), Eras.RENAISSANCE),
    MILITARY_SCIENCE("Military Science", 1300, new ArrayList<>(Arrays.asList(ECONOMICS, CHEMISTRY)), Eras.RENAISSANCE),
    SCIENTIFIC_THEORY("Scientific Theory", 1300, new ArrayList<>(List.of(ACOUSTICS)), Eras.RENAISSANCE),
    RIFLING("Rifling",  1425, new ArrayList<>(List.of(METALLURGY)), Eras.RENAISSANCE),

    //Industrial technologies
    BIOLOGY("Biology", 1680, new ArrayList<>(Arrays.asList(ARCHAEOLOGY, SCIENTIFIC_THEORY)), Eras.INDUSTRIAL),
    STEAM_POWER("Steam Power", 1680, new ArrayList<>(Arrays.asList(SCIENTIFIC_THEORY, MILITARY_SCIENCE)), Eras.INDUSTRIAL),
    DYNAMITE("Dynamite", 1900, new ArrayList<>(Arrays.asList(FERTILIZER, RIFLING)), Eras.INDUSTRIAL),
    ELECTRICITY("Electricity", 1900, new ArrayList<>(Arrays.asList(BIOLOGY, STEAM_POWER)), Eras.INDUSTRIAL),
    RAILROAD("Railroad", 1900, new ArrayList<>(List.of(STEAM_POWER)), Eras.INDUSTRIAL),
    REPLACEABLE_PARTS("Replaceable Parts", 1900, new ArrayList<>(List.of(STEAM_POWER)), Eras.INDUSTRIAL),
    COMBUSTION("Combustion", 2200, new ArrayList<>(Arrays.asList(REPLACEABLE_PARTS, RAILROAD, DYNAMITE)), Eras.INDUSTRIAL),
    RADIO("Radio", 2200, new ArrayList<>(List.of(ELECTRICITY)), Eras.INDUSTRIAL),
    TELEGRAPH("Telegraph", 2200, new ArrayList<>(List.of(ELECTRICITY)), Eras.INDUSTRIAL);


    final Technology technology;

    Technologies(String gameName, int researchCost, ArrayList<Technologies> neededTechnologies, Eras era)
    {
        technology = new Technology(gameName, researchCost, neededTechnologies, era);
    }
}
