package Model;

public class MiniMapTile {
    Coordinates coordinates;
    Terrain terrain;
    boolean hasPlayerCity;
    PlayerCity playerCity;
    boolean hasDefaultCity;
    DefaultCity defaultCity;
    boolean hasWorker;
    Worker worker;
    boolean hasSettler;
    Settler settler;
    boolean hasMeleeMilitaryUnit;
    MeleeMilitaryUnit meleeMilitaryUnit;
    boolean hasRangedMilitaryUnit;
    RangedMilitaryUnit rangedMilitaryUnit;
    boolean hasHeavyRangedMilitaryUnit;
    HeavyRangedMilitaryUnits heavyRangedMilitaryUnits;

    //TODO:





    ////methods////
    public MiniMapTile(Coordinates coordinates, Terrain terrain)
    {
        this.coordinates = coordinates;
        this.terrain = terrain;
    }



    //getters
    public Coordinates getCoordinates() {
        return coordinates;
    }


    public Terrain getTerrain() {
        return terrain;
    }


    public boolean isHasPlayerCity() {
        return hasPlayerCity;
    }


    public PlayerCity getPlayerCity() {
        return playerCity;
    }


    public boolean isHasDefaultCity() {
        return hasDefaultCity;
    }


    public DefaultCity getDefaultCity() {
        return defaultCity;
    }


    public boolean isHasWorker() {
        return hasWorker;
    }


    public Worker getWorker() {
        return worker;
    }


    public boolean isHasSettler() {
        return hasSettler;
    }


    public Settler getSettler() {
        return settler;
    }


    public boolean isHasMeleeMilitaryUnit() {
        return hasMeleeMilitaryUnit;
    }


    public MeleeMilitaryUnit getMeleeMilitaryUnit() {
        return meleeMilitaryUnit;
    }


    public boolean isHasRangedMilitaryUnit() {
        return hasRangedMilitaryUnit;
    }


    public RangedMilitaryUnit getRangedMilitaryUnit() {
        return rangedMilitaryUnit;
    }


    public boolean isHasHeavyRangedMilitaryUnit() {
        return hasHeavyRangedMilitaryUnit;
    }


    public HeavyRangedMilitaryUnits getHeavyRangedMilitaryUnits() {
        return heavyRangedMilitaryUnits;
    }



    //setters
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }


    public void setHasPlayerCity(boolean hasPlayerCity) {
        this.hasPlayerCity = hasPlayerCity;
    }


    public void setPlayerCity(PlayerCity playerCity) {
        this.playerCity = new PlayerCity(playerCity);
    }


    public void setHasDefaultCity(boolean hasDefaultCity) {
        this.hasDefaultCity = hasDefaultCity;
    }


    public void setDefaultCity(DefaultCity defaultCity) {
        this.defaultCity = defaultCity;
    }


    public void setHasWorker(boolean hasWorker) {
        this.hasWorker = hasWorker;
    }


    public void setWorker(Worker worker) {
        this.worker = worker;
    }


    public void setHasSettler(boolean hasSettler) {
        this.hasSettler = hasSettler;
    }


    public void setSettler(Settler settler) {
        this.settler = settler;
    }


    public void setHasMeleeMilitaryUnit(boolean hasMeleeMilitaryUnit) {
        this.hasMeleeMilitaryUnit = hasMeleeMilitaryUnit;
    }


    public void setMeleeMilitaryUnit(MeleeMilitaryUnit meleeMilitaryUnit) {
        this.meleeMilitaryUnit = meleeMilitaryUnit;
    }


    public void setHasRangedMilitaryUnit(boolean hasRangedMilitaryUnit) {
        this.hasRangedMilitaryUnit = hasRangedMilitaryUnit;
    }


    public void setRangedMilitaryUnit(RangedMilitaryUnit rangedMilitaryUnit) {
        this.rangedMilitaryUnit = rangedMilitaryUnit;
    }


    public void setHasHeavyRangedMilitaryUnit(boolean hasHeavyRangedMilitaryUnit) {
        this.hasHeavyRangedMilitaryUnit = hasHeavyRangedMilitaryUnit;
    }


    public void setHeavyRangedMilitaryUnits(HeavyRangedMilitaryUnits heavyRangedMilitaryUnits) {
        this.heavyRangedMilitaryUnits = heavyRangedMilitaryUnits;
    }
}
