package controllers;

import application.AppData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static utils.LoadScene.changeLauncherScene;
import static utils.UICommonMethods.setImage;

public class RulesController {

    @FXML
    Button previousPageButton, nextPageButton;
    @FXML
    ImageView rulesImageView;
    @FXML
    Label pageNumberLabel;

    int currentPageNumber;
    int maxPageNumber;

    public void initialize() throws FileNotFoundException {
        currentPageNumber = 1;
        maxPageNumber = 18;
        refreshScene();
    }

    public void refreshScene() throws FileNotFoundException {
        setPageImage();
        setPageLabel();
        setButtonStates();
    }

    private void setPageImage() throws FileNotFoundException {
        String imageUrl = "rules/" + AppData.getLanguage() + "_page_" + currentPageNumber;
        setImage(rulesImageView, imageUrl);
    }

    private void setPageLabel() {
        String text = currentPageNumber + " / " + maxPageNumber;
        pageNumberLabel.setText(text);
    }

    private void setButtonStates() {
        previousPageButton.setDisable(false);
        nextPageButton.setDisable(false);
        if(currentPageNumber == 1){
            previousPageButton.setDisable(true);
        }
        if(currentPageNumber == maxPageNumber){
            nextPageButton.setDisable(true);
        }
    }

    @FXML
    private void onBackButtonClick() throws IOException {
        changeLauncherScene("game-init");
    }

    public void onPreviousButtonClick() throws FileNotFoundException {
        currentPageNumber -= 1;
        refreshScene();
    }

    public void onNextButtonClick() throws FileNotFoundException {
        currentPageNumber +=1;
        refreshScene();
    }

}
