package Program.Model;

import Program.Model.Enums.Eras;
import Program.Model.Enums.Technologies;

import java.util.ArrayList;

public class Technology {
    private String type;
    private String gameName;
    private int researchCost;
    private ArrayList<Technologies> neededTechnologies;
    private Eras era;





    ////methods////
    public Technology(String gameName, int researchCost, ArrayList<Technologies> neededTechnologies, Eras era)
    {
        this.gameName = gameName;
        this.researchCost = researchCost;
        this.neededTechnologies = neededTechnologies;
        this.era = era;
    }



    //getters
    public String getType() {
        return type;
    }


    public String getGameName() {
        return gameName;
    }


    public int getResearchCost() {
        return researchCost;
    }


    public ArrayList<Technologies> getNeededTechnologies() {
        return neededTechnologies;
    }


    public Eras getEra() {
        return era;
    }
}
