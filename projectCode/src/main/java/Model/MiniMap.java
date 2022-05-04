package Model;

import java.util.ArrayList;

public class MiniMap extends Map{
    private ArrayList<MiniMapTile> hiddenTiles;
    private ArrayList<Coordinates> hiddenCoordinates;
    private ArrayList<MiniMapTile> visibleTiles;
    private ArrayList<Coordinates> visibleCoordinates;
    Map originalMap;
    Player owner;





    ////methods////
    public MiniMap(Map map, Player owner)
    {
        super(map);
        originalMap = map;
        this.owner = owner;
    }



    public void updateMap()
    {
        //TODO: updating map from original map
        updateVisibility();
        updateTiles();
        //TODO:
    }



    public void updateVisibility()
    {
        visibleCoordinates = new ArrayList<>();

        updateUnitVisibility(owner.getPlayerUnits().getWorkers());
        updateUnitVisibility(owner.getPlayerUnits().getSettlers());
        updateUnitVisibility(owner.getPlayerUnits().getMeleeMilitaryUnits());
        updateUnitVisibility(owner.getPlayerUnits().getRangedMilitaryUnits());
        updateUnitVisibility(owner.getPlayerUnits().getHeavyRangedUnits());
    }



    public void updateUnitVisibility(ArrayList<? extends Unit> checkingUnits)
    {
        for (int i = 0; i < checkingUnits.size(); i++){
            ArrayList<Coordinates> visibleWorkerCoordinates = new ArrayList<>(findVisibleCoordinates(checkingUnits.get(i).getCoordinates(), checkingUnits.get(i).getVisibilityRange()));

            for (int k = 0; k < visibleWorkerCoordinates.size(); k++){
                if (!visibleCoordinates.contains(visibleWorkerCoordinates.get(k))){
                    visibleCoordinates.add(visibleWorkerCoordinates.get(k));
                }
            }
        }
    }



    private void updateTiles()
    {
        visibleTiles = new ArrayList<>();

        for (int i = 0; i < visibleCoordinates.size(); i++){
            visibleTiles.add(getTileFromCoordinates(visibleCoordinates.get(i)));

            if (hiddenCoordinates.contains(visibleCoordinates.get(i))){
                hiddenTiles.remove(getIndexOfHiddenTileFromCoordinates(visibleCoordinates.get(i)));
                hiddenCoordinates.remove(getIndexOfHiddenCoordinateFromCoordinates(visibleCoordinates.get(i)));
            }

            hiddenCoordinates.add(visibleCoordinates.get(i));
            hiddenTiles.add(visibleTiles.get(i));
        }
    }



    public ArrayList<Coordinates> findVisibleCoordinates(Coordinates coordinates, int range)
    {
        ArrayList<Coordinates> availableCoordinates = new ArrayList<>();
        ArrayList<Coordinates> blockCoordinates = new ArrayList<>();

        for (int j = -range; j <= range; j++){
            for (int i = Math.abs(j) - range; i <= range - Math.abs(j); i++){
                Coordinates checkingCoordinates = new Coordinates(coordinates.getX() + i, coordinates.getY() + j, 0);
                availableCoordinates.add(checkingCoordinates);

                if (getTerrainFromCoordinates(checkingCoordinates).getType().equals("HILLS") || getTerrainFromCoordinates(checkingCoordinates).getType().equals("MOUNTAIN")){
                    blockCoordinates.add(checkingCoordinates);
                }
            }
        }

        ArrayList<Coordinates> visibleCoordinates = new ArrayList<>();

        for (int i = 0; i < availableCoordinates.size(); i++){
            if (isInLineOfSight(availableCoordinates.get(i), blockCoordinates, coordinates)){
                visibleCoordinates.add(availableCoordinates.get(i));
            }
        }

        return visibleCoordinates;
    }



