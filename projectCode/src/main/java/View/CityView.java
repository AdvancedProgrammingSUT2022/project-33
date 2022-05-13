package View;

import Model.PlayerCity;

public class CityView {





    ////methods////
    public CityView(String cityName)
    {
        System.out.println("you are now controlling city: " + cityName);
    }



    public void showCityStats(PlayerCity city)
    {
        System.out.println("city name: " + city.getCityName());
        System.out.println("city health: " + city.getHealth() + " of " + city.getMaxHealth());
        System.out.println("attack damage: " + city.getAttackDamage());
        System.out.println("population: " + city.getPopulation());

        if (city.isCityStarving()){
            System.out.println("city is starving");
            System.out.println("turns until a citizen dies: " + city.getTurnsUntilACitizenDies());
        }
        else {
            System.out.println("food per turn: " + city.getFood());
            System.out.println("turns until new citizen is born: " + city.getFoodUntilNewCitizen() / city.getFood());
        }

        System.out.println("production per turn: " + city.getProduction());
        System.out.println("gold income: " + city.getGoldPerTurn());

        if (city.isWorkingOnTask()){
            System.out.println("currently working on " + city.getTaskGameName());
        }
        else {
            System.out.println("city is working on nothing right now");
        }
    }



    public void showInvalidCommand()
    {
        System.out.println("invalid command");
    }



    public void showCurrentMenu(String cityName)
    {
        System.out.println("you are now in city menu for " + cityName);
    }
}

