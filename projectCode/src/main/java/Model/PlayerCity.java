package Model;

import java.util.ArrayList;

public class PlayerCity extends City{
    private Player owner;
    private ArrayList<Wonders> wonders;
    private String cityName;
    //TODO:





    ////methods////
    public PlayerCity(boolean isCapital, Terrain terrain, Player owner, String cityName)
    {
        super(isCapital, new CityLand(terrain), owner.getColor().toString());
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

        if (owner.getMap().getTerrainFromCoordinates(coordinates) != null && !owner.getMap().getTerrainFromCoordinates(coordinates).getIsTerritory()){
            Terrain terrain = owner.getMap().getTerrainFromCoordinates(coordinates);
            CityLand cityLand = new CityLand(terrain);
            addLand(cityLand);
            terrain.setTerritory(true, owner.getColor().toString());
        }
    }



    public void updateCity()
    {
        calculateGold();
        calculateFood();
        calculateProduction();
        calculateHappiness();
        updateResources();
        findConnectedCities();
        managePopulation();
        repairCity();
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

        for (int i = 0; i < wonders.size(); i++){
            goldIncome += wonders.get(i).wonder.getGoldPerTurn();
            goldIncreasePercentage *= 1 + (double) wonders.get(i).wonder.getGoldEffect() / 100;
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(super.getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            goldIncome += workableLands.get(i).getLandGold();
        }

        goldIncome *= goldIncreasePercentage;

        setGoldPerTurn(goldIncome);
    }



    private void calculateFood()
    {
        int foodRemaining = 0;
        int foodIncreasePercentage = 1;

        for (int i = 0; i < getBuildings().size(); i++){
            foodRemaining += getBuildings().get(i).building.getFoodPerTurn();
        }

        for (int i = 0; i < wonders.size(); i++){
            foodRemaining += wonders.get(i).wonder.getFoodPerTurn();
            foodIncreasePercentage *= 1 + (double) wonders.get(i).wonder.getFoodEffect() / 100;
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            foodRemaining += workableLands.get(i).getLandFood();
        }

        foodRemaining *= foodIncreasePercentage;

        if (getHappiness() < 0){
            foodRemaining /= 3;
        }

        foodRemaining -= getPopulation() * 2;

        setFood(foodRemaining);
    }



    private void calculateProduction()
    {
        int production = 0;
        int productionIncreasePercentage = 1;

        for (int i = 0; i < getBuildings().size(); i++){
            production += getBuildings().get(i).building.getProductionPerTurn();
        }

        for (int i = 0; i < wonders.size(); i++){
            production += wonders.get(i).wonder.getProductionPerTurn();
            productionIncreasePercentage *= 1 + (double) wonders.get(i).wonder.getProductionEffect() / 100;
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            production += workableLands.get(i).getLandProduction();
        }

        production *= productionIncreasePercentage;

        setProduction(production);
    }



    private void calculateHappiness()
    {
        int happiness  = 0;
        int happinessEffect = 1;

        for (int i = 0; i < getBuildings().size(); i++){
            happiness += getBuildings().get(i).building.getHappinessPerTurn();
        }

        for (int i = 0; i < wonders.size(); i++){
            happiness += getWonders().get(i).wonder.getHappinessPerTurn();
            happinessEffect *= 1 + (double) wonders.get(i).wonder.getHappinessEffect() / 100;
        }

        happiness += getLuxuryResources().size();

        for (int i = 0; i < getConnectedCities().size(); i++){
            happiness += getConnectedCities().get(i).getLuxuryResources().size();
        }

        happiness *= happinessEffect;

        if (isAnnexed()){
            happiness -= getPopulation() * 4 / 3;
        }
        else {
            happiness -= getPopulation();
        }

        setHappiness(happiness);
    }



    private void findConnectedCities()
    {
        setConnectedCities(new ArrayList<>());
        ArrayList<Coordinates> searchedCoordinates = new ArrayList<>();

        searchRoad(getCoordinates(), searchedCoordinates);

        //TODO
    }



    private void searchRoad(Coordinates coordinates, ArrayList<Coordinates> searchedCoordinates)
    {
        if (owner.getMap().getTerrainFromCoordinates(coordinates) == null || searchedCoordinates.contains(coordinates) ||
                (!owner.getMap().getTerrainFromCoordinates(coordinates).isHasRoad() && owner.getMap().getPlayerCityFromCoordinates(coordinates) == null)){
            return;
        }

        searchedCoordinates.add(coordinates);

        if (owner.getMap().getPlayerCityFromCoordinates(coordinates) != null && owner.getMap().getPlayerCityFromCoordinates(coordinates) != this){
            getConnectedCities().add(owner.getMap().getPlayerCityFromCoordinates(coordinates));
        }

        int x = coordinates.getX();
        int y = coordinates.getY();

        if (y > 0){
            searchRoad(new Coordinates(x, y - 1, 0), searchedCoordinates);
        }

        if (x % 2 == 0){
            if (x > 0){
                searchRoad(new Coordinates(x - 1, y, 0), searchedCoordinates);

                if (y > 0){
                    searchRoad(new Coordinates(x - 1, y - 1, 0), searchedCoordinates);
                }
            }

            if (x < owner.getMap().getMapSize() - 1){
                 searchRoad(new Coordinates(x + 1, y, 0), searchedCoordinates);

                if (y < owner.getMap().getMapSize() - 1){
                    searchRoad(new Coordinates(x + 1, y - 1, 0), searchedCoordinates);
                }
            }
        }
        else {
            if (x > 0){
                searchRoad(new Coordinates(x - 1, y, 0), searchedCoordinates);

                if (y < owner.getMap().getMapSize() - 1){
                    searchRoad(new Coordinates(x - 1, y + 1, 0), searchedCoordinates);
                }
            }

            if (x < owner.getMap().getMapSize() - 1){
                searchRoad(new Coordinates(x + 1, y, 0), searchedCoordinates);

                if (y < owner.getMap().getMapSize() - 1){
                    searchRoad(new Coordinates(x + 1, y + 1, 0), searchedCoordinates);
                }
            }
        }

        if (y < owner.getMap().getMapSize() - 1){
            searchRoad(new Coordinates(x, y + 1, 0), searchedCoordinates);
        }
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


    public ArrayList<Wonders> getWonders() {
        return wonders;
    }


    public String getCityName() {
        return cityName;
    }
}
