package Model;

public class MapMaker {
    private Map map;
    private GeneralBiomes generalBiome;
    private MapSizes mapSize;





    ////methods////
    public MapMaker(Map map, GeneralBiomes generalBiome, MapSizes mapSize)
    {
        this.map = map;
        this.generalBiome = generalBiome;
        this.mapSize = mapSize;
    }
}
