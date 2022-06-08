package Program.Controller;

import Program.Model.Models.LoginMenu;
import Program.Model.Models.MatchingStrings;
import Program.Model.Models.ProfileMenu;
import Program.Model.Models.User;
import Program.View.LoginMenuView;
import Program.View.MainMenuView;
import Program.View.ProfileMenuView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class ProfileMenuController {
    private ProfileMenu menu;
    private ProfileMenuView view;
    private int imageNumber;
    private ArrayList<Image> previewImages;

    @FXML
    private Circle profileImageCircle;
    @FXML
    private ImageView imagePreview;
    @FXML
    private Label nicknameLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    public Button changeNicknameButton;
    public Button changePasswordButton;





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
        setLabels();
    }



    private void setLabels()
    {
        nicknameLabel.setText("nickname: " + menu.getUser().getNickname());
        usernameLabel.setText("username: " + menu.getUser().getUsername());
        passwordLabel.setText("password: " + menu.getUser().getPassword());
    }


    public void setRandomImage()
    {
        menu.setRandomImage();

        try {
            profileImageCircle.setFill(new ImagePattern(new Image(new FileInputStream(menu.getProfileImagePath()))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        loadPreviewSectionImages();
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
        view.openImageSelectionMenu();
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



    public void setSelectionImage(String path)
    {
        menu.setImage(path);
        try {
            profileImageCircle.setFill(new ImagePattern(new Image(new FileInputStream(menu.getProfileImagePath()))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LoginMenu.saveUsers();
        view.closeImageSelection();
        loadPreviewSectionImages();
    }

    public void changeNickname(MouseEvent mouseEvent)
    {
        Button button = (Button) mouseEvent.getSource();
        button.setVisible(false);

        view.loadNicknameField();
    }



    public void changePassword(MouseEvent mouseEvent)
    {
        Button button = (Button) mouseEvent.getSource();
        button.setVisible(false);

        view.loadPasswordField();
    }



    public void savePassword(TextField passwordTextField)
    {
        String password = passwordTextField.getText();

        if (isPasswordFormatInvalid(password)){
            passwordTextField.setPromptText("password format is invalid");
            passwordTextField.setStyle("-fx-prompt-text-fill: red");
            passwordTextField.setText("");
            return;
        }

        menu.getUser().setPassword(password);
        passwordTextField.setPromptText("password changed");
        passwordTextField.setStyle("-fx-prompt-text-fill: green");
        passwordTextField.setText("");

        passwordTextField.setText("password: " + menu.getUser().getPassword());
    }



    public void saveNickname(TextField nicknameTextField)
    {
        String password = nicknameTextField.getText();

        if (isNicknameFormatInvalid(password)){
            nicknameTextField.setPromptText("nickname format is invalid");
            nicknameTextField.setStyle("-fx-prompt-text-fill: red");
            nicknameTextField.setText("");
            return;
        }

        menu.getUser().setNickname(password);
        nicknameTextField.setPromptText("nickname changed");
        nicknameTextField.setStyle("-fx-prompt-text-fill: green");
        nicknameTextField.setText("");

        nicknameTextField.setText("nickname: " + menu.getUser().getPassword());
    }



    private boolean isPasswordFormatInvalid(String password)
    {
        return !(MatchingStrings.LoginControllerStrings.PASSWORD.matcher(password).matches() && Pattern.compile("\\d").matcher(password).find()
                && password.length() > 5 && password.length() < 15);
    }



    private boolean isNicknameFormatInvalid(String nickname)
    {
        return !(MatchingStrings.LoginControllerStrings.NICKNAME.matcher(nickname).matches() && nickname.length() < 15);
    }
}
