package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LauncherController implements Initializable {//implements initializable obligatoire pour méthode initialize

    @FXML
    private ComboBox<Integer> ComboBoxNumPlayer;

    @FXML
    private ImageView LogoView;

    @FXML
    private Button StartButton;

    @FXML
    private Button RulesButton;
    private Integer[] NumPlayer = {2,3,4,5,6,7};

    public static int NombreJoueurs;

    @FXML
    void NumPlayerChoosed(ActionEvent event) {
        StartButton.setDisable(false);
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
}
