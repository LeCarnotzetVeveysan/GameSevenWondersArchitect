package controllers;

import application.AppData;
import data.GameData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import other.LoadScene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static other.LoadScene.changeLauncherScene;

public class GameInitController implements Initializable {//implements initializable obligatoire pour méthode initialize

    @FXML
    private ComboBox ComboBoxNumPlayer;
    private Integer[] NumPlayer = {2,3,4,5,6,7};

    @FXML
    private TextField Player1Name, Player2Name, Player3Name, Player4Name, Player5Name, Player6Name, Player7Name;
    private TextField[] nameInputs;
    public static int numberOfPlayers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameInputs = new TextField[]{Player1Name, Player2Name, Player3Name, Player4Name, Player5Name, Player6Name, Player7Name};
        ComboBoxNumPlayer.getItems().addAll(NumPlayer);
        numberOfPlayers = 0;
        refreshNameFields();
    }

    public void onRuleButtonClicked() throws IOException {
        changeLauncherScene("rules");
    }

    @FXML
    void onNumPlayersChanged() {
        numberOfPlayers = Integer.parseInt(ComboBoxNumPlayer.getValue().toString());
        refreshNameFields();
    }

    private void refreshNameFields() {
        for (TextField tf : nameInputs){
            tf.setDisable(false);
        }
        for (int i = numberOfPlayers; i < 7; i++){
            nameInputs[i].setDisable(true);
            nameInputs[i].setText("");
        }
    }

    public void onStartButtonClicked() throws IOException {
        if(validInputs()){
            registerAppData();
            LoadScene.changeScene("main","new-game-scene");
        } else {
            //Display that not enough names are selected
        }
    }

    private boolean validInputs(){
        for (int i = 0; i < numberOfPlayers;i++){
            String name = nameInputs[i].getText();
            if(!isValidName(name)){
                return false;
            }
        }
        return  true;
    }

    public boolean isValidName(String input){
        if(input.equals("")){
            return false;
        }

        String[] chars = input.split("");
        String allowed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_ ";

        for (String c : chars){
            if(!(allowed.contains(c))){
                return false;
            }
        }
        return true;
    }

    private void registerAppData() {
        GameData.setNumberOfPlayers(numberOfPlayers);
        String[] names = new String[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++)
        {
            names[i] = nameInputs[i].getText();
        }
        GameData.setPlayerNames(names);
    }

}

