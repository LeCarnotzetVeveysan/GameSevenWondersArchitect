package utils;

import application.AppData;
import data.Player;
import data.Deck;
import data.ProgressTokenStack;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.HashMap;

public class UICommonMethods {

    public static void setImage(ImageView iv, String url) throws FileNotFoundException {
        String resPath = "src/main/resources/images/";
        url += ".png";
        if (url.endsWith(".png.png")) {
            url = url.replace(".png.png", ".png");
        }
        Image image = new Image(new FileInputStream(resPath + url));
        iv.setImage(image);
    }

    public static String getTextFromLangDict(String textCode) throws IOException {
        String file = "src/main/resources/language-dicts/" + AppData.getLanguage().toLowerCase() + "-dict.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        HashMap<String, String> langDict = new HashMap<>() {};
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split("\\|");
            langDict.put(parts[0], parts[1]);
        }
        return langDict.get(textCode);
    }
}
