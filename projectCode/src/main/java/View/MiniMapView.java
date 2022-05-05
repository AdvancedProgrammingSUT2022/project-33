package View;

import Model.Coordinates;
import Model.MiniMap;
import Model.MiniMapTile;

public class MiniMapView {





    ////methods////
    public void showMiniMap(MiniMap miniMap)
    {
        showXCoordinates(miniMap.getMapSize());
    }



    private void showXCoordinates(int mapSize)
    {
        for (int i = 0; i < mapSize; i++){
            System.out.print("        " + i + "        ");
        }
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