    private boolean isInLineOfSight(Coordinates checkingCoordinates, ArrayList<Coordinates> blockCoordinates, Coordinates centerCoordinates)
    {
        for (int i = 0; i < blockCoordinates.size(); i++){
            if (!checkingCoordinates.equals(blockCoordinates.get(i))){
                NormalCoordinates normalCheckingCoordinates = new NormalCoordinates(checkingCoordinates);
                NormalCoordinates normalBlockCoordinates = new NormalCoordinates(blockCoordinates.get(i));
                NormalCoordinates normalCenterCoordinates = new NormalCoordinates(centerCoordinates);

                for (int r = 0; r < normalCenterCoordinates.calculateDistance(normalCheckingCoordinates); r++){
                    double lineX = normalCenterCoordinates.getX() + r *
                            (normalCheckingCoordinates.getX() - normalCenterCoordinates.getX()) / normalCenterCoordinates.calculateDistance(normalCheckingCoordinates);
                    double lineY = normalCenterCoordinates.getY() +  r *
                            (normalCheckingCoordinates.getY() - normalCenterCoordinates.getY()) / normalCenterCoordinates.calculateDistance(normalCheckingCoordinates);

                    NormalCoordinates lineCoordinates = new NormalCoordinates(lineX, lineY);
                    double lineDistanceFromBlockCoordinates = normalBlockCoordinates.calculateDistance(lineCoordinates);

                    if (lineDistanceFromBlockCoordinates < Math.sqrt(3) / 2 * 0.8 && getTerrainFromCoordinates(blockCoordinates.get(i)).getType().equals("MOUNTAIN")){
                        return false;
                    }
                    else if (lineDistanceFromBlockCoordinates < Math.sqrt(3) / 2 * 0.65 && getTerrainFromCoordinates(blockCoordinates.get(i)).getType().equals("HILLS")){
                        return false;
                    }
                }
            }
        }

        return true;
    }



    private void setTileUnitType(Coordinates coordinates, MiniMapTile tile){
        if (getUnits().getWorkerFromCoordinates(coordinates) != null){
            tile.setHasWorker(true);
            tile.setWorker(getUnits().getWorkerFromCoordinates(coordinates));
        }

        if (getUnits().getSettlerFromCoordinates(coordinates) != null){
            tile.setHasSettler(true);
            tile.setSettler(getUnits().getSettlerFromCoordinates(coordinates));
        }

        if (getUnits().getMeleeMilitaryUnitFromCoordinates(coordinates) != null){
            tile.setHasMeleeMilitaryUnit(true);
            tile.setMeleeMilitaryUnit(getUnits().getMeleeMilitaryUnitFromCoordinates(coordinates));
        }

        if (getUnits().getRangedMilitaryUnitFromCoordinates(coordinates) != null){
            tile.setHasRangedMilitaryUnit(true);
            tile.setRangedMilitaryUnit(getUnits().getRangedMilitaryUnitFromCoordinates(coordinates));
        }

        if (getUnits().getHeavyRangedMilitaryUnitFromCoordinates(coordinates) != null){
            tile.setHasHeavyRangedMilitaryUnit(true);
            tile.setHeavyRangedMilitaryUnits(getUnits().getHeavyRangedMilitaryUnitFromCoordinates(coordinates));
        }
    }



    //getters
    public MiniMapTile getTileFromCoordinates(Coordinates coordinates)
    {
        Terrain terrain = getTerrainFromCoordinates(coordinates);
        MiniMapTile tile = new MiniMapTile(coordinates, terrain);

        if (getDefaultCityFromCoordinates(coordinates) != null){
            tile.setDefaultCity(getDefaultCityFromCoordinates(coordinates));
            tile.setHasDefaultCity(true);
        }

        if (getPlayerCityFromCoordinates(coordinates) != null){
            tile.setPlayerCity(getPlayerCityFromCoordinates(coordinates));
            tile.setHasPlayerCity(true);
        }

        setTileUnitType(coordinates, tile);

        return tile;
    }


    public int getIndexOfHiddenTileFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < hiddenTiles.size(); i++){
            if (hiddenTiles.get(i).getCoordinates().equals(coordinates)){
                return i;
            }
        }

        return -1;
    }


    public int getIndexOfHiddenCoordinateFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < hiddenCoordinates.size(); i++){
            if (hiddenCoordinates.get(i).equals(coordinates)){
                return i;
            }
        }

        return -1;
    }


    public ArrayList<MiniMapTile> getHiddenTiles() {
        return hiddenTiles;
    }


    public ArrayList<Coordinates> getHiddenCoordinates() {
        return hiddenCoordinates;
    }


    public ArrayList<MiniMapTile> getVisibleTiles() {
        return visibleTiles;
    }


    public ArrayList<Coordinates> getVisibleCoordinates() {
        return visibleCoordinates;
    }


    public MiniMapTile getVisibleTileFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < visibleTiles.size(); i++){
            if (visibleTiles.get(i).getCoordinates().equals(coordinates)){
                return visibleTiles.get(i);
            }
        }

        return null;
    }



    public MiniMapTile getHiddenTileFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < hiddenTiles.size(); i++){
            if (hiddenTiles.get(i).getCoordinates().equals(coordinates)){
                return hiddenTiles.get(i);
            }
        }

        return null;
    }


    public Map getOriginalMap() {
        return originalMap;
    }
}
