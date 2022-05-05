package Controller;

import Model.MiniMap;
import Model.Player;
import Model.UserInput;
import View.MiniMapView;

public class MiniMapController {
    Player player;
    MiniMapView view;





    ////methods////
    public MiniMapController(Player player)
    {
        this.player = player;
        this.view = new MiniMapView();
        view.showMiniMap(player.getMap());

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            //TODO:
        }
    }
}
