package Program.Model.Models;

import java.util.ArrayList;
import java.util.Random;

public class UselessTips {
    private ArrayList<String> tips;





    ////methods////
    public UselessTips()
    {
        tips = new ArrayList<>();

        tips.add("you are looking at a loading screen!");
        tips.add("you can select objects on the map by selecting them");
        tips.add("units can be moved");
        tips.add("if you die, you die!");
        tips.add("population of a city need food to survive!");
        //TODO: fixing tips and adding new tips.
    }



    //getters
    public String getRandomTip()
    {
        Random rand = new Random();
        int tipIndex = rand.nextInt(tips.size() - 1);
        return tips.get(tipIndex);
    }
}
