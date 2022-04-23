package Model;

import java.util.ArrayList;
import java.util.Random;

public class Terrain extends MapLandElement{
    ArrayList<String> availableProperties;
    private boolean hasProperty;
    private MapProperty property;
    boolean hasResource;
    String resourceType;
    Resource resource;
    LuxuryResource luxuryResource;
    StrategicResource strategicResource;






    ////methods////
    public Terrain(int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean canBeCrossed, ArrayList<String> availableProperties)
    {
        super(food, production, gold, fightChangePercentage, movementPrice, canBeCrossed);
        this.availableProperties = availableProperties;
    }



    public Terrain(String type, Terrain terrain)
    {
        super(terrain.getFood(), terrain.getProduction(), terrain.getGold(), terrain.getFightChangePercentage(), terrain.getMovementPrice(), terrain.isCanBeCrossed());
        super.setType(type);
        this.availableProperties = terrain.availableProperties;

        chooseAndPlaceProperty();
        chooseAndPlaceResource();
    }



    public void chooseAndPlaceProperty()
    {
        Random rand = new Random();

        if (rand.nextInt(100) >= 45)
        {
            hasProperty = false;
            return;
        }

        if (availableProperties.size() == 0){
            hasProperty = false;
            return;
        }

        int propertyTypeIndex = rand.nextInt(availableProperties.size() - 1);
        property = new MapProperty(MapPropertyTypes.values()[propertyTypeIndex].toString(), MapPropertyTypes.values()[propertyTypeIndex].property);
        hasProperty = true;
    }



    public void chooseAndPlaceResource()
    {
        Random rand = new Random();

        if (rand.nextInt(100) >= 25)
        {
            hasResource = false;
            return;
        }
    }
}
