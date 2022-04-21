package View;

public class MainMenuView {





    ////methods////
    public void showWelcomeMessage()
    {
        System.out.println("Welcome");
    }



    public void showCurrentMenu()
    {
        System.out.println("Main Menu");
    }



    public void showImpossibleMenuNavigation()
    {
        System.out.println("menu navigation is not possible");
    }



    public static void showFirstUserMustBEYou()
    {
        System.out.println("first username must be your username");
    }



    public static void showUsernameDoesNotExist(String username)
    {
        System.out.println(username + " does not exist");
    }



    public static void showUsernamesAreTheSame(String username)
    {
        System.out.println("Duplicated inputs : " + username);
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }
}
