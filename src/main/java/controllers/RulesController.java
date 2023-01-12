package controllers;

import application.AppData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static other.LoadScene.changeLauncherScene;
import static other.UICommonMethods.setImage;

public class RulesController {

    @FXML
    Button backButton, previousPageButton, nextPageButton;
    @FXML
    ImageView contentImageView;
    @FXML
    Label pageNumberLabel;

    int pageNumber;
    public void initialize() throws FileNotFoundException {

        pageNumber = 1;

        setPageImage();
        setPageLabel();
        setButtonStates();

    }

    private void setPageImage() throws FileNotFoundException {
        String imageUrl = "rules_page_" + pageNumber;
        setImage(contentImageView, imageUrl);
    }

    private void setPageLabel() {
        String text = pageNumber + " / maxPages";
        pageNumberLabel.setText(text);
    }

    private void setButtonStates() {
        if(pageNumber == 1){
            previousPageButton.setDisable(true);
        }
        if(pageNumber == 9){ //En fonction du vrai nombre de pages de règles
            nextPageButton.setDisable(false);
        }
    }

    private void onBackButtonClicked() throws IOException {
        changeLauncherScene("launcher");
    }

}
