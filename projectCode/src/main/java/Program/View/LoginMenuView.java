package Program.View;

import Program.Controller.LoginMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMenuView {
    Stage stage;
    Scene scene;
    Group root;
    LoginMenuController controller;





    ////methods////
    public LoginMenuView(Stage stage)
    {
        root = new Group();
        this.stage = stage;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/LoginMenu.fxml"));

        try {
            root.getChildren().add(fxmlLoader.load());
            controller = fxmlLoader.getController();
            controller.initialize(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        scene = new Scene(root);
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