package Model;

import View.GameLoaderView;

import java.util.ArrayList;
import java.util.Timer;

public class GameLoader {
    private ArrayList<Player> players;
    GeneralBiomes biome;
    MapSizes size;





    ////methods////
    public GameLoader(ArrayList<User> users, GeneralBiomes biome, MapSizes size)
    {
        players = new ArrayList<>();
        this.biome = biome;
        this.size = size;

        for (int i = 0; i < users.size(); i++){
            players.add(new Player(users.get(i).getNickname(), i + 1));
        }

        startGame();
    }



    private void startGame()
    {
        GameLoaderView.showLoadingScreen("00");
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < 2000){

        }

        GameLoaderView.printSpaces();
        GameLoaderView.showLoadingScreen("45");

        Map map = new Map();
        MapMaker mapMaker = new MapMaker(map, biome, size);


    }
}
