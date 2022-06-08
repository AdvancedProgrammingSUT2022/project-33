package Program.Model.Models;

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



    //setters
    public void setType(String type) {
        this.type = type;
    }


    public void setCenterCoordinates(Coordinates centerCoordinates) {
        this.centerCoordinates = centerCoordinates;
    }


    public void setFood(int food) {
        this.food = food;
    }


    public void setProduction(int production) {
        this.production = production;
    }


    public void setGold(int gold) {
        this.gold = gold;
    }


    public void setFightChangePercentage(int fightChangePercentage) {
        this.fightChangePercentage = fightChangePercentage;
    }


    public void setMovementPrice(int movementPrice) {
        this.movementPrice = movementPrice;
    }


    public void setCanBeCrossed(boolean canBeCrossed) {
        this.canBeCrossed = canBeCrossed;
    }
}
