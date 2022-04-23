package Model;

public class Terrain extends MapLandElement{
    private boolean hasProperty;
    private MapProperty property;
    boolean hasResource;
    String resourceType;
    Resource resource;
    LuxuryResource luxuryResource;
    StrategicResource strategicResource;






    ////methods////
    public Terrain(String type, int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean canBeCrossed)
    {
        super(food, production, gold, fightChangePercentage, movementPrice, canBeCrossed);
    }



    public void chooseAndPlaceProperty()
    {
        
    }
}
