package Model;

import java.util.ArrayList;
import java.util.Locale;

public class LoginMenu {
    private ArrayList<User> users;





    ////methods////
    public LoginMenu()
    {
        //TODO load users from file
        users = new ArrayList<>();
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



    public void addUser(User user)
    {
        users.add(user);
    }



    public void loginUser(User user)
    {

    }
}
