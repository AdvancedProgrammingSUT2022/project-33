package Model;

public class MiniMapTile {
    private Coordinates coordinates;
    private Terrain terrain;
    private boolean hasPlayerCity;
    private PlayerCity playerCity;
    private boolean hasDefaultCity;
    private DefaultCity defaultCity;
    private boolean hasWorker;
    private Worker worker;
    private boolean hasSettler;
    private Settler settler;
    private boolean hasMeleeMilitaryUnit;
    private MeleeMilitaryUnit meleeMilitaryUnit;
    private boolean hasRangedMilitaryUnit;
    private RangedMilitaryUnit rangedMilitaryUnit;
    private boolean hasHeavyRangedMilitaryUnit;
    private HeavyRangedMilitaryUnits heavyRangedMilitaryUnits;

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
        this.playerCity.setHealth(playerCity.getHealth());
        this.playerCity.setUnitInTheCity(playerCity.isUnitInTheCity());
        this.playerCity.setCoordinates(playerCity.getCoordinates());
        this.playerCity.setMaxHealth(playerCity.getMaxHealth());
        this.playerCity.setAttackDamage(playerCity.getAttackDamage());
        this.playerCity.setCapital(playerCity.isCapital());
        this.playerCity.setLandsOwned(playerCity.getLandsOwned());
    }


    public void setHasDefaultCity(boolean hasDefaultCity) {
        this.hasDefaultCity = hasDefaultCity;
    }


    public void setDefaultCity(DefaultCity defaultCity) {
        defaultCity = new DefaultCity(defaultCity.getLandsOwned().get(0), defaultCity.getColor(), defaultCity.getName());
        this.defaultCity.setHealth(defaultCity.getHealth());
        this.defaultCity.setUnitInTheCity(defaultCity.isUnitInTheCity());
        this.defaultCity.setCoordinates(defaultCity.getCoordinates());
        this.defaultCity.setMaxHealth(defaultCity.getMaxHealth());
        this.defaultCity.setAttackDamage(defaultCity.getAttackDamage());
        this.defaultCity.setCapital(defaultCity.isCapital());
        this.defaultCity.setLandsOwned(defaultCity.getLandsOwned());
    }


    public void setHasWorker(boolean hasWorker) {
        this.hasWorker = hasWorker;
    }


    public void setWorker(Worker worker) {
        this.worker = new Worker(worker.getCoordinates());
        this.worker.setHealth(worker.getHealth());
        this.worker.setColor(worker.getColor());
        this.worker.setNonPlayerColor(worker.getNonPlayerColor());
        this.worker.setBelongsToPlayer(worker.isBelongsToPlayer());
    }


    public void setHasSettler(boolean hasSettler) {
        this.hasSettler = hasSettler;
    }


    public void setSettler(Settler settler) {
            this.settler = new Settler(settler.getCoordinates(), settler.getColor());
            this.settler.setNonPlayerColor(settler.getNonPlayerColor());
            this.settler.setBelongsToPlayer(settler.isBelongsToPlayer());
    }


    public void setHasMeleeMilitaryUnit(boolean hasMeleeMilitaryUnit) {
        this.hasMeleeMilitaryUnit = hasMeleeMilitaryUnit;
    }


    public void setMeleeMilitaryUnit(MeleeMilitaryUnit meleeMilitaryUnit) {
        this.meleeMilitaryUnit = new MeleeMilitaryUnit(meleeMilitaryUnit, meleeMilitaryUnit.getCoordinates(), meleeMilitaryUnit.getColor());
        this.meleeMilitaryUnit.setNonPlayerColor(meleeMilitaryUnit.getNonPlayerColor());
        this.meleeMilitaryUnit.setBelongsToPlayer(meleeMilitaryUnit.isBelongsToPlayer());
    }


    public void setHasRangedMilitaryUnit(boolean hasRangedMilitaryUnit) {
        this.hasRangedMilitaryUnit = hasRangedMilitaryUnit;
    }


    public void setRangedMilitaryUnit(RangedMilitaryUnit rangedMilitaryUnit) {
        this.rangedMilitaryUnit = new RangedMilitaryUnit(rangedMilitaryUnit, rangedMilitaryUnit.getCoordinates(), rangedMilitaryUnit.getColor());
        this.rangedMilitaryUnit.setNonPlayerColor(rangedMilitaryUnit.getNonPlayerColor());
        this.rangedMilitaryUnit.setBelongsToPlayer(rangedMilitaryUnit.isBelongsToPlayer());
    }


    public void setHasHeavyRangedMilitaryUnit(boolean hasHeavyRangedMilitaryUnit) {
        this.hasHeavyRangedMilitaryUnit = hasHeavyRangedMilitaryUnit;
    }


    public void setHeavyRangedMilitaryUnits(HeavyRangedMilitaryUnits heavyRangedMilitaryUnits) {
        this.heavyRangedMilitaryUnits = new HeavyRangedMilitaryUnits(heavyRangedMilitaryUnits,
                heavyRangedMilitaryUnits.getCoordinates(), heavyRangedMilitaryUnits.getColor());
        this.heavyRangedMilitaryUnits.setNonPlayerColor(heavyRangedMilitaryUnits.getNonPlayerColor());
        this.heavyRangedMilitaryUnits.setBelongsToPlayer(heavyRangedMilitaryUnits.isBelongsToPlayer());
    }
}
