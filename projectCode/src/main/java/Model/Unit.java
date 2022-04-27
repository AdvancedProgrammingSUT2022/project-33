package Model;

import java.util.ArrayList;

public class Unit {
    private String type;
    private Colors color;
    private boolean belongsToPlayer;
    private NonPlayerColors nonPlayerColor;
    private int health;
    private int visibilityRange;
    private int maxMovements;
    private int remainingMovements;
    private Coordinates coordinates;
    private Coordinates destinationCoordinates;
    private int price;
    private int productionNeededForBeingMade;
    private int maintenancePricePerTurn;
    private boolean isMoving;
    private PathFinder pathFinder;
    private ArrayList<Coordinates> path;





    ////methods////
    public Unit(int health, int visibilityRange, int maxMovements, int price, int productionNeededForBeingMade, int maintenancePricePerTurn)
    {
        this.health = health;
        this.visibilityRange = visibilityRange;
        this.maxMovements = maxMovements;
        this.price = price;
        this.productionNeededForBeingMade = productionNeededForBeingMade;
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



    public void cancelCurrentAction()
    {
        //TODO:
    }



    //setters
    public void setPath(Coordinates destinationCoordinates)
    {
        this.destinationCoordinates = destinationCoordinates;

        pathFinder.findPath(coordinates, destinationCoordinates);
    }


    public void setType(String type) {
        this.type = type;
    }


    public void setColor(Colors color) {
        this.color = color;
    }


    public void setBelongsToPlayer(boolean belongsToPlayer) {
        this.belongsToPlayer = belongsToPlayer;
    }


    public void setNonPlayerColor(NonPlayerColors nonPlayerColor) {
        this.nonPlayerColor = nonPlayerColor;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public void setVisibilityRange(int visibilityRange) {
        this.visibilityRange = visibilityRange;
    }


    public void setMaxMovements(int maxMovements) {
        this.maxMovements = maxMovements;
    }


    public void setRemainingMovements(int remainingMovements) {
        this.remainingMovements = remainingMovements;
    }


    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setDestinationCoordinates(Coordinates destinationCoordinates) {
        this.destinationCoordinates = destinationCoordinates;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public void setTimeRequiredForBeingMade(int productionNeededForBeingMade) {
        this.productionNeededForBeingMade = productionNeededForBeingMade;
    }


    public void setMaintenancePricePerTurn(int maintenancePricePerTurn) {
        this.maintenancePricePerTurn = maintenancePricePerTurn;
    }


    public void setMoving(boolean moving) {
        isMoving = moving;
    }


    public void setPathFinder(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }


    public void setPath(ArrayList<Coordinates> path) {
        this.path = path;
    }



    //getters
    private Terrain getTerrainFromCoordinates(ArrayList<Terrain> terrains, Coordinates coordinates)
    {
        for (int i = 0; i < terrains.size(); i++){
            if (coordinates.equals(terrains.get(i))){
                return terrains.get(i);
            }
        }

        return null;
    }


    public String getType() {
        return type;
    }


    public Colors getColor() {
        return color;
    }


    public boolean isBelongsToPlayer() {
        return belongsToPlayer;
    }


    public NonPlayerColors getNonPlayerColor() {
        return nonPlayerColor;
    }


    public int getHealth() {
        return health;
    }


    public int getVisibilityRange() {
        return visibilityRange;
    }


    public int getMaxMovements() {
        return maxMovements;
    }


    public int getRemainingMovements() {
        return remainingMovements;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }


    public Coordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }


    public int getPrice() {
        return price;
    }


    public int getProductionNeededForBeingMade() {
        return productionNeededForBeingMade;
    }


    public int getMaintenancePricePerTurn() {
        return maintenancePricePerTurn;
    }


    public boolean isMoving() {
        return isMoving;
    }


    public PathFinder getPathFinder() {
        return pathFinder;
    }


    public ArrayList<Coordinates> getPath() {
        return path;
    }
}
