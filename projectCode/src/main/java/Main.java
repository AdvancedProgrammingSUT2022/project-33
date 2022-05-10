import Controller.LoginMenuController;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        User test = new User("test", "test", "test1234");
        User test2 = new User("testPrime", "test2", "test1234");
        GameLoader gameLoader = new GameLoader(new ArrayList<User>(Arrays.asList(test, test2)), GeneralBiomes.DESERT, MapSizes.VERY_TINY);


        //LoginMenuController loginMenuController = new LoginMenuController();

    }
}
