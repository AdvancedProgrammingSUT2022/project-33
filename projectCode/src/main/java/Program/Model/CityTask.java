package Program.Model;

public class CityTask {
    private String gameName;
    private int productionNeeded;
    private boolean isUnit;
    private boolean isWonder;
    private boolean isBuilding;
    private boolean isTaskValid;
    private boolean isMeleeUnit;
    private boolean isRangedUnit;
    private boolean isHeavyUnit;





    ////methods////
    public CityTask(String gameName, boolean isUnit, boolean isBuilding, boolean isWonder)
    {
        this.gameName = gameName;

        if (isUnit) {
            isTaskValid = findUnitTask();
        }
        else if (isBuilding){
            isTaskValid = findBuilding();
        }
    }



    private boolean findUnitTask()
    {
        if (gameName.equalsIgnoreCase("Settler")){
            gameName = "Settler";
            isUnit = true;
        }
        else if (gameName.equalsIgnoreCase("Worker")){
            gameName = "Worker";
            isUnit = true;
        }
        else if (getMeleeUnit() != null){
            gameName = getMeleeUnit().unit.getGameName();
            isMeleeUnit = true;
            isUnit = true;
        }
        else if (getRangedUnit() != null){
            gameName = getRangedUnit().unit.getGameName();
            isRangedUnit = true;
            isUnit = true;
        }
        else if (getHeavyUnit() != null){
            gameName = getHeavyUnit().unit.getGameName();
            isHeavyUnit = true;
            isUnit = true;
        }
        else if (getWonder() != null){
            gameName = getWonder().wonder.getGameName();
            isWonder = true;
        }
        else if (getBuilding() != null){
            gameName = getBuilding().building.getGameName();
            isBuilding = true;
        }
        else {
            return false;
        }

        return true;
    }



    private boolean findBuilding()
    {
        if (getBuilding() != null){
            isTaskValid = true;
            gameName = getBuilding().building.getGameName();
        }

        return false;
    }



    //getters
    public MeleeUnits getMeleeUnit()
    {
        for (int i = 0; i < MeleeUnits.values().length; i++){
            if (gameName.equalsIgnoreCase(MeleeUnits.values()[i].unit.getGameName())){
                return MeleeUnits.values()[i];
            }
        }

        return null;
    }


    public RangedUnits getRangedUnit()
    {
        for (int i = 0; i < RangedUnits.values().length; i++){
            if (gameName.equalsIgnoreCase(RangedUnits.values()[i].unit.getGameName())){
                return RangedUnits.values()[i];
            }
        }

        return null;
    }


    public HeavyRangedUnits getHeavyUnit()
    {
        for (int i = 0; i < HeavyRangedUnits.values().length; i++){
            if (gameName.equalsIgnoreCase(HeavyRangedUnits.values()[i].unit.getGameName())){
                return HeavyRangedUnits.values()[i];
            }
        }

        return null;
    }


    public String getGameName() {
        return gameName;
    }


    public int getProductionNeeded() {
        return productionNeeded;
    }


    public boolean isTaskValid() {
        return isTaskValid;
    }



    public Technologies getUnitNeededTechnology()
    {
        if (isMeleeUnit){
            return getMeleeUnit().unit.getTechnologyRequired();
        }
        else if (isRangedUnit){
            return getRangedUnit().unit.getTechnologyRequired();
        }
        else if (isHeavyUnit){
            return getHeavyUnit().unit.getTechnologyRequired();
        }
        else {
            return null;
        }
    }



    public BuildingTypes getBuilding()
    {
        for (int i = 0; i < BuildingTypes.values().length; i++){
            if (gameName.equalsIgnoreCase(BuildingTypes.values()[i].building.getGameName())){
                return BuildingTypes.values()[i];
            }
        }

        return null;
    }



    public Technologies getBuildingNeededTechnology()
    {
        return getBuilding().building.getTechnologyNeeded();
    }



    public BuildingTypes getBuildingNeededBuildings()
    {
        return getBuilding().building.getRequiredBuildings();
    }



    public Wonders getWonder()
    {
        for (int i = 0; i < Wonders.values().length; i++){
            if (gameName.equalsIgnoreCase(Wonders.values()[i].wonder.getGameName())){
                return Wonders.values()[i];
            }
        }

        return null;
    }


    public boolean isWonder() {
        return isWonder;
    }


    public boolean isBuilding() {
        return isBuilding;
    }


    public  Technologies getWonderNeededTechnology()
    {
        return getWonder().wonder.getTechnologyNeeded();
    }


    public boolean isUnit() {
        return isUnit;
    }


    public boolean isMeleeUnit() {
        return isMeleeUnit;
    }


    public boolean isRangedUnit() {
        return isRangedUnit;
    }


    public boolean isHeavyUnit() {
        return isHeavyUnit;
    }


    public StrategicResourceTypes getResourceNeeded()
    {
        if (isMeleeUnit){
            return getMeleeUnit().unit.getResourceRequired();
        }
        else if (isRangedUnit){
            return getRangedUnit().unit.getResourceRequired();
        }
        else if (isHeavyUnit){
            return getHeavyUnit().unit.getResourceRequired();
        }
        else {
            return null;
        }
    }


    public int getGoldNeeded()
    {
        if (isMeleeUnit){
            return getMeleeUnit().unit.getPrice();
        }
        else if (isRangedUnit){
            return getRangedUnit().unit.getPrice();
        }
        else if (isHeavyUnit){
            return getHeavyUnit().unit.getPrice();
        }
        else {
            if (gameName.equalsIgnoreCase("settler")){
                return 89;
            }
            else {
                return 70;
            }
        }
    }



    //setters
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }


    public void setProductionNeeded(int productionNeeded) {
        this.productionNeeded = productionNeeded;
    }
}
