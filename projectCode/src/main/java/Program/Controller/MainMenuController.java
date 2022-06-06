package Program.Controller;

import Program.Model.MainMenu;
import Program.Model.MatchingStrings;
import Program.Model.User;
import Program.Model.UserInput;
import Program.View.GameStartingMenuView;
import Program.View.LoginMenuView;
import Program.View.MainMenuView;
import Program.View.ProfileMenuView;
import javafx.application.Platform;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class MainMenuController {
    private MainMenu menu;
    private MainMenuView view;





    ////methods////
    public void initialize(MainMenuView mainMenuView, User user)
    {
        menu = new MainMenu(user);
        this.view = mainMenuView;
    }



    public void startNewGame(MouseEvent mouseEvent)
    {
        GameStartingMenuView gameStartingMenuView = new GameStartingMenuView(view.getStage(), menu.getUser());
    }



    public void openProfile(MouseEvent mouseEvent)
    {
        ProfileMenuView profileMenuView = new ProfileMenuView(view.getStage(), menu.getUser());
    }



    public void logout(MouseEvent mouseEvent)
    {
        LoginMenuView loginMenuView = new LoginMenuView(view.getStage());
    }



    public void exit(MouseEvent mouseEvent)
    {
        Platform.exit();
    }
}
