package Program.Controller;

import Program.Model.MainMenu;
import Program.Model.MatchingStrings;
import Program.Model.User;
import Program.Model.UserInput;
import Program.View.MainMenuView;

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
}
