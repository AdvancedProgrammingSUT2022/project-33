package Model;

import java.util.ArrayList;

public class Resource {
   private String gameName;
   private String type;
   private int food;
   private int production;
   private int gold;
   private String constructionNeeded;
   private ArrayList<String> landsThatCanBeFound;





    ////methods////
    public Resource(String gameName, int food, int production, int gold, String constructionNeeded, ArrayList<String>  landsThatCanBeFound)
    {
        this.gameName = gameName;
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



    //getters
    public String getGameName() {
        return gameName;
    }


    public String getType() {
        return type;
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


    public String getConstructionNeeded() {
        return constructionNeeded;
    }


    public ArrayList<String> getLandsThatCanBeFound() {
        return landsThatCanBeFound;
    }
}
