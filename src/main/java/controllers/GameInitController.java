package controllers;

import data.GameData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import other.LoadScene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static other.LoadScene.changeLauncherScene;
import static other.UICommonMethods.getTextFromLangDict;

public class GameInitController implements Initializable {//implements initializable obligatoire pour méthode initialize

    @FXML
    private Button startButton, rulesButton;
    @FXML
    private ComboBox ComboBoxNumPlayer;
    private Integer[] NumPlayer = {2,3,4,5,6,7};

    @FXML
    private Label numPlayersLB, p1NameLB, p2NameLB, p3NameLB, p4NameLB, p5NameLB, p6NameLB, p7NameLB;
    private Label[] nameLabels;
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
        nameLabels = new Label[]{p1NameLB, p2NameLB, p3NameLB, p4NameLB, p5NameLB, p6NameLB, p7NameLB};

        try {
            initLabels();
            startButton.setText(getTextFromLangDict("start"));
            rulesButton.setText(getTextFromLangDict("rules"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initLabels() throws IOException {
        int count = 49;
        for(Label lb : nameLabels){
            lb.setText(getTextFromLangDict("playerName").replace('X',(char) count));
            count++;
        }
        numPlayersLB.setText(getTextFromLangDict("numPlayers"));
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
            Stage stage = (Stage) startButton.getScene().getWindow();
            stage.close();


        } else {
            //Display that not enough names are selected
        }
    }

    private boolean validInputs(){
        if(numberOfPlayers == 0){ return false; }
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

