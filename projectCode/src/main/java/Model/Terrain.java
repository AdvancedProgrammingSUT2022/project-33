package Model;

public class Terrain extends MapLandElement{
    private boolean hasProperty;
    private MapProperty property;
    boolean hasResource;





    ////methods////
    public Terrain(String type, int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean canBeCrossed)
    {
        super(type, food, production, gold, fightChangePercentage, movementPrice, canBeCrossed);
    }
}
