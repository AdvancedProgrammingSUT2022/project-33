package Model;

public enum MapSizes {
    SMALL(250),
    MEDIUM(500),
    LARGE(1000);

    public final int size;

    MapSizes(int size)
    {
        this.size = size;
    }
}
