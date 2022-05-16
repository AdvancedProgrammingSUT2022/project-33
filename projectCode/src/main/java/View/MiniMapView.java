package View;

import Model.*;

import java.util.ArrayList;

public class MiniMapView {





    ////methods////
    public void showYouAreInMiniMapMessage()
    {
        System.out.println("you are now controlling minimap");
    }



    public void showMiniMap(MiniMap miniMap, boolean isCheat)
    {
        showXCoordinates(0, miniMap.getMapSize());
        showRows(0, miniMap.getMapSize(), miniMap, isCheat);
    }



    public void showMiniMapZoomed(MiniMap miniMap, int startingPoint, int endingPoint, boolean isCheat)
    {
        showXCoordinates(startingPoint, endingPoint);
        showRows(startingPoint,  endingPoint, miniMap, isCheat);
    }



    public void showCurrentMenu()
    {
        System.out.println("minimap menu");
    }



    private void showXCoordinates(int startingPoint, int endingPoint)
    {
        for (int i = startingPoint; i < endingPoint; i++){
            System.out.print("                    " + i + "       ");
        }

        System.out.println();
    }



    private void showRows(int startingPoint, int endingPoint, MiniMap miniMap, boolean isCheat)
    {
        for (int j = startingPoint; j <= endingPoint; j++){
            showLine1(startingPoint, endingPoint, j);
            showTileLines(startingPoint, endingPoint, miniMap, j, isCheat);
        }
    }



    private void showLine1(int startingPoint, int endingPoint, int y)
    {
        System.out.print("      ");
        printLinearSpaces(3);

        for (int i = startingPoint; i < endingPoint; i++){
            if (i % 2 == 0){
                System.out.print(".---------------------.");
            }
            else {
                if (y != 0) {
                    System.out.print("────────────────◯────────────────");
                }
                else {
                    System.out.print("                                 ");
                }
            }
        }

        System.out.println();
    }



    private void showMidLine(int startingPoint, int endingPoint, int y)
    {
        if (y < endingPoint) {
            System.out.print(y);
            printLinearSpaces(3 - Integer.toString(y).length());
        }
        else {
            printLinearSpaces(3);
        }

        System.out.print(".");

        for (int i = startingPoint; i < endingPoint; i++){
            if (i % 2 == 0) {
                if (y < endingPoint) {
                    System.out.print("────────────────◯────────────────");
                }
                else {
                    System.out.print("                                 ");
                }
            }
            else {
                System.out.print(".---------------------.");
            }
        }

        System.out.println();
    }



    private void showTileLines(int startingPoint, int endingPoint, MiniMap map, int y, boolean isCheat)
    {
        for (int j = 0; j < 5; j++){
            printLinearSpaces(3);

            for (int i = startingPoint; i < endingPoint; i++){
                showFirstPartOfVisibleTile(i, j, y, map, endingPoint, isCheat);
            }

            printLinearSpaces(5 - j);
            System.out.print("/");
            System.out.println();
        }

        showMidLine(startingPoint, endingPoint, y);

        for (int j = 0; j < 5; j++){
            printLinearSpaces(3);

            for (int i = startingPoint; i < endingPoint; i++){
                showSecondPartOfVisibleTile(i, j, y, map, endingPoint, isCheat);
            }

            if (y != endingPoint) {
                printLinearSpaces(j + 1);
                System.out.print("\\");
            }

            System.out.println();
        }
    }



