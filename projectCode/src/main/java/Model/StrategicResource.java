package Model;

public class StrategicResource extends Resource {
    String technologyNeeded;





    ////methods////
    public StrategicResource(int food, int production, int gold, String constructionNeeded, String technologyNeeded)
    {
        super(food, production, gold, constructionNeeded);
        this.technologyNeeded = technologyNeeded;
    }



    public StrategicResource(String type, StrategicResource strategicResource)
    {
        super(type, strategicResource);
        this.technologyNeeded = strategicResource.technologyNeeded;
    }
}
