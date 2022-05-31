package Program.View;

import Program.Model.Player;
import Program.Model.Technologies;

import java.util.ArrayList;

public class TechnologyTreeView {






    ////methods////
    public TechnologyTreeView()
    {
        System.out.println("you are now in technology tree section");
    }



    public void showCurrentMenu()
    {
        System.out.println("technology tree");
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showTechnologies(Player player, boolean discoveredFlag, boolean availableFlag, boolean unavailableFlag)
    {
        if (discoveredFlag || availableFlag || unavailableFlag){
            if (discoveredFlag){
                showDiscoveredTechnologies(player.getTechnologies());
            }

            if (availableFlag){
                showAvailableTechnologies(player.getTechnologies(), player.getResearchPerTurn());
            }

            if (unavailableFlag){
                showUnavailableTechnologies(player.getTechnologies());
            }
        }
        else {
            showDiscoveredTechnologies(player.getTechnologies());
            showAvailableTechnologies(player.getTechnologies(), player.getResearchPerTurn());
            showUnavailableTechnologies(player.getTechnologies());
        }
    }



    private void showDiscoveredTechnologies(ArrayList<Technologies> playerTechnologies)
    {
        System.out.println("discovered technologies: ");

        for (int i = 0; i < playerTechnologies.size(); i++){
            System.out.print((i + 1) + ") " + playerTechnologies.get(i).technology.getGameName() + ": era:" + playerTechnologies.get(i).technology.getEra());
            System.out.print(", leads to:");

            for (int k = 0; k < Technologies.values().length; k++){
                if (Technologies.values()[k].technology.getNeededTechnologies().contains(playerTechnologies.get(i))){
                    System.out.print(" " + Technologies.values()[k].technology.getGameName());
                }
            }

            System.out.println();
        }
    }



    private void showAvailableTechnologies(ArrayList<Technologies> playerTechnologies, int researchPerTurn)
    {
        System.out.println("available technologies: ");

        ArrayList<Technologies> availableTechnologies = getAvailableTechnologies(playerTechnologies);

        for (int i = 0; i < availableTechnologies.size(); i++){
            if (researchPerTurn != 0) {
                System.out.print((i + 1) + ") " + availableTechnologies.get(i).technology.getGameName() +
                        ", turns needed: " + availableTechnologies.get(i).technology.getResearchCost() / researchPerTurn +
                        ",  era:" + availableTechnologies.get(i).technology.getEra());
            }
            else {
                System.out.print((i + 1) + ") " + availableTechnologies.get(i).technology.getGameName() +
                        ", turns needed: " + "-" +
                        ", era: " + availableTechnologies.get(i).technology.getEra());
            }

            System.out.print(", leads to:");

            for (int k = 0; k < Technologies.values().length; k++){
                if (Technologies.values()[k].technology.getNeededTechnologies().contains(availableTechnologies.get(i))){
                    System.out.print(" " + Technologies.values()[k].technology.getGameName());
                }
            }

            System.out.println();
        }
    }



    private void showUnavailableTechnologies(ArrayList<Technologies> playerTechnologies)
    {
        System.out.println("unavailable technologies: ");

        ArrayList<Technologies> unavailableTechnologies = getUnavailableTechnologies(playerTechnologies);

        for (int i = 0; i < unavailableTechnologies.size(); i++){
            System.out.print((i + 1) + ") " + unavailableTechnologies.get(i).technology.getGameName() +
                    ", era: " + unavailableTechnologies.get(i).technology.getEra());

            System.out.print(" technologies needed: ");

            for (int k = 0; k < unavailableTechnologies.get(i).technology.getNeededTechnologies().size(); k++){
                System.out.print(" " + unavailableTechnologies.get(i).technology.getNeededTechnologies().get(k).technology.getGameName());
            }

            System.out.print(", leads to:");

            for (int k = 0; k < Technologies.values().length; k++){
                if (Technologies.values()[k].technology.getNeededTechnologies().contains(unavailableTechnologies.get(i))){
                    System.out.print(" " + Technologies.values()[k].technology.getGameName());
                }
            }

            System.out.println();
        }
    }



    private ArrayList<Technologies> getAvailableTechnologies(ArrayList<Technologies> playerTechnologies)
    {
        ArrayList<Technologies> availableTechnologies = new ArrayList<>();

        for (int i = 0; i < Technologies.values().length; i++){
            if (!playerTechnologies.contains(Technologies.values()[i])){
                boolean isAvailable = true;

                for (int k = 0; k < Technologies.values()[i].technology.getNeededTechnologies().size(); k++){
                    if (!playerTechnologies.contains(Technologies.values()[i].technology.getNeededTechnologies().get(k))){
                        isAvailable = false;
                        break;
                    }
                }

                if (isAvailable){
                    availableTechnologies.add(Technologies.values()[i]);
                }
            }
        }

        return availableTechnologies;
    }



    private ArrayList<Technologies> getUnavailableTechnologies(ArrayList<Technologies> playerTechnologies)
    {
        ArrayList<Technologies> unavailableTechnologies = new ArrayList<>();
        ArrayList<Technologies> availableTechnologies = getAvailableTechnologies(playerTechnologies);

        for (int i = 0; i < Technologies.values().length; i++){
            if (!availableTechnologies.contains(Technologies.values()[i]) && !playerTechnologies.contains(Technologies.values()[i])){
                unavailableTechnologies.add(Technologies.values()[i]);
            }
        }

        return unavailableTechnologies;
    }



    public void showResearch(Player player)
    {
        if (player.isResearching()){
            System.out.print("current research: " + player.getResearch().technology.getGameName());
            System.out.print(" research progress: " + (player.getResearchProgress() / player.getResearch().technology.getResearchCost()) + "%");
            System.out.println(" time remaining: " +
                    ((player.getResearch().technology.getResearchCost() - player.getResearchProgress()) / player.getResearchPerTurn()) + " turns");
        }
        else {
            System.out.println("you are not working on any research right now");
        }
    }



    public void showInvalidTechnology()
    {
        System.out.println("invalid technology");
        System.out.println("please enter a valid technology and try again");
        System.out.println("technologies:");

        for (int i = 0; i < Technologies.values().length; i++){
            System.out.println((i + 1) + ") " + Technologies.values()[i].technology.getGameName());
        }
    }



    public void showInvalidResearch(Technologies technology)
    {
        System.out.println("you don't have the required technologies to research this technology");

        System.out.print("first research " + technology.technology.getNeededTechnologies().get(0));

        if (technology.technology.getNeededTechnologies().size() > 1){
            for (int i = 1; i < technology.technology.getNeededTechnologies().size(); i++){
                System.out.print(" and " +  technology.technology.getNeededTechnologies().get(i));
            }
        }

        System.out.println();
    }



    public void showAlreadyResearchingMessage(Technologies researchingTechnology)
    {
        System.out.println("you are already researching (" + researchingTechnology.technology.getGameName() + ")");
        System.out.println("are you sure you want to cancel it?");
    }



    public void showInvalidConfirmationCommand()
    {
        System.out.println("invalid command");
        System.out.println("please choose (yes) to start new research and (no) to continue last research");
    }



    public void showStartingResearch(Player player, Technologies technology)
    {
        System.out.println("starting new research: " + technology.technology.getGameName());

        if (player.getResearchPerTurn() != 0) {
            System.out.println("estimated time: " + technology.technology.getResearchCost() / player.getResearchPerTurn() + " turn");
        }
        else {
            System.out.println("this research will not finish with current research income");
        }
    }



    public void showDuplicatedResearch()
    {
        System.out.println("you have already discovered this technology");
    }



    public void showTechnologyDiscovered(Technologies technology)
    {
        System.out.println(technology.technology.getGameName() + " has been discovered");
    }



    public void showTechnologyDiscoveredForAllCheat(Technologies technology)
    {

        for (int i = 0; i < 20; i ++){
            try {
                Thread.sleep(35);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            System.out.print("■");
        }

        try {
            Thread.sleep(80);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println();
        System.out.println(technology.technology.getGameName() + " has been discovered");
    }



    public void showAllTechnologiesDiscovered()
    {
        System.out.println();
        System.out.println("⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎");
        System.out.println("all technologies has been discovered");
        System.out.println("⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎⟎");
        System.out.println();
    }



    public void showNoResearch()
    {
        System.out.println("you are not researching anything");
    }
}
