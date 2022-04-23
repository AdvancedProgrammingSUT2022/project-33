package Model;

import java.util.ArrayList;
import java.util.Random;

public class Terrain extends MapLandElement{
    private ArrayList<String> availableProperties;
    private boolean hasProperty;
    private MapProperty property;
    boolean hasResource;
    private ResourceCategories resourceCategory;
    private Resource resource;
    private StrategicResource strategicResource;
    private LuxuryResource luxuryResource;






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



    private void chooseAndPlaceProperty()
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

        int propertyTypeIndex = rand.nextInt(availableProperties.size());
        property = new MapProperty(MapPropertyTypes.values()[propertyTypeIndex].toString(), MapPropertyTypes.values()[propertyTypeIndex].property);
        hasProperty = true;
    }



    private void chooseAndPlaceResource()
    {
        Random rand = new Random();
        hasResource = false;

        if (rand.nextInt(100) >= 35)
        {
            return;
        }

        int resourceTypeNumber = rand.nextInt(3);

        if (resourceTypeNumber == 0){
            int resourceIndex = rand.nextInt(ResourceTypes.values().length);
            Resource temporarilyResource = new Resource(ResourceTypes.values()[resourceIndex].toString() , ResourceTypes.values()[resourceIndex].resource);

            if (temporarilyResource.landsThatCanBeFound != null && temporarilyResource.landsThatCanBeFound.contains(Terrain.super.getType())){
                hasResource = true;
                resourceCategory = ResourceCategories.NORMAL;
                resource = temporarilyResource;
            }
        }
        else if (resourceTypeNumber == 1){
            int resourceIndex = rand.nextInt(StrategicResourceTypes.values().length);
            StrategicResource temporarilyResource = new StrategicResource(StrategicResourceTypes.values()[resourceIndex].toString() , StrategicResourceTypes.values()[resourceIndex].resource);

            if (temporarilyResource.landsThatCanBeFound != null && temporarilyResource.landsThatCanBeFound.contains(Terrain.super.getType())){
                hasResource = true;
                resourceCategory = ResourceCategories.STRATEGIC;
                strategicResource = temporarilyResource;
            }
        }
        else {
            int resourceIndex = rand.nextInt(LuxuryResourceTypes.values().length);
            LuxuryResource temporarilyResource = new LuxuryResource(LuxuryResourceTypes.values()[resourceIndex].toString() , LuxuryResourceTypes.values()[resourceIndex].resource);

            if (temporarilyResource.landsThatCanBeFound != null && temporarilyResource.landsThatCanBeFound.contains(Terrain.super.getType())){
                hasResource = true;
                resourceCategory = ResourceCategories.LUXURY;
                luxuryResource = temporarilyResource;
            }
        }
    }



    //getters
    public void setCoordinates(Coordinates coordinates)
    {
        super.setCenterCoordinates(coordinates);
    }
}
