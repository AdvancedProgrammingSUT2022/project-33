package Model;

public class Worker extends Unit{
    boolean isWorking;
    int turnsRemaining;





    public Worker (Coordinates coordinates)
    {
        super(8, 2, 2, 70, 70, 0);
        super.setCoordinates(coordinates);
    }
}
