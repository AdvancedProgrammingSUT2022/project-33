package Controller;

import Model.Player;
import View.PlayerView;

public class PlayerController {
    Player player;
    PlayerView view;





    ////methods////
    public PlayerController(Player player)
    {
        this.player = player;
        view = new PlayerView();

        //TODO:

        MiniMapController miniMapController = new MiniMapController(player.getMap());
    }
}
