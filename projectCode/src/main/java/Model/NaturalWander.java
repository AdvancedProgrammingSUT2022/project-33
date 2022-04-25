package Model;

public class NaturalWander {
    Coordinates coordinates;
    private int happinessBoost;
    private int gold;
    private String name;





    ////methods////
    public NaturalWander(int happinessBoost, int gold, String name)
    {
        this.happinessBoost = happinessBoost;
        this.gold = gold;
        this.name = name;
    }



    public NaturalWander(NaturalWanderTypes naturalWander, Coordinates coordinates)
    {
        this.happinessBoost = naturalWander.naturalWander.getHappinessBoost();
        this.gold = naturalWander.naturalWander.getGold();
        this.name = naturalWander.naturalWander.getName();
        this.coordinates = coordinates;
    }



    //getters
    public int getHappinessBoost()
    {
        return happinessBoost;
    }


    public int getGold()
    {
        return gold;
    }


    public String getName()
    {
        return name;
    }
}
