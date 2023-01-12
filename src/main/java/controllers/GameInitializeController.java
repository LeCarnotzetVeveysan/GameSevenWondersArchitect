package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GameInitializeController implements Initializable {

    @FXML
    private Button ConfirmButton;

    @FXML
    private Label Player3Label;

    @FXML
    private TextField Player3TextField;
    @FXML
    private Label Player4Label;

    @FXML
    private Label Player5Label;

    @FXML
    private Label Player6Label;

    @FXML
    private Label Player7Label;

    @FXML
    private TextField Player4TextField;

    @FXML
    private TextField Player5TextField;

    @FXML
    private TextField Player6TextField;

    @FXML
    private TextField Player7TextField;

    @FXML
    private Button ReturnButton;

    @FXML
    void ReturnClicked(ActionEvent event) {//Reviens au launcher


    }
    @FXML
    void ConfirmClicked(ActionEvent event) {//Passe a game scene

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//affiche les textfields des noms en fonction du nombre de joueurs
        if (LauncherController.NombreJoueurs == 7){
            Player3TextField.setVisible(true);
            Player4TextField.setVisible(true);
            Player5TextField.setVisible(true);
            Player6TextField.setVisible(true);
            Player7TextField.setVisible(true);
            Player3TextField.setDisable(false);
            Player4TextField.setDisable(false);
            Player5TextField.setDisable(false);
            Player6TextField.setDisable(false);
            Player7TextField.setDisable(false);
            Player3Label.setVisible(true);
            Player4Label.setVisible(true);
            Player5Label.setVisible(true);
            Player6Label.setVisible(true);
            Player7Label.setVisible(true);
        }
        else if (LauncherController.NombreJoueurs == 6) {
            Player3TextField.setVisible(true);
            Player4TextField.setVisible(true);
            Player5TextField.setVisible(true);
            Player6TextField.setVisible(true);
            Player3TextField.setDisable(false);
            Player4TextField.setDisable(false);
            Player5TextField.setDisable(false);
            Player6TextField.setDisable(false);
            Player3Label.setVisible(true);
            Player4Label.setVisible(true);
            Player5Label.setVisible(true);
            Player6Label.setVisible(true);
        }
        else if (LauncherController.NombreJoueurs == 5) {
            Player3TextField.setVisible(true);
            Player4TextField.setVisible(true);
            Player5TextField.setVisible(true);
            Player3TextField.setDisable(false);
            Player4TextField.setDisable(false);
            Player5TextField.setDisable(false);
            Player3Label.setVisible(true);
            Player4Label.setVisible(true);
            Player5Label.setVisible(true);
        }
        else if (LauncherController.NombreJoueurs == 4) {
            Player3TextField.setVisible(true);
            Player4TextField.setVisible(true);
            Player3TextField.setDisable(false);
            Player4TextField.setDisable(false);
            Player3Label.setVisible(true);
            Player4Label.setVisible(true);
        }
        else if (LauncherController.NombreJoueurs == 3) {
            Player3TextField.setVisible(true);
            Player3TextField.setDisable(false);
            Player3Label.setVisible(true);
        }
    }
}
