package Program.Model.Models;

import Program.Model.Enums.GeneralBiomes;
import Program.Model.Enums.MapSizes;
import Program.Model.Enums.MeleeUnits;
import Program.View.GameLoaderView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class GameLoader {
    private ArrayList<Player> players;
    GeneralBiomes biome;
    MapSizes size;
    Map map;





    ////methods////
    public GameLoader(ArrayList<User> users, GeneralBiomes biome, MapSizes size)
    {
        players = new ArrayList<>();
        this.biome = biome;
        this.size = size;

        for (int i = 0; i < users.size(); i++){
            players.add(new Player(users.get(i).getNickname(), i + 1));
        }

        initializeGame();
    }



    private void initializeGame()
    {
        map = new Map(size);
        MapMaker mapMaker = new MapMaker(map, biome, size);
        dropPlayers(map);
    }



    private void dropPlayers(Map map)
    {
        int k = 0;
        int maxChance = map.getMapSize() * map.getMapSize();
        Random rand = new Random();

        while (k < players.size()){
            players.get(k).setMap(new MiniMap(map, players.get(k)));
            boolean flag = false;

            for (int j = 0; j < map.getMapSize(); j++){
                for (int i = 0; i < map.getMapSize(); i++){
                    Coordinates coordinates = new Coordinates(i, j, 0);

                    if (map.getTerrainFromCoordinates(coordinates).isCanBeCrossed() && rand.nextInt(maxChance) < 1){
                        Settler settler = new Settler(coordinates, players.get(k).getColor(), players.get(k));
                        players.get(k).getMap().getUnits().addSettler(settler);
                        players.get(k).getPlayerUnits().addSettler(settler);
                        map.getUnits().addSettler(settler);
                        MeleeMilitaryUnit warrior = new MeleeMilitaryUnit(MeleeUnits.WARRIOR.unit, coordinates, players.get(k).getColor(), players.get(k));
                        players.get(k).getMap().getUnits().addMeleeMilitaryUnit(warrior);
                        map.getUnits().addMeleeMilitaryUnit(warrior);
                        players.get(k).getPlayerUnits().addMeleeMilitaryUnit(warrior);
                        players.get(k).getMap().updateMap();
                        k++; flag = true;
                        break;
                    }
                }

                if (flag){
                    break;
                }
            }
        }
    }



    public void startGame(Stage stage)
    {
        ZaWarudo zaWarudo = new ZaWarudo(map, players, stage);
    }
}
