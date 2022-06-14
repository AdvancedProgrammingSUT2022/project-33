package Program.Model.Models;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;

public class MapImages {
    private HashMap<String, Image> terrainImages;
    private HashMap<String, Image> buildingImages;
    private HashMap<String, Image> unitImages;
    private HashMap<String, Image> iconImages;





    ////methods////
    public MapImages()
    {
        terrainImages = new HashMap<>();
        buildingImages = new HashMap<>();
        unitImages = new HashMap<>();
        iconImages = new HashMap<>();
        loadTerrainImages();
        loadBuildingImages();
        loadUnitImages();
        loadIconImages();
    }



    private void loadTerrainImages()
    {
        File[] directory = new File("src/main/resources/Textures/Game/Map/Terrain/").listFiles();
        addImagesFromDirectory(terrainImages, Objects.requireNonNull(directory));
    }



    private void loadBuildingImages()
    {
        File[] directory = new File("src/main/resources/Textures/Game/Map/Buildings/").listFiles();
        addImagesFromDirectory(buildingImages, Objects.requireNonNull(directory));
    }



    private void loadUnitImages()
    {
        File[] directory = new File("src/main/resources/Textures/Game/Map/Units/").listFiles();
        addImagesFromDirectory(unitImages, Objects.requireNonNull(directory));
    }



    private void loadIconImages()
    {
        File[] directory = new File("src/main/resources/Textures/Game/Map/Icons/").listFiles();
        addImagesFromDirectory(iconImages, Objects.requireNonNull(directory));
    }



    private void addImagesFromDirectory(HashMap<String, Image> images, File[] directory)
    {
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



    public Image getTerrainImageByName(String name)
    {
        for (String key: terrainImages.keySet()){
            if (key.equalsIgnoreCase(name)){
                return terrainImages.get(key);
            }
        }

        return null;
    }



    public Image getBuildingImageByName(String name)
    {
        for (String key: buildingImages.keySet()){
            if (key.equalsIgnoreCase(name)){
                return buildingImages.get(key);
            }
        }

        return null;
    }



    public Image getUnitImageByName(String name)
    {
        for (String key: unitImages.keySet()){
            if (key.equalsIgnoreCase(name)){
                return unitImages.get(key);
            }
        }

        return null;
    }



    public Image getIconImageByName(String name)
    {
        for (String key: iconImages.keySet()){
            if (key.equalsIgnoreCase(name)){
                return iconImages.get(key);
            }
        }

        return null;
    }
}
