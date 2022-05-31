package Program.Model;

import java.util.ArrayList;

public class Improvement {
    String type;
    String gameName;
    ArrayList<String> availableLandTypes;
    Technologies neededTechnology;
    int constructionTime;
    int timeRemaining;
    int foodEffect;
    int productionEffect;
    int goldEffect;





    ////methods////
    public Improvement(String gameName, ArrayList<String> availableLandTypes, Technologies neededTechnology, int foodEffect, int productionEffect, int goldEffect)
    {
        this.gameName = gameName;
        this.availableLandTypes = availableLandTypes;
        this.neededTechnology = neededTechnology;
        this.foodEffect = foodEffect;
        this.productionEffect = productionEffect;
        this.goldEffect = goldEffect;
        constructionTime = 6;
    }
}
