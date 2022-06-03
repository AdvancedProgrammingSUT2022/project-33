package Program.Controller;

import Program.Model.MatchingStrings;
import Program.Model.ProfileMenu;
import Program.Model.User;
import Program.Model.UserInput;
import Program.View.ProfileMenuView;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
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

}