    private void showFirstPartOfVisibleTile(int i, int j, int y, MiniMap map, int mapSize, boolean isCheat)
    {
        if (i % 2 == 0){
            if (i != 0 && !isCheat && map.getHiddenTileFromCoordinates(new Coordinates(i - 1, y - 1, 0)) == null &&
                    map.getVisibleTileFromCoordinates(new Coordinates(i - 1, y - 1, 0)) == null){
                printFog(5 - j);
            }
            else {
                printLinearSpaces(5 - j);
            }

            System.out.print("/");

            Coordinates coordinates = new Coordinates(i, y, 0);

            if (!isCheat && map.getHiddenTileFromCoordinates(coordinates) == null && map.getVisibleTileFromCoordinates(coordinates) == null){
                showFirstPartOfFog(i, j);
                return;
            }

            String dataType = "";
            String data = "";

            if (y < mapSize) {
                dataType = findTileLineDataFromLineNumber(j, map, i, y)[0];
                data = findTileLineDataFromLineNumber(j, map, i, y)[1];
            }

            printLinearSpaces(j + 1);
            int spaceNeeded = printTileDate(dataType, data, 21);
            printLinearSpaces(spaceNeeded);
        }
        else {
            if (y < mapSize && !isCheat && map.getHiddenTileFromCoordinates(new Coordinates(i - 1, y, 0)) == null &&
                    map.getVisibleTileFromCoordinates(new Coordinates(i - 1, y, 0)) == null){
                printFog(j + 1);
            }
            else if (y == mapSize){
                printFog(j + 1);
            }
            else {
                printLinearSpaces(j + 1);
            }

            System.out.print("\\");

            Coordinates coordinates = new Coordinates(i, y - 1, 0);

            if (!isCheat && map.getHiddenTileFromCoordinates(coordinates) == null && map.getVisibleTileFromCoordinates(coordinates) == null){
                showFirstPartOfFog(i, j);
                return;
            }

            printLinearSpaces(5 - j);

            String dataType = "";
            String data = "";

            if (y > 0) {
                dataType = findTileLineDataFromLineNumber(5 + j, map, i, y - 1)[0];
                data = findTileLineDataFromLineNumber(5 + j, map, i, y - 1)[1];
            }

            int spaceNeeded = printTileDate(dataType, data, 21);
            printLinearSpaces(spaceNeeded);
        }
    }



    private void showFirstPartOfFog(int i, int j)
    {
        if (i % 2 == 0){
            printFog(22 + j);
        }
        else {
            printFog(26 - j);
        }
    }



    private void showSecondPartOfFog(int i, int j)
    {
        if (i % 2 == 0){
            printFog(26 - j);
        }
        else {
            printFog(22 + j);
        }
    }



    private void printFog(int numberOfFogs)
    {
        for (int i = 0; i < numberOfFogs; i++){
            System.out.print("●");
        }
    }



    private void showSecondPartOfVisibleTile(int i, int j, int y, MiniMap map, int mapSize, boolean isCheat)
    {
        if (i % 2 == 0 && y < mapSize){
            if (i != 0 && !isCheat && map.getHiddenTileFromCoordinates(new Coordinates(i - 1, y, 0)) == null &&
                    map.getVisibleTileFromCoordinates(new Coordinates(i - 1, y, 0)) == null){
                printFog(j + 1);
            }
            else {
                printLinearSpaces(j + 1);
            }

            System.out.print("\\");

            Coordinates coordinates = new Coordinates(i, y, 0);

            if (!isCheat && map.getHiddenTileFromCoordinates(coordinates) == null && map.getVisibleTileFromCoordinates(coordinates) == null){
                showSecondPartOfFog(i, j);
                return;
            }

            String data;
            String dataType;

            dataType = findTileLineDataFromLineNumber(j + 5, map, i, y)[0];
            data = findTileLineDataFromLineNumber(j + 5, map, i, y)[1];

            printLinearSpaces(5 - j);
            int spaceNeeded = printTileDate(dataType, data, 21);
            printLinearSpaces(spaceNeeded);
        }
        else if (y < mapSize){
            if (!isCheat && map.getHiddenTileFromCoordinates(new Coordinates(i - 1, y, 0)) == null &&
                    map.getVisibleTileFromCoordinates(new Coordinates(i - 1, y, 0)) == null){
                printFog(5 - j);
            }
            else {
                printLinearSpaces(5 - j);
            }

            System.out.print("/");

            Coordinates coordinates = new Coordinates(i, y, 0);

            if (!isCheat && map.getHiddenTileFromCoordinates(coordinates) == null && map.getVisibleTileFromCoordinates(coordinates) == null){
                showSecondPartOfFog(i, j);
                return;
            }

            printLinearSpaces(j + 1);

            String dataType;
            String data;

            dataType = findTileLineDataFromLineNumber(j , map, i, y )[0];
            data = findTileLineDataFromLineNumber(j, map, i, y)[1];

            int spaceNeeded = printTileDate(dataType, data, 21);
            printLinearSpaces(spaceNeeded);
        }
    }



