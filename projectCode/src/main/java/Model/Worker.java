package Model;

import View.MeleeView;
import View.SettlerView;
import View.WorkerView;

import java.util.ArrayList;

public class Worker extends Unit{
    boolean isWorking;
    int turnsRemaining;





    public Worker (Coordinates coordinates)
    {
        super("Worker", 8, 2, 2, 70, 70, 0);
        super.setCoordinates(coordinates);
    }



    public Worker(Coordinates coordinates, Colors color, Player owner){
        super("Worker", 8, 2, 2, 70, 70, 0);
        setCoordinates(coordinates);
        setColor(color);
        setBelongsToPlayer(true);
        setOwner(owner);
    }



    public void updateUnit(ArrayList<Terrain> terrains)
    {
        setRemainingMovements(getMaxMovements());

        if (isMoving()) {
            moveUnit(terrains, getOwner().getMap(), new WorkerView(getGameName()));
        }

        //TODO:
    }



    public void moveUnit(ArrayList<Terrain> terrains, MiniMap miniMap, WorkerView view)
    {
        ArrayList<Coordinates> remainingPath = new ArrayList<>();

        int i = 0;

        while(!getPath().get(i).equals(getCoordinates())){
            i++;
        }

        i++;

        while (i < getPath().size()){
            remainingPath.add(getPath().get(i));
            i++;
        }

        i = 0;

        while (!getCoordinates().equals(getDestinationCoordinates()) &&
                getRemainingMovements() >= getTerrainFromCoordinates(terrains, remainingPath.get(i)).getMovementPrice()){
            if (miniMap.getUnits().getSettlerFromCoordinates(remainingPath.get(i)) != null){
                view.showOccupiedCoordinates(false, remainingPath.get(i));
                resetDestinationCoordinates();
                setMoving(false);
                return;
            }
            else if (miniMap.getUnits().getWorkerFromCoordinates(remainingPath.get(i)) != null){
                view.showOccupiedCoordinates(false, remainingPath.get(i));
                resetDestinationCoordinates();
                setMoving(false);
                return;
            }

            setRemainingMovements(getRemainingMovements() - getTerrainFromCoordinates(terrains, remainingPath.get(i)).getMovementPrice());
            setCoordinates(remainingPath.get(i));
            i++;
        }

        getOwner().getMap().updateMap();

        if (getCoordinates().equals(getDestinationCoordinates())){
            setMoving(false);
        }
    }



    public void removeUnit()
    {
        getOwner().addGold(getPrice() * getHealth() / 10);

        getOwner().getPlayerUnits().getRangedMilitaryUnits().remove(this);
        getOwner().getMap().getUnits().getRangedMilitaryUnits().remove(this);
        getOwner().getMap().getOriginalMap().getUnits().getRangedMilitaryUnits().remove(this);
    }
}
