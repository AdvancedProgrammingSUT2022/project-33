package Model;

import java.util.ArrayList;

public class Unit {
    String type;
    int health;
    int visibilityRange;
    int maxMovements;
    int remainingMovements;
    Coordinates coordinates;
    Coordinates destinationCoordinates;
    int price;
    int timeRequiredForBeingMade;
    int maintenancePricePerTurn;
    boolean isMoving;
    PathFinder pathFinder;
    ArrayList<Coordinates> path;





    ////methods////
    public Unit(int health, int visibilityRange, int maxMovements, Coordinates coordinates, int price, int timeRequiredForBeingMade, int maintenancePricePerTurn)
    {
        this.health = health;
        this.visibilityRange = visibilityRange;
        this.maxMovements = maxMovements;
        this.coordinates = coordinates;
        this.price = price;
        this.timeRequiredForBeingMade = timeRequiredForBeingMade;
        this.maintenancePricePerTurn = maintenancePricePerTurn;
        this.path = new ArrayList<>();


    }



    public void updateUnit()
    {
        //TODO:
    }



    public void resetUnit()
    {
        //TODO:
    }



    private void moveUnit(ArrayList<Terrain> terrains)
    {
        ArrayList<Coordinates> remainingPath = new ArrayList<>();

        int i = 0;

        while(!path.get(i).equals(coordinates)){
            i++;
        }

        i++;

        while (i < path.size()){
            remainingPath.add(path.get(i));
        }

        i = 0;

        while (!coordinates.equals(destinationCoordinates) && remainingMovements >= getTerrainFromCoordinates(terrains, path.get(i)).getMovementPrice()){
            remainingMovements -= getTerrainFromCoordinates(terrains, path.get(i)).getMovementPrice();
            coordinates = path.get(i);
            i++;
        }


        if (coordinates.equals(destinationCoordinates)){
            isMoving = false;
        }
    }



    public void setPath(Coordinates destinationCoordinates)
    {
        this.destinationCoordinates = destinationCoordinates;

        pathFinder.findPath(coordinates, destinationCoordinates);
    }



    private Terrain getTerrainFromCoordinates(ArrayList<Terrain> terrains, Coordinates coordinates)
    {
        for (int i = 0; i < terrains.size(); i++){
            if (coordinates.equals(terrains.get(i))){
                return terrains.get(i);
            }
        }

        return null;
    }



    public void cancelCurrentAction()
    {
        //TODO:
    }
}
