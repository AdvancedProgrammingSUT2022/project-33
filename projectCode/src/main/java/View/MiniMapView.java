package View;

import Model.Coordinates;
import Model.MiniMap;
import Model.MiniMapTile;

public class MiniMapView {





    ////methods////
    public void showMiniMap(MiniMap miniMap)
    {
        showXCoordinates(miniMap.getMapSize());
        showRows(miniMap.getMapSize(), miniMap);
    }



    private void showXCoordinates(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            //hex side is almost equal to 18. and it has a center -> 18 + 1.
            System.out.print("                 " + i + "         ");
        }

        System.out.println();
    }



    private void showRows(int mapSize, MiniMap miniMap)
    {
        for (int j = 0; j <= mapSize; j++){
            showLine1(mapSize, j);
            showTileLines(mapSize, miniMap, j);
        }
            //TODO:
    }



    private void showLine1(int mapSize, int y)
    {
        System.out.print("      ");
        printLinearSpaces(3);

        for (int i = 0; i < mapSize; i++){
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

        System.out.println("");
    }



    private void showMidLine(int mapSize, int y)
    {
        System.out.print(y);
        printLinearSpaces(3 - Integer.toString(y).length());

        System.out.print(".");

        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0) {
                if (y < mapSize) {
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

        System.out.println("");
    }



    private void showTileLines(int mapSize, MiniMap map, int y)
    {
        for (int j = 0; j < 5; j++){
            printLinearSpaces(3);

            for (int i = 0; i < mapSize; i++){
                if (i % 2 == 0){
                    printLinearSpaces(5 - j);
                    System.out.print("/");

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
                    printLinearSpaces(j + 1);
                    System.out.print("\\");
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

            System.out.println("");
        }

        showMidLine(mapSize, y);

        for (int j = 0; j < 5; j++){
            printLinearSpaces(3);

            for (int i = 0; i < mapSize; i++){
                if (i % 2 == 0){
                    printLinearSpaces(j + 1);
                    System.out.print("\\");

                    String data = "";
                    String dataType = "";

                    if (y < mapSize) {
                        dataType = findTileLineDataFromLineNumber(j + 5, map, i, y)[0];
                        data = findTileLineDataFromLineNumber(j + 5, map, i, y)[1];
                    }

                    printLinearSpaces(5 - j);
                    int spaceNeeded = printTileDate(dataType, data, 21);
                    printLinearSpaces(spaceNeeded);
                }
                else {
                    printLinearSpaces(5 - j);
                    System.out.print("/");
                    printLinearSpaces(j + 1);

                    String dataType = "";
                    String data = "";

                    if (y > 0 && y < mapSize) {
                        dataType = findTileLineDataFromLineNumber(j , map, i, y - 1)[0];
                        data = findTileLineDataFromLineNumber(j, map, i, y - 1)[1];
                    }

                    int spaceNeeded = printTileDate(dataType, data, 21);
                    printLinearSpaces(spaceNeeded);
                }
            }

            System.out.println("");
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



    private void showLine2(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("      /                     ");
            }
            else {
                System.out.print("  \\                         ");

            }
        }

        System.out.println("");
    }



    private void showLine3(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("     /                      ");
            }
            else {
                System.out.print("   \\                        ");

            }
        }

        System.out.println("");
    }



    private void showLine4(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("    /                       ");
            }
            else {
                System.out.print("    \\                       ");

            }
        }

        System.out.println("");
    }



    private void showLine5(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("   /                        ");
            }
            else {
                System.out.print("     \\                      ");

            }
        }

        System.out.println("");
    }



    private void showLine6(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("  /                         ");
            }
            else {
                System.out.print("      \\                     ");

            }
        }

        System.out.println("");
    }



    private void showLine7(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("  \\                         ");
            }
            else {
                System.out.print("      /                     ");

            }
        }

        System.out.println("");
    }



    private void showLine8(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("   \\                        ");
            }
            else {
                System.out.print("     /                      ");

            }
        }

        System.out.println("");
    }



    private void showLine9(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("    \\                       ");
            }
            else {
                System.out.print("    /                       ");

            }
        }

        System.out.println("");
    }



    private void showLine10(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("     \\                      ");
            }
            else {
                System.out.print("   /                        ");

            }
        }

        System.out.println("");
    }



    private void showLine11(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("      \\                     ");
            }
            else {
                System.out.print("  /                         ");

            }
        }

        System.out.println("");
    }




    public void showTiles(MiniMap map)
    {
        for (int j = 0; j < map.getMapSize(); j++) {
            for (int i = 0; i < map.getMapSize(); i++){
                Coordinates coordinates = new Coordinates(i, j, 0);

                if (map.getVisibleCoordinates().contains(coordinates)){
                    showVisibleTiles(map.getVisibleTileFromCoordinates(coordinates));
                }
                else if (map.getHiddenCoordinates().contains(coordinates)){
                    showHiddenTiles(map.getHiddenTileFromCoordinates(coordinates));
                }
                else {
                    //TODO:
                }
            }
        }
    }



    public void showVisibleTiles(MiniMapTile tile)
    {
        //TODO:
    }



    public void showHiddenTiles(MiniMapTile tile)
    {
        //TODO:
    }



    public void showFog()
    {
        //TODO:
    }
}
