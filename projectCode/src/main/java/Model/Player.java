package Model;

public class Player {
    String nickname;
    Colors color;
    MiniMap map;





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
}
