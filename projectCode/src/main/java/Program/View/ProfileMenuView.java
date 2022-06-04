package Program.View;

import Program.Controller.ProfileMenuController;
import Program.Model.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ProfileMenuView {
    Stage stage;
    Scene scene;
    Group root;
    ProfileMenuController controller;
    Stage confirmationStage;





    ////methods////
    public ProfileMenuView(Stage stage, User user)
    {
        this.stage = stage;
        root = new Group();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/ProfileMenu.fxml"));

        try {
            root.getChildren().add(fxmlLoader.load());
            controller = fxmlLoader.getController();
            controller.initialize(user, this);
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



    public void getConfirmation()
    {
        confirmationStage = new Stage();
        confirmationStage.setResizable(false);

        confirmationStage.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (!confirmationStage.isFocused()){
                    confirmationStage.close();
                }
            }
        });


        Group confirmationRoot = new Group();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/removingProfileConfirmation.fxml"));

        try {
            confirmationRoot.getChildren().add(fxmlLoader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        loadConfirmationButtons(confirmationRoot);

        Scene confirmationScene = new Scene(confirmationRoot);
        confirmationScene.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/ProfileMenu.css")));
        confirmationStage.setScene(confirmationScene);
        confirmationStage.centerOnScreen();
        confirmationStage.show();
    }



    private void loadConfirmationButtons(Group confirmationRoot)
    {
        Button yesButton = new Button("yes");
        yesButton.setLayoutX(105);
        yesButton.setLayoutY(130);
        yesButton.setId("normalButton");

        yesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.removeUser();
            }
        });

        Button noButton = new Button("no");
        noButton.setLayoutX(395);
        noButton.setLayoutY(130);
        noButton.setId("normalButton");

        noButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                closeConfirmation();
            }
        });

        confirmationRoot.getChildren().add(yesButton);
        confirmationRoot.getChildren().add(noButton);
    }



    public void closeConfirmation()
    {
        confirmationStage.close();
    }



    //getters
    public Stage getStage()
    {
        return stage;
    }
}