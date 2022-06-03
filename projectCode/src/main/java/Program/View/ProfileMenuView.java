package Program.View;

import Program.Controller.ProfileMenuController;
import Program.Model.User;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileMenuView {
    Stage stage;
    Scene scene;
    Group root;
    ProfileMenuController controller;
    Image profileImage;
    Image[] profileImages;





    ////methods////
    public ProfileMenuView(Stage stage, User user)
    {
        this.stage = stage;
        root = new Group();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/ProfileMenuController.fxml"));

        try {
            root.getChildren().add(fxmlLoader.load());
            controller = fxmlLoader.getController();
            controller.initialize(user, this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        loadImages();


        scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.centerOnScreen();
    }



    private void loadImages()
    {
        profileImage = controller.getProfileImage();
    }



    private void loadImageList()
    {
        /*GridPane gridPane = new GridPane();

        for (int j = 0; j < 3; j ++){
            for (int i = 0; i < 3; i++){
                ImageView  image = new ImageView(String.valueOf(getClass().getResource("/Textures/Menu/MainMenuBackground.png")));
                image.setFitWidth(100);
                image.setFitHeight(100);
                image.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        image.setEffect(new Glow(0.5));
                    }
                });
                gridPane.add(image, j, i);
            }
        }

        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setPrefHeight(100);
        root.getChildren().add(scrollPane);*/
    }
}