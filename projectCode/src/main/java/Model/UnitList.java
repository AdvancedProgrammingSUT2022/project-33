package Model;

import java.util.ArrayList;

public class UnitList {
    ArrayList<Worker> workers;
    ArrayList<Settler> settlers;
    ArrayList<MilitaryUnit> militaryUnits;





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
    }



    public void addSettler(Settler settler)
    {
        settlers.add(settler);
    }



    public void addMilitaryUnit(MilitaryUnit militaryUnit)
    {
        militaryUnits.add(militaryUnit);
    }
}
