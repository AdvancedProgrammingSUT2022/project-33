package Model;

import java.util.Random;

public class BarbarianBase {
    Coordinates coordinates;
    int maxHealth;
    int health;
    int turnsNeededToBuildNewUnit;
    int turnsRemainingUntilNextUnit;
    boolean hasBarbarians;
    Barbarian barbarian;





    ////methods////
    public BarbarianBase(Coordinates coordinates)
    {
        this.coordinates = coordinates;
        //TODO: SETTING MAX_HEALTH
        health = maxHealth;

        turnsNeededToBuildNewUnit = 3 + new Random().nextInt(8);
        turnsRemainingUntilNextUnit = 0;
        hasBarbarians = false;
    }
}
