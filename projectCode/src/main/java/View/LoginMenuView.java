package View;

public class LoginMenuView {





    ////methods////
    public void showUsernameExist(String username)
    {
        System.out.println("user with username " + username + " already exists");
    }



    public void showNicknameExist(String nickname)
    {
        System.out.println("user with nickname " + nickname + " already exists");
    }



    public void showInvalidUsername()
    {
        System.out.println("username format is invalid");
    }



    public void showinvalidPassword()
    {
        System.out.println("password fromat is invalid");
    }



    public void showUserCreated()
    {
        System.out.println("user created successfully!");
    }



    public void showPleaseLogin()
    {
        System.out.println("please login first");
    }



    public void showCurrentMenu()
    {
        System.out.println("Login Menu");
    }



    public void showWrongPassword()
    {
        System.out.println("username and password didn't match!");
    }



    public void showLoginMessage()
    {
        System.out.println("user logged in successfully!");
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showGoodbye()
    {
        System.out.println("goodbye");
    }
}
