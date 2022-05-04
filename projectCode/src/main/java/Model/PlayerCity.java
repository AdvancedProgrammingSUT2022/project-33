package Model;

import java.util.ArrayList;

public class PlayerCity extends City{
    private Player owner;
    private ArrayList<Wonder> wonders;
    private String cityName;
    //TODO:





    ////methods////
    public PlayerCity(boolean isCapital, Terrain terrain, Player owner, String cityName)
    {
        super(isCapital, new CityLand(terrain));
        this.owner = owner;
        this.cityName = cityName;
        wonders = new ArrayList<>();

        initializeBorders();

        //TODO:
    }



    private void initializeBorders()
    {
        int x = getCoordinates().getX();
        int y = getCoordinates().getY();

        if (y > 0){
            tryAddingBorder(x, y - 1);
        }

        if (y < owner.getMap().getMapSize()){
            tryAddingBorder(x, y + 1);
        }

        if (x % 2 == 0){
            if (x > 0){
                tryAddingBorder(x - 1, y);

                if (y > 0) {
                    tryAddingBorder(x - 1, y - 1);
                }
            }

            if (x < owner.getMap().getMapSize() - 1){
                tryAddingBorder(x + 1, y);

                if (y > 0){
                    tryAddingBorder(x + 1, y - 1);
                }
            }
        }
        else {
            if (x > 0){
                tryAddingBorder(x - 1, y);

                if (y < owner.getMap().getMapSize()) {
                    tryAddingBorder(x - 1, y + 1);
                }
            }

            if (x < owner.getMap().getMapSize() - 1){
                tryAddingBorder(x + 1, y);

                if (y < owner.getMap().getMapSize()){
                    tryAddingBorder(x + 1, y + 1);
                }
            }
        }
    }



    private void tryAddingBorder(int x, int y)
    {
        Coordinates coordinates = new Coordinates(x, y, 0);

        if (!owner.getMap().getTerrainFromCoordinates(coordinates).getIsTerritory()){
            Terrain terrain = owner.getMap().getTerrainFromCoordinates(coordinates);
            CityLand cityLand = new CityLand(terrain);
            addLand(cityLand);
            terrain.setTerritory(true);
        }
    }



    public void updateCity()
    {
        calculateGold();
        //TODO:
    }




    private void calculateGold()
    {
        int goldIncome = 0;
        double goldIncreasePercentage = 1;

        for (int i = 0; i < getBuildings().size(); i++){
            goldIncome += getBuildings().get(i).building.getGoldPerTurn() - getBuildings().get(i).building.getMaintenance();
            goldIncreasePercentage *= 1 + (double) getBuildings().get(i).building.getGoldEffect() / 100;
        }

        for (int i = 0; i < getLandsOwned().size(); i++){
            goldIncome += getLandsOwned().get(i).getLandGold();
        }

        goldIncome *= goldIncreasePercentage;

        setGoldPerTurn(goldIncome);
    }



    //setters:
    public void setOwner(Player owner) {
        this.owner = owner;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }



    //getters:
    public Player getOwner() {
        return owner;
    }


    public ArrayList<Wonder> getWonders() {
        return wonders;
    }


    public String getCityName() {
        return cityName;
    }
}
