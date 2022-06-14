package Program.View;

import Program.Controller.PlayerController;
import Program.Model.Models.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class PlayerView {
    private Stage stage;
    private Scene scene;
    private Group root;
    private MiniMap miniMap;
    private int centerX;
    private int centerY;
    private int lastCenterX;
    private int lastCenterY;
    private Group mapTerrainRoot;
    private int tileXLength;
    private int tileYLength;
    private PlayerController controller;
    private boolean isHoldingUp;
    private boolean isHoldingDown;
    private boolean isHoldingRight;
    private boolean isHoldingLeft;
    private MapImages mapImages;
    private Group mapBuildings;
    private Group mapUnitsRoot;







    ////methods////
    public PlayerView(Stage stage, Player player)
    {
        this.stage = stage;
        initializeValues(player);

        loadBackground();

        reloadMap();
        root.getChildren().add(mapTerrainRoot);

        loadFront(player);

        initializeScene();
        stage.setScene(scene);
    }



    private void initializeValues(Player player)
    {
        tileXLength = 16 * 3;
        tileYLength = 56;
        centerX = player.getPlayerUnits().getSettlers().get(0).getCoordinates().getX() * tileXLength;
        centerY = player.getPlayerUnits().getSettlers().get(0).getCoordinates().getY() * tileYLength;
        lastCenterX = centerX;
        lastCenterY = centerY;
        root = new Group();
        mapTerrainRoot = new Group();
        mapBuildings = new Group();
        mapUnitsRoot = new Group();
        this.miniMap = player.getMap();

        mapImages = new MapImages();
    }



    public void loadFront(Player player)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/PlayerView.fxml"));

        try {
            root.getChildren().add(fxmlLoader.load());
            controller = fxmlLoader.getController();
            controller.initializeController(player, this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void loadBackground()
    {
        ImageView background = new ImageView(String.valueOf(getClass().getResource("/Textures/Game/Map/Background.png")));
        background.setFitWidth(1280);
        background.setFitHeight(720);
        root.getChildren().add(background);
    }



    private void reloadMap()
    {
        mapTerrainRoot.getChildren().clear();

        for (int j = getMinY(); j < getMaxY(); j++){
            for (int i = getMinX(); i < getMaxX(); i++){
                Coordinates coordinates = new Coordinates(i, j, 0);

                if (!miniMap.isCoordinatesInFog(coordinates)){

                    loadTerrain(i, j);
                    loadRiver(i, j);

                    if (!miniMap.isCoordinatesHidden(coordinates) && (miniMap.getTileFromCoordinates(coordinates).isHasDefaultCity() ||
                            miniMap.getTileFromCoordinates(coordinates).isHasPlayerCity())){

                    }
                    else {
                        loadProperty(i, j);
                        loadResources(i, j);
                    }

                    if (miniMap.isCoordinatesHidden(coordinates)){
                        addHiddenTileShadow(i, j);
                    }
                    else{
                        loadUnits(i, j);
                    }
                }
            }
        }
    }



    private void loadTerrain(int x, int y)
    {
        /*Image image = new Image(String.valueOf(getClass().getResource(
                "/Textures/Game/Map/Terrain/" + miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getType() + ".png")));
        loadImageIntoCoordinates(image, x, y);*/

        loadImageIntoCoordinates(mapImages.getTerrainImageByName(miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getType()), x, y);
    }



    private void addHiddenTileShadow(int x, int y)
    {
        loadImageIntoCoordinates(mapImages.getTerrainImageByName("HiddenTileShadow") , x, y);
    }



    private void loadRivers()
    {
        for (River river: miniMap.getRivers()){
            loadRiver(river);
        }
    }



    private void loadRiver(River river)
    {
        for (Coordinates coordinates: river.getRiverCoordinates()){
            if (river.getNextPart(coordinates) == null){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/River.png")));
                loadRiverImageIntoCoordinates(image, coordinates.getX(), 0, coordinates.getY(), 0);
                return;
            }

            int x = coordinates.getX();
            int y = coordinates.getY();
            int nextX = river.getNextPart(coordinates).getX();
            int nextY = river.getNextPart(coordinates).getY();

            if (nextY - y > 0 && nextX - x == 0){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpDown.png")));
                loadRiverImageIntoCoordinates(image, x, 0, y, 29);
            }
            else if (nextY - y < 0 && nextX - x == 0){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpDown.png")));
                loadRiverImageIntoCoordinates(image, x, 0, y, -29);
            }
            else if (x % 2 == 0){
                if (nextY < y) {
                    if (nextX > x) {
                        Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                        loadRiverImageIntoCoordinates(image, x, 25, y, -16);
                    } else if (nextX < x) {
                        Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                        loadRiverImageIntoCoordinates(image, x, -25, y, -16);
                    }
                }
                else {
                    if (nextX > x) {
                        Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                        loadRiverImageIntoCoordinates(image, x, 25, y, 16);
                    } else if (nextX < x) {
                        Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                        loadRiverImageIntoCoordinates(image, x, -25, y, 16);
                    }
                }
            }
            else {
                if (nextY == y) {
                    if (nextX > x) {
                        Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                        loadRiverImageIntoCoordinates(image, x, 25, y, -16);
                    } else if (nextX < x) {
                        Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                        loadRiverImageIntoCoordinates(image, x, -25, y, -16);
                    }
                }
                else {
                    if (nextX > x) {
                        Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                        loadRiverImageIntoCoordinates(image, x, 25, y, 16);
                    } else if (nextX < x) {
                        Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                        loadRiverImageIntoCoordinates(image, x, -25, y, 16);
                    }
                }
            }
        }
    }



    private void loadRiver(int x, int y)
    {
        if (!miniMap.getTerrainFromCoordinates(new Coordinates(x, y , 0)).isHasRiver()) {
            return;
        }

        boolean placedRiver = false;

        if (y > 0 && miniMap.getTerrainFromCoordinates(new Coordinates(x, y - 1, 0)).isHasRiver()){
            Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpDown.png")));
            loadRiverImageIntoCoordinates(image, x, 0, y, -29);
            placedRiver = true;
        }

        if (y < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x, y + 1, 0)).isHasRiver()) {
            Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpDown.png")));
            loadRiverImageIntoCoordinates(image, x, 0, y, 29);
            placedRiver = true;
        }

        if (x % 2 == 0){
            if (x < miniMap.getMapSize() - 1 && y > 0 &&  miniMap.getTerrainFromCoordinates(new Coordinates(x + 1, y - 1, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                loadRiverImageIntoCoordinates(image, x, 25, y, -16);
                placedRiver = true;
            }

            if (x > 0 && y > 0 && miniMap.getTerrainFromCoordinates(new Coordinates(x - 1, y - 1, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, -25, y, -16);
                placedRiver = true;
            }

            if (x < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x + 1, y, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, 25, y, 16);
                placedRiver = true;
            }

            if (x > 0 && miniMap.getTerrainFromCoordinates(new Coordinates(x - 1, y, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                loadRiverImageIntoCoordinates(image, x, -25, y, 16);
                placedRiver = true;
            }
        }
        else {
            if (x < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x + 1, y, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                loadRiverImageIntoCoordinates(image, x, 25, y, -16);
                placedRiver = true;
            }

            if (x > 0 && miniMap.getTerrainFromCoordinates(new Coordinates(x - 1, y, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, -25, y, -16);
                placedRiver = true;
            }

            if (x < miniMap.getMapSize() - 1 && y < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x + 1, y + 1, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, 25, y, 16);
                placedRiver = true;
            }

            if (x > 0 && y < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x - 1, y + 1, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                loadRiverImageIntoCoordinates(image, x, -25, y, 16);
                placedRiver = true;
            }
        }

        if (!placedRiver) {
            Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/River.png")));
            loadRiverImageIntoCoordinates(image, x, 0, y, 0);
        }
    }



    private void loadProperty (int x, int y)
    {
        if (miniMap.getTerrainFromCoordinates(new Coordinates(x, y , 0)).isHasProperty()) {
            /*Image image = new Image(String.valueOf(getClass().getResource(
                    "/Textures/Game/Map/Terrain/" + miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getProperty().getType() + ".png")));
            loadImageIntoCoordinates(image, x, y);*/

            loadImageIntoCoordinates(mapImages.getTerrainImageByName(miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getProperty().getType()), x, y);
        }
    }



    private void loadResources(int x, int y)
    {
        if (miniMap.getTerrainFromCoordinates(new Coordinates(x, y , 0)).isHasResource()) {
            /*Image image = new Image(String.valueOf(getClass().getResource(
                    "/Textures/Game/Map/Terrain/" + miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getResourceTypeString() + ".png")));
            loadImageIntoCoordinates(image, x, y);*/

            loadImageIntoCoordinates(mapImages.getTerrainImageByName(miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getResourceTypeString()), x, y);
        }
    }



    private void loadUnits(int x, int y)
    {
        if (!miniMap.getUnits().isUnitInCoordinates(new Coordinates(x, y, 0))){
            return;
        }

        if (miniMap.getUnits().getMilitaryUnitNameFromCoordinates(new Coordinates(x, y, 0)) != null){
            loadImageIntoCoordinates(mapImages.getUnitImageByName(miniMap.getUnits().getMilitaryUnitNameFromCoordinates(new Coordinates(x, y, 0))), x, y);
            //TODO:
        }

        if (miniMap.getUnits().getNormalUnitNameFromCoordinates(new Coordinates(x, y, 0)) != null){
            loadImageIntoCoordinates(mapImages.getUnitImageByName(miniMap.getUnits().getNormalUnitNameFromCoordinates(new Coordinates(x, y, 0))), x, y);
        }
    }



    private void loadImageIntoCoordinates(Image image, int x, int y)
    {
        ImageView imageView = new ImageView(image);
        imageView.setX(x * tileXLength - centerX + 640);
        imageView.setY(y * tileYLength + (x % 2 ) * (tileYLength / 2) - centerY + 360);

        if (image.getHeight() != tileYLength){
            imageView.setY(imageView.getY() - (image.getHeight() - tileYLength));
        }

        mapTerrainRoot.getChildren().add(imageView);
    }



    private void loadRiverImageIntoCoordinates(Image image, int x, int deltaX, int y, int deltaY){
        ImageView imageView = new ImageView(image);
        imageView.setX(x * tileXLength + deltaX - centerX + 640);
        imageView.setY(y * tileYLength + (x % 2 ) * (tileYLength / 2) + deltaY - centerY + 360);

        if (image.getHeight() != tileYLength){
            imageView.setY(imageView.getY() - (image.getHeight() - tileYLength));
        }

        mapTerrainRoot.getChildren().add(imageView);
    }



    private int getMinX()
    {
        int borderX = centerX - 1280;

        if (borderX < 0){
            borderX = 0;
        }


        return borderX / tileXLength;
    }



    private int getMaxX()
    {
        int borderX = centerX + 1280;

        if (borderX > (miniMap.getMapSize() - 1) * tileXLength){
            borderX = (miniMap.getMapSize() - 1) * tileXLength;
        }

        return borderX / tileXLength;
    }



    private int getMinY()
    {
        int borderY = centerY - 720;

        if (borderY < 0){
            borderY = 0;
        }

        return borderY/ tileYLength;
    }



    private int getMaxY()
    {
        int borderY = centerY + 720;

        if (borderY > (miniMap.getMapSize() - 1) * tileYLength){
            borderY = (miniMap.getMapSize() - 1) * tileYLength;
        }

        return borderY/ tileYLength;
    }



    private void initializeScene()
    {
        scene = new Scene(root);
        scene.setCursor(new ImageCursor(new Image(String.valueOf(getClass().getResource("/Textures/Cursor.png"))), 64, 64));

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.UP)){
                    isHoldingUp = true;
                }
                if (keyEvent.getCode().equals(KeyCode.DOWN)){
                    isHoldingDown = true;
                }
                if (keyEvent.getCode().equals(KeyCode.RIGHT)){
                    isHoldingRight = true;
                }
                if (keyEvent.getCode().equals(KeyCode.LEFT)){
                    isHoldingLeft = true;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.UP)){
                    isHoldingUp = false;
                }
                if (keyEvent.getCode().equals(KeyCode.DOWN)){
                    isHoldingDown = false;
                }
                if (keyEvent.getCode().equals(KeyCode.RIGHT)){
                    isHoldingRight = false;
                }
                if (keyEvent.getCode().equals(KeyCode.LEFT)){
                    isHoldingLeft = false;
                }
            }
        });

        Timeline mapMovingTimeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moveMap();
            }
        }));

        mapMovingTimeline.setCycleCount(-1);
        mapMovingTimeline.play();
    }



    private void moveMap()
    {
        int deltaY = 0;
        int deltaX = 0;

        if (isHoldingDown && centerY < miniMap.getMapSize() * tileYLength){
            deltaY = -5;
        }

        if (isHoldingUp && centerY > 0){
            deltaY = 5;
        }

        if (isHoldingLeft && centerX > 0){
            deltaX = 5;
        }

        if (isHoldingRight && centerX < miniMap.getMapSize() * tileXLength){
            deltaX = -5;
        }

        centerX -= deltaX;
        centerY -= deltaY;
        moveMapElements(deltaX, deltaY);
    }



    private void moveMapElements(int deltaX, int deltaY)
    {
        if (Math.abs(Math.abs(lastCenterX) - Math.abs(centerX)) > 1280 || Math.abs(Math.abs(lastCenterY) - Math.abs(centerY)) > 720){
            lastCenterX = centerX;
            lastCenterY = centerY;
            reloadMap();
        }

        for (int i = 0; i < mapTerrainRoot.getChildren().size(); i++){
            mapTerrainRoot.getChildren().get(i).setLayoutX(mapTerrainRoot.getChildren().get(i).getLayoutX() + deltaX);
            mapTerrainRoot.getChildren().get(i).setLayoutY(mapTerrainRoot.getChildren().get(i).getLayoutY() + deltaY);
        }
    }



    public void showScienceTip()
    {
        //TODO:
    }



    public void closeScienceTip()
    {
        //TODO:
    }



    public void showGoldTip()
    {
        //TODO:
    }



    public void closeGoldTip()
    {
        //TODO:
    }



    public void showHappinessTip()
    {
        //TODO:
    }



    public void closeHappinessTip()
    {
        //TODO:
    }
}
