package Controller;

import Model.LoginMenu;
import Model.MatchingStrings;
import Model.User;
import Model.UserInput;
import View.LoginMenuView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {
    private LoginMenu menu;
    private LoginMenuView view;





    ////methods////
    public LoginMenuController()
    {
        menu = new LoginMenu();
        view = new LoginMenuView();

        run();
    }



    private void run()
    {
        while (true)
        {
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (doesMatch(input, MatchingStrings.LoginControllerStrings.CREATE_USER_1) || doesMatch(input, MatchingStrings.LoginControllerStrings.CREATE_USER_2)
            || doesMatch(input, MatchingStrings.LoginControllerStrings.CREATE_USER_3) || doesMatch(input, MatchingStrings.LoginControllerStrings.CREATE_USER_4)
            || doesMatch(input, MatchingStrings.LoginControllerStrings.CREATE_USER_5) || doesMatch(input, MatchingStrings.LoginControllerStrings.CREATE_USER_6)){
                createUser(input);
            }
            else if (doesMatch(input, MatchingStrings.LoginControllerStrings.ENTER_MENU)){
                view.showPleaseLogin();
            }
            else if (doesMatch(input, MatchingStrings.LoginControllerStrings.SHOW_MENU)){
                view.showCurrentMenu();
            }
            else if (doesMatch(input, MatchingStrings.LoginControllerStrings.LOGIN_USER_1) || doesMatch(input, MatchingStrings.LoginControllerStrings.LOGIN_USER_2)){
                loginUser(input);
            }
            else if (doesMatch(input, MatchingStrings.LoginControllerStrings.EXIT)){
                view.showGoodbye();
                menu.Exit();
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
        return  matcher.matches();
    }



    private void createUser(String input)
    {
        User user = getUserFromInput(input);

        if (user != null && isPasswordAndUsernameValid(user.getUsername(), user.getPassword())){
            menu.addUser(user);
            view.showUserCreated();
        }
    }



    private User getUserFromInput(String input)
    {
        Matcher usernameMatcher = MatchingStrings.LoginControllerStrings.USERNAME.matcher(input);
        Matcher nicknameMatcher = MatchingStrings.LoginControllerStrings.NICKNAME.matcher(input);
        Matcher passwordMatcher = MatchingStrings.LoginControllerStrings.PASSWORD.matcher(input);

        usernameMatcher.find();
        nicknameMatcher.find();
        passwordMatcher.find();

        String username = usernameMatcher.group().split(" ")[1];
        String nickname = nicknameMatcher.group().split(" ")[1];
        String password = passwordMatcher.group().split(" ")[1];

        User user = menu.getUserFromUsername(username);

        if (menu.getUserFromUsername(username) != null){
            view.showUsernameExist(username);
        }
        else if (menu.getUserFromNickname(nickname) != null){
            view.showNicknameExist(nickname);
        }
        else {
            return new User(nickname, username, password);
        }

        return null;
    }



    private boolean isPasswordAndUsernameValid(String username, String password)
    {
        if (username.length() < 3){
            view.showInvalidUsername();
            return false;
        }
        else if (password.length() < 5 || !password.matches(".*\\d.*") || !password.matches(".*\\D.*")){
            view.showinvalidPassword();
            return false;
        }

        return true;
    }



    private void loginUser(String input)
    {
        String[] usernameAndPassword = getUsernameAndPassword(input);
        User user = menu.getUserFromUsername(usernameAndPassword[0]);

        if (user == null || !user.getPassword().equals(usernameAndPassword[1])){
            view.showWrongPassword();
        }
        else {
            view.showLoginMessage();
            menu.loginUser(user);
        }
    }



    private String[] getUsernameAndPassword(String input)
    {
        Matcher usernameMatcher = MatchingStrings.LoginControllerStrings.USERNAME.matcher(input);
        Matcher passwordMatcher = MatchingStrings.LoginControllerStrings.PASSWORD.matcher(input);

        usernameMatcher.find();
        passwordMatcher.find();

        String username = usernameMatcher.group().split(" ")[1];
        String password = passwordMatcher.group().split(" ")[1];

        return new String[]{username, password};
    }
}
