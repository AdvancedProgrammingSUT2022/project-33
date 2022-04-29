package Model;

import Controller.MainMenuController;
import com.google.gson.Gson;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginMenu {
    private ArrayList<User> users;





    ////methods////
    public LoginMenu()
    {
        users = new ArrayList<>();
        Gson gson = new Gson();

        try {
            Reader reader = Files.newBufferedReader(Paths.get("../Users/usersList.json"));

            if (gson.fromJson(reader, User[].class) != null) {
                users = new ArrayList<>(Arrays.asList(gson.fromJson(reader, User[].class)));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }



    public void addUser(User user)
    {
        users.add(user);
    }



    public void loginUser(User user)
    {
        MainMenuController mainMenuController = new MainMenuController(user, users);
    }



    public void Exit()
    {
        Gson gson = new Gson();

        try {
            Writer writer = Files.newBufferedWriter(Paths.get("../Users/usersList.json"));

            gson.toJson(users, writer);
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    //getters
    public User getUserFromUsername(String username)
    {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUsername().equals(username)){
                return users.get(i);
            }
        }

        return null;
    }



    public User getUserFromNickname(String nickname)
    {
        nickname = nickname.toLowerCase();

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getNickname().toLowerCase().equals(nickname)){
                return users.get(i);
            }
        }

        return null;
    }
}
