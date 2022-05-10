package Model;

import View.MeleeView;
import View.MilitaryView;

import java.util.ArrayList;

public class MeleeMilitaryUnit extends MilitaryUnit{





    ////methods////
    public MeleeMilitaryUnit(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                             int attackDamage, boolean isCavalry, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        super(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn, attackDamage,
                isCavalry, technologyRequired, resourceRequired, era);
    }



    public MeleeMilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates, Colors color, Player player)
    {
        super(unit, coordinates);
        super.setColor(color);
        super.setBelongsToPlayer(true);
        super.setOwner(player);
    }



    public MeleeMilitaryUnit(MeleeMilitaryUnit unit, Coordinates coordinates, NonPlayerColors color)
    {
        super(unit, coordinates);
        super.setNonPlayerColor(color);
        super.setBelongsToPlayer(false);
    }



    public void updateUnit(ArrayList<Terrain> terrains)
    {
        setRemainingMovements(getMaxMovements());

        if (isMoving()) {
            moveUnit(terrains, getOwner().getMap(), new MilitaryView());
        }

        //TODO:
    }



    public void removeUnit()
    {
        getOwner().addGold(getPrice() * getHealth() / 10);

        getOwner().getPlayerUnits().getMeleeMilitaryUnits().remove(this);
        getOwner().getMap().getUnits().getMeleeMilitaryUnits().remove(this);
        getOwner().getMap().getOriginalMap().getUnits().getMeleeMilitaryUnits().remove(this);
    }
}
