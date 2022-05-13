package Model;

import java.util.ArrayList;

public class DefaultCity extends City{
    private String defaultCityGameName;
    private DefaultCityNames name;
    private NonPlayerColors color;





    ////methods////
    public DefaultCity(CityLand cityLand, NonPlayerColors color, DefaultCityNames name)
    {
        super(true, cityLand, color.toString());
        this.name = name;
        this.defaultCityGameName =name.name;
        this.color = color;

        //TODO:
    }



    public void addCityLand(ArrayList<CityLand> lands)
    {
        setLandsOwned(lands);
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
