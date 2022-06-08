package Program.Controller;

import Program.Model.Models.MatchingStrings;
import Program.Model.Models.Player;
import Program.Model.Enums.Technologies;
import Program.Model.Models.UserInput;
import Program.View.TechnologyTreeView;

import java.util.ArrayList;
import java.util.Arrays;

public class TechnologyTreeController {
    private Player player;
    private TechnologyTreeView view;






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
                getResearchAndStart(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.TechnologyTreeStrings.GET_RESEARCH_CHEAT)){
                researchCheatTechnology(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.TechnologyTreeStrings.RESEARCH_ALL_CHEAT)){
                researchAll();
            }
            else if (UserInput.doesMatch(input, MatchingStrings.TechnologyTreeStrings.FINISH_RESEARCH_CHEAT)){
                finishResearch();
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



    private void getResearchAndStart(String input)
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
        if (player.getTechnologies().contains(technology)){
            view.showDuplicatedResearch();
            return;
        }

        if (!canResearchTechnology(technology)){
            view.showInvalidResearch(technology);
            return;
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



    private void researchCheatTechnology(String input)
    {
        Technologies technology = getResearchFromInput(input);

        if (technology == null){
            view.showInvalidTechnology();
            return;
        }

        if (player.getTechnologies().contains(technology)){
            view.showDuplicatedResearch();
            return;
        }

        addCheatTechnology(technology);
        view.showTechnologyDiscovered(technology);
    }



    private Technologies getResearchFromInput(String input)
    {
        for (int i = 0; i < input.length(); i++){
            String temporarilyString = input.substring(i);

            for (int k = 0; k < Technologies.values().length; k++){
                if (temporarilyString.equalsIgnoreCase(Technologies.values()[k].technology.getGameName())){
                    return Technologies.values()[k];
                }
            }
        }

        view.showInvalidTechnology();
        return null;
    }



    private void addCheatTechnology(Technologies technology){
        for (int i = 0; i < technology.technology.getNeededTechnologies().size(); i++){
            if (!player.getTechnologies().contains(technology.technology.getNeededTechnologies().get(i))){
                addCheatTechnology(technology.technology.getNeededTechnologies().get(i));
            }
        }

        player.addTechnology(technology);
    }



    private void researchAll()
    {
        for (int i = 0; i < Technologies.values().length; i++){
            if (!player.getTechnologies().contains(Technologies.values()[i])){
                player.addTechnology(Technologies.values()[i]);
                view.showTechnologyDiscoveredForAllCheat(Technologies.values()[i]);
            }
        }

        view.showAllTechnologiesDiscovered();
    }



    private void finishResearch()
    {
        if (!player.isResearching()){
            view.showNoResearch();
            return;
        }

        player.addTechnology(player.getResearch());
        player.setResearching(false);
        view.showTechnologyDiscovered(player.getResearch());
    }
}
