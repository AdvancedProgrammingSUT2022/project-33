package Controller;

import Model.MatchingStrings;
import Model.Player;
import Model.Technologies;
import Model.UserInput;
import View.TechnologyTreeView;

import java.util.ArrayList;
import java.util.Arrays;

public class TechnologyTreeController {
    Player player;
    TechnologyTreeView view;






    ////methods////
    public TechnologyTreeController(Player player)
    {
        this.player = player;
        view = new TechnologyTreeView();

        run();
    }



    private void run()
    {
        while (true)
        {
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatchMultipleRegex(input, MatchingStrings.TechnologyTreeStrings.SHOW_TECHNOLOGIES.toString(),
                    new ArrayList<>(Arrays.asList(MatchingStrings.TechnologyTreeStrings.DISCOVERED_TECHNOLOGIES_FLAG,
                            MatchingStrings.TechnologyTreeStrings.AVAILABLE_TECHNOLOGIES_FLAG,
                            MatchingStrings.TechnologyTreeStrings.UNAVAILABLE_TECHNOLOGIES_FLAG)))){
                showTechnologies(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.TechnologyTreeStrings.SHOW_MENU)){
                view.showCurrentMenu();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.TechnologyTreeStrings.SHOW_CURRENT_RESEARCH)){
                view.showResearch(player);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.TechnologyTreeStrings.START_RESEARCH)){
                getResearch(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.TechnologyTreeStrings.BACK)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }

    }


    private void showTechnologies(String input)
    {
        boolean discoveredFlag = MatchingStrings.TechnologyTreeStrings.DISCOVERED_TECHNOLOGIES.matcher(input).find();
        boolean availableFlag = MatchingStrings.TechnologyTreeStrings.AVAILABLE_TECHNOLOGIES.matcher(input).find();
        boolean unavailableFlag = MatchingStrings.TechnologyTreeStrings.UNAVAILABLE_TECHNOLOGIES.matcher(input).find();

        view.showTechnologies(player, discoveredFlag, availableFlag, unavailableFlag);
    }



    private void getResearch(String input)
    {
        String technologyString = input.substring(9);

        for (int i = 0; i < Technologies.values().length; i++){
            if (technologyString.equalsIgnoreCase(Technologies.values()[i].technology.getGameName())){
                startResearch(Technologies.values()[i]);
                return;
            }
        }

        view.showInvalidTechnology();
    }



    private void startResearch(Technologies technology)
    {
        if (!canResearchTechnology(technology)){
            view.showInvalidResearch(technology);
        }

        if (player.isResearching()){
            if (!getConfirmation()){
                return;
            }
        }

        player.setResearching(true);
        player.setResearch(technology);
        player.setResearchProgress(0);
        view.showStartingResearch(player, technology);
    }



    private boolean canResearchTechnology(Technologies technology)
    {
        for (int i = 0; i < technology.technology.getNeededTechnologies().size(); i++){
            if (!player.getTechnologies().contains(technology.technology.getNeededTechnologies().get(i))){
                return false;
            }
        }

        return true;
    }



    private boolean getConfirmation()
    {
        view.showAlreadyResearchingMessage(player.getResearch());

        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (input.equalsIgnoreCase("yes")){
                return true;
            }
            else if (input.equalsIgnoreCase("no")){
                return false;
            }
            else {
                view.showInvalidConfirmationCommand();
            }
        }
    }
}
