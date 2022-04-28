package Model;

import java.util.ArrayList;

public class UnitList {
    private ArrayList<Worker> workers;
    private ArrayList<Settler> settlers;
    private ArrayList<MeleeMilitaryUnit> meleeMilitaryUnits;
    private ArrayList<RangedMilitaryUnit> rangedMilitaryUnits;
    private int numberOfAllUnits;





    ////methods////
    public UnitList()
    {
        this.workers = new ArrayList<>();
        this.settlers = new ArrayList<>();
        //TODO:
    }



    public void addWorker(Worker worker)
    {
        workers.add(worker);
        this.numberOfAllUnits++;
    }



    public void addSettler(Settler settler)
    {
        settlers.add(settler);
        this.numberOfAllUnits++;
    }



    public void addMilitaryUnit(MeleeMilitaryUnit militaryUnit)
    {
        meleeMilitaryUnits.add(militaryUnit);
        this.numberOfAllUnits++;
    }



    //getters
    public ArrayList<Worker> getWorkers() {
        return workers;
    }


    public ArrayList<Settler> getSettlers() {
        return settlers;
    }


    public ArrayList<MeleeMilitaryUnit> getMeleeMilitaryUnits() {
        return meleeMilitaryUnits;
    }



    public ArrayList<RangedMilitaryUnit> getRangedMilitaryUnits()
    {
        return rangedMilitaryUnits;
    }
}
