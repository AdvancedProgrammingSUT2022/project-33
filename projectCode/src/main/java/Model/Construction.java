package Model;

import java.util.ArrayList;

public class Construction {
    String type;
    ArrayList<String> availableLandTypes;
    Technologies neededTechnology;
    int constructionTime;
    int timeRemaining;
    int foodEffect;
    int productionEffect;
    int goldEffect;





    ////methods////
    public Construction(ArrayList<String> availableLandTypes, Technologies neededTechnology, int constructionTime, int foodEffect, int productionEffect, int goldEffect)
    {
        this.availableLandTypes = availableLandTypes;
        this.neededTechnology = neededTechnology;
        this.constructionTime = constructionTime;
        this.foodEffect = foodEffect;
        this.productionEffect = productionEffect;
        this.goldEffect = goldEffect;
    }
}
