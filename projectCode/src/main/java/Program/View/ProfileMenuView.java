package Program.View;

import Program.Controller.ProfileMenuController;
import Program.Model.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ProfileMenuView {
    Stage stage;
    Scene scene;
    Group root;
    ProfileMenuController controller;
    Stage confirmationStage;
    ScrollPane imageSelectionScrollPane;





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
        scene.setCursor(new ImageCursor(new Image(String.valueOf(getClass().getResource("/Textures/Cursor.png"))), 64, 64));
        stage.setScene(scene);
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.centerOnScreen();
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



    public void openImageSelectionMenu()
    {
        GridPane gridPane = new GridPane();

        loadGridImages(gridPane);

        imageSelectionScrollPane = new ScrollPane(gridPane);
        imageSelectionScrollPane.setLayoutX(385);
        imageSelectionScrollPane.setLayoutY(205);
        imageSelectionScrollPane.setPrefHeight(200);
        imageSelectionScrollPane.setPrefWidth(315);
        imageSelectionScrollPane.setFitToWidth(true);

        imageSelectionScrollPane.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/ProfileMenu.css")));

        root.getChildren().add(imageSelectionScrollPane);

        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getSceneX() < imageSelectionScrollPane.getLayoutX() || mouseEvent.getSceneX() > imageSelectionScrollPane.getLayoutX() + imageSelectionScrollPane.getWidth() ||
                        mouseEvent.getSceneY() < imageSelectionScrollPane.getLayoutY() || mouseEvent.getSceneY() > imageSelectionScrollPane.getLayoutY() + imageSelectionScrollPane.getHeight() ){
                    root.getChildren().remove(imageSelectionScrollPane);
                }
            }
        });

    }



    private void loadGridImages(GridPane gridPane)
    {
        File[] imageFiles = new File("src/main/resources/UserImages/DefaultImages/").listFiles();
        ArrayList<Image> images = new ArrayList<>();

        for (File imageFile: imageFiles){
            try {
                images.add(new Image(new FileInputStream(imageFile)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < images.size(); i++){
            ImageView image = new ImageView(images.get(i));
            image.setFitWidth(100);
            image.setFitHeight(100);

            image.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    image.setEffect(new Glow(0.4));
                }
            });

            image.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    image.setEffect(null);
                }
            });

            image.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    image.setEffect(new Glow(0.75));
                    controller.setSelectionImage(imageFiles[images.indexOf(image.getImage())].getPath());
                }
            });

            gridPane.add(image, i % 3, i / 3);
        }
    }



    public void closeImageSelection()
    {
        root.getChildren().remove(imageSelectionScrollPane);
    }




    public void loadNicknameField()
    {
        TextField nicknameTextField = new TextField();
        nicknameTextField.setPromptText("new nickname");
        nicknameTextField.setLayoutX(370);
        nicknameTextField.setLayoutY(490);
        nicknameTextField.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/ProfileMenu.css")));
        root.getChildren().add(nicknameTextField);

        Button nicknameSaveButton = new Button();
        nicknameSaveButton.setText("save nickname");
        nicknameSaveButton.setLayoutX(660);
        nicknameSaveButton.setLayoutY(490);
        nicknameSaveButton.setId("normalButton");
        nicknameSaveButton.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/ProfileMenu.css")));
        root.getChildren().add(nicknameSaveButton);
    }



    public void loadPasswordField()
    {
        TextField passwordTextField = new TextField();
        passwordTextField.setPromptText("new password");
        passwordTextField.setLayoutX(370);
        passwordTextField.setLayoutY(550);
        passwordTextField.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/ProfileMenu.css")));
        root.getChildren().add(passwordTextField);

        Button passwordSaveButton = new Button();
        passwordSaveButton.setText("save password");
        passwordSaveButton.setLayoutX(660);
        passwordSaveButton.setLayoutY(550);
        passwordSaveButton.setId("normalButton");
        passwordSaveButton.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/ProfileMenu.css")));
        root.getChildren().add(passwordSaveButton);

        passwordSaveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.savePassword(passwordTextField);
            }
        });
    }



    //getters
    public Stage getStage()
    {
        return stage;
    }
}