package Controller;

import Model.*;
import View.GameLoaderView;

import java.util.ArrayList;

public class GameLoaderController {
    GameLoader loader;
    GameLoaderView view;





    ////methods////
    public GameLoaderController(ArrayList<User> users)
    {
        view = new GameLoaderView();
        GeneralBiomes biome = getBiomeFromUser();
        MapSizes size = getMapSizeFromUser();
        loader = new GameLoader(users, biome, size);
    }



    private GeneralBiomes getBiomeFromUser()
    {
        view.showChooseBiome();

        while (true)
        {
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            for(int i = 0; i < GeneralBiomes.values().length; i++){
                if (GeneralBiomes.values()[i].toString().toLowerCase().equals(input.toLowerCase())){
                    return GeneralBiomes.values()[i];
                }
            }

            view.showInvalidInput();
            view.showChooseBiome();
        }
    }



    private MapSizes getMapSizeFromUser()
    {
        view.showChooseMapSize();

        while (true)
        {
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            for(int i = 0; i < MapSizes.values().length; i++){
                if (MapSizes.values()[i].toString().toLowerCase().equals(input.toLowerCase())){
                    return MapSizes.values()[i];
                }
            }

            view.showInvalidInput();
            view.showChooseMapSize();
        }
    }
}
