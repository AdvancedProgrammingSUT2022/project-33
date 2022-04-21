package Model;

import View.MainMenuView;

import java.util.ArrayList;

public class MainMenu {
    private User user;
    private ArrayList<User> users;





    ////methods////
    public MainMenu(User user, ArrayList<User> users)
    {
        this.user = user;
        this.users = users;
    }



    public void startGame(ArrayList<String> usernames)
    {
        if (!usernames.get(0).equals(user.getUsername())){
            MainMenuView.showFirstUserMustBEYou();
            return;
        }

        for (int i = 0; i < usernames.size(); i++){
            if (!doesUsernameExist(usernames.get(i))){
                MainMenuView.showUsernameDoesNotExist(usernames.get(i));
                return;
            }
        }

        for (int j = 0; j < usernames.size(); j++){
            for (int i = 0; i < usernames.size(); i++){
                if (usernames.get(i).equals(usernames.get(j))){
                    MainMenuView.showUsernamesAreTheSame(usernames.get(i));
                }
            }
        }

        ArrayList<User> players = new ArrayList<>();

        for (int i = 0; i < usernames.size(); i++){
            players.add(getUserFromUsername(usernames.get(i)));
        }

        GameLoader gameLoader = new GameLoader(players);
    }



    private boolean doesUsernameExist(String username)
    {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUsername().equals(username)){
                return true;
            }
        }

        return false;
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
