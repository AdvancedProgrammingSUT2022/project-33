package Model;

import View.GameLoaderView;

import java.util.ArrayList;
import java.util.Random;
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

        Map map = new Map(size);
        MapMaker mapMaker = new MapMaker(map, biome, size);

        startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < 2000){

        }

        GameLoaderView.printSpaces();
        GameLoaderView.showLoadingScreen("80");
    }



    private void dropPlayers(Map map)
    {
        int k = 0;
        int maxChance = map.getMapSize();
        Random rand = new Random();

        while (k < players.size()){
            players.get(k).setMap(new MiniMap(map));

            for (int j = 0; j < map.getMapSize(); j++){
                for (int i = 0; i < map.getMapSize(); i++){
                    Coordinates coordinates = new Coordinates(i, j, 0);

                    if (map.getTerrainFromCoordinates(coordinates).isCanBeCrossed() && rand.nextInt(maxChance) < 1){

                    }
                }
            }
        }
    }
}
