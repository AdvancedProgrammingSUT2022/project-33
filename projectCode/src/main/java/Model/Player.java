package Model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    private Colors color;
    private MiniMap map;
    private UnitList playerUnits;
    private ArrayList<PlayerCity> cities;
    private int gold;
    private int happiness;





    ////methods////
    public Player(String nickname, int numberOfPlayer)
    {
        this.nickname = nickname;
        this.color = Colors.values()[numberOfPlayer];
        playerUnits = new UnitList();
        cities = new ArrayList<>();
        this.gold = 0;
        this.happiness = 0;
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



    public void addGold(int amount)
    {
        this.gold += amount;
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


    public int getGold() {
        return gold;
    }


    public int getHappiness() {
        return happiness;
    }
}
