package View;

import Model.Coordinates;
import Model.MiniMap;
import Model.MiniMapTile;

public class MiniMapView {





    ////methods////
    public void showMiniMap(MiniMap miniMap)
    {
        showXCoordinates(miniMap.getMapSize());
        //showRows(miniMap.getMapSize());
    }



    private void showXCoordinates(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            //hex side is almost equal to 18. and it has a center -> 18 + 1.
            System.out.print("                  " + i + "         ");
        }

        System.out.println();

        showLine1(mapSize);
        showLine2(mapSize);
        showLine3(mapSize);
        showLine4(mapSize);
        showLine5(mapSize);
        showLine6(mapSize);
        showMidLine(mapSize);
        showLine7(mapSize);
        showLine8(mapSize);
        showLine9(mapSize);
        showLine10(mapSize);
        showLine11(mapSize);
    }



    private void showRows(int mapSize)
    {
        for (int j = 0; j < mapSize; j++){
            showLine1(mapSize);
            //TODO:
        }
    }



    private void showLine1(int mapSize)
    {
        System.out.print(" ");

        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("      .---------------------.");
            }
            else {
                System.out.print("                           ");
            }
        }

        System.out.println("");
    }



    private void showTileFirstHalf()
    {
        for (int i = 0; i < 5; i++){
            
        }
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



    private void showMidLine(int mapSize)
    {
        System.out.print(" .");

        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("                           ");
            }
            else {
                System.out.print("      .---------------------.");

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



    private int printTileDate(String dataType, String data, int characterLimit)
    {
        characterLimit -= dataType.length() + 2;
        System.out.print(dataType + ": ");

        if (characterLimit < data.length()) {
            System.out.print(data.substring(0, characterLimit - 1));
            return 0;
        }

        System.out.print(data);
        return characterLimit - data.length();
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
