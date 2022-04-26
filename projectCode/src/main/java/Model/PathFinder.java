package Model;

import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    Coordinates startingPoint;
    Coordinates destination;
    ArrayList<Coordinates> unavailableTerrains;
    int mapSize;
    ArrayList<ArrayList<Coordinates>> possiblePaths;





    ////methods////
    public PathFinder(int mapSize, ArrayList<Coordinates> unavailableTerrains)
    {
        this.mapSize = mapSize;
        this.unavailableTerrains = unavailableTerrains;
        possiblePaths = new ArrayList<>();
    }



    public ArrayList<Coordinates> findPath(Coordinates startingPoint, Coordinates destination)
    {
        this.startingPoint = startingPoint;
        this.destination = destination;
        possiblePaths.add(new ArrayList<>(List.of(startingPoint)));

        testNewPaths();
        ArrayList<Coordinates> bestPath = possiblePaths.get(possiblePaths.size() - 1);

        for (int i = 0; i < bestPath.size(); i++){
            System.out.println(bestPath.get(i).getX() + "    " + bestPath.get(i).getY());
        }

        return bestPath;
    }



    private boolean testPath(ArrayList<Coordinates> searchedPlaces, Coordinates coordinatesToBeSearched)
    {
        if (searchedPlaces.contains(coordinatesToBeSearched) || unavailableTerrains.contains(coordinatesToBeSearched)){
            return false;
        }
        else if (coordinatesToBeSearched.getX() < 0 || coordinatesToBeSearched.getX() >= mapSize ||
                coordinatesToBeSearched.getY() < 0 || coordinatesToBeSearched.getY() >= mapSize){
            return false;
        }

        ArrayList<Coordinates> path = new ArrayList<>(searchedPlaces);
        path.add(coordinatesToBeSearched);
        possiblePaths.add(path);

        return coordinatesToBeSearched.equals(destination);
    }



    private void testNewPaths()
    {
        while (true){
            Coordinates coordinatesToBeSearched = possiblePaths.get(0).get(possiblePaths.get(0).size() - 1);
            ArrayList<Coordinates> temporarilyCoordinates = new ArrayList<>();

            temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX(), coordinatesToBeSearched.getY() - 1, 0));

            if (coordinatesToBeSearched.getX() % 2 == 0) {
                temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX() + 1, coordinatesToBeSearched.getY() - 1, 0));
                temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX() - 1, coordinatesToBeSearched.getY() - 1, 0));
                temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX() + 1, coordinatesToBeSearched.getY(), 0));
                temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX() - 1, coordinatesToBeSearched.getY(), 0));
            }
            else {
                temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX() + 1, coordinatesToBeSearched.getY(), 0));
                temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX() - 1, coordinatesToBeSearched.getY(), 0));
                temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX() + 1, coordinatesToBeSearched.getY() + 1, 0));
                temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX() - 1, coordinatesToBeSearched.getY() + 1, 0));
            }

            temporarilyCoordinates.add(new Coordinates(coordinatesToBeSearched.getX(), coordinatesToBeSearched.getY() + 1, 0));

            for (int k = 0; k < temporarilyCoordinates.size(); k++){
                if (testPath(possiblePaths.get(0), temporarilyCoordinates.get(k))){
                    return;
                }
            }

            possiblePaths.remove(0);
        }
    }
}
