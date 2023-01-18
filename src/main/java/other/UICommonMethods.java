package other;

import data.Player;
import data.Deck;
import data.ProgressTokenStack;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UICommonMethods {

    public static void setImage(ImageView iv, String url) throws FileNotFoundException {
        String resPath = "src/main/resources/images/";
        Image image = new Image(new FileInputStream(resPath + url + ".png"));
        iv.setImage(image);
    }

    public void refreshBoard() {

    }

    private void refreshCommonTokens() {

    }

    private void refreshCombatTokenImages() {

    }

    private void refreshProgressTokenImages() {

    }

    private void refreshPlayer() {

    }

    private void refreshPlayerImages() {

    }

    private void refreshWonderImages() {

    }

    private void refreshMaterialImages() {

    }

    private void refreshPlayerTokenImages() {

    }

    private void refreshPlayerShieldImages() {

    }

}
