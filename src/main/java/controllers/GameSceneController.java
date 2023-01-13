package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameSceneController {

    @FXML
    private Button ButtonScience1;

    @FXML
    private Button ButtonScience2;

    @FXML
    private Button ButtonScience3;

    @FXML
    private Button ButtonScienceRand;

    @FXML
    private ImageView ImageViewJetonsPaix1;

    @FXML
    private ImageView ImageViewJetonsPaix2;

    @FXML
    private ImageView ImageViewJetonsPaix3;

    @FXML
    private ImageView ImageViewJetonsSciences1;

    @FXML
    private ImageView ImageViewJetonsSciences2;

    @FXML
    private ImageView ImageViewJetonsSciences3;

    @FXML
    private ImageView ImageViewJetonsSciencesRand;

    @FXML
    private Button NextTurnButton;

    @FXML
    private Button PiocheCentraleButton;

    @FXML
    private Button PiocheDroiteButton;

    @FXML
    private Button PiocheGaucheButton;

    @FXML
    private Label Player1Name;

    @FXML
    private Label Player2Name;

    @FXML
    private Label Player3Name;

    @FXML
    private Label Player4Name;

    @FXML
    private Label Player5Name;

    @FXML
    private Label Player6Name;

    @FXML
    private Label Player7Name;

    @FXML
    private TitledPane HoverPane1;

    @FXML
    private TitledPane HoverPane2;

    @FXML
    private TitledPane HoverPane3;

    @FXML
    private TitledPane HoverPane4;

    @FXML
    private TitledPane HoverPane5;

    @FXML
    private TitledPane HoverPane6;

    @FXML
    private TitledPane HoverPane7;

    @FXML
    private Label InfoPlayer1;

    @FXML
    private Label InfoPlayer2;

    @FXML
    private Label InfoPlayer3;

    @FXML
    private Label InfoPlayer4;

    @FXML
    private Label InfoPlayer5;

    @FXML
    private Label InfoPlayer6;

    @FXML
    private Label InfoPlayer7;

    @FXML
    private Label Materials;

    @FXML
    private Label WarPoints;

    @FXML
    private Label WinPoints;

    @FXML
    private Label JetonsSciencesJoueur;

    @FXML
    void PiocheCentraleClicked(ActionEvent event) {

    }

    @FXML
    void PiocheDroiteClicked(ActionEvent event) {

    }

    @FXML
    void PiocheGaucheClicked(ActionEvent event) {

    }

    @FXML
    void Science1Clicked(ActionEvent event) {

    }

    @FXML
    void Science2Clicked(ActionEvent event) {

    }

    @FXML
    void Science3Clicked(ActionEvent event) {

    }

    @FXML
    void ScienceRandClicked(ActionEvent event) {

    }

    @FXML
    void HoveredOne(ActionEvent event) {
        HoverPane1.setVisible(true);
    }

    @FXML
    void HoveredTwo(ActionEvent event) {
        HoverPane2.setVisible(true);
    }

    @FXML
    void HoveredThree(ActionEvent event) {
        HoverPane3.setVisible(true);
    }

    @FXML
    void HoveredFour(ActionEvent event) {
        HoverPane4.setVisible(true);
    }

    @FXML
    void HoveredFive(ActionEvent event) {
        HoverPane5.setVisible(true);
    }

    @FXML
    void HoveredSix(ActionEvent event) {
        HoverPane6.setVisible(true);
    }

    @FXML
    void HoveredSeven(ActionEvent event) {
        HoverPane7.setVisible(true);
    }

    @FXML
    void UnHoveredOne(ActionEvent event) {
        HoverPane1.setVisible(false);
    }

    @FXML
    void UnHoveredTwo(ActionEvent event) {
        HoverPane2.setVisible(false);
    }

    @FXML
    void UnHoveredThree(ActionEvent event) {
        HoverPane3.setVisible(false);
    }

    @FXML
    void UnHoveredFour(ActionEvent event) {
        HoverPane4.setVisible(false);
    }

    @FXML
    void UnHoveredFive(ActionEvent event) {
        HoverPane5.setVisible(false);
    }

    @FXML
    void UnHoveredSix(ActionEvent event) {
        HoverPane6.setVisible(false);
    }

    @FXML
    void UnHoveredSeven(ActionEvent event) {
        HoverPane7.setVisible(false);
    }

}
