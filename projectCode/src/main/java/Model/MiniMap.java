package Model;

import java.util.ArrayList;

public class MiniMap extends Map{
    ArrayList<Fog> fogs;
    ArrayList<HiddenTile> hiddenTiles;





    ////methods////
    public MiniMap(Map map)
    {
        super(map);
    }
}
