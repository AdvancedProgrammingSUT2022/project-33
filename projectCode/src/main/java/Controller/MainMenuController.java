package Controller;

import Model.MainMenu;
import Model.MatchingStrings;
import Model.User;
import Model.UserInput;
import View.MainMenuView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuController {
    private MainMenu menu;
    private MainMenuView view;





    ////methods////
    public MainMenuController(User user, ArrayList<User> users)
    {
        menu = new MainMenu(user, users);
        view = new MainMenuView();

        run();
    }



    private void run()
    {
        view.showWelcomeMessage();

        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (doesMatch(input, MatchingStrings.MainControllerStrings.SHOW_MENU)){
                view.showCurrentMenu();
            }
            else if (doesMatch(input, MatchingStrings.MainControllerStrings.ENTER_MENU)){
                if (doesMatch(input, MatchingStrings.MainControllerStrings.ENTER_PROFILE_MENU)){
                    ProfileMenuController profileMenuController = new ProfileMenuController(menu.getUser(), menu.getUsers());
                }
                else {
                    view.showImpossibleMenuNavigation();
                }
            }
            else if (doesMatch(input, MatchingStrings.MainControllerStrings.PLAY_2_PLAYER_GAME) || doesMatch(input, MatchingStrings.MainControllerStrings.PLAY_3_PLAYER_GAME)
            || doesMatch(input, MatchingStrings.MainControllerStrings.PLAY_4_PLAYER_GAME) || doesMatch(input, MatchingStrings.MainControllerStrings.PLAY_5_PLAYER_GAME)
            || doesMatch(input, MatchingStrings.MainControllerStrings.PLAY_6_PLAYER_GAME) || doesMatch(input, MatchingStrings.MainControllerStrings.PLAY_7_PLAYER_GAME)
            || doesMatch(input, MatchingStrings.MainControllerStrings.PLAY_8_PLAYER_GAME)){
                getUsernamesAndStartGame(input);
            }
            else if (doesMatch(input, MatchingStrings.MainControllerStrings.EXIT) || doesMatch(input, MatchingStrings.MainControllerStrings.LOGOUT)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private boolean doesMatch(String input, Pattern pattern)
    {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }



    private void getUsernamesAndStartGame(String input)
    {
        ArrayList<String> usernames = new ArrayList<>();
        Matcher matcher = MatchingStrings.MainControllerStrings.PLAYER.matcher(input);

        while (matcher.find()){
            usernames.add(matcher.group().split(" ")[1]);
        }

        menu.startGame(usernames);
    }
}
