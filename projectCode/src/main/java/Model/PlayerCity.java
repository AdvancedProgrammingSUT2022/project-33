package Model;

import java.util.ArrayList;

public class PlayerCity extends City{
    private Player owner;
    private ArrayList<Wander> wanders;
    //TODO:





    ////methods////
    public PlayerCity(boolean isCapital, Terrain terrain, Player owner)
    {
        super(isCapital, terrain);
        this.owner = owner;
        wanders = new ArrayList<>();

        //TODO:
    }
}
