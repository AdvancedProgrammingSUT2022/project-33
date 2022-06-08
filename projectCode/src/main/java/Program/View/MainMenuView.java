package Program.View;

import Program.Controller.MainMenuController;
import Program.Model.Models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuView {
    Stage stage;
    Scene scene;
    Group root;
    MainMenuController controller;





    ////methods////
    public MainMenuView(Stage stage, User user)
    {
        this.stage = stage;

        root = new Group();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/MainMenu.fxml"));

        try {
            root.getChildren().add(fxmlLoader.load());
            controller = fxmlLoader.getController();
            controller.initialize(this, user);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        scene = new Scene(root);
        scene.setCursor(new ImageCursor(new Image(String.valueOf(getClass().getResource("/Textures/Cursor.png"))), 64, 64));
        stage.setScene(scene);
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.centerOnScreen();
    }


    public Stage getStage()
    {
        return stage;
    }
}
