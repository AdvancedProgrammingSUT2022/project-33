package Model;

import java.util.ArrayList;

public class Map {
    ArrayList<Terrain> terrains;





    ////methods////
    public Map()
    {
        terrains = new ArrayList<>();
    }



    public void addTerrain(Terrain terrain)
    {
        terrains.add(terrain);
    }
}
