package Controller;

import Model.MatchingStrings;
import Model.ProfileMenu;
import Model.User;
import Model.UserInput;
import View.ProfileMenuView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenuController {
    private ProfileMenu menu;
    private ProfileMenuView view;





    ////methods////
    public ProfileMenuController(User user, ArrayList<User> users)
    {
        this.menu = new ProfileMenu(user, users);
        this.view = new ProfileMenuView();

        run();
    }



    private void run()
    {
        view.showEnteredProfileMenu();

        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.SHOW_MENU)){
                view.showCurrentMenu();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.ENTER_MENU)){
                view.showImpossibleNavigation();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.CHANGE_NICKNAME)){
                changeNickname(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.CHANGE_PASSWORD1) || UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.CHANGE_PASSWORD2)
            || UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.CHANGE_PASSWORD3) || UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.CHANGE_PASSWORD4)
            || UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.CHANGE_PASSWORD5) || UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.CHANGE_PASSWORD6)){
                changePassword(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.ProfileControllerStrings.EXIT)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }



    private void changeNickname(String input)
    {
        String nickname = input.split(" ")[3];

        if (menu.doesNicknameExist(nickname)){
            view.showNicknameExist(nickname);
        }
        else {
            view.showNicknameChanged();
            menu.changeNickname(nickname);
        }
    }



    private void changePassword(String input)
    {
        Matcher currentPasswordMatcher =MatchingStrings.ProfileControllerStrings.CURRENT_PASSWORD.matcher(input);
        Matcher newPasswordMatcher = MatchingStrings.ProfileControllerStrings.NEW_PASSWORD.matcher(input);

        String password = currentPasswordMatcher.group().split(" ")[1];
        String newPassword = newPasswordMatcher.group().split(" ")[1];

        if (!password.equals(menu.getUser().getPassword())){
            view.showWrongPassword();
        }
        else if (newPassword.length() < 5 || !newPassword.matches(".*\\d.*") || !newPassword.matches(".*\\D.*")){
            view.showInvalidPasswordFormat();
        }
        else if (newPassword.equals(password)){
            view.showSamePassword();
        }
        else {
            view.showPasswordChanged();
            menu.changePassword(newPassword);
        }
    }
}
