package Model;

import java.util.regex.Pattern;

public class MatchingStrings {
    public static class LoginControllerStrings
    {
        public final static Pattern CREATE_USER_1 = Pattern.compile("user create ((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+ ((-(-?)nickname)|(-(-?)n)) (\\w)+ ((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+");
        public final static Pattern CREATE_USER_2 = Pattern.compile("user create ((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+ ((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+ ((-(-?)nickname)|(-(-?)n)) (\\w)+");
        public final static Pattern CREATE_USER_3 = Pattern.compile("user create ((-(-?)nickname)|(-(-?)n)) (\\w)+ ((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+ ((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+");
        public final static Pattern CREATE_USER_4 = Pattern.compile("user create ((-(-?)nickname)|(-(-?)n)) (\\w)+ ((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+ ((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+");
        public final static Pattern CREATE_USER_5 = Pattern.compile("user create ((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+ ((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+ ((-(-?)nickname)|(-(-?)n)) (\\w)+");
        public final static Pattern CREATE_USER_6 = Pattern.compile("user create ((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+ ((-(-?)nickname)|(-(-?)n)) (\\w)+ ((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+");
        public final static Pattern USERNAME = Pattern.compile("((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+");
        public final static Pattern NICKNAME = Pattern.compile("((-(-?)nickname)|(-(-?)n)) (\\w)+");
        public final static Pattern PASSWORD = Pattern.compile("((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+");
        public final static Pattern LOGIN_USER_1 = Pattern.compile("user login ((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+ ((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+");
        public final static Pattern LOGIN_USER_2 = Pattern.compile("user login ((-(-?)password)|(-(-?)p)) [a-zA-Z0-9]+ ((-(-?)username)|(-(-?)u)) [a-zA-Z0-9]+");
        public final static Pattern ENTER_MENU = Pattern.compile("menu enter \\S+");
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern EXIT = Pattern.compile("Exit");
    }



    public static class MainControllerStrings
    {
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern ENTER_MENU = Pattern.compile("menu enter \\S+");
        public final static Pattern ENTER_PROFILE_MENU = Pattern.compile("menu enter Profile");
        public final static Pattern EXIT = Pattern.compile("menu exit");
        public final static Pattern LOGOUT = Pattern.compile("user logout");
        public final static Pattern PLAY_2_PLAYER_GAME = Pattern.compile("play game (((-(-?)player1)|(-(-?)p1)) [a-zA-Z0-9]+) (((-(-?)player2)|(-(-?)p2)) [a-zA-Z0-9]+)");
        public final static Pattern PLAY_3_PLAYER_GAME = Pattern.compile("play game (((-(-?)player1)|(-(-?)p1)) [a-zA-Z0-9]+) (((-(-?)player2)|(-(-?)p2)) [a-zA-Z0-9]+) (((-(-?)player3)|(-(-?)p3)) [a-zA-Z0-9]+)");
        public final static Pattern PLAY_4_PLAYER_GAME = Pattern.compile("play game (((-(-?)player1)|(-(-?)p1)) [a-zA-Z0-9]+) (((-(-?)player2)|(-(-?)p2)) [a-zA-Z0-9]+) (((-(-?)player3)|(-(-?)p3)) [a-zA-Z0-9]+) (((-(-?)player4)|(-(-?)p4)) [a-zA-Z0-9]+)");
        public final static Pattern PLAY_5_PLAYER_GAME = Pattern.compile("play game (((-(-?)player1)|(-(-?)p1)) [a-zA-Z0-9]+) (((-(-?)player2)|(-(-?)p2)) [a-zA-Z0-9]+) (((-(-?)player3)|(-(-?)p3)) [a-zA-Z0-9]+) (((-(-?)player4)|(-(-?)p4)) [a-zA-Z0-9]+) (((-(-?)player5)|(-(-?)p5)) [a-zA-Z0-9]+)");
        public final static Pattern PLAY_6_PLAYER_GAME = Pattern.compile("play game (((-(-?)player1)|(-(-?)p1)) [a-zA-Z0-9]+) (((-(-?)player2)|(-(-?)p2)) [a-zA-Z0-9]+) (((-(-?)player3)|(-(-?)p3)) [a-zA-Z0-9]+) (((-(-?)player4)|(-(-?)p4)) [a-zA-Z0-9]+) (((-(-?)player5)|(-(-?)p5)) [a-zA-Z0-9]+) (((-(-?)player6)|(-(-?)p6)) [a-zA-Z0-9]+)");
        public final static Pattern PLAY_7_PLAYER_GAME = Pattern.compile("play game (((-(-?)player1)|(-(-?)p1)) [a-zA-Z0-9]+) (((-(-?)player2)|(-(-?)p2)) [a-zA-Z0-9]+) (((-(-?)player3)|(-(-?)p3)) [a-zA-Z0-9]+) (((-(-?)player4)|(-(-?)p4)) [a-zA-Z0-9]+) (((-(-?)player5)|(-(-?)p5)) [a-zA-Z0-9]+) (((-(-?)player5)|(-(-?)p5)) [a-zA-Z0-9]+) (((-(-?)player7)|(-(-?)p7)) [a-zA-Z0-9]+)");
        public final static Pattern PLAY_8_PLAYER_GAME = Pattern.compile("play game (((-(-?)player1)|(-(-?)p1)) [a-zA-Z0-9]+) (((-(-?)player2)|(-(-?)p2)) [a-zA-Z0-9]+) (((-(-?)player3)|(-(-?)p3)) [a-zA-Z0-9]+) (((-(-?)player4)|(-(-?)p4)) [a-zA-Z0-9]+) (((-(-?)player5)|(-(-?)p5)) [a-zA-Z0-9]+) (((-(-?)player5)|(-(-?)p5)) [a-zA-Z0-9]+) (((-(-?)player7)|(-(-?)p7)) [a-zA-Z0-9]+) (((-(-?)player8)|(-(-?)p8)) [a-zA-Z0-9]+)");
        public final static Pattern PLAYER = Pattern.compile("(-(-?)player[1-8] [a-zA-Z0-9]+)");
    }



