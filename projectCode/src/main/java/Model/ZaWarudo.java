package Model;

import Controller.PlayerController;

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
        //TODO:
        while (true) {
            for (int i = 0; i < players.size(); i++) {
                players.get(i).updatePlayer();
                PlayerController controller = new PlayerController(players.get(i));


                //TODO: managing turns and game
            }
        }
    }
}
