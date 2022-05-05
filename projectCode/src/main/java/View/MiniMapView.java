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
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("      .---------------------.");
            }
            else {
                System.out.print("                          ");
            }
        }

        System.out.println("");
    }



    private void showLine2(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("     /                     ");
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
                System.out.print("    /                      ");
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
                System.out.print("   /                       ");
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
                System.out.print("  /                        ");
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
                System.out.print(" /                         ");
            }
            else {
                System.out.print("      \\                     ");

            }
        }

        System.out.println("");
    }



    private void showMidLine(int mapSize)
    {
        System.out.print(".");

        for (int i = 0; i < mapSize; i++){
            if (i % 2 == 0){
                System.out.print("                          ");
            }
            else {
                System.out.print("      .---------------------.");

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
