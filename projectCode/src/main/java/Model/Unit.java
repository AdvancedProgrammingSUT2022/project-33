package Model;

import java.util.ArrayList;

public class Unit {
    private String gameName;
    private String type;
    private Colors color;
    private boolean belongsToPlayer;
    private Player Owner;
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
    public Unit(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionNeededForBeingMade,
                int maintenancePricePerTurn)
    {
        this.gameName = gameName;
        this.health = health;
        this.visibilityRange = visibilityRange;
        this.maxMovements = maxMovements;
        this.price = price;
        this.productionNeededForBeingMade = productionNeededForBeingMade;
        this.maintenancePricePerTurn = maintenancePricePerTurn;
        this.path = new ArrayList<>();
    }



    public void resetUnit()
    {
        //TODO:
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


    public boolean setDestinationCoordinates(Coordinates destinationCoordinates, ArrayList<Coordinates> unavailableTerrains, int mapSize) {
        if (!getOwner().getMap().getTerrainFromCoordinates(destinationCoordinates).isCanBeCrossed())
        {
            //returns true if can destination is not available
            return true;
        }

        this.destinationCoordinates = destinationCoordinates;
        pathFinder = new PathFinder(mapSize, unavailableTerrains);
        setPath(pathFinder.findPath(coordinates, destinationCoordinates));
        isMoving = true;

        return false;
    }



    public void resetDestinationCoordinates()
    {
        this.destinationCoordinates = getCoordinates();
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


    public void setOwner(Player owner) {
        Owner = owner;
    }



    //getters
    public Terrain getTerrainFromCoordinates(ArrayList<Terrain> terrains, Coordinates coordinates)
    {
        for (int i = 0; i < terrains.size(); i++){
            if (coordinates.equals(terrains.get(i).getCenterCoordinates())){
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


    public String getGameName() {
        return gameName;
    }


    public Player getOwner() {
        return Owner;
    }
}
