package Controller;

import Model.MatchingStrings;
import Model.MeleeMilitaryUnit;
import Model.UserInput;

public class MeleeController {
    MeleeMilitaryUnit unit;
    MeleeView view;





    ////methods////
    public MeleeController(MeleeMilitaryUnit unit)
    {
        this.unit = unit;
        this.view = new MeleeView(unit.getGameName());

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.SHOW_STATS)){
                view.showStats(unit);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.FINISH)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }




}
