package Model;

public class CityTask {
    String gameName;
    int productionNeeded;
    boolean isUnit;
    boolean isWonder;
    boolean isBuilding;
    boolean isTaskValid;
    boolean isMeleeUnit;
    boolean isRangedUnit;
    boolean isHeavyUnit;





    ////methods////
    public CityTask(String gameName, boolean isUnit, boolean isBuilding, boolean isWonder)
    {
        this.gameName = gameName;

        if (isUnit) {
            isTaskValid = findUnitTask();
        }
    }



    private boolean findUnitTask()
    {
        if (gameName.equalsIgnoreCase("Settler")){
            gameName = "Settler";
        }
        else if (gameName.equalsIgnoreCase("Worker")){
            gameName = "Worker";
        }
        else if (getMeleeUnit() != null){
            gameName = getMeleeUnit().unit.getGameName();
            isMeleeUnit = true;
        }
        else if (getRangedUnit() != null){
            gameName = getRangedUnit().unit.getGameName();
            isRangedUnit = true;

        }
        else if (getHeavyUnit() != null){
            gameName = getHeavyUnit().unit.getGameName();
            isHeavyUnit = true;
        }
        else {
            return false;
        }

        return true;
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
}
