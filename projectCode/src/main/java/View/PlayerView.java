package View;

import Model.Player;

public class PlayerView {





    ////methods////
    public void showYourTurn(String nickname)
    {
        System.out.println("its now your turn " + nickname);
    }



    public void showEnteringSection(String section)
    {
        System.out.println("entering " + section + " section");
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showCurrentMenu()
    {
        System.out.println("player menu");
    }



    public void showHappiness(Player player)
    {
        System.out.println("cities: ");

        if (player.getCities().size() == 0){
            System.out.println("there is no city");
        }

        for (int i = 0; i < player.getCities().size(); i++){
            System.out.println(player.getCities().get(i).getCityName() + ": " + player.getCities().get(i).getHappiness());
        }

        System.out.println("overall happiness = " + player.getHappiness());
    }
}
