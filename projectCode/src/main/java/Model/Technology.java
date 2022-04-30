package Model;

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
}
