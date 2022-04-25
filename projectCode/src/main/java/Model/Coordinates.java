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
}
