package Program.Model;

public class SpecialPerson {
    private String gameName;
    private int gold;
    private int science;
    private int happiness;





    ////methods////
    public SpecialPerson(String gameName, int gold, int science, int happiness)
    {
        this.gameName = gameName;
        this.gold = gold;
        this.science = science;
        this.happiness = happiness;
    }



    //getters
    public String getGameName() {
        return gameName;
    }


    public int getGold() {
        return gold;
    }


    public int getScience() {
        return science;
    }


    public int getHappiness() {
        return happiness;
    }
}
