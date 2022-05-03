package Model;

public class Settler extends Unit{





    public Settler(Coordinates coordinates, Colors color, Player player)
    {
        super("Settler" , 5, 2, 2, 89, 0, 100);
        /* health = 5
        visibilityRange =2
        maxMovements = 2
        price = 89
        maintenancePricePerTurn = 0
        productionNeededForBeingMade = 100 */

        super.setCoordinates(coordinates);
        super.setBelongsToPlayer(true);
        super.setColor(color);
        super.setOwner(player);

        //TODO:
    }



    public Settler(Coordinates coordinates, NonPlayerColors color){

        super("Settler", 5, 2, 2, 89, 0, 100);
        /* health = 5
        visibilityRange =2
        maxMovements = 2
        price = 89
        maintenancePricePerTurn = 0
        productionNeededForBeingMade = 100 */

        super.setCoordinates(coordinates);
        super.setBelongsToPlayer(false);
        super.setNonPlayerColor(color);


        //TODO:
    }



    public void createCity()
    {
        if (getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getIsTerritory()){
            //TODO: error message
            return;
        }

        //TODO: get city name

         String cityName = "ye chizi"; //TODO:  set city name

        PlayerCity newCity = new PlayerCity(getOwner().getCities().size() == 0,
                getOwner().getMap().getTerrainFromCoordinates(getCoordinates()), getOwner(), cityName);
        getOwner().addCity(newCity);
        getOwner().getMap().addPlayerCity(newCity);
        getOwner().getMap().getOriginalMap().addPlayerCity(newCity);

        getOwner().getPlayerUnits().getSettlers().remove(this);
        getOwner().getMap().getUnits().getSettlers().remove(this);
        getOwner().getMap().getOriginalMap().getUnits().getSettlers().remove(this);
    }
}
