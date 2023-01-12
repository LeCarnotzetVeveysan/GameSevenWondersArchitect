package controllers;

import application.AppData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static other.LoadScene.changeLauncherScene;
import static other.LoadScene.changeScene;

public class LauncherController implements Initializable {//implements initializable obligatoire pour méthode initialize

    @FXML
    private ComboBox<Integer> ComboBoxNumPlayer;

    @FXML
    private ImageView LogoView;

    @FXML
    private Button StartButton;

    @FXML
    private TextField Player1NameField;

    @FXML
    private Label Player1NameLabel;

    @FXML
    private TextField Player2NameField;

    @FXML
    private Label Player2NameLabel;

    @FXML
    private TextField Player3NameField;

    @FXML
    private Label Player3NameLabel;

    @FXML
    private TextField Player4NameField;

    @FXML
    private Label Player4NameLabel;

    @FXML
    private TextField Player5NameField;

    @FXML
    private Label Player5NameLabel;

    @FXML
    private TextField Player6NameField;

    @FXML
    private Label Player6NameLabel;

    @FXML
    private TextField Player7NameField;

    @FXML
    private Label Player7NameLabel;

    @FXML
    private TitledPane TitledPaneNames;

    @FXML
    private Button RulesButton;
    private Integer[] NumPlayer = {2,3,4,5,6,7};

    public static int NombreJoueurs;

    @FXML
    void NumPlayerChoosed(ActionEvent event) {
        StartButton.setDisable(false);
        TitledPaneNames.setDisable(false);
        //Afficher les text fields names et labels names en fonction du nombre de joueurs
    }
    @FXML
    void RulesClicked(ActionEvent event) {//Ouvre fenêtre rules

    }
    @FXML
    void StartClicked(ActionEvent event) {//Passe a la fenêtre game initialize
        NombreJoueurs = ComboBoxNumPlayer.getValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//méthode initialize se lance directement à l'ouverture d'une fenêtre
        ComboBoxNumPlayer.getItems().addAll(NumPlayer);
        StartButton.setDisable(true);
    }

    public void onRuleButtonClicked() throws IOException {
        changeLauncherScene("rule");
    }

    public void onStartButtonClicked() throws IOException {

        if(validInputs()){
            registerAppData();
            changeLauncherScene("game-initialize");
        }
    }


    private boolean validInputs(){

        boolean numPlayersSelected = false;
        boolean languageSelected = false;
        boolean screenSizeSelected = false;
        if (!(ComboBoxNumPlayer.getValue() == null)){
            numPlayersSelected = true;
        }
        //Faire de même pour les combobox de la langue et du screensize

        //Normalement combinaison mais pour le moment on dit que c'est juste;
        //return numPlayersSelected && languageSelected && screenSizeSelected;
        return  numPlayersSelected;

    }

    private void registerAppData() {
        //AppData.setLanguage() = LanguageComboBox.getValue();
    }


}
