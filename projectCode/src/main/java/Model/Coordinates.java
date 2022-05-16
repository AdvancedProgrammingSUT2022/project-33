package Model;

public class Coordinates {
    private int x;
    private int y;
    private int z;





    ////methods////
    public Coordinates(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }



    @Override
    public boolean equals(Object object)
    {
        if (object == this){
            return true;
        }
        else if (getClass() != object.getClass()){
            return false;
        }

        Coordinates coordinates = (Coordinates) object;

        return x == coordinates.getX() && y == coordinates.getY() && z == coordinates.getZ();
    }



    public boolean isNextToCoordinates(Coordinates coordinates)
    {
        if (Math.abs(x - coordinates.getX()) +  Math.abs(y - coordinates.getY()) == 1){
            return true;
        }
        else if (Math.abs(x - coordinates.getX()) + Math.abs(y - coordinates.getY()) == 2){
            if (y - coordinates.getY() == 1 && coordinates.getX() % 2 == 0){
                return true;
            }
            else if (coordinates.getY() - y == 1 &&  x % 2 == 0){
                return true;
            }
        }

        return false;
    }



    //getters
    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getZ() {
        return z;
    }



    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
