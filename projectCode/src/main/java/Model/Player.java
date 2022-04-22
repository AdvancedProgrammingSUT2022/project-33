package Model;

public class Player {
    String nickname;
    Colors color;





    ////methods////
    public Player(String nickname, int numberOfPlayer)
    {
        this.nickname = nickname;
        this.color = Colors.values()[numberOfPlayer];
    }
}
