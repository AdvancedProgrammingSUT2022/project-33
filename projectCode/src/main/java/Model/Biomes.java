package Model;

import java.util.ArrayList;

public class Biomes {
    int desertChance;
    int grasslandChance;
    int hillsChance;
    int mountainChance;
    int oceanChance;
    int plainChance;
    int snowChance;
    int tundraChance;






    ////methods////

    public Biomes(int desertChance, int grasslandChance, int hillsChance, int mountainChance, int oceanChance,
                  int plainChance, int snowChance, int tundraChance)
    {
        this.desertChance = desertChance;
        this.grasslandChance = grasslandChance;
        this.hillsChance = hillsChance;
        this.mountainChance = mountainChance;
        this.oceanChance = oceanChance;
        this.plainChance = plainChance;
        this.snowChance = snowChance;
        this.tundraChance = tundraChance;
    }



    public Biomes(Biomes biomes)
    {
        this.desertChance = biomes.desertChance;
        this.grasslandChance = biomes.grasslandChance;
        this.hillsChance = biomes.hillsChance;
        this.mountainChance = biomes.mountainChance;
        this.oceanChance = biomes.oceanChance;
        this.plainChance = biomes.plainChance;
        this.snowChance = biomes.snowChance;
        this.tundraChance = biomes.tundraChance;
    }



    //getters
    public int getMaxChance()
    {
        return desertChance + grasslandChance + hillsChance + mountainChance + oceanChance + plainChance + snowChance + tundraChance;
    }



    public ArrayList<Integer> getChancesList()
    {
        ArrayList<Integer> chanceList = new ArrayList<>();
        chanceList.add(desertChance);
        chanceList.add(grasslandChance);
        chanceList.add(hillsChance);
        chanceList.add(mountainChance);
        chanceList.add(oceanChance);
        chanceList.add(plainChance);
        chanceList.add(snowChance);
        chanceList.add(tundraChance);

        return chanceList;
    }
}
