package Model;

public class LuxuryResource extends Resource{





    ////methods////
    public LuxuryResource(int food, int production, int gold, String constructionNeeded)
    {
        super(food, production, gold, constructionNeeded);
    }



    public LuxuryResource(String type, Resource LuxuryResource)
    {
        super(type, LuxuryResource);
    }
}
