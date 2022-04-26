import Controller.LoginMenuController;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Coordinates> unavailablePaths = new ArrayList<>();
        unavailablePaths.add(new Coordinates(1, 0, 0));
        unavailablePaths.add(new Coordinates(1, 1, 0));
        unavailablePaths.add(new Coordinates(3, 1, 0));
        unavailablePaths.add(new Coordinates(3, 2, 0));
        unavailablePaths.add(new Coordinates(3, 3, 0));

        PathFinder pathFinder = new PathFinder(10, unavailablePaths);
        pathFinder.findPath(new Coordinates(0, 0, 0), new Coordinates(4, 2, 0));
        //LoginMenuController loginMenuController = new LoginMenuController();
    }
}
