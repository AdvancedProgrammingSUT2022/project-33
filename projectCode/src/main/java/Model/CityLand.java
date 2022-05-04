package Model;

public class CityLand {
    private Terrain terrain;
    private boolean hasImprovement;
    private Improvement improvement;
    //TODO:





    ////methods////
    public CityLand (Terrain terrain)
    {
        this.terrain = terrain;
        hasImprovement = false;
    }



    //getters
    public Terrain getTerrain() {
        return terrain;
    }


    public boolean isHasImprovement() {
        return hasImprovement;
    }


    public Improvement getImprovement() {
        return improvement;
    }


    public int getLandGold()
    {
        int gold = terrain.getGold();

        if (hasImprovement){
            gold += improvement.goldEffect;
        }

        return gold;
    }


    public int getLandFood()
    {
        int food = terrain.getFood();

        if (hasImprovement){
            food += improvement.foodEffect;
        }

        return food;
    }



    public int getLandProduction()
    {
        int production = terrain.getProduction();

        if (hasImprovement){
            production += improvement.productionEffect;
        }

        return production;
    }
}
