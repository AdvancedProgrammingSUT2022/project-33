package Program.View;

import Program.Controller.GameStartingMenuController;
import Program.Model.Models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameStartingMenuView {
    private Stage stage;
    private Scene scene;
    private Group root;
    private GameStartingMenuController controller;
    private ArrayList<Label> usersLabel;
    private int numberOfPlayers;






    ////methods////
    public GameStartingMenuView(Stage stage, User user)
    {
        this.stage = stage;
        root = new Group();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/GameStartingMenu.fxml"));

        try {
            root.getChildren().add(fxmlLoader.load());
            controller = fxmlLoader.getController();
            controller.initialize(user, this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        loadLabels();
        updateUsers(new ArrayList<>(List.of(user)));
        scene = new Scene(root);
        scene.setCursor(new ImageCursor(new Image(String.valueOf(getClass().getResource("/Textures/Cursor.png"))), 64, 64));
        stage.setScene(scene);
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.centerOnScreen();
    }



    private void loadLabels()
    {
        usersLabel = new ArrayList<>();
        
        for (int i = 0; i < 8; i++){
            Label label = new Label();
            label.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/GameStartingMenu.css")));
            label.setLayoutX(110 + (i % 4) * 270);
            label.setLayoutY(275 + (i / 4) * 50);
            usersLabel.add(label);
            root.getChildren().add(label);
        }
    }


    public void loadChoiceBoxes(ComboBox<String> biomeComboBox, ComboBox<String> mapSizeComboBox, ComboBox<Integer> numberOfPlayers)
    {
        biomeComboBox.getItems().add("Random");
        biomeComboBox.getItems().add("Desert");
        biomeComboBox.getItems().add("Forest");
        biomeComboBox.getItems().add("Grassland");
        biomeComboBox.getItems().add("Tundra");
        biomeComboBox.getItems().add("Fresh water");

        mapSizeComboBox.getItems().add("Random");
        mapSizeComboBox.getItems().add("Auto");
        mapSizeComboBox.getItems().add("Very tiny");
        mapSizeComboBox.getItems().add("Tiny");
        mapSizeComboBox.getItems().add("Small");
        mapSizeComboBox.getItems().add("Medium");
        mapSizeComboBox.getItems().add("Large");

        for (int i = 2; i < 9; i++){
            numberOfPlayers.getItems().add(i);
        }
    }



    public void updateUsers(ArrayList<User> users)
    {
        for (int i = 0; i < users.size(); i++){
            usersLabel.get(i).setText(users.get(i).getUsername());
        }
    }



    public void updateNumberOfPlayers(int n)
    {
        numberOfPlayers = n;

        for (int i = numberOfPlayers; i < 8; i++){
            usersLabel.get(i).setText("");
        }
    }



    //getters
    public Stage getStage()
    {
        return stage;
    }
}
