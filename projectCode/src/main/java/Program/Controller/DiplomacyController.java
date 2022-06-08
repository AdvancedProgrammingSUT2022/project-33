package Program.Controller;

import Program.Model.Models.MatchingStrings;
import Program.Model.Models.Player;
import Program.Model.Models.UserInput;
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
