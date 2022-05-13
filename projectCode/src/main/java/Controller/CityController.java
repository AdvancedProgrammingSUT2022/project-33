package Controller;

import Model.MatchingStrings;
import Model.Player;
import Model.PlayerCity;
import Model.UserInput;
import View.CityView;


public class CityController {
    Player player;
    PlayerCity city;
    CityView view;





    ////methods////
    public CityController(Player player, PlayerCity city)
    {
        this.city = city;
        this.player = player;
        this.view = new CityView(city.getCityName());

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.STATS)){
                view.showCityStats(city);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.SHOW_CITIZENS)){
                view.showCitizens(city);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.SHOW_MENU)){
                view.showCurrentMenu(city.getCityName());
            }
            else if (UserInput.doesMatch(input, MatchingStrings.CityControllerStrings.BACK)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
        }
    }
}
