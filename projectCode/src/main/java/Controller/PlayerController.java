package Controller;

import Model.MatchingStrings;
import Model.Player;
import Model.User;
import Model.UserInput;
import View.PlayerView;

public class PlayerController {
    private Player player;
    private PlayerView view;





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
            else if (UserInput.doesMatch(input, MatchingStrings.PlayerControllerStrings.SHOW_HAPPINESS)){
                view.showHappiness(player);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.PlayerControllerStrings.ADD_HAPPINESS_CHEAT)){
                addCheatHappiness();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.PlayerControllerStrings.END_TURN)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void enterSection(String input)
    {
        String section = input.split(" ")[2];

        if (UserInput.doesMatch(section, MatchingStrings.PlayerControllerStrings.MINIMAP)){
            view.showEnteringSection("minimap");
            MiniMapController miniMapController = new MiniMapController(player);
        }
        else if (UserInput.doesMatch(section, MatchingStrings.PlayerControllerStrings.TECHNOLOGY_TREE)){
            TechnologyTreeController technologyTreeController = new TechnologyTreeController(player);
        }
        else if (UserInput.doesMatch(section, MatchingStrings.PlayerControllerStrings.GOLD_SECTION)){
            GoldBoxController goldBoxController = new GoldBoxController(player);
        }
        else if (UserInput.doesMatch(section, MatchingStrings.PlayerControllerStrings.DIPLOMACY_SECTION)){
            DiplomacyController diplomacyController = new DiplomacyController(player);
        }
        else {
            view.showInvalidSection();
        }
    }



    private void addCheatHappiness()
    {
        if (player.getHappinessCheatBonus() >= 20){
            view.showMaximumHappinessBonus();
            return;
        }

        player.setHappinessCheatBonus(player.getHappinessCheatBonus() + 5);
        view.showAddHappinessCheat();
    }
}
