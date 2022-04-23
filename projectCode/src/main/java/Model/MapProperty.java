package Model;

public class MapProperty extends MapLandElement{





    ////methods////
    public MapProperty(int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean canBeCrossed)
    {
        super(food, production, gold, fightChangePercentage, movementPrice, canBeCrossed);
    }



    public MapProperty(String type, MapLandElement property)
    {
        super(type, property);
    }
}
