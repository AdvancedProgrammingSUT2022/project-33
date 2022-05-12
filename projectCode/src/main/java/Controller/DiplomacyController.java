package Controller;

import Model.MatchingStrings;
import Model.Player;
import Model.UserInput;
import View.DiplomacyView;

public class DiplomacyController {
    Player player;
    DiplomacyView view;





    ////methods////
    public DiplomacyController(Player player)
    {
        this.player = player;
        view = new DiplomacyView();

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.DiplomacyStrings.BACK)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }
}
