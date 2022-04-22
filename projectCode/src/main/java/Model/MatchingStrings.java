package Model;

import java.util.regex.Pattern;

public class MatchingStrings {
    public static class LoginControllerStrings{
        public final static Pattern CREATE_USER_1 = Pattern.compile("user create -(-?)username [a-zA-Z0-9]+ -(-?)nickname (\\w)+ -(-?)password [a-zA-Z0-9]+");
        public final static Pattern CREATE_USER_2 = Pattern.compile("user create -(-?)username [a-zA-Z0-9]+ -(-?)password [a-zA-Z0-9]+ -(-?)nickname (\\w)+");
        public final static Pattern CREATE_USER_3 = Pattern.compile("user create -(-?)nickname (\\w)+ -(-?)username [a-zA-Z0-9]+ -(-?)password [a-zA-Z0-9]+");
        public final static Pattern CREATE_USER_4 = Pattern.compile("user create -(-?)nickname (\\w)+ -(-?)password [a-zA-Z0-9]+ -(-?)username [a-zA-Z0-9]+");
        public final static Pattern CREATE_USER_5 = Pattern.compile("user create -(-?)password [a-zA-Z0-9]+ -(-?)username [a-zA-Z0-9]+ -(-?)nickname (\\w)+");
        public final static Pattern CREATE_USER_6 = Pattern.compile("user create -(-?)password [a-zA-Z0-9]+ -(-?)nickname (\\w)+ -(-?)username [a-zA-Z0-9]+");
        public final static Pattern USERNAME = Pattern.compile("-(-?)username [a-zA-Z0-9]+");
        public final static Pattern NICKNAME = Pattern.compile("-(-?)nickname (\\w)+");
        public final static Pattern PASSWORD = Pattern.compile("-(-?)password [a-zA-Z0-9]+");
        public final static Pattern LOGIN_USER_1 = Pattern.compile("user login -(-?)username [a-zA-Z0-9]+ -(-?)password [a-zA-Z0-9]+");
        public final static Pattern LOGIN_USER_2 = Pattern.compile("user login -(-?)password [a-zA-Z0-9]+ -(-?)username [a-zA-Z0-9]+");
        public final static Pattern ENTER_MENU = Pattern.compile("menu enter \\S+");
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern EXIT = Pattern.compile("Exit");
    }



    public static class MainControllerStrings{
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern ENTER_MENU = Pattern.compile("menu enter \\S+");
        public final static Pattern ENTER_PROFILE_MENU = Pattern.compile("menu enter Profile");
        public final static Pattern EXIT = Pattern.compile("menu exit");
        public final static Pattern LOGOUT = Pattern.compile("user logout");
        public final static Pattern PLAY_2_PLAYER_GAME = Pattern.compile("play game (-(-?)player1 [a-zA-Z0-9]+) (-(-?)player2 [a-zA-Z0-9]+)");
        public final static Pattern PLAY_3_PLAYER_GAME = Pattern.compile("play game (-(-?)player1 [a-zA-Z0-9]+) (-(-?)player2 [a-zA-Z0-9]+) (-(-?)player3 [a-zA-Z0-9]+)");
        public final static Pattern PLAY_4_PLAYER_GAME = Pattern.compile("play game (-(-?)player1 [a-zA-Z0-9]+) (-(-?)player2 [a-zA-Z0-9]+) (-(-?)player3 [a-zA-Z0-9]+) (-(-?)player4 [a-zA-Z0-9]+)");
        public final static Pattern PLAY_5_PLAYER_GAME = Pattern.compile("play game (-(-?)player1 [a-zA-Z0-9]+) (-(-?)player2 [a-zA-Z0-9]+) (-(-?)player3 [a-zA-Z0-9]+) (-(-?)player4 [a-zA-Z0-9]+) (-(-?)player5 [a-zA-Z0-9]+)");
        public final static Pattern PLAY_6_PLAYER_GAME = Pattern.compile("play game (-(-?)player1 [a-zA-Z0-9]+) (-(-?)player2 [a-zA-Z0-9]+) (-(-?)player3 [a-zA-Z0-9]+) (-(-?)player4 [a-zA-Z0-9]+) (-(-?)player5 [a-zA-Z0-9]+) (-(-?)player6 [a-zA-Z0-9]+)");
        public final static Pattern PLAY_7_PLAYER_GAME = Pattern.compile("play game (-(-?)player1 [a-zA-Z0-9]+) (-(-?)player2 [a-zA-Z0-9]+) (-(-?)player3 [a-zA-Z0-9]+) (-(-?)player4 [a-zA-Z0-9]+) (-(-?)player5 [a-zA-Z0-9]+) (-(-?)player6 [a-zA-Z0-9]+) (-(-?)player7 [a-zA-Z0-9]+)");
        public final static Pattern PLAY_8_PLAYER_GAME = Pattern.compile("play game (-(-?)player1 [a-zA-Z0-9]+) (-(-?)player2 [a-zA-Z0-9]+) (-(-?)player3 [a-zA-Z0-9]+) (-(-?)player4 [a-zA-Z0-9]+) (-(-?)player5 [a-zA-Z0-9]+) (-(-?)player6 [a-zA-Z0-9]+) (-(-?)player7 [a-zA-Z0-9]+) (-(-?)player8 [a-zA-Z0-9]+)");
        public final static Pattern PLAYER = Pattern.compile("(-(-?)player[1-8] [a-zA-Z0-9]+)");
    }



    public static class ProfileControllerStrings{
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern ENTER_MENU = Pattern.compile("menu enter \\S+");
        public final static Pattern EXIT = Pattern.compile("menu exit");
        public final static Pattern CHANGE_NICKNAME = Pattern.compile("profile change -(-?)nickname (\\w)+");
        public final static Pattern CHANGE_PASSWORD1 = Pattern.compile("profile change (-(-?)password) -(-?)current [a-zA-Z0-9]+ -(-?)new [a-zA-Z0-9]+");
        public final static Pattern CHANGE_PASSWORD2 = Pattern.compile("profile change (-(-?)password) -(-?)new [a-zA-Z0-9]+ -(-?)current [a-zA-Z0-9]+");
        public final static Pattern CHANGE_PASSWORD3 = Pattern.compile("profile change -(-?)current [a-zA-Z0-9]+ (-(-?)password) -(-?)new [a-zA-Z0-9]+");
        public final static Pattern CHANGE_PASSWORD4 = Pattern.compile("profile change -(-?)current [a-zA-Z0-9]+ -(-?)new [a-zA-Z0-9]+ (-(-?)password)");
        public final static Pattern CHANGE_PASSWORD5 = Pattern.compile("profile change -(-?)new [a-zA-Z0-9]+ (-(-?)password) -(-?)current [a-zA-Z0-9]+");
        public final static Pattern CHANGE_PASSWORD6 = Pattern.compile("profile change -(-?)new [a-zA-Z0-9]+ -(-?)current [a-zA-Z0-9]+ (-(-?)password)");
        public final static Pattern CURRENT_PASSWORD = Pattern.compile("-(-?)current [a-zA-Z0-9]+");
        public final static Pattern NEW_PASSWORD = Pattern.compile("-(-?)new [a-zA-Z0-9]+");
    }
}
