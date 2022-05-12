package Controller;

import Model.MatchingStrings;
import Model.Player;
import Model.User;
import Model.UserInput;
import View.GoldBoxView;

public class GoldBoxController {
    private Player player;
    private GoldBoxView view;





    ////methods////
    public GoldBoxController(Player player)
    {
        this.player = player;
        view = new GoldBoxView();

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.GoldBoxStrings.SHOW_GOLD)){
                view.showGold(player);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.GoldBoxStrings.SHOW_GOLD_INCOME)){
                view.showGoldIncome(player);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.GoldBoxStrings.BACK)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
            //TODO:
        }
    }
}
