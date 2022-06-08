package Program.View;

import Program.Model.Models.Player;

public class GoldBoxView {





    ////methods////
    public GoldBoxView()
    {
        System.out.println("you are now in gold box section");
    }



    public void showGold(Player player)
    {
        System.out.println("Gold: " + player.getGold());
        System.out.println("gold per turn: " + player.getGoldIncome());
    }



    public void showGoldIncome(Player player)
    {
        System.out.println("cities gold income: ");

        for (int i = 0; i < player.getCities().size(); i++){
            System.out.println((i + 1) + ") " + player.getCities().get(i).getCityName() + ": " + player.getCities().get(i).getGoldPerTurn());
        }

        System.out.println("overall city gold income: " + player.getCitiesGoldIncome());
        System.out.println("units maintenance: " + player.getPlayerUnits().getGoldNeeded());

        System.out.println("overall gold income: " + player.getGoldIncome());
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showNoSpace()
    {
        System.out.println("there is no space for more gold in storage");
    }



    public void showGoldAdded(int amount)
    {
        System.out.println("your gold has increased by " + amount);
    }
}
