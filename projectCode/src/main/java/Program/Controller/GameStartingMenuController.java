package Program.Controller;

import Program.Model.Enums.GeneralBiomes;
import Program.Model.Enums.MapSizes;
import Program.Model.Models.GameLoader;
import Program.Model.Models.LoginMenu;
import Program.Model.Models.User;
import Program.View.GameLoaderView;
import Program.View.GameStartingMenuView;
import Program.View.MainMenuView;
import Program.View.MenuSoundPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameStartingMenuController {
    private GameStartingMenuView view;
    private User user;
    private ArrayList<User> users;
    private ArrayList<User> players;
    private boolean isAutoSave;
    private boolean showTip;
    private Label lastTipLabel;
    private String biomeTypeString;
    private String mapSizeString;
    private int autoSaveRounds;

    @FXML
    private ComboBox<String> biomeComboBox;
    @FXML
    private ComboBox<String> mapSizeComboBox;
    @FXML
    private ComboBox<Integer> numberOfPlayersComboBox;
    @FXML
    private TextField usernamesTextField;
    @FXML
    private ComboBox<Integer> roundsNeededComboBox;
    @FXML
    private Label autoSaveRoundsLabel;
    @FXML
    private Label biomeTip;
    @FXML
    private Label mapSizeTip;
    @FXML
    private Label numberOfPlayerTip;
    @FXML
    private Label autoSaveTip;
    @FXML
    private Label autoSaveButtonTip;





    ////methods////
    public void initialize(User user, GameStartingMenuView gameStartingMenuView)
    {
        this.user = user;
        this.view = gameStartingMenuView;
        view.loadChoiceBoxes(biomeComboBox, mapSizeComboBox, numberOfPlayersComboBox);
        users = LoginMenu.getUsers();
        players = new ArrayList<>();
        players.add(user);

        numberOfPlayersComboBox.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                for (int i = numberOfPlayersComboBox.getValue(); i < players.size(); i++){
                    players.remove(i);
                    i--;
                }

                view.updateNumberOfPlayers(numberOfPlayersComboBox.getValue());
            }
        });

        initializeSaveComboBox();
        autoSaveRoundsLabel.setVisible(isAutoSave);
        roundsNeededComboBox.setVisible(isAutoSave);
    }



    public void initializeSaveComboBox()
    {
        roundsNeededComboBox.getItems().add(1);
        roundsNeededComboBox.getItems().add(2);
        roundsNeededComboBox.getItems().add(5);
        roundsNeededComboBox.getItems().add(10);
        roundsNeededComboBox.getItems().add(20);
        roundsNeededComboBox.getItems().add(50);

        roundsNeededComboBox.setVisibleRowCount(4);
    }



    public void addUser(KeyEvent keyEvent)
    {
        if (!keyEvent.getCode().equals(KeyCode.ENTER)){
            return;
        }

        if (getUserByUsername(usernamesTextField.getText()) == null){
            usernamesTextField.setText("");
            usernamesTextField.setPromptText("invalid username");
            usernamesTextField.setStyle("-fx-prompt-text-fill: red");
            return;
        }

        if (numberOfPlayersComboBox.getValue() == null){
            return;
        }

        if (players.size() < numberOfPlayersComboBox.getValue()){
            players.add(getUserByUsername(usernamesTextField.getText()));
            view.updateUsers(players);
            usernamesTextField.setText("");
            usernamesTextField.setPromptText("enter usernames 1 by 1");
            usernamesTextField.setStyle("-fx-prompt-text-fill: gray");
        }
    }



    private User getUserByUsername(String username)
    {
        for (User user: users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }

        return null;
    }



    public void changeSaveState(MouseEvent mouseEvent)
    {
        MenuSoundPlayer.playClickSound();

        Button button = (Button) mouseEvent.getSource();
        isAutoSave = !isAutoSave;
        roundsNeededComboBox.setVisible(isAutoSave);
        autoSaveRoundsLabel.setVisible(isAutoSave);

        if (isAutoSave){
            button.setText("on");
        }
        else {
            button.setText("off");
        }
    }



    public void startGame()
    {
        MenuSoundPlayer.playClickSound();

        if (numberOfPlayersComboBox.getValue() == null || !numberOfPlayersComboBox.getValue().equals(players.size())){
            usernamesTextField.setText("");
            usernamesTextField.setPromptText("not enough players");
            usernamesTextField.setStyle("-fx-prompt-text-fill: red");
            return;
        }

        GeneralBiomes mapBiome = setBiomeValue();
        MapSizes mapSize = setMapSize();
        GameLoaderView gameLoaderView = new GameLoaderView(view.getStage(), players, mapBiome, mapSize);
    }



    private GeneralBiomes setBiomeValue()
    {
        GeneralBiomes mapBiome = GeneralBiomes.DESERT;

        if (biomeTypeString == null){
            biomeTypeString = "random";
        }

        for (GeneralBiomes generalBiome: GeneralBiomes.values()){
            if (generalBiome.toString().equalsIgnoreCase(biomeTypeString)){
                mapBiome = generalBiome;
            }
        }

        if (biomeTypeString.equalsIgnoreCase("random")){
            Random rand = new Random();
            mapBiome = GeneralBiomes.values()[rand.nextInt(GeneralBiomes.values().length)];
        }

        return mapBiome;
    }



    private MapSizes setMapSize()
    {
        MapSizes mapSize = MapSizes.TINY;

        if (mapSizeString == null){
            mapSizeString = "";
        }

        for (MapSizes defaultMapSize: MapSizes.values()){
            if (defaultMapSize.toString().equalsIgnoreCase(mapSizeString)){
                mapSize = defaultMapSize;
            }
        }

        if (mapSizeString.equalsIgnoreCase("very tiny")){
            mapSize = MapSizes.VERY_TINY;
        }

        if (mapSizeString.equalsIgnoreCase("random")){
            Random rand = new Random();
            mapSize = MapSizes.values()[rand.nextInt(MapSizes.values().length)];
        }

        return mapSize;
    }



    public void back()
    {
        MenuSoundPlayer.playClickSound();
        MainMenuView mainMenuView = new MainMenuView(view.getStage(), user);
    }



    public void showBiomeTip(MouseEvent mouseEvent)
    {
        showTip = true;
        lastTipLabel = biomeTip;

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (showTip && lastTipLabel == biomeTip) {
                    showTipFadingInAnimation(biomeTip, mouseEvent);
                }
            }
        }, 500);
    }



    public void closeBiomeTip()
    {
        showTipFadingOutAnimation(biomeTip);
    }



    public void showMapSizeTip(MouseEvent mouseEvent)
    {
        showTip = true;
        lastTipLabel = mapSizeTip;

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (showTip && lastTipLabel == mapSizeTip) {
                    showTipFadingInAnimation(mapSizeTip, mouseEvent);
                }
            }
        }, 500);
    }



    public void closeMapSizeTip()
    {
        showTipFadingOutAnimation(mapSizeTip);
    }



    public void showNumberOfPlayersTip(MouseEvent mouseEvent)
    {
        showTip = true;
        lastTipLabel = numberOfPlayerTip;

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (showTip && lastTipLabel == numberOfPlayerTip) {
                    showTipFadingInAnimation(numberOfPlayerTip, mouseEvent);
                }
            }
        }, 500);
    }



    public void closeNumberOfPlayersTip()
    {
        showTipFadingOutAnimation(numberOfPlayerTip);
    }



    public void showAutoSaveLabelTip(MouseEvent mouseEvent)
    {
        showTip = true;
        lastTipLabel = autoSaveRoundsLabel;

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (showTip && lastTipLabel == autoSaveRoundsLabel) {
                    showTipFadingInAnimation(autoSaveTip, mouseEvent);
                }
            }
        }, 500);
    }



    public void closeAutoSaveLabelTip()
    {
        showTipFadingOutAnimation(autoSaveTip);
    }



    public void showAutoSaveButtonTip(MouseEvent mouseEvent)
    {
        showTip = true;
        lastTipLabel = autoSaveButtonTip;

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (showTip && lastTipLabel == autoSaveButtonTip) {
                    showTipFadingInAnimation(autoSaveButtonTip, mouseEvent);
                }
            }
        }, 800);
    }



    public void closeAutoSaveButtonTip()
    {
        showTipFadingOutAnimation(autoSaveButtonTip);
    }
    
    

    private void showTipFadingInAnimation(Label label, MouseEvent mouseEvent)
    {
        label.setVisible(true);
        label.setLayoutX(mouseEvent.getSceneX() + 10);
        label.setLayoutY(mouseEvent.getSceneY() - 50);
        label.setOpacity(0);

        Timeline animationTimeline = new Timeline(new KeyFrame(Duration.millis(80), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setOpacity(label.getOpacity() + 0.1);
            }
        }));

        animationTimeline.setCycleCount(10);
        animationTimeline.play();

        animationTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!showTip){
                    label.setVisible(false);
                }
            }
        });
    }



    private void showTipFadingOutAnimation(Label label)
    {
        showTip = false;
        Timeline animationTimeline = new Timeline(new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (label.getOpacity() >= 0.1) {
                    label.setOpacity(label.getOpacity() - 0.1);
                }
            }
        }));

        animationTimeline.setCycleCount(10);
        animationTimeline.play();

        animationTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setVisible(false);
            }
        });
    }



    public void setBiomeType(ActionEvent event)
    {
        biomeTypeString = biomeComboBox.getValue();
    }



    public void setMapSizeValue(ActionEvent event)
    {
        mapSizeString = mapSizeComboBox.getValue();
    }



    public void playButtonSound()
    {
        MenuSoundPlayer.playButtonSound();
    }
}
