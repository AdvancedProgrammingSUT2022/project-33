package Model;

public class LandElementTypeEffect {
    private int food;
    private int production;
    private int gold;
    private int fightChangePercentage;
    private int movementPrice;
    private boolean canBeCrossed;





    ////methods////
    public LandElementTypeEffect(int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean canBeCrossed)
    {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.fightChangePercentage = fightChangePercentage;
        this.movementPrice = movementPrice;
        this.canBeCrossed = canBeCrossed;
    }
}
