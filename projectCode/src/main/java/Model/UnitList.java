package Model;

import java.util.ArrayList;

public class UnitList {
    ArrayList<Worker> workers;
    ArrayList<Settler> settlers;
    ArrayList<MeleeMilitaryUnit> militaryUnits;
    int numberOfAllUnits;





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
        militaryUnits.add(militaryUnit);
        this.numberOfAllUnits++;
    }



    //getters
    public ArrayList<Worker> getWorkers() {
        return workers;
    }


    public ArrayList<Settler> getSettlers() {
        return settlers;
    }


    public ArrayList<MeleeMilitaryUnit> getMilitaryUnits() {
        return militaryUnits;
    }
}
