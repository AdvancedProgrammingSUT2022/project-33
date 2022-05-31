package Program.Controller;

import Program.Model.MatchingStrings;
import Program.Model.Player;
import Program.Model.UserInput;
import Program.View.DiplomacyView;

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
