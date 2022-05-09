package Model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    private Colors color;
    private MiniMap map;
    UnitList playerUnits;
    ArrayList<PlayerCity> cities;





    ////methods////
    public Player(String nickname, int numberOfPlayer)
    {
        this.nickname = nickname;
        this.color = Colors.values()[numberOfPlayer];
        playerUnits = new UnitList();
        cities = new ArrayList<>();
    }



    public void updatePlayer(){
        //TODO: updating map
        getPlayerUnits().updateUnits(map.getTerrains());

        //TODO:
    }



    public void addCity(PlayerCity city)
    {
        cities.add(city);
    }



    //setters
    public void setMap(MiniMap map)
    {
        this.map = map;
    }



    //getters
    public String getNickname() {
        return nickname;
    }


    public Colors getColor() {
        return color;
    }


    public MiniMap getMap() {
        return map;
    }


    public UnitList getPlayerUnits() {
        return playerUnits;
    }


    public ArrayList<PlayerCity> getCities() {
        return cities;
    }
}
