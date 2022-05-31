package Program.Model;

public enum MapSizes {
    VERY_TINY(10),
    TINY(25),
    SMALL(50),
    MEDIUM(100),
    LARGE(200);

    public final int size;

    MapSizes(int size)
    {
        this.size = size;
    }
}