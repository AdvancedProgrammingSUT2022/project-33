package Program.Model.Models;

import java.util.ArrayList;
import java.util.Random;

public class Ruin {
    Coordinates coordinates;
    ArrayList<Coordinates> coordinatesToBeRevealed;
    boolean hasBarbarianActivity;
    Coordinates barbarianCoordinates;
    int gold;





    ////methods////
    public Ruin(Coordinates coordinates, ArrayList<BarbarianBase> barbarianBases, int maxSize)
    {
        this.coordinates = coordinates;
        chooseCoordinatesToBeRevealed(maxSize);

        Random rand = new Random();

        hasBarbarianActivity = (rand.nextInt(2) == 0);

        if (hasBarbarianActivity && barbarianBases.size() != 0){
            barbarianCoordinates = barbarianBases.get(rand.nextInt(barbarianBases.size())).getCoordinates();
        }

        gold = rand.nextInt(150) + 100;
    }



    private void chooseCoordinatesToBeRevealed(int maxSize)
    {
        Random rand = new Random();
        int xChange = rand.nextInt(5) + 2;
        int yChange = rand.nextInt(5) + 2;
        int x = coordinates.getX();
        int y = coordinates.getY();

        if (rand.nextInt(2) == 0){
            x += xChange;
        }
        else {
            x -= xChange;
        }

        if (rand.nextInt(2) == 0){
            y += yChange;
        }
        else {
            y -= yChange;
        }

        Coordinates newCoordinates = new Coordinates(x, y, 0);

        if (x < maxSize && x >= 0 && y < maxSize && y >= 0) {

            if (coordinatesToBeRevealed != null) {
                coordinatesToBeRevealed.add(newCoordinates);
                spreadCoordinates(newCoordinates, 80, maxSize);
            }
        }
    }



    private void spreadCoordinates(Coordinates newCoordinates, int chance, int maxSize)
    {
        int x = newCoordinates.getX();
        int y = newCoordinates.getY();

        if (y < maxSize - 1) {
            tryAddingCoordinates(x, y + 2, chance, maxSize);
        }

        if (x < maxSize - 1) {
            tryAddingCoordinates(x + 1, y, chance, maxSize);
        }

        if (x > 0) {
            tryAddingCoordinates(x - 1, y, chance, maxSize);
        }

        if (y > 0) {
            tryAddingCoordinates(x, y - 1, chance, maxSize);

            if (x < maxSize - 1) {
                tryAddingCoordinates(x + 1, y - 1, chance, maxSize);
            }

            if (x > 0) {
                tryAddingCoordinates(x - 1, y - 1, chance, maxSize);
            }
        }
    }



    private void tryAddingCoordinates(int x, int y, int chance, int maxSize)
    {
        Random rand = new Random();

        if (rand.nextInt(100) <= chance && isCoordinatesHidden(new Coordinates(x, y, 0))){
            Coordinates newCoordinates = new Coordinates(x, y, 0);
            coordinatesToBeRevealed.add(newCoordinates);
            spreadCoordinates(newCoordinates, chance / 10, maxSize);
        }
    }



    private boolean isCoordinatesHidden(Coordinates checkingCoordinates)
    {
        for (int i = 0; i < coordinatesToBeRevealed.size(); i++){
            if (coordinates.getX() == checkingCoordinates.getX() && coordinates.getY() == checkingCoordinates.getY() && coordinates.getZ() == checkingCoordinates.getZ()){
                return false;
            }
        }

        return true;
    }
}
