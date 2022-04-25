package Model;

import java.util.ArrayList;
import java.util.Random;

public class River {
    ArrayList<Coordinates> riverCoordinates;
    TileDirections mainDirection;





    ////methods////
    public River(Coordinates rootCoordinates, int mapSize, ArrayList<Coordinates> unavailableTerrainCoordinates)
    {
        riverCoordinates = new ArrayList<>();
        riverCoordinates.add(rootCoordinates);
        Random rand = new Random();
        mainDirection = TileDirections.values()[rand.nextInt(TileDirections.values().length)];

        flowWater(mapSize, unavailableTerrainCoordinates);
    }



    private void flowWater(int mapSize, ArrayList<Coordinates> unavailableTerrainCoordinates)
    {
        Random rand = new Random();
        int chance = 100 * (int) Math.pow(0.75, riverCoordinates.size() - 1);

        if (rand.nextInt(100) > chance){
            return;
        }

        TileDirections direction = chooseDirection();
        Coordinates coordinates = getCoordinatesFromDirection(direction, mapSize);

        if (coordinates != null && isCoordinatesAvailable(coordinates, unavailableTerrainCoordinates)){
            riverCoordinates.add(coordinates);
            flowWater(mapSize, unavailableTerrainCoordinates);
        }
    }



    private TileDirections chooseDirection()
    {
        Random rand = new Random();
        int directionNumber =  getDirectionNumber(mainDirection) + rand.nextInt(3) - 1;

        if (directionNumber < 0){
            directionNumber = TileDirections.values().length - 1;
        }
        else if (directionNumber >= TileDirections.values().length){
            directionNumber = 0;
        }

        return TileDirections.values()[directionNumber];
    }



    private int getDirectionNumber(TileDirections direction)
    {
        for (int i = 0; i <  TileDirections.values().length; i++){
            if (TileDirections.values()[i].equals(direction)){
                return i;
            }
        }

        return 0;
    }



    private Coordinates getCoordinatesFromDirection(TileDirections direction, int mapSize)
    {
        Coordinates lastCoordinates = riverCoordinates.get(riverCoordinates.size() - 1);

        if (direction.equals(TileDirections.UP) && lastCoordinates.getY() > 1){
            return new Coordinates(lastCoordinates.getX(), lastCoordinates.getY() - 2, 0);
        }
        else if (direction.equals(TileDirections.UP_RIGHT) && lastCoordinates.getY() > 0 && lastCoordinates.getX() < mapSize - 1){
            return new Coordinates(lastCoordinates.getX() + 1, lastCoordinates.getY() - 1, 0);
        }
        else if (direction.equals(TileDirections.DOWN_RIGHT) && lastCoordinates.getY() < mapSize - 1 && lastCoordinates.getX() < mapSize - 1){
            return new Coordinates(lastCoordinates.getX() + 1, lastCoordinates.getY() + 1, 0);
        }
        else if (direction.equals(TileDirections.DOWN) && lastCoordinates.getY() < mapSize - 2){
            return new Coordinates(lastCoordinates.getX(), lastCoordinates.getY() + 2, 0);
        }
        else if (direction.equals(TileDirections.DOWN_LEFT) && lastCoordinates.getY() < mapSize - 1 && lastCoordinates.getX() > 0){
            return new Coordinates(lastCoordinates.getX() - 1, lastCoordinates.getY() + 1, 0);
        }
        else if (direction.equals(TileDirections.UP_LEFT) && lastCoordinates.getY() > 0 && lastCoordinates.getX() > 0){
            return new Coordinates(lastCoordinates.getX() - 1, lastCoordinates.getY() - 1, 0);
        }
        else {
            return null;
        }
    }



    private boolean isCoordinatesAvailable(Coordinates coordinates, ArrayList<Coordinates> unavailableCoordinates)
    {
        for (int i = 0; i < unavailableCoordinates.size(); i++){
            if (unavailableCoordinates.get(i).equals(coordinates)){
                return false;
            }
        }

        return true;
    }
}
