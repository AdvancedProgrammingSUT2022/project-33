package Program.Controller;

import Program.Model.*;
import Program.View.LoginMenuView;
import Program.View.MainMenuView;
import Program.View.ProfileMenuView;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.Objects;
import java.util.regex.Matcher;

public class ProfileMenuController {
    private ProfileMenu menu;
    private ProfileMenuView view;
    private int imageNumber;
    private ArrayList<Image> previewImages;

    @FXML
    private Circle profileImageCircle;
    @FXML
    private ImageView imagePreview;





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

        loadPreviewSectionImages();
    }



    public void setRandomImage()
    {
        menu.setRandomImage();

        try {
            profileImageCircle.setFill(new ImagePattern(new Image(new FileInputStream(menu.getProfileImagePath()))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void setCustomImage()
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



    private void loadPreviewSectionImages()
    {
        previewImages = new ArrayList<>();
        File[] imageFiles = new File("src/main/resources/UserImages/DefaultImages/").listFiles();

        for (int i = 0; i < imageFiles.length; i++){
            try {
                previewImages.add(new Image(new FileInputStream(imageFiles[i])));
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (menu.getProfileImagePath().equals(imageFiles[i].getPath())){
                imageNumber = i;
            }
        }

        if (menu.getUser().hasCustomImage()){
            imageNumber = 0;
            imagePreview.setImage(previewImages.get(0));
            return;
        }

        imagePreview.setImage(previewImages.get(imageNumber));
    }



    public void nextImage()
    {
        imageNumber++;
        imageNumber %= previewImages.size();
        imagePreview.setImage(previewImages.get(imageNumber));
    }



    public void previousImage()
    {
        imageNumber--;

        if (imageNumber < 0){
            imageNumber = previewImages.size() - 1;
        }

        imageNumber %= previewImages.size();
        imagePreview.setImage(previewImages.get(imageNumber));
    }



    public void saveImage()
    {
        menu.setImage(Objects.requireNonNull(new File("src/main/resources/UserImages/DefaultImages/").listFiles())[imageNumber].getPath());
        profileImageCircle.setFill(new ImagePattern(previewImages.get(imageNumber)));
        LoginMenu.saveUsers();
    }



    public void openImageSelectionMenu(MouseEvent mouseEvent)
    {
        //TODO:
    }



    public void back()
    {
        MainMenuView mainMenuView = new MainMenuView(view.getStage(), menu.getUser());
    }



    public void getConfirmation()
    {
        view.getConfirmation();
    }



    public void removeUser()
    {
        view.closeConfirmation();
        ArrayList<User> users = LoginMenu.getUsers();
        users.remove(menu.getUser());
        LoginMenu.saveUsers();
        LoginMenuView loginMenuView = new LoginMenuView(view.getStage());
    }
}
