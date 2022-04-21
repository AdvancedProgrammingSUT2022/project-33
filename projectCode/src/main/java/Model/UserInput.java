package Model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);




    ////methods////
    public static String getInput()
    {
        return scanner.nextLine();
    }



    public static String removeSpaces(String input)
    {
        Matcher spaceMatcher = Pattern.compile("\\s(\\s+)").matcher(input);

        while (spaceMatcher.find()){
            input = input.substring(0, spaceMatcher.start()) + input.substring(spaceMatcher.end());
            spaceMatcher = Pattern.compile("\\s(\\s+)").matcher(input);
        }

        return input;
    }
}
