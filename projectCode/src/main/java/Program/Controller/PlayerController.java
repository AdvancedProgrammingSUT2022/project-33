package Program.Controller;

import Program.Model.Models.MatchingStrings;
import Program.Model.Models.Player;
import Program.Model.Models.UserInput;
import Program.View.PlayerView;

public class PlayerController {
    private Player player;
    private PlayerView view;





    ////methods////
    public void initializeController(Player player, PlayerView view)
    {
        this.player = player;
        this.view = view;
    }
}
