package Program.Model;

import java.util.ArrayList;

public class ProfileMenu {
    private User user;
    private ArrayList<User> users;





    ////methods////
    public ProfileMenu(User user, ArrayList<User> users)
    {
        this.user = user;
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



    //getters
    public User getUser() {
        return user;
    }
}
