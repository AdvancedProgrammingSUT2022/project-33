package Program.Model.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LoginMenu {
    private static ArrayList<User> users;





    ////methods////
    public LoginMenu()
    {
        try {
            FileReader reader = new FileReader("src/main/resources/users.json");
            users = new Gson().fromJson(reader, new TypeToken<List<User>>(){}.getType());
            reader.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        if (users == null){
            users = new ArrayList<>();
        }
    }



    public void addUser(User user)
    {
        users.add(user);
    }



    public static void saveUsers()
    {
        try {
            Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
            Path userPath = Path.of("src/main/resources/users.json");
            Writer writer = Files.newBufferedWriter(userPath);
            gsonBuilder.toJson(users, writer);
            writer.close();

            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    //getters
    public User getUserFromUsername(String username)
    {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }


    public static ArrayList<User> getUsers()
    {
        return users;
    }
}
