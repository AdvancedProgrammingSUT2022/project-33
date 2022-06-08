package Program.View;

import Program.Model.Enums.GeneralBiomes;
import Program.Model.Enums.MapSizes;
import Program.Model.Models.GameLoader;
import Program.Model.Models.UselessTips;
import Program.Model.Models.User;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class GameLoaderView  {
    static UselessTips tips = new UselessTips();
    Stage stage;
    Scene scene;
    Group root;
    Label uselessTipLabel;
    Label percentage;
    Rectangle percentageShape;
    Rectangle percentageBorder;
    int loadPercentage;
    GameLoader gameLoader;






    ////methods////
    public GameLoaderView(Stage stage, ArrayList<User> players, GeneralBiomes biome, MapSizes mapSizes)
    {
        gameLoader = new GameLoader(players, biome, mapSizes);
        this.stage = stage;
        root = new Group();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/LoadingScreen.fxml"));

        try {
            root.getChildren().add(fxmlLoader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        initializeTip();
        initializePercentage();

        scene = new Scene(root);
        scene.setCursor(new ImageCursor(new Image(String.valueOf(getClass().getResource("/Textures/Cursor.png"))), 64, 64));
        stage.setScene(scene);
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.centerOnScreen();

        showAnimation();
    }



    private void initializeTip()
    {
        uselessTipLabel = new Label(tips.getRandomTip());
        uselessTipLabel.setLayoutX(5);
        uselessTipLabel.setLayoutY(505);
        uselessTipLabel.setPrefWidth(1275);
        uselessTipLabel.setPrefHeight(200);
        uselessTipLabel.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/LoadingScreen.css")));
        root.getChildren().add(uselessTipLabel);
    }




    private void initializePercentage()
    {
        loadPercentage = 0;
        percentage = new Label(loadPercentage + "%");
        percentage.setLayoutY(320);
        percentage.setLayoutX(540);
        percentage.setPrefWidth(200);
        percentage.setPrefHeight(40);
        percentage.getStylesheets().add(String.valueOf(getClass().getResource("/CssFiles/LoadingScreen.css")));
        percentage.setStyle("-fx-text-alignment: center");
        percentage.setStyle("-fx-alignment: center");
        root.getChildren().add(percentage);

        percentageBorder = new Rectangle();
        percentageBorder.setX(540);
        percentageBorder.setY(295);
        percentageBorder.setWidth(200);
        percentageBorder.setHeight(20);
        percentageBorder.setStyle("-fx-fill: transparent; -fx-stroke: #ff9900; -fx-stroke-width: 2");
        root.getChildren().add(percentageBorder);

        percentageShape = new Rectangle();
        percentageShape.setX(540);
        percentageShape.setY(295);
        percentageShape.setWidth(0);
        percentageShape.setHeight(20);
        percentageShape.setStyle("-fx-fill: #ffc400;");
        root.getChildren().add(percentageShape);
    }



    private void showAnimation()
    {
        Timeline percentageAnimationTimeline = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadPercentage++;
                percentage.setText(loadPercentage + "%");
                percentageShape.setWidth(loadPercentage * 2);
            }
        }));

        Timeline tipAnimationTimeline = new Timeline(new KeyFrame(Duration.millis(3300), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uselessTipLabel.setText(tips.getRandomTip());
            }
        }));

        percentageAnimationTimeline.setCycleCount(100);
        tipAnimationTimeline.setCycleCount(3);
        percentageAnimationTimeline.play();
        tipAnimationTimeline.play();

        percentageAnimationTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameLoader.startGame(stage);
            }
        });
    }
}
