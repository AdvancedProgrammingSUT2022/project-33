package Controller;

import Model.Coordinates;
import Model.MatchingStrings;
import Model.Player;
import Model.UserInput;
import View.MiniMapView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

public class MiniMapController {
    Player player;
    MiniMapView view;





    ////methods////
    public MiniMapController(Player player)
    {
        this.player = player;
        this.view = new MiniMapView();
        view.showYouAreInMiniMapMessage();
        view.showMiniMap(player.getMap());

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.SHOW_MAP)){
                view.showMiniMap(player.getMap());
            }
            else if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.SHOW_MAP_ZOOMED1) ||
                    UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.SHOW_MAP_ZOOMED2)){
                showZoomedMap(input);
            }
            else if (UserInput.doesMatchMultipleRegex(input, MatchingStrings.MinimapControllerStrings.SHOW_UNITS.toString(),
                    new ArrayList<>(Arrays.asList(MatchingStrings.MinimapControllerStrings.HEALTH_FLAG, MatchingStrings.MinimapControllerStrings.MOVE_POINT_FLAG,
                            MatchingStrings.MinimapControllerStrings.ATTACK_DAMAGE_FLAG, MatchingStrings.MinimapControllerStrings.DEFENCE_FLAG)))){
                showUnits(input);
            }
            else if (UserInput.doesMatchMultipleRegex(input, MatchingStrings.MinimapControllerStrings.SHOW_CITIES.toString(),
                    new ArrayList<>(Arrays.asList(MatchingStrings.MinimapControllerStrings.HEALTH_FLAG, MatchingStrings.MinimapControllerStrings.POPULATION_FLAG,
                            MatchingStrings.MinimapControllerStrings.GOLD_FLAG, MatchingStrings.MinimapControllerStrings.HAPPINESS_FLAG,
                            MatchingStrings.MinimapControllerStrings.TASK_FLAG, MatchingStrings.MinimapControllerStrings.LANDS_FLAG)))){
                showCities(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.MANAGE_UNIT1) ||
                    UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.MANAGE_UNIT2)){
                manageUnit(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.MANAGE_MILITARY_UNIT1) ||
            UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.MANAGE_MILITARY_UNIT2)){
                manageMilitaryUnit(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.SHOW_MENU)){
                view.showCurrentMenu();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.BACK)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void showZoomedMap(String input)
    {
        String startingPointString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.MinimapControllerStrings.STARTING_POINT);
        String endingPointString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.MinimapControllerStrings.ENDING_POINT);
        int startingPoint = Integer.parseInt(startingPointString.split(" ")[1]);
        int endingPoint = Integer.parseInt(endingPointString.split(" ")[1]);

        if (startingPoint > player.getMap().getMapSize()){
            view.showValueOutOfBoundaries(startingPoint, player.getMap().getMapSize(), "Starting Point");
        }
        else if (endingPoint > player.getMap().getMapSize()){
            view.showValueOutOfBoundaries(endingPoint, player.getMap().getMapSize(), "Ending Point");
        }
        else {
            if (startingPoint % 2 != 0){
                startingPoint--;
            }

            view.showMiniMapZoomed(player.getMap(), startingPoint, endingPoint);
        }
    }



    private void showUnits(String input)
    {
        String unitType = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.MinimapControllerStrings.UNIT_TYPE);
        unitType = unitType.split(" ")[1];

        boolean healthFlag = MatchingStrings.MinimapControllerStrings.HEALTH.matcher(input).find();
        boolean movePointFlag = MatchingStrings.MinimapControllerStrings.MOVE_POINT.matcher(input).find();
        boolean attackDamageFlag = MatchingStrings.MinimapControllerStrings.ATTACK_DAMAGE.matcher(input).find();
        boolean defenceFlag = MatchingStrings.MinimapControllerStrings.DEFENCE.matcher(input).find();

        if ((defenceFlag || attackDamageFlag) && (unitType.equals("worker") || unitType.equals("settler"))){
            view.showInvalidUnitFlag(unitType);
            return;
        }

        if (unitType.equals("worker")) {
            view.showNormalUnits(player.getPlayerUnits().getWorkers(), healthFlag, movePointFlag);
        }
        else if (unitType.equals("settler")){
            view.showNormalUnits(player.getPlayerUnits().getSettlers(), healthFlag, movePointFlag);
        }
        else {
            view.showMilitaryUnits(player.getPlayerUnits().getMeleeMilitaryUnits(), healthFlag, movePointFlag, attackDamageFlag, defenceFlag);
            view.showMilitaryUnits(player.getPlayerUnits().getRangedMilitaryUnits(), healthFlag, movePointFlag, attackDamageFlag, defenceFlag);
            view.showMilitaryUnits(player.getPlayerUnits().getHeavyRangedUnits(), healthFlag, movePointFlag, attackDamageFlag, defenceFlag);
        }
    }



    private void showCities(String input)
    {
        boolean healthFlag = MatchingStrings.MinimapControllerStrings.HEALTH.matcher(input).find();
        boolean populationFlag = MatchingStrings.MinimapControllerStrings.POPULATION.matcher(input).find();
        boolean goldFlag = MatchingStrings.MinimapControllerStrings.GOLD.matcher(input).find();
        boolean happinessFlag = MatchingStrings.MinimapControllerStrings.HAPPINESS.matcher(input).find();
        boolean taskFlag = MatchingStrings.MinimapControllerStrings.TASK.matcher(input).find();
        boolean landsFlag = MatchingStrings.MinimapControllerStrings.LANDS.matcher(input).find();

        view.showCities(player.getCities(), healthFlag, populationFlag, goldFlag, happinessFlag, taskFlag, landsFlag);
    }



    private void manageUnit(String input)
    {
        Coordinates coordinates = getCoordinatesFromInput(input);

        if (coordinates == null){
            return;
        }

        if (player.getPlayerUnits().getWorkerFromCoordinates(coordinates) != null){
            //TODO:
        }
        else if (player.getPlayerUnits().getSettlerFromCoordinates(coordinates) != null){
            SettlerController settlerController = new SettlerController(player.getPlayerUnits().getSettlerFromCoordinates(coordinates));
            view.showYouAreInMiniMapMessage();
        }
        else {
            view.showThereIsNoUnit();
        }
    }



    private void manageMilitaryUnit(String input)
    {
        Coordinates coordinates = getCoordinatesFromInput(input);

        if (coordinates == null){
            return;
        }

        if (player.getPlayerUnits().getMeleeMilitaryUnitFromCoordinates(coordinates) != null){
            MeleeController meleeController = new MeleeController(player.getPlayerUnits().getMeleeMilitaryUnitFromCoordinates(coordinates));
            view.showYouAreInMiniMapMessage();
        }
        else if (player.getPlayerUnits().getRangedMilitaryUnitFromCoordinates(coordinates) != null){
            //TODO:
        }
        else if (player.getPlayerUnits().getHeavyRangedMilitaryUnitFromCoordinates(coordinates) != null){
            //TODO:
        }
        else {
            view.showThereIsNoUnit();
        }
    }



    public Coordinates getCoordinatesFromInput(String input)
    {
        String xString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.MinimapControllerStrings.X_VALUE).split(" ")[1];
        String yString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.MinimapControllerStrings.Y_VALUE).split(" ")[1];

        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);

        if (x < 0 || x > player.getMap().getMapSize() - 1){
            view.showCoordinatesOutOfBoundary(x, "x", player.getMap().getMapSize());
            return null;
        }
        else if (y < 0 || y > player.getMap().getMapSize() - 1)
        {
            view.showCoordinatesOutOfBoundary(y, "y", player.getMap().getMapSize());
            return null;
        }
        else {
            return new Coordinates(x, y, 0);
        }
    }
}
