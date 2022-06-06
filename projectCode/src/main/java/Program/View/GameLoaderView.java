package Program.View;

import Program.Model.Enums.GeneralBiomes;
import Program.Model.Enums.MapSizes;
import Program.Model.UselessTips;

public class GameLoaderView  {
    static UselessTips tips = new UselessTips();





    ////methods////
    public void showChooseBiome()
    {
        System.out.println("please choose your biome");
        System.out.println("Bioms:");

        for (int i = 0; i < GeneralBiomes.values().length; i++){
            System.out.println(" " + GeneralBiomes.values()[i]);
        }
    }



    public void showChooseMapSize()
    {
        System.out.println("please choose map size");
        System.out.println("sizes:");

        for(int i = 0; i < MapSizes.values().length; i++){
            System.out.println(" " + MapSizes.values()[i] + ": " + MapSizes.values()[i].size + "×" + MapSizes.values()[i].size + ",");
        }
    }



    public void showInvalidInput()
    {
        System.out.println("invalid input");
    }



    public static void showLoadingScreen(String loadingPercentage)
    {
        System.out.println("⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣⬣");
        System.out.println("⬣                                                                ⬣");
        System.out.println("⬣                                                                ⬣");
        System.out.println("⬣                                                                ⬣");
        System.out.println("⬣                                                                ⬣");
        show0PercentMessage(loadingPercentage);
        System.out.println("⬣                                                                ⬣");
        System.out.println("⬣                                                                ⬣");
        System.out.println("⬣                                                                ⬣");
        System.out.println("⬣▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄⬣");
        showRandomTip();
        System.out.println("⬣▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄⬣");

    }



    public static void printSpaces()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }



    private static void show0PercentMessage(String percentage)
    {
        System.out.println("⬣                         [ LOADING: " + percentage + "%]                        ⬣");
    }



    private static void showRandomTip()
    {
        System.out.println("Tip: " + tips.getRandomTip());
    }
}
