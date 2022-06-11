package Program.Controller;

import Program.Model.Models.MatchingStrings;
import Program.Model.Models.Player;
import Program.Model.Models.UserInput;
import Program.View.PlayerView;
import javafx.scene.input.MouseEvent;

public class PlayerController {
    private Player player;
    private PlayerView view;





    ////methods////
    public void initializeController(Player player, PlayerView view)
    {
        this.player = player;
        this.view = view;
    }



    public void showScienceTip(MouseEvent mouseEvent)
    {
        view.showScienceTip();
    }



    public void closeScienceTip(MouseEvent mouseEvent)
    {
        view.closeScienceTip();
    }



    public void showGoldTip(MouseEvent mouseEvent)
    {
        view.showGoldTip();
    }



    public void closeGoldTip(MouseEvent mouseEvent)
    {
        view.closeGoldTip();
    }



    public void showHappinessTip(MouseEvent mouseEvent)
    {
        view.showHappinessTip();
    }



    public void closeHappinessTip(MouseEvent mouseEvent)
    {
        view.closeHappinessTip();
    }



    public void openScienceTree(MouseEvent mouseEvent)
    {
        //TODO:
    }
}
