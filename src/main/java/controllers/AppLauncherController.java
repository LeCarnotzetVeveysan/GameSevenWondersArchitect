package controllers;

import application.AppData;
import com.almasb.fxgl.core.collection.Array;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import other.LoadScene;

import java.io.IOException;

public class AppLauncherController {

    public ChoiceBox languageChoiceBox, screenSizeChoiceBox;

    public void initialize(){
        languageChoiceBox.setValue(languageChoiceBox.getItems().get(0));
        screenSizeChoiceBox.setValue(screenSizeChoiceBox.getItems().get(0));
    }

    public boolean validLanguageInput(){
        return languageChoiceBox.getSelectionModel().getSelectedIndex() != 0;
    }

    public boolean validScreenSizeInput(){
        return screenSizeChoiceBox.getSelectionModel().getSelectedIndex() != 0;
    }

    public void onPreviewButtonClick() throws IOException {
        if(validScreenSizeInput()){
            setPrefScreenSize();
            LoadScene.changeScene("main", "main-preview");
        }
    }

    public void setPrefScreenSize() {
        String input = screenSizeChoiceBox.getValue().toString();
        String[] arr1 = input.split("x");
        int[] sizes = new int[]{Integer.parseInt(arr1[0]),Integer.parseInt(arr1[1])};
        AppData.setPrefWidth(sizes[0]);
        AppData.setPrefHeight(sizes[1]);
    }

    public void setLanguage(){
        if(validLanguageInput()){
            AppData.setLanguage((String) languageChoiceBox.getValue());
        }
    }

    public void onLaunchButtonClick() throws IOException {
        if(validLanguageInput() && validScreenSizeInput()){
            setLanguage();
            setPrefScreenSize();
            System.out.println();
            LoadScene.changeLauncherScene("game-init");
        }

    }

}
