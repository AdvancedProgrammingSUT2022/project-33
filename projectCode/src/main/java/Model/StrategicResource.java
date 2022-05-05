package Model;

import java.util.ArrayList;

public class StrategicResource extends Resource {
    String technologyNeeded;





    ////methods////
    public StrategicResource(String gameName, int food, int production, int gold, String constructionNeeded, String technologyNeeded, ArrayList<String> landsThatCanBeFound)
    {
        super(gameName, food, production, gold, constructionNeeded, landsThatCanBeFound);
        this.technologyNeeded = technologyNeeded;
    }



    public StrategicResource(String type, StrategicResource strategicResource)
    {
        super(type, strategicResource);
        this.technologyNeeded = strategicResource.technologyNeeded;
    }
}
