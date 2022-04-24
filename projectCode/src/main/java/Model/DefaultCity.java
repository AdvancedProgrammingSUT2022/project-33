package Model;

public class DefaultCity extends City{
    private DefaultCityNames name;
    private NonPlayerColors color;





    ////methods////
    public DefaultCity(Terrain terrain, NonPlayerColors color, DefaultCityNames name)
    {
        super(true, terrain);

        this.color = color;

        //TODO:
    }
}
