package Program.Model;

import java.io.File;
import java.util.Random;

public class User {
    private String nickname;
    private String username;
    private String password;
    private String imagePath;





    ////methods////
    public User(String nickname, String username, String password)
    {
            this.nickname = nickname;
            this.username = username;
            this.password = password;

            setRandomImage();
    }



    private void setRandomImage()
    {
        File[] imageFiles =  new File("src/main/resources/UserImages/DefaultImages/").listFiles();
        Random rand = new Random();
        File image = imageFiles[rand.nextInt(imageFiles.length)];
        imagePath = image.getPath();
    }



    //getters
    public String getNickname() {
        return nickname;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }



    //setters
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
