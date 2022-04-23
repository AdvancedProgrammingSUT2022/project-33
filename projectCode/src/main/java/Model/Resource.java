package Model;

import java.util.ArrayList;

public class Resource {
    String type;
    int food;
    int production;
    int gold;
    String constructionNeeded;
    ArrayList<String> landsThatCanBeFound;





    ////methods////
    public Resource(int food, int production, int gold, String constructionNeeded, ArrayList<String>  landsThatCanBeFound)
    {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.constructionNeeded = constructionNeeded;
        this.landsThatCanBeFound = landsThatCanBeFound;
    }



    public Resource(String type, Resource resource)
    {
        this.type = type;
        this.food = resource.food;
        this.production = resource.production;
        this.gold = resource.gold;
        this.constructionNeeded = resource.constructionNeeded;
    }
}
