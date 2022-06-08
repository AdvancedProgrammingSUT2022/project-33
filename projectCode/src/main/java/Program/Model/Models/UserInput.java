package Program.Model.Models;

import java.util.ArrayList;
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
            input = input.substring(0, spaceMatcher.start()) + " " + input.substring(spaceMatcher.end());
            spaceMatcher = Pattern.compile("\\s(\\s+)").matcher(input);
        }

        return input;
    }



    public static boolean doesMatch(String input, Pattern pattern)
    {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }



    public static String getMatchingStringGroupFromInput(String input, Pattern searchingPattern)
    {
        Matcher matcher = searchingPattern.matcher(input);

        if (matcher.find()){
            return matcher.group();
        }

        return "";
    }



    public static boolean doesMatchMultipleRegex(String input, String base,  ArrayList<Pattern> patterns)
    {
        ArrayList<Pattern> finalPatterns = new ArrayList<>();
        combinePatterns(patterns, base, finalPatterns);

        for (int i = 0; i < finalPatterns.size(); i++){
            if (doesMatch(input, finalPatterns.get(i))){
                return true;
            }
        }

        return false;
    }



    private static void combinePatterns(ArrayList<Pattern> patterns, String pattern, ArrayList<Pattern> finalPatterns)
    {
        for (int i = 0; i < patterns.size(); i++){
            ArrayList<Pattern> patternsCopy = new ArrayList<>(patterns);
            String newPattern = pattern + patternsCopy.get(i).toString();
            patternsCopy.remove(i);
            combinePatterns(patternsCopy, newPattern, finalPatterns);
        }

        if (patterns.size() != 0){
            return;
        }

        for (int i = 0; i < finalPatterns.size(); i++){
            if (finalPatterns.get(i).toString().equals(pattern)){
                return;
            }
        }

        finalPatterns.add(Pattern.compile(pattern));
    }



    public static String getSpecificInputFromPatternWithOneSpace(String input, Pattern pattern)
    {
        String[] inputGroup = getMatchingStringGroupFromInput(input, pattern).split(" ");
        String output = "";

        for (int i = 1; i < inputGroup.length; i++){
            output += " " +inputGroup[i];
        }

        output = output.substring(1);
        return output;
    }
}
