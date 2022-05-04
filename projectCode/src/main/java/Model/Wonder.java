package Model;

public class Wonder {
    private int goldPerTurn;
    private int happinessPerTurn;
    private int productionPerTurn;
    private int foodPerTurn;
    private int goldEffect;
    private int happinessEffect;
    private int productionEffect;
    private int foodEffect;
    private int productionNeeded;

    //TODO:





    ////methods////
    public Wonder(int goldPerTurn, int happinessPerTurn, int productionPerTurn, int foodPerTurn, int goldEffect,
                  int happinessEffect, int productionEffect, int foodEffect, int productionNeeded)
    {
        this.goldPerTurn = goldPerTurn;
        this.happinessPerTurn = happinessPerTurn;
        this.productionPerTurn = productionPerTurn;
        this.foodPerTurn = foodPerTurn;
        this.goldEffect = goldEffect;
        this.happinessEffect = happinessEffect;
        this.productionEffect = productionEffect;
        this.foodEffect = foodEffect;
        this.productionNeeded = productionNeeded;
    }



    //getters
    public int getGoldPerTurn() {
        return goldPerTurn;
    }


    public int getHappinessPerTurn() {
        return happinessPerTurn;
    }


    public int getProductionPerTurn() {
        return productionPerTurn;
    }


    public int getFoodPerTurn() {
        return foodPerTurn;
    }


    public int getProductionNeeded() {
        return productionNeeded;
    }


    public int getGoldEffect() {
        return goldEffect;
    }


    public int getHappinessEffect() {
        return happinessEffect;
    }


    public int getProductionEffect() {
        return productionEffect;
    }


    public int getFoodEffect() {
        return foodEffect;
    }
}
