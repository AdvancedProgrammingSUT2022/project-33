package Program.Controller;

import Program.Model.Models.MainMenu;
import Program.Model.Models.User;
import Program.View.*;
import javafx.application.Platform;
import javafx.scene.input.MouseEvent;

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
        MenuSoundPlayer.playClickSound();
        GameStartingMenuView gameStartingMenuView = new GameStartingMenuView(view.getStage(), menu.getUser());
    }



    public void openProfile(MouseEvent mouseEvent)
    {
        MenuSoundPlayer.playClickSound();
        ProfileMenuView profileMenuView = new ProfileMenuView(view.getStage(), menu.getUser());
    }



    public void logout(MouseEvent mouseEvent)
    {
        MenuSoundPlayer.playClickSound();
        LoginMenuView loginMenuView = new LoginMenuView(view.getStage());
    }



    public void exit(MouseEvent mouseEvent)
    {
        MenuSoundPlayer.playClickSound();
        Platform.exit();
    }



    public void playButtonSound(MouseEvent mouseEvent)
    {
        MenuSoundPlayer.playButtonSound();
    }
}
