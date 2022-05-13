package Model;

import java.util.ArrayList;

public class City {
    private Coordinates coordinates;
    private int population;
    private int food;
    private int production;
    private int happiness;
    private int health;
    private int maxHealth;
    private boolean isUnitInTheCity;
    private int attackDamage;
    private ArrayList<Building> buildings;
    private ArrayList<CityLand> landsOwned;
    private ArrayList<LuxuryResource> luxuryResources;
    private ArrayList<StrategicResource> strategicResources;
    private ArrayList<Citizen> citizens;
    private int goldPerTurn;
    private boolean isCapital;
    private ArrayList<City> connectedCities;
    private boolean isAnnexed;
    private int foodUntilNewCitizen;
    private boolean isCityStarving;
    private int turnsUntilACitizenDies;
    private boolean isWorkingOnTask;
    private String taskGameName;
    private int taskNeededProduction;





    ////methods////
    public City(boolean isCapital, CityLand cityLand, String color)
    {
        this.isCapital = isCapital;
        this.coordinates = cityLand.getTerrain().getCenterCoordinates();

        this.population = 1;
        this.isUnitInTheCity = false;
        this.buildings = new ArrayList<>();
        this.landsOwned = new ArrayList<>();
        landsOwned.add(cityLand);
        cityLand.getTerrain().setTerritory(true, color);
        this.isWorkingOnTask = false;
        this.maxHealth = 20;
        this.luxuryResources = new ArrayList<>();
        this.isAnnexed = false;
        foodUntilNewCitizen = 10;
        isCityStarving = false;
        connectedCities = new ArrayList<>();
        this.citizens = new ArrayList<>();

        //TODO:
    }



    public void updateCity()
    {
        calculateGold();
        calculateFood();
        calculateProduction();
        calculateHappiness();
        updateResources();
        managePopulation();
        repairCity();
     //TODO:
    }



    public void addLand(CityLand cityLand)
    {
        landsOwned.add(cityLand);
    }



    private void calculateGold()
    {
        int goldIncome = 0;
        double goldIncreasePercentage = 1;

        for (int i = 0; i < getBuildings().size(); i++){
            goldIncome += getBuildings().get(i).getGoldPerTurn() - getBuildings().get(i).getMaintenance();
            goldIncreasePercentage *= 1 + (double) getBuildings().get(i).getGoldEffect() / 100;
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            goldIncome += workableLands.get(i).getLandGold();
        }

        goldIncome *= goldIncreasePercentage;

        setGoldPerTurn(goldIncome);
    }



    private void calculateFood()
    {
        int foodRemaining = 0;

        for (int i = 0; i < getBuildings().size(); i++){
            foodRemaining += getBuildings().get(i).getFoodPerTurn();
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            foodRemaining += workableLands.get(i).getLandFood();
        }

        if (happiness < 0){
            foodRemaining /= 3;
        }

        foodRemaining -= population * 2;

        setFood(foodRemaining);
    }



    private void calculateProduction()
    {
        int production  = 0;

        for (int i = 0; i < getBuildings().size(); i++){
            production += getBuildings().get(i).getProductionPerTurn();
        }

        ArrayList<CityLand> workableLands = new ArrayList<>(getWorkableLands());

        for (int i = 0; i < workableLands.size(); i++){
            production += workableLands.get(i).getLandProduction();
        }

        setProduction(production);
    }



    private void calculateHappiness()
    {
        int happiness  = 0;

        for (int i = 0; i < getBuildings().size(); i++){
            happiness += getBuildings().get(i).getHappinessPerTurn();
        }

        happiness += luxuryResources.size();

        if (isAnnexed()){
            happiness -= getPopulation() * 4 / 3;
        }
        else {
            happiness -= getPopulation();
        }

        for (int i = 0; i < connectedCities.size(); i++){
            happiness += connectedCities.get(i).getLuxuryResources().size();
        }

        setProduction(happiness);
    }



    protected void updateResources()
    {
        ArrayList<CityLand> workableLands = getWorkableLands();
            strategicResources = new ArrayList<>();
            luxuryResources = new ArrayList<>();

        for (int i = 0; i < workableLands.size(); i++){
            if (workableLands.get(i).hasStrategicResourceProduction()){
                strategicResources.add(workableLands.get(i).getTerrain().getStrategicResource());
            }
            else if (workableLands.get(i).hasLuxuryResource()){
                luxuryResources.add(workableLands.get(i).getTerrain().getLuxuryResource());
            }
        }
    }



    protected void managePopulation()
    {
        if (food < 0){
            if (isCityStarving){
                turnsUntilACitizenDies--;

                if (turnsUntilACitizenDies == 0){
                    population--;
                    turnsUntilACitizenDies = 5;
                }
            }
            else {
                turnsUntilACitizenDies = 5;
                isCityStarving = true;
            }
        }
        else {
            foodUntilNewCitizen -= food;

            if (foodUntilNewCitizen <= 0){
                foodUntilNewCitizen = (int) (10 * Math.pow(1.15, population));
                //TODO: finding a normal function.
                population++;
            }
        }
    }



    protected void repairCity()
    {
        if (health == maxHealth){
            return;
        }

        double repairFactor = ((double) maxHealth) / 20 + ((double) health) / 20;
        repairFactor *= (1 + ((double) production) / 20);
        //TODO: finding normal values.

        health += repairFactor;

        if (health > maxHealth){
            health = maxHealth;
        }
    }



