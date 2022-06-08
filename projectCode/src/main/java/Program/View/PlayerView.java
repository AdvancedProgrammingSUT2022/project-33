package Program.View;

import Program.Model.Models.Coordinates;
import Program.Model.Models.MiniMap;
import Program.Model.Models.Player;
import Program.Model.Models.River;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;

public class PlayerView {
    Stage stage;
    Scene scene;
    Group root;
    MiniMap miniMap;
    int centerX;
    int centerY;
    Group mapRoot;






    ////methods////
    public PlayerView(Stage stage, Player player)
    {
        root = new Group();
        mapRoot = new Group();
        this.miniMap = player.getMap();
        loadBackground();

        reloadMap();
        root.getChildren().add(mapRoot);
        scene = new Scene(root);
        stage.setScene(scene);
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
        for (int j = 0; j < 10; j++){
            for (int i = 0; i < 10; i++){
                loadTerrain(i, j);
                loadProperty(i, j);
                loadResources(i, j);
            }
        }

        loadRivers();
    }



    private void loadTerrain(int x, int y)
    {
        Image image = new Image(String.valueOf(getClass().getResource(
                "/Textures/Game/Map/Terrain/" + miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getType() + ".png")));
        loadImageIntoCoordinates(image, x, y);
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
                System.out.println(river.getRiverCoordinates());
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



        if (y > 0 && miniMap.getTerrainFromCoordinates(new Coordinates(x, y - 1, 0)).isHasRiver()){
            Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/River.png")));
            loadRiverImageIntoCoordinates(image, x, 0, y, -16);
        }
        else if (y < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x, y + 1, 0)).isHasRiver()) {
            Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/River.png")));
            loadRiverImageIntoCoordinates(image, x, 0, y, 16);
        }
        else if (x % 2 == 0){
            if (x < miniMap.getMapSize() - 1 && y > 0 &&  miniMap.getTerrainFromCoordinates(new Coordinates(x + 1, y - 1, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                loadRiverImageIntoCoordinates(image, x, 25, y, -16);
            }
            else if (x > 0 && y > 0 && miniMap.getTerrainFromCoordinates(new Coordinates(x - 1, y - 1, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, -25, y, -16);
            }
            else if (x < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x + 1, y, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, 25, y, 16);
            }
            else if (x > 0 && miniMap.getTerrainFromCoordinates(new Coordinates(x - 1, y, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, -25, y, 16);
            }
        }
        else {
            if (x < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x + 1, y, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpRight.png")));
                loadRiverImageIntoCoordinates(image, x, 25, y, -16);
            }
            else if (x > 0 && miniMap.getTerrainFromCoordinates(new Coordinates(x - 1, y, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, -25, y, -16);
            }
            else if (x < miniMap.getMapSize() - 1 && y < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x + 1, y + 1, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, 25, y, 16);
            }
            else if (x > 0 && y < miniMap.getMapSize() - 1 && miniMap.getTerrainFromCoordinates(new Coordinates(x - 1, y + 1, 0)).isHasRiver()){
                Image image = new Image(String.valueOf(getClass().getResource("/Textures/Game/Map/Terrain/RiverUpLeft.png")));
                loadRiverImageIntoCoordinates(image, x, -25, y, 16);
            }
        }
    }



    private void loadProperty (int x, int y)
    {
        if (miniMap.getTerrainFromCoordinates(new Coordinates(x, y , 0)).isHasProperty()) {
            Image image = new Image(String.valueOf(getClass().getResource(
                    "/Textures/Game/Map/Terrain/" + miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getProperty().getType() + ".png")));
            loadImageIntoCoordinates(image, x, y);
        }
    }



    private void loadResources(int x, int y)
    {
        if (miniMap.getTerrainFromCoordinates(new Coordinates(x, y , 0)).isHasResource()) {
            Image image = new Image(String.valueOf(getClass().getResource(
                    "/Textures/Game/Map/Terrain/" + miniMap.getTerrainFromCoordinates(new Coordinates(x, y, 0)).getResourceTypeString() + ".png")));
            loadImageIntoCoordinates(image, x, y);
        }
    }



    private void loadImageIntoCoordinates(Image image, int x, int y)
    {
        ImageView imageView = new ImageView(image);
        imageView.setX(x * 16 * 3);
        imageView.setY(y * 56 + (x % 2 ) * 28);

        if (image.getHeight() != 56){
            imageView.setY(imageView.getY() - (image.getHeight() - 56));
        }

        mapRoot.getChildren().add(imageView);
    }



    private void loadRiverImageIntoCoordinates(Image image, int x, int deltaX, int y, int deltaY){
        ImageView imageView = new ImageView(image);
        imageView.setX(x * 16 * 3 + deltaX);
        imageView.setY(y * 56 + (x % 2 ) * 28 + deltaY);

        if (image.getHeight() != 56){
            imageView.setY(imageView.getY() - (image.getHeight() - 56));
        }

        mapRoot.getChildren().add(imageView);
    }
}
