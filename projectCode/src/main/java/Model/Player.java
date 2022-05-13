package Model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    private Colors color;
    private MiniMap map;
    private UnitList playerUnits;
    private ArrayList<PlayerCity> cities;
    private ArrayList<Technologies> technologies;
    private int gold;
    private int happiness;
    private boolean isResearching;
    private Technologies research;
    private int researchProgress;
    private int researchPerTurn;
    private int happinessCheatBonus;
    private int happinessBonus;





    ////methods////
    public Player(String nickname, int numberOfPlayer)
    {
        this.nickname = nickname;
        this.color = Colors.values()[numberOfPlayer];
        playerUnits = new UnitList();
        cities = new ArrayList<>();
        this.technologies = new ArrayList<>();
        this.gold = 0;
        this.happiness = 0;
        this.isResearching = false;
        this.researchPerTurn = 0;
        this.happinessCheatBonus = 0;
        this.happinessBonus = 0;
    }



    public void updatePlayer(){
        //TODO: updating map
        getPlayerUnits().updateUnits(map.getTerrains());

        updateHappiness();
        updateGold();
        //TODO:
    }



    private void updateHappiness()
    {
        int temporarilyHappiness = 5;
        temporarilyHappiness += happinessCheatBonus;

        for (int i = 0; i < cities.size(); i++){
            temporarilyHappiness += cities.get(i).getHappiness();
            temporarilyHappiness -= 3;
        }

        happiness = temporarilyHappiness;
    }



    private void updateGold()
    {
        gold += getGoldIncome();
    }



    public int getGoldIncome()
    {
        int goldIncome = 0;

        goldIncome += getCitiesGoldIncome();
        goldIncome -= playerUnits.getGoldNeeded();

        if (goldIncome >= 0) {
            if (happiness > 19) {
                goldIncome *= 2;
            } else if (happiness > 9) {
                goldIncome *= 2;
                goldIncome /= 3;
            } else if (happiness < 0 && happiness > -6) {
                goldIncome *= 2;
                goldIncome /= 3;
            } else if (happiness < -5 && happiness > -11) {
                goldIncome /= 4;
            } else if (happiness < -10 && happiness > -16) {
                goldIncome /= 10;
            }
        }
        else {
            if (happiness > 19) {
                goldIncome /= 2;
            } else if (happiness > 9) {
                goldIncome *= 2;
                goldIncome /= 3;
            } else if (happiness < 0 && happiness > -6) {
                goldIncome *= 3;
                goldIncome /= 2;
            } else if (happiness < -5 && happiness > -11) {
                goldIncome *= 4;
            } else if (happiness < -10 && happiness > -16) {
                goldIncome *= 10;
            }
        }

        return goldIncome;
    }



    public int getCitiesGoldIncome()
    {
        int goldIncome = 0;

        for (int i = 0; i < cities.size(); i++){
            goldIncome += cities.get(i).getGoldPerTurn();
        }

        return goldIncome;
    }



    public void addCity(PlayerCity city)
    {
        cities.add(city);
    }



    public void addGold(int amount)
    {
        this.gold += amount;
    }



    public void addTechnology(Technologies technology){
        this.technologies.add(technology);
    }



    //setters
    public void setMap(MiniMap map)
    {
        this.map = map;
    }


    public void setResearching(boolean researching) {
        isResearching = researching;
    }

    public void setResearch(Technologies research) {
        this.research = research;
    }

    public void setResearchProgress(int researchProgress) {
        this.researchProgress = researchProgress;
    }


    public void setHappinessCheatBonus(int happinessCheatBonus) {
        this.happinessCheatBonus = happinessCheatBonus;
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


    public ArrayList<Technologies> getTechnologies() {
        return technologies;
    }


    public int getResearchPerTurn() {
        return researchPerTurn;
    }


    public boolean isResearching() {
        return isResearching;
    }


    public Technologies getResearch() {
        return research;
    }


    public int getResearchProgress() {
        return researchProgress;
    }


    public int getHappinessCheatBonus() {
        return happinessCheatBonus;
    }


    public PlayerCity getCityFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < cities.size(); i++){
            if (cities.get(i).getCoordinates().equals(coordinates)){
                return cities.get(i);
            }
        }

        return null;
    }
}
