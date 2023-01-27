package controllers;

import application.AppData;
import javafx.scene.control.ChoiceBox;
import utils.LoadScene;

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
            String toSet = "";
            switch ((String) languageChoiceBox.getValue()){
                case "English", "Select language" -> toSet = "EN";
                case "Français" -> toSet = "FR";
                case "Italiano" -> toSet = "IT";
            }
            AppData.setLanguage(toSet);
        }
    }

    private void setLayoutSize() {
        int toSet = 0;
        String wantedSize = screenSizeChoiceBox.getValue().toString();
        switch (wantedSize){
            case "988x707" -> toSet = 350;
            case "1000x800" -> toSet = 500;
            case "coucou" -> toSet = 200;
        }
        AppData.setWonderLayoutSize(toSet);
    }

    public void languageCBChanged() {
        setLanguage();
    }

    public void onLaunchButtonClick() throws IOException {
        if(validLanguageInput() && validScreenSizeInput()){
            setLanguage();
            setPrefScreenSize();
            setLayoutSize();
            LoadScene.changeLauncherScene("game-init");
        }
    }
}
