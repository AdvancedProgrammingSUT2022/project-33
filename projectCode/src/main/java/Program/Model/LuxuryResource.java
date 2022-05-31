package Program.Model;

import java.util.ArrayList;

public class LuxuryResource extends Resource{





    ////methods////
    public LuxuryResource(String gameName, int food, int production, int gold, String constructionNeeded, ArrayList<String> landsThatCanBeFound)
    {
        super(gameName, food, production, gold, constructionNeeded, landsThatCanBeFound);
    }



    public LuxuryResource(String type, Resource LuxuryResource)
    {
        super(type, LuxuryResource);
    }
}
