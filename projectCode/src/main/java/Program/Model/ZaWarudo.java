package Program.Model;

import Program.Controller.PlayerController;
import Program.View.ZaWarudoView;

import java.util.ArrayList;

public class ZaWarudo {
    Map map;
    ArrayList<Player> players;





    ////methods////
    public ZaWarudo(Map map, ArrayList<Player> players)
    {
        this.map = map;
        this.players = players;
        updateGame();
    }



    public void updateGame()
    {
        ZaWarudoView view = new ZaWarudoView();

        while (true) {
            for (int i = 0; i < players.size(); i++) {
                players.get(i).updatePlayer();
                PlayerController controller = new PlayerController(players.get(i));

                if (players.get(i).isHasWon()){
                    view.showPlayerWon(players.get(i).getNickname());
                    return;
                }
                else if (players.get(i).isHasLost()){
                    view.showPlayerLost(players.get(i).getNickname());
                    players.remove(i);
                    i--;
                }


                //TODO: managing turns and game
            }
        }
    }
}
