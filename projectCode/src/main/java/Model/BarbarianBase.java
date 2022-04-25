package Model;

import java.util.Random;

public class BarbarianBase {
    private Coordinates coordinates;
    private int maxHealth;
    private int health;
    private int turnsNeededToBuildNewUnit;
    private int turnsRemainingUntilNextUnit;
    private boolean hasBarbarians;
    private Barbarian barbarian;





    ////methods////
    public BarbarianBase(Coordinates coordinates)
    {
        this.coordinates = coordinates;
        //TODO: SETTING MAX_HEALTH
        health = maxHealth;

        turnsNeededToBuildNewUnit = 3 + new Random().nextInt(8);
        turnsRemainingUntilNextUnit = 0;
        hasBarbarians = false;

        //TODO: MAKING THE AI.
    }



    //getters
    public Coordinates getCoordinates() {
        return coordinates;
    }
}
