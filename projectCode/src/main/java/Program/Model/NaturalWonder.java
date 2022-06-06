package Program.Model;

import Program.Model.Enums.NaturalWonderTypes;

public class NaturalWonder {
    Coordinates coordinates;
    private int happinessBoost;
    private int gold;
    private int instantGold;
    private String name;





    ////methods////
    public NaturalWonder(int happinessBoost, int gold, int instantGold, String name)
    {
        this.happinessBoost = happinessBoost;
        this.instantGold = instantGold;
        this.gold = gold;
        this.name = name;
    }



    public NaturalWonder(NaturalWonderTypes naturalWander, Coordinates coordinates)
    {
        this.happinessBoost = naturalWander.naturalWonder.getHappinessBoost();
        this.gold = naturalWander.naturalWonder.getGold();
        this.name = naturalWander.naturalWonder.getName();
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


    public int getInstantGold() {
        return instantGold;
    }
}
