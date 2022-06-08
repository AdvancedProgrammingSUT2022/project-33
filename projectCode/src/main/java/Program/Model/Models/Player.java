package Program.Model.Models;

import Program.Model.Enums.Colors;
import Program.Model.Enums.StrategicResourceTypes;
import Program.Model.Enums.Technologies;
import Program.View.TechnologyTreeView;

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
    private int happinessUntilNextSpecialPerson;
    private ArrayList<StrategicResourceTypes> strategicResources;
    private boolean hasWon;
    private boolean hasLost;
    private ArrayList<String> notifications;





    ////methods////
    public Player(String nickname, int numberOfPlayer)
    {
        this.nickname = nickname;
        this.color = Colors.values()[numberOfPlayer];
        playerUnits = new UnitList();
        cities = new ArrayList<>();
        this.technologies = new ArrayList<>();
        this.gold = 200;
        this.happiness = 0;
        this.isResearching = false;
        this.researchPerTurn = 0;
        this.happinessCheatBonus = 0;
        this.happinessBonus = 0;
        this.happinessUntilNextSpecialPerson = 50;
        strategicResources = new ArrayList<>();
        notifications = new ArrayList<>();
    }



    public void updatePlayer(){
        getPlayerUnits().updateUnits(map.getTerrains());
        updateScience();
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



    public void updateScience()
    {
        researchPerTurn = 0;

        for (int i = 0; i < cities.size(); i++){
            researchPerTurn += cities.get(i).getScience();
        }

        if (isResearching) {
            researchProgress += researchPerTurn;

            if (researchProgress >= research.technology.getResearchCost()){
                isResearching = false;
                technologies.add(research);
                researchProgress = 0;
                new TechnologyTreeView().showTechnologyDiscovered(research);
            }
        }
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



    public void decreaseGold(int amount)
    {
        gold -= amount;
    }



    public void addNotification(String message)
    {
        notifications.add(message);
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


    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }


    public void setHasLost(boolean hasLost) {
        this.hasLost = hasLost;
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


    public boolean isCoordinatesFreeForNewUnit(Coordinates coordinates, boolean isMilitary)
    {
        if (isMilitary){
            if (playerUnits.getMeleeMilitaryUnitFromCoordinates(coordinates) == null &&
                    playerUnits.getRangedMilitaryUnitFromCoordinates(coordinates) == null &&
                    playerUnits.getHeavyRangedMilitaryUnitFromCoordinates(coordinates) == null){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (playerUnits.getSettlerFromCoordinates(coordinates) == null && playerUnits.getWorkerFromCoordinates(coordinates) == null){
                return true;
            }
            else {
                return false;
            }
        }
    }



    public ArrayList<StrategicResourceTypes> getStrategicResources() {
        return strategicResources;
    }


    public boolean isHasWon() {
        return hasWon;
    }


    public boolean isHasLost() {
        return hasLost;
    }


    public ArrayList<String> getNotifications() {
        return notifications;
    }
}
