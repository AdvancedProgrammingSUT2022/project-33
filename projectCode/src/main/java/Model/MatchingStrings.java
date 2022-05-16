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
        public final static Pattern END_TURN = Pattern.compile("end turn");
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern SHOW_HAPPINESS = Pattern.compile("show happiness");
        public final static Pattern ADD_HAPPINESS_CHEAT = Pattern.compile("clown attack");
        public final static Pattern GOLD_SECTION = Pattern.compile("gold_box");
        public final static Pattern TECHNOLOGY_TREE = Pattern.compile("technology_tree");
        public final static Pattern DIPLOMACY_SECTION = Pattern.compile("diplomacy");
        //TODO:
    }



    public static class TechnologyTreeStrings
    {
        public final static Pattern SHOW_TECHNOLOGIES = Pattern.compile("show technologies");
        public final static Pattern DISCOVERED_TECHNOLOGIES = Pattern.compile(" -(-?)(discovered|d)");
        public final static Pattern DISCOVERED_TECHNOLOGIES_FLAG = Pattern.compile("( -(-?)(discovered|d))?");
        public final static Pattern AVAILABLE_TECHNOLOGIES = Pattern.compile(" -(-?)(available|a)");
        public final static Pattern AVAILABLE_TECHNOLOGIES_FLAG = Pattern.compile("( -(-?)(available|a))?");
        public final static Pattern UNAVAILABLE_TECHNOLOGIES = Pattern.compile(" -(-?)(unavailable|u)");
        public final static Pattern UNAVAILABLE_TECHNOLOGIES_FLAG = Pattern.compile("( -(-?)(unavailable|u))?");
        public final static Pattern SHOW_CURRENT_RESEARCH = Pattern.compile("show current research");
        public final static Pattern START_RESEARCH = Pattern.compile("research \\S+( \\S+)?( \\S+)?");
        public final static Pattern FINISH_RESEARCH_CHEAT = Pattern.compile("is research over\\?");
        public final static Pattern GET_RESEARCH_CHEAT = Pattern.compile("new discovery \\S+( \\S+)?( \\S+)?");
        public final static Pattern RESEARCH_ALL_CHEAT = Pattern.compile("MegaMind");
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern BACK = Pattern.compile("back");
    }



    public static class GoldBoxStrings
    {
        public final static Pattern SHOW_GOLD = Pattern.compile("show gold");
        public final static Pattern SHOW_GOLD_INCOME = Pattern.compile("show gold income");
        public final static Pattern ADD_POCKET_OF_GOLD_CHEAT = Pattern.compile("is that a coin");
        public final static Pattern ADD_CHEST_OF_GOLD_CHEAT = Pattern.compile("is that a treasure chest");
        public final static Pattern BACK = Pattern.compile("back");
    }



    public static class DiplomacyStrings
    {
        public final static Pattern BACK = Pattern.compile("back");
    }



    public static class MinimapControllerStrings
    {
        public final static Pattern SHOW_MAP = Pattern.compile("show map");
        public final static Pattern SHOW_MAP_ZOOMED1 = Pattern.compile("show zoomed map (-(-?)(start|s) (\\d+)) (-(-?)(end|e) (\\d+))");
        public final static Pattern SHOW_MAP_ZOOMED2 = Pattern.compile("show zoomed map (-(-?)(end|e) (\\d+)) (-(-?)(start|s) (\\d+))");
        public final static Pattern STARTING_POINT = Pattern.compile("-(-?)(start|s) (\\d+)");
        public final static Pattern ENDING_POINT = Pattern.compile("-(-?)(start|s) (\\d+)");
        public final static Pattern SHOW_UNITS = Pattern.compile("show units -(-?)(type|t) (military|worker|settler)");
        public final static Pattern UNIT_TYPE = Pattern.compile("-(-?)(type|t) (military|worker|settler)");
        public final static Pattern MOVE_POINT = Pattern.compile(" -(-?)(move_point|mp)");
        public final static Pattern MOVE_POINT_FLAG = Pattern.compile("( -(-?)(move_point|mp))?");
        public final static Pattern HEALTH = Pattern.compile(" -(-?)(health|h)");
        public final static Pattern HEALTH_FLAG = Pattern.compile("( -(-?)(health|h))?");
        public final static Pattern ATTACK_DAMAGE = Pattern.compile(" -(-?)(attack_damage|ad)");
        public final static Pattern ATTACK_DAMAGE_FLAG = Pattern.compile("(( -(-?)(attack_damage|ad))?)");
        public final static Pattern DEFENCE = Pattern.compile(" -(-?)(defence|d)");
        public final static Pattern DEFENCE_FLAG = Pattern.compile("(( -(-?)(defence|d))?)");
        public final static Pattern BACK = Pattern.compile("back");
        public final static Pattern SHOW_CITIES = Pattern.compile("show cities");
        public final static Pattern POPULATION = Pattern.compile(" -(-?)(population|p)");
        public final static Pattern POPULATION_FLAG = Pattern.compile("( -(-?)(population|p))?");
        public final static Pattern GOLD = Pattern.compile(" -(-?)(gold|g)");
        public final static Pattern GOLD_FLAG = Pattern.compile("( -(-?)(gold|g))?");
        public final static Pattern HAPPINESS = Pattern.compile(" -(-?)(happiness|h)");
        public final static Pattern HAPPINESS_FLAG = Pattern.compile("( -(-?)(happiness|h))?");
        public final static Pattern TASK = Pattern.compile(" -(-?)(task|t)");
        public final static Pattern TASK_FLAG = Pattern.compile("( -(-?)(task|t))?");
        public final static Pattern LANDS = Pattern.compile(" -(-?)(lands|l)");
        public final static Pattern LANDS_FLAG = Pattern.compile("( -(-?)(lands|l))?");
        public final static Pattern MANAGE_UNIT1 = Pattern.compile("manage unit -(-?)x \\d+ -(-?)y \\d+");
        public final static Pattern MANAGE_UNIT2 = Pattern.compile("manage unit -(-?)y \\d+ -(-?)x \\d+");
        public final static Pattern MANAGE_MILITARY_UNIT1 = Pattern.compile("manage military unit -(-?)y \\d+ -(-?)x \\d+");
        public final static Pattern MANAGE_MILITARY_UNIT2 = Pattern.compile("manage military unit -(-?)x \\d+ -(-?)y \\d+");
        public final static Pattern MANAGE_CITY_NAME = Pattern.compile("manage city -(-?)(name|n) [a-zA-Z_0-9 ]+");
        public final static Pattern MANAGE_CITI_NAME_KNOWN_PART = Pattern.compile("manage city -(-?)(name|n) ");
        public final static Pattern MANAGE_CITY1 = Pattern.compile("manage city -(-?)x \\d+ -(-?)y \\d+");
        public final static Pattern MANAGE_CITY2 = Pattern.compile("manage city -(-?)y \\d+ -(-?)x \\d+");
        public final static Pattern X_VALUE = Pattern.compile("-(-?)x \\d+");
        public final static Pattern Y_VALUE = Pattern.compile("-(-?)y \\d+");
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
    }



    public static class CityControllerStrings
    {
        public final static Pattern STATS = Pattern.compile("show stats");
        public final static Pattern SHOW_CITIZENS = Pattern.compile("show citizens");
        public final static Pattern ADD_CITIZEN_CHEAT = Pattern.compile("where did it come from");
        public final static Pattern ASSIGN_WORK_BUILDING = Pattern.compile("assign work -(-?)(building|b)( \\S+)+");
        public final static Pattern ASSIGN_WORK_LAND1 = Pattern.compile("assign work -(-?)x \\d+ -(-?)y \\d+");
        public final static Pattern ASSIGN_WORK_LAND2 = Pattern.compile("assign work -(-?)y \\d+ -(-?)x \\d+");
        public final static Pattern BUILDING = Pattern.compile("-(-?)(building|b)( \\S+)+");
        public final static Pattern X_VALUE = Pattern.compile("-(-?)x \\d+");
        public final static Pattern Y_VALUE = Pattern.compile("-(-?)y \\d+");
        public final static Pattern FIRE_CITIZEN_BUILDING = Pattern.compile("fire citizen -(-?)(building|b)( \\S+)+");
        public final static Pattern FIRE_CITIZEN_LAND1 = Pattern.compile("fire citizen -(-?)x \\d+ -(-?)y \\d+");
        public final static Pattern FIRE_CITIZEN_LAND2 = Pattern.compile("fire citizen -(-?)y \\d+ -(-?)x \\d+");
        public final static Pattern SHOW_BUILDINGS = Pattern.compile("show buildings");
        public final static Pattern BUILT_BUILDINGS_FLAG = Pattern.compile("( -(-?)(built|b))?");
        public final static Pattern BUILT_BUILDINGS = Pattern.compile(" -(-?)(built|b)");
        public final static Pattern AVAILABLE_FLAG = Pattern.compile("( -(-?)(available|a))?");
        public final static Pattern AVAILABLE = Pattern.compile(" -(-?)(available|a)");
        public final static Pattern UNAVAILABLE = Pattern.compile(" -(-?)(unavailable|u)");
        public final static Pattern UNAVAILABLE_FLAG = Pattern.compile("( -(-?)(unavailable|u))?");
        public final static Pattern SHOW_WONDERS = Pattern.compile("show wonders");
        public final static Pattern SHOW_LANDS = Pattern.compile("show lands");
        public final static Pattern START_TASK_UNIT = Pattern.compile("make( \\S+)+");
        public final static Pattern START_TASK_BUILDING = Pattern.compile("build -(-?)(building|b)( \\S+)+");
        public final static Pattern START_TASK_Wonder = Pattern.compile("build -(-?)(wonder|w)( \\S+)+");
        public final static Pattern WONDER = Pattern.compile("-(-?)(wonder|w)( \\S+)+");
        public final static Pattern FOOD_FOCUS = Pattern.compile("produce food");
        public final static Pattern PRODUCTION_FOCUS = Pattern.compile("produce production");
        public final static Pattern GOLD_FOCUS = Pattern.compile("produce gold");
        public final static Pattern TASK_FINISHING_CHEAT = Pattern.compile("but i want it");
        public final static Pattern PURCHASE_BUILDING = Pattern.compile("purchase -(-?)(building|b)( \\S+)+");
        public final static Pattern BUILDING_CHEAT = Pattern.compile("place it right over there( \\S+)+");
        public final static Pattern PURCHASE_UNIT = Pattern.compile("purchase -(-?)(unit|u)( \\S+)+");
        public final static Pattern UNIT = Pattern.compile("-(-?)(unit|u)( \\S+)+");
        public final static Pattern X_VALUE_SPACE = Pattern.compile(" -(-?)x \\d+");
        public final static Pattern Y_VALUE_SPACE = Pattern.compile(" -(-?)y \\d+");
        public final static Pattern PURCHASE_TILE = Pattern.compile("purchase");
        public final static Pattern TILE = Pattern.compile(" -(-?)(tile|t)");
        public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        public final static Pattern BACK = Pattern.compile("back");
    }



    public static class UnitsControllerStrings
    {
        public static class Settler
        {
            public final static Pattern SHOW_STATS = Pattern.compile("show stats");
            public final static Pattern MOVE_UNIT1 = Pattern.compile("move to -x \\d+ -y \\d+");
            public final static Pattern MOVE_UNIT2 = Pattern.compile("move to -y \\d+ -x \\d+");
            public final static Pattern FINISH = Pattern.compile("finish");
            public final static Pattern X_VALUE = Pattern.compile("-x \\d+");
            public final static Pattern Y_VALUE = Pattern.compile("-y \\d+");
            public final static Pattern CREATE_CITY =  Pattern.compile("create city");
            public final static Pattern CANCEL = Pattern.compile("cancel");
            public final static Pattern VALID_CITY_NAME = Pattern.compile("[a-zA-Z_0-9 ]+");
            public final static Pattern REMOVE_UNIT = Pattern.compile("remove unit");
            public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
        }



        public static class MeleeUnitStrings
        {
            public final static Pattern SHOW_STATS = Pattern.compile("show stats");
            public final static Pattern MOVE_UNIT1 = Pattern.compile("move to -x \\d+ -y \\d+");
            public final static Pattern MOVE_UNIT2 = Pattern.compile("move to -y \\d+ -x \\d+");
            public final static Pattern X_VALUE = Pattern.compile("-x \\d+");
            public final static Pattern Y_VALUE = Pattern.compile("-y \\d+");
            public final static Pattern CANCEL = Pattern.compile("cancel");
            public final static Pattern REMOVE_UNIT = Pattern.compile("remove unit");
            public final static Pattern SHOW_MENU = Pattern.compile("menu show-current");
            public final static Pattern FINISH = Pattern.compile("finish");
        }
    }
}
