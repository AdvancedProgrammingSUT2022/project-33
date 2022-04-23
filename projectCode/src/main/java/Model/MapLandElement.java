package Model;

public class MapLandElement {
    private String type;
    private Coordinates centerCoordinates;
    private int food;
    private int production;
    private int gold;
    private int fightChangePercentage;
    private int movementPrice;
    private boolean canBeCrossed;






    ////methods////
    public MapLandElement(int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean canBeCrossed)
    {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.fightChangePercentage = fightChangePercentage;
        this.movementPrice = movementPrice;
        this.canBeCrossed = canBeCrossed;
    }



    public MapLandElement(String type, MapLandElement land)
    {
        this.type = type;
        this.food = land.food;
        this.production = land.production;
        this.gold = land.gold;
        this.fightChangePercentage = land.fightChangePercentage;
        this.movementPrice = land.movementPrice;
        this.canBeCrossed = land.canBeCrossed;
    }



    //getters
    public String getType() {
        return type;
    }


    public Coordinates getCenterCoordinates() {
        return centerCoordinates;
    }


    public int getFood() {
        return food;
    }


    public int getProduction() {
        return production;
    }


    public int getGold() {
        return gold;
    }


    public int getFightChangePercentage() {
        return fightChangePercentage;
    }


    public int getMovementPrice() {
        return movementPrice;
    }


    public boolean isCanBeCrossed() {
        return canBeCrossed;
    }
}
