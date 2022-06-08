package Program.Model.Models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Random;

public class ProfileMenu {
    private User user;
    private ArrayList<User> users;





    ////methods////
    public ProfileMenu(User user)
    {
        this.user = user;
        users = LoginMenu.getUsers();
    }



    public void setRandomImage()
    {
        File[] imageFiles = new File("src/main/resources/UserImages/DefaultImages/").listFiles();
        Random rand = new Random();
        File imageFile = imageFiles[rand.nextInt(imageFiles.length)];
        user.setImagePath(imageFile.getPath());
        LoginMenu.saveUsers();
    }




    public void setCustomImage(File file)
    {
        if (file != null){
            try {
                Files.copy(Paths.get(file.getPath()), Paths.get("src/main/resources/UserImages/CustomImages/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

            user.setImagePath("src/main/resources/UserImages/CustomImages/" + file.getName());
        }
    }



    public boolean doesNicknameExist(String nickname)
    {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).equals(nickname)){
                return true;
            }
        }

        return false;
    }



    public void changeNickname(String nickname)
    {
        user.setNickname(nickname);
    }



    public void changePassword(String password)
    {
        user.setPassword(password);
    }




    public void setImage(String imagePath)
    {
        user.setImagePath(imagePath);
    }



    //getters
    public User getUser() {
        return user;
    }


    public String getProfileImagePath()
    {
        return user.getImagePath();
    }

}
