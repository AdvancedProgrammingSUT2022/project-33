import Controller.LoginMenuController;
import Model.GeneralBiomes;
import Model.Map;
import Model.MapMaker;
import Model.MapSizes;

public class Main {
    public static void main(String[] args)
    {
        Map map = new Map();
        MapMaker mapMaker = new MapMaker(map, GeneralBiomes.DESERT, MapSizes.VERY_TINY);
        LoginMenuController loginMenuController = new LoginMenuController();
    }
}
