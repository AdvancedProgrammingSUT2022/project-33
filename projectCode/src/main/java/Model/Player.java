package Model;

public class Player {
    private String nickname;
    private Colors color;
    private MiniMap map;





    ////methods////
    public Player(String nickname, int numberOfPlayer)
    {
        this.nickname = nickname;
        this.color = Colors.values()[numberOfPlayer];
    }



    //setters
    public void setMap(MiniMap map)
    {
        this.map = map;
    }



    //getters
    public String getNickname() {
        return nickname;
    }


    public Colors getColor() {
        return color;
    }


    public MiniMap getMap() {
        return map;
    }
}
