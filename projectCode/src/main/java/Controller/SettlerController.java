package Controller;

import Model.MatchingStrings;
import Model.Settler;
import Model.UserInput;
import View.SettlerView;

public class SettlerController {
    private Settler settler;
    private SettlerView view;






    ////methods////
    public SettlerController(Settler settler)
    {
        this.settler = settler;

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.SHOW_STATS)){
                view.showStats(settler);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.MOVE_UNIT1) ||
                    UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.MOVE_UNIT2)){
                moveUnit(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.UnitsControllerStrings.Settler.FINISH)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void moveUnit(String input)
    {
        //TODO:
    }
}
