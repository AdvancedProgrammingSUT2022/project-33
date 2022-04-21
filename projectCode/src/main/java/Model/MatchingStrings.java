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
        public final static Pattern ENTER_MENU = Pattern.compile("menu enter \\S");
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern EXIT = Pattern.compile("Exit");
    }
}
