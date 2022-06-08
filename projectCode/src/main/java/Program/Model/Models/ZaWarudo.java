package Program.Model.Models;

import Program.Controller.PlayerController;
import Program.View.PlayerView;
import Program.View.ZaWarudoView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ZaWarudo {
    Map map;
    ArrayList<Player> players;
    Stage stage;





    ////methods////
    public ZaWarudo(Map map, ArrayList<Player> players, Stage stage)
    {
        this.map = map;
        this.players = players;
        this.stage = stage;
        updateGame(0);
    }



    public void updateGame(int i)
    {
        players.get(i).updatePlayer();
        PlayerView playerView = new PlayerView(stage, players.get(i));
    }
}
