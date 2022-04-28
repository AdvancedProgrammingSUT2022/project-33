package Model;

public class NormalCoordinates {
    private double x;
    private double y;





    ////methods////
    public NormalCoordinates(double normalX, double normalY)
    {
        this.x = normalX;
        this.y = normalY;
    }



    public NormalCoordinates(Coordinates coordinates)
    {
        x = 1.5 * coordinates.getX();
        y = Math.sqrt(3) * (coordinates.getY() + (x % 2) / 2);
    }



    public double calculateDistance(NormalCoordinates normalCoordinates)
    {
        return Math.sqrt(Math.pow(normalCoordinates.x - x, 2) + Math.pow(normalCoordinates.y - y, 2));
    }



    //getters
    public double getX()
    {
        return x;
    }


    public double getY()
    {
        return y;
    }
}
