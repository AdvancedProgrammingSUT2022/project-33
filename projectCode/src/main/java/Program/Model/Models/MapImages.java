package Program.Model.Models;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class MapImages {
    private HashMap<String, Image> images;





    ////methods////
    public MapImages()
    {
        images = new HashMap<>();
        loadTerrainImages();
    }



    private void loadTerrainImages()
    {
        File[] directory = new File("src/main/resources/Textures/Game/Map/Terrain/").listFiles();

        for (File imageFile: directory){
            String name = imageFile.getName().split("\\.")[0];

            try {
                Image image = new Image(new FileInputStream(imageFile));
                images.put(name, image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }



    public Image getImageByName(String name)
    {
        for (String key: images.keySet()){
            if (key.equalsIgnoreCase(name)){
                return images.get(key);
            }
        }

        return null;
    }
}