    public static class ProfileControllerStrings
    {
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern ENTER_MENU = Pattern.compile("menu enter \\S+");
        public final static Pattern EXIT = Pattern.compile("menu exit");
        public final static Pattern CHANGE_NICKNAME = Pattern.compile("profile change ((-(-?)nickname)|(-(-?)n)) (\\w)+");
        public final static Pattern CHANGE_PASSWORD1 = Pattern.compile("profile change ((-(-?)password)|(-(-?)p)) ((-(-?)current)|(-(-?)c)) [a-zA-Z0-9]+ ((-(-?)new)|(-(-?)n)) [a-zA-Z0-9]+");
        public final static Pattern CHANGE_PASSWORD2 = Pattern.compile("profile change ((-(-?)password)|(-(-?)p)) ((-(-?)new)|(-(-?)n)) [a-zA-Z0-9]+ ((-(-?)current)|(-(-?)c)) [a-zA-Z0-9]+");
        public final static Pattern CHANGE_PASSWORD3 = Pattern.compile("profile change ((-(-?)current)|(-(-?)c)) [a-zA-Z0-9]+ ((-(-?)password)|(-(-?)p)) ((-(-?)new)|(-(-?)n)) [a-zA-Z0-9]+");
        public final static Pattern CHANGE_PASSWORD4 = Pattern.compile("profile change ((-(-?)current)|(-(-?)c)) [a-zA-Z0-9]+ ((-(-?)new)|(-(-?)n)) [a-zA-Z0-9]+ ((-(-?)password)|(-(-?)p))");
        public final static Pattern CHANGE_PASSWORD5 = Pattern.compile("profile change ((-(-?)new)|(-(-?)n)) [a-zA-Z0-9]+ ((-(-?)password)|(-(-?)p)) ((-(-?)current)|(-(-?)c)) [a-zA-Z0-9]+");
        public final static Pattern CHANGE_PASSWORD6 = Pattern.compile("profile change ((-(-?)new)|(-(-?)n)) [a-zA-Z0-9]+ ((-(-?)current)|(-(-?)c)) [a-zA-Z0-9]+ ((-(-?)password)|(-(-?)p))");
        public final static Pattern CURRENT_PASSWORD = Pattern.compile("((-(-?)current)|(-(-?)c)) [a-zA-Z0-9]+");
        public final static Pattern NEW_PASSWORD = Pattern.compile("((-(-?)new)|(-(-?)n)) [a-zA-Z0-9]+");
    }



    public static class PlayerControllerStrings
    {
        public final static Pattern ENTER_SECTION = Pattern.compile("enter -(-?)(section|s) \\S+");
        public final static Pattern MINIMAP = Pattern.compile("minimap");
    }
}
