package Program.Controller;

import Program.Model.*;
import Program.View.ProfileMenuView;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class ProfileMenuController {
    private ProfileMenu menu;
    private ProfileMenuView view;

    @FXML
    private Circle profileImageCircle;





    ////methods////
    public void initialize(User user, ProfileMenuView  view)
    {
        this.view = view;
        menu = new ProfileMenu(user);

        try {
            profileImageCircle.setFill(new ImagePattern(new Image(new FileInputStream(menu.getProfileImagePath()))));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public Image getProfileImage()
    {
        try {
            return new Image(new FileInputStream(menu.getProfileImagePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }



    public void setRandomImage(MouseEvent mouseEvent)
    {
        menu.setRandomImage();

        try {
            profileImageCircle.setFill(new ImagePattern(new Image(new FileInputStream(menu.getProfileImagePath()))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setCustomImage(MouseEvent mouseEvent)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Image Files", "png", "jpg"));
        fileChooser.setTitle("custom image");
        File file = fileChooser.showOpenDialog(view.getStage());

        menu.setCustomImage(file);

        try {
            profileImageCircle.setFill(new ImagePattern(new Image(new FileInputStream(menu.getProfileImagePath()))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        LoginMenu.saveUsers();
    }
}
