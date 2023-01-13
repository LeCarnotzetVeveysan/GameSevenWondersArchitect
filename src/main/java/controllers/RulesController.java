package controllers;

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
    Button previousPageButton, nextPageButton;
    @FXML
    ImageView rulesImageView;
    @FXML
    Label pageNumberLabel;

    int currentPageNumber;
    int maxPageNumber;
    public void initialize() throws FileNotFoundException {
        currentPageNumber = 1;
        maxPageNumber = 5;
        refreshScene();
    }

    public void refreshScene() throws FileNotFoundException {
        setPageImage();
        setPageLabel();
        setButtonStates();
    }

    private void setPageImage() throws FileNotFoundException {
        String imageUrl = "rules/rules_page" + currentPageNumber;
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
        changeLauncherScene("launcher");
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