    private void printLinearSpaces(int numberOfSpaces)
    {
        for (int i = 0; i < numberOfSpaces; i++){
            System.out.print(" ");
        }
    }



    private String[] findTileLineDataFromLineNumber(int lineNumber, MiniMap map, int x, int y)
    {
        String[] data = new String[2];
        Coordinates coordinates = new Coordinates(x, y, 0);

        data[1] = "-";

        switch (lineNumber){
            case (0):
                data[0] = "Terrain";
                data[1] = map.getTerrainFromCoordinates(coordinates).getType();
                break;
            case (1):
                data[0] = "Feature";

                if (map.getTerrainFromCoordinates(coordinates).isHasProperty()) {
                    data[1] = map.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getProperty().getType();
                }
                break;
            case (2):
                data[0] = "Resource";

                if (map.getTerrainFromCoordinates(coordinates).isHasResource()){
                    data[1] = map.getTerrainFromCoordinates(coordinates).getResourceTypeString();
                }
                break;
            case (3):
                data[0] = "coordinates";
                data[1] = "(" + x + ", " + y + ")";
                break;
            case(4):
                data[0] = "has River or road";

                if (map.getTerrainFromCoordinates(coordinates).isHasRiver()){
                    data[1] = "river,";
                }
                if (map.getTerrainFromCoordinates(coordinates).isHasRoad()){
                    data[1] += "road";
                }
                break;
            case (5):
                data[0] = "City";

                if (map.getPlayerCityFromCoordinates(coordinates) != null){
                    data[1] = map.getPlayerCityFromCoordinates(coordinates).getCityName();
                }
                else if (map.getDefaultCityFromCoordinates(coordinates) != null){
                    data[1] = map.getDefaultCityFromCoordinates(coordinates).getDefaultCityGameName();
                }
                break;
            case (6):
                data[0] = "unit";

                if (map.getUnits().getWorkerFromCoordinates(coordinates) != null){
                    data[1] = "Worker";
                }
                else if (map.getUnits().getSettlerFromCoordinates(coordinates) != null){
                    data[1] = "Settler";
                }
                break;
            case (7):
                data[0] = "military";
                data[1] = getMilitaryUnitFromCoordinates(map, coordinates);
                break;
            case (8):
                data[0] = "color";

                if (map.getTerrainFromCoordinates(coordinates).isTerritory()){
                    data[1] = map.getTerrainFromCoordinates(coordinates).getTerritoryColor();
                }
                break;
            case (9):
                data[0] = "is visible";

                if (map.getVisibleTileFromCoordinates(coordinates) != null){
                    data[1] = "yes";
                }
                else {
                    data[1] = "no";
                }

                //TODO:
        }

        return data;
    }



    public String getMilitaryUnitFromCoordinates(MiniMap miniMap, Coordinates coordinates)
    {
        String data = "-";

        if (miniMap.getUnits().getMeleeMilitaryUnitFromCoordinates(coordinates) != null){
            data = miniMap.getUnits().getMeleeMilitaryUnitFromCoordinates(coordinates).getGameName();
        }
        else if (miniMap.getUnits().getRangedMilitaryUnitFromCoordinates(coordinates) != null){
            data = miniMap.getUnits().getRangedMilitaryUnitFromCoordinates(coordinates).getGameName();
        }
        else if (miniMap.getUnits().getHeavyRangedMilitaryUnitFromCoordinates(coordinates) != null){
            data = miniMap.getUnits().getRangedMilitaryUnitFromCoordinates(coordinates).getGameName();
        }

        return data;
    }



    private int printTileDate(String dataType, String data, int characterLimit)
    {

        if (dataType.length() != 0) {
            characterLimit -= dataType.length() + 2;
            System.out.print(dataType + ": ");
        }

        if (characterLimit < data.length()) {
            System.out.print(data.substring(0, characterLimit - 1));
            return 0;
        }

        System.out.print(data);
        return characterLimit - data.length();
    }