    public void addCitizenCheat()
    {
        Citizen citizen = new Citizen(this);
        citizens.add(citizen);
    }



    //getters
    public Coordinates getCoordinates() {
        return coordinates;
    }


    public int getPopulation() {
        return population;
    }


    public int getFood() {
        return food;
    }


    public int getProduction() {
        return production;
    }


    public int getHappiness() {
        return happiness;
    }


    public int getHealth() {
        return health;
    }


    public int getMaxHealth() {
        return maxHealth;
    }


    public boolean isUnitInTheCity() {
        return isUnitInTheCity;
    }


    public int getAttackDamage() {
        return attackDamage;
    }


    public ArrayList<Building> getBuildings() {
        return buildings;
    }


    public ArrayList<CityLand> getLandsOwned() {
        return landsOwned;
    }


    public int getGoldPerTurn() {
        return goldPerTurn;
    }


    public boolean isCapital() {
        return isCapital;
    }


    public ArrayList<City> getConnectedCities() {
        return connectedCities;
    }


    public boolean isWorkingOnTask() {
        return isWorkingOnTask;
    }


    public ArrayList<CityLand> getWorkableLands()
    {
        ArrayList<CityLand> workableLands = new ArrayList<>();

        for (int j = -2; j < 2; j++){
            for (int i = Math.abs(j) - 2; i < 2 - Math.abs(j); i++){
                if (getCityLandFromCoordinates(new Coordinates(coordinates.getX() + i, coordinates.getY() + j, 0)) != null){
                    workableLands.add(getCityLandFromCoordinates(new Coordinates(coordinates.getX() + i, coordinates.getY() + j, 0)));
                }
            }
        }

        return workableLands;
    }



    private CityLand getCityLandFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < landsOwned.size(); i++){
            if (landsOwned.get(i).getTerrain().getCenterCoordinates().equals(coordinates)){
                return landsOwned.get(i);
            }
        }

        return null;
    }


    public ArrayList<LuxuryResource> getLuxuryResources() {
        return luxuryResources;
    }


    public boolean isAnnexed() {
        return isAnnexed;
    }


    public String getTaskGameName() {
        return taskGameName;
    }


    public int getTaskTurnsNeeded() {
        return taskNeededProduction / production;
    }


    public boolean isCitizenWorkingInLand(Coordinates coordinates)
    {
        for (int i = 0; i < citizens.size(); i++){
            if (citizens.get(i).isWorking() && !citizens.get(i).isInside() && citizens.get(i).getCoordinates().equals(coordinates)){
                return true;
            }
        }

        return false;
    }



    public boolean isCitizenWorkingInBuilding(Building building)
    {
        for (int i = 0; i < citizens.size(); i++){
            if (citizens.get(i).isWorking() && !citizens.get(i).isInside() && citizens.get(i).getBuilding() == building){
                return true;
            }
        }

        return false;
    }


    public int getFoodUntilNewCitizen() {
        return foodUntilNewCitizen;
    }


    public boolean isCityStarving() {
        return isCityStarving;
    }


    public int getTurnsUntilACitizenDies() {
        return turnsUntilACitizenDies;
    }


    public ArrayList<Citizen> getCitizens() {
        return citizens;
    }



    public CityLand getOwnedLandFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < landsOwned.size(); i++){
            if (coordinates.equals(landsOwned.get(i).getTerrain().getCenterCoordinates())){
                return landsOwned.get(i);
            }
        }

        return null;
    }



    public boolean isWorkerInBuilding(Building building)
    {
        for (int i = 0; i < citizens.size(); i++){
            if (citizens.get(i).isWorking() && citizens.get(i).isInside() && citizens.get(i).getBuilding() == building){
                return true;
            }
        }

        return false;
    }



    public void fireWorkerFromBuilding(Building building)
    {
        for (int i = 0; i < citizens.size(); i++){
            if (citizens.get(i).isWorking() && citizens.get(i).isInside() && citizens.get(i).getBuilding() == building){
                citizens.get(i).setWorking(false);
            }
        }
    }



    public void assignWorkerToBuilding(Building building)
    {
        for (int i = 0; i < citizens.size(); i++){
            if (!citizens.get(i).isWorking()){
                citizens.get(i).setWorking(true);
                citizens.get(i).setInside(true);
                citizens.get(i).setBuilding(building);
            }
        }
    }



    //setters
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setPopulation(int population) {
        this.population = population;
    }


    public void setFood(int food) {
        this.food = food;
    }


    public void setProduction(int production) {
        this.production = production;
    }


    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


    public void setUnitInTheCity(boolean unitInTheCity) {
        isUnitInTheCity = unitInTheCity;
    }


    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }


    public void setLandsOwned(ArrayList<CityLand> landsOwned) {
        this.landsOwned = landsOwned;
    }


    public void setGoldPerTurn(int goldPerTurn) {
        this.goldPerTurn = goldPerTurn;
    }


    public void setCapital(boolean capital) {
        isCapital = capital;
    }


    public void setConnectedCities(ArrayList<City> connectedCities) {
        this.connectedCities = connectedCities;
    }


    public void setWorkingOnTask(boolean workingOnTask) {
        isWorkingOnTask = workingOnTask;
    }



}
