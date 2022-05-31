package Program;

import Program.Controller.GameLoaderController;
import Program.Model.*;
import Program.View.LoginMenuView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {
    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setResizable(false);
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        LoginMenuView loginMenuView = new LoginMenuView(stage);
    }
}
