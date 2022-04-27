package Model;

import java.util.ArrayList;

public class MiniMap extends Map{
    ArrayList<Fog> fogs;
    ArrayList<HiddenTile> hiddenTiles;





    ////methods////
    public MiniMap(Map map)
    {
        super(map);
    }



    public void updateMap()
    {
        //TODO:
    }



    public void updateHiddenTiles()
    {
        //TODO:
    }



    public void updateFog()
    {
        //TODO:
    }



    public ArrayList<Coordinates> findVisibleCoordinates(Coordinates coordinates, int range, ArrayList<Coordinates> visibleCoordinatesUntilNow)
    {
        ArrayList<Coordinates> visibleCoordinates = new ArrayList<>();
        ArrayList<Coordinates> blockCoordinates = new ArrayList<>();
        ArrayList<Coordinates> resultCoordinates = new ArrayList<>();

        for (int j = -1; j <= 1; j++){
            for (int i = Math.abs(j) - 1; i < 1 - Math.abs(j); i++){
                Coordinates checkingCoordinates = new Coordinates(coordinates.getX() + i, coordinates.getY() + j, 0);

                if (!visibleCoordinatesUntilNow.contains(checkingCoordinates)) {
                    if (getTerrainFromCoordinates(checkingCoordinates).getType().equals("HILLS") ||
                            getTerrainFromCoordinates(checkingCoordinates).getType().equals("MOUNTAIN")) {
                        blockCoordinates.add(checkingCoordinates);
                    } else {
                        visibleCoordinates.add(checkingCoordinates);
                    }
                }
            }
        }

        resultCoordinates.addAll(visibleCoordinates);
        resultCoordinates.addAll(blockCoordinates);

        if (range - 1 == 0){
            return resultCoordinates;
        }
        else {
            ArrayList<Coordinates> unavailableCoordinates = new ArrayList<>();

            for (int i = 0; i < visibleCoordinates.size(); i++){
                resultCoordinates.addAll(findVisibleCoordinates(visibleCoordinates.get(i), range - 1));
            }

            for (int i = 0; i < blockCoordinates.size(); i++){
                unavailableCoordinates.addAll(findVisibleCoordinates(blockCoordinates.get(i), range - 1))''
            }

            for (int i = 0; i < unavailableCoordinates.size(); i++){
                if (resultCoordinates.contains())
            }

            return resultCoordinates;
        }
    }
}
