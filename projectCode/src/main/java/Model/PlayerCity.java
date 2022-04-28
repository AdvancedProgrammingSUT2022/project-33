package Model;

import java.util.ArrayList;

public class PlayerCity extends City{
    Player owner;
    ArrayList<Wander> wanders;
    //TODO:





    ////methods////
    public PlayerCity()
    {
        //TODO:
    }



    public PlayerCity(PlayerCity city)
    {
        super(city.isCapital(), city.getLandsOwned().get(0));
        //TODO:
    }
}
