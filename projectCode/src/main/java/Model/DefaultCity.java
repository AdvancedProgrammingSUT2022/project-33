package Model;

public class DefaultCity extends City{
    private String defaultCityGameName;
    private DefaultCityNames name;
    private NonPlayerColors color;





    ////methods////
    public DefaultCity(Terrain terrain, NonPlayerColors color, DefaultCityNames name)
    {
        super(true, terrain);
        this.name = name;
        this.defaultCityGameName =name.name;
        this.color = color;

        //TODO:
    }



    //getters
    public DefaultCityNames getName() {
        return name;
    }


    public NonPlayerColors getColor() {
        return color;
    }


    public String getDefaultCityGameName() {
        return defaultCityGameName;
    }



    //setters
    public void setName(DefaultCityNames name) {
        this.name = name;
    }


    public void setColor(NonPlayerColors color) {
        this.color = color;
    }
}