    public void showValueOutOfBoundaries(int number, int maxValue, String valuePart)
    {
        System.out.println(number + "is out of Boundaries for " + valuePart);
        System.out.println("maximum value is: " + maxValue);
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showInvalidUnitFlag(String unit)
    {
        System.out.println("input flag is Invalid for " + unit);
    }



    public void showNormalUnits(ArrayList<? extends Unit> units, boolean healthFlag, boolean movePointFlag)
    {
        if (units.size() == 0){
            System.out.println("nothing");
        }

        for (int i = 0; i < units.size(); i++){
            System.out.print(units.get(i).getGameName() +
                            ": coordinates: (x = " + units.get(i).getCoordinates().getX() + ", y = " + units.get(i).getCoordinates().getY() + ")");

            if (healthFlag){
                System.out.print(", health = " + units.get(i).getHealth());
            }

            if (movePointFlag){
                System.out.print(", move point = " + units.get(i).getRemainingMovements());
            }

            System.out.println();
        }
    }



    public void showMilitaryUnits(ArrayList<? extends MilitaryUnit> units, boolean healthFlag, boolean movePointFlag, boolean attackDamageFlag, boolean defenceFlag)
    {
        if (units.size() == 0){
            System.out.println("nothing");
        }

        for (int i = 0; i < units.size(); i++){
            System.out.print(units.get(i).getGameName() +
                    ": coordinates: (x = " + units.get(i).getCoordinates().getX() + ", y = " + units.get(i).getCoordinates().getY() + ")");

            if (healthFlag){
                System.out.print(", health = " + units.get(i).getHealth());
            }

            if (movePointFlag){
                System.out.print(", move point = " + units.get(i).getRemainingMovements());
            }

            if (attackDamageFlag){
                System.out.print(", attack damage = " + units.get(i).getOverallDamage());
            }

            if (defenceFlag){
                System.out.print(", defence = " + units.get(i).getOverallDefence());
            }

            System.out.println();
        }
    }



    public void showCities(ArrayList<PlayerCity> cities, boolean healthFlag, boolean populationFlag, boolean goldFlag,
                           boolean happinessFlag, boolean taskFlag, boolean landsFlag)
    {
        if (cities.size() == 0){
            System.out.println("nothing");
        }

        for (int i = 0; i < cities.size(); i++){
            System.out.print(cities.get(i).getCityName() + ": " +
                    "coordinates: (" + cities.get(i).getCoordinates().getX() + ", " + cities.get(i).getCoordinates().getY() + ")");

            if (healthFlag){
                System.out.print(", health: " + cities.get(i).getHealth());
            }

            if (populationFlag){
                System.out.print(", population: " + cities.get(i).getPopulation());
            }

            if (goldFlag){
                System.out.print(", gold income: " + cities.get(i).getGoldPerTurn());
            }

            if (happinessFlag){
                System.out.print(", happiness: " + cities.get(i).getHappiness());
            }

            if (taskFlag){
                if (cities.get(i).isWorkingOnTask()){
                    System.out.print(", current task: " + cities.get(i).getTask().getGameName());

                    if (cities.get(i).getProduction() != 0){
                        System.out.println(" turns remaining: " + cities.get(i).getTask().getProductionNeeded() / cities.get(i).getProduction());
                    }
                    else {
                        System.out.println("  city can not finish this task with current production");
                    }
                }
                else {
                    System.out.print(", current task: " + "nothing");
                }
            }

            if (landsFlag){
                System.out.print(", lands coordinates:");

                for (int k = 0; k < cities.get(i).getLandsOwned().size(); i++){
                    System.out.print(" (" + cities.get(i).getLandsOwned().get(k).getTerrain().getCenterCoordinates().getX() +
                            ", " + cities.get(i).getLandsOwned().get(k).getTerrain().getCenterCoordinates().getY() + ")");
                }
            }

            System.out.println();
        }
    }



    public void showCoordinatesOutOfBoundary(int value, String axis, int mapSize)
    {
        System.out.println(axis + "axis value is out of boundaries: " + value);
        System.out.println("value must be between 0 and " +( mapSize - 1));
    }



    public void showThereIsNoUnit()
    {
        System.out.println("there is no unit in the given coordinates");
    }


    public void showThereIsNoCity()
    {
        System.out.println("there is no city in the given coordinates");
    }
}
