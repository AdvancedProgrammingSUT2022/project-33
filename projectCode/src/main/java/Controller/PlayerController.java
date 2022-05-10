package Controller;

import Model.MatchingStrings;
import Model.Player;
import Model.User;
import Model.UserInput;
import View.PlayerView;

public class PlayerController {
    Player player;
    PlayerView view;





    ////methods////
    public PlayerController(Player player)
    {
        this.player = player;
        view = new PlayerView();
        run();

        //TODO:
    }



    private void run()
    {
        view.showYourTurn(player.getNickname());

        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.PlayerControllerStrings.ENTER_SECTION)){
                enterSection(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.PlayerControllerStrings.SHOW_MENU)){
                view.showCurrentMenu();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.PlayerControllerStrings.END_TURN)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
            //TODO:
        }
    }



    private void enterSection(String input)
    {
        String section = input.split(" ")[2];

        if (UserInput.doesMatch(section, MatchingStrings.PlayerControllerStrings.MINIMAP)){
            view.showEnteringSection("minimap");
            MiniMapController miniMapController = new MiniMapController(player);
            //TODO:
        }
    }
}
