package Program.View;

public class ProfileMenuView {





    ////methods////
    public void showEnteredProfileMenu()
    {
        System.out.println("entered Profile Menu");
    }



    public void showCurrentMenu()
    {
        System.out.println("Profile Menu");
    }



    public void showImpossibleNavigation()
    {
        System.out.println("menu navigation is not possible");
    }



    public void showNicknameExist(String nickname)
    {
        System.out.println("user with nickname " + nickname + "already exists");
    }



    public void showNicknameChanged()
    {
        System.out.println("nickname changed successfully!");
    }



    public void showWrongPassword()
    {
        System.out.println("current password is invalid");
    }



    public void showSamePassword()
    {
        System.out.println("please enter a new password");
    }



    public void showInvalidPasswordFormat()
    {
        System.out.println("password format is invalid");
    }



    public void showPasswordChanged()
    {
        System.out.println("password changed successfully!");
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }
}