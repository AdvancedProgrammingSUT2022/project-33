package Program.Controller;

import Program.Model.Models.LoginMenu;
import Program.Model.Models.MatchingStrings;
import Program.Model.Models.User;
import Program.View.LoginMenuView;
import Program.View.MainMenuView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.regex.Pattern;

public class LoginMenuController {
    private LoginMenu menu;
    private LoginMenuView view;
    public TextField newNicknameTextField;
    public TextField newUsernameTextField;
    public TextField newPasswordTextField;
    public TextField usernameTextField;
    public TextField passwordTextField;





    ////methods////
    public void initialize(LoginMenuView view)
    {
        this.view = view;
        menu = new LoginMenu();
    }



    public void registerUserClick(KeyEvent keyEvent)
    {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            registerUser();
        }
    }



    public void registerUser()
    {
        String nickname = newNicknameTextField.getText();
        String username = newUsernameTextField.getText();
        String password = newPasswordTextField.getText();
        boolean isValid = true;

        if (isNicknameFormatInvalid(nickname)){
            isValid = false;
            newNicknameTextField.setPromptText("nickname format is invalid");
            newNicknameTextField.setStyle("-fx-prompt-text-fill: red");
            newNicknameTextField.setText("");
        }

        if (isUsernameFormatInValid(username)){
            isValid = false;
            newUsernameTextField.setPromptText("username format is invalid");
            newUsernameTextField.setStyle("-fx-prompt-text-fill: red");
            newUsernameTextField.setText("");
        }

        if (isPasswordFormatInvalid(password)){
            isValid = false;
            newPasswordTextField.setPromptText("password format is invalid");
            newPasswordTextField.setStyle("-fx-prompt-text-fill: red");
            newPasswordTextField.setText("");
        }

        if (menu.getUserFromUsername(username) != null){
            isValid = false;
            newUsernameTextField.setPromptText("this username already exist");
            newUsernameTextField.setStyle("-fx-prompt-text-fill: red");
            newUsernameTextField.setText("");
        }

        if (isValid){
            User user = new User(nickname, username, password);
            menu.addUser(user);
            LoginMenu.saveUsers();
            MainMenuView mainMenuView = new MainMenuView(view.getStage(), user);
        }
    }




    public void loginUserClick(KeyEvent keyEvent)
    {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            loginUser();
        }
    }



    public void loginUser()
    {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (menu.getUserFromUsername(username) == null || !menu.getUserFromUsername(username).getPassword().equals(password)){
            usernameTextField.setPromptText("invalid username or password");
            passwordTextField.setPromptText("invalid username or password");
            usernameTextField.setStyle("-fx-prompt-text-fill: red");
            passwordTextField.setStyle("-fx-prompt-text-fill: red");
            usernameTextField.setText("");
            passwordTextField.setText("");
            return;
        }

        MainMenuView mainMenuView = new MainMenuView(view.getStage(), menu.getUserFromUsername(username));
    }



    private boolean isNicknameFormatInvalid(String nickname)
    {
        return !(MatchingStrings.LoginControllerStrings.NICKNAME.matcher(nickname).matches() && nickname.length() < 15);
    }



    private boolean isUsernameFormatInValid(String username)
    {
        return !(MatchingStrings.LoginControllerStrings.USERNAME.matcher(username).matches() && username.length() > 3 && username.length() < 15);
    }



    private boolean isPasswordFormatInvalid(String password)
    {
        return !(MatchingStrings.LoginControllerStrings.PASSWORD.matcher(password).matches() && Pattern.compile("\\d").matcher(password).find()
        && password.length() > 5 && password.length() < 15);
    }
}
