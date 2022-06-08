package Program.Model.Models;


import java.util.ArrayList;

public class MainMenu {
    private User user;
    private ArrayList<User> users;





    ////methods////
    public MainMenu(User user)
    {
        this.user = user;
        this.users = LoginMenu.getUsers();
    }



    //getters
    private User getUserFromUsername(String username)
    {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUsername().equals(username)){
                return users.get(i);
            }
        }

        return null;
    }



    public User getUser()
    {
        return user;
    }
}
