package controllers;

import application.AppData;
import data.Wonder;
import data.GameData;
import data.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class GameSceneController {

    @FXML
    private Button ButtonScience1, ButtonScience2, ButtonScience3, ButtonScienceRand;

    @FXML
    private ImageView ImageViewJetonsPaix1, ImageViewJetonsPaix2, ImageViewJetonsPaix3;

    @FXML
    private ImageView ImageViewJetonsSciences1, ImageViewJetonsSciences2, ImageViewJetonsSciences3, ImageViewJetonsSciencesRand;

    @FXML
    private Button NextTurnButton, PiocheCentraleButton, PiocheDroiteButton, PiocheGaucheButton;

    @FXML
    private Label Player1Name, Player2Name, Player3Name, Player4Name, Player5Name, Player6Name, Player7Name;

    @FXML
    private TitledPane HoverPane1, HoverPane2, HoverPane3, HoverPane4, HoverPane5, HoverPane6, HoverPane7;

    @FXML
    private Label InfoPlayer1, InfoPlayer2, InfoPlayer3, InfoPlayer4, InfoPlayer5, InfoPlayer6, InfoPlayer7;

    @FXML
    private Label Materials, WarPoints, WinPoints, JetonsSciencesJoueur;

    //Game variables
    private int numPlayers = GameData.getNumberOfPlayers();
    private int currentPlayerIndex;
    private Player currentPlayer;
    private ArrayList<Player> playerList;

    public void initialize(){
        System.out.println(Arrays.toString(GameData.getPlayerNames()));
        playerList = new ArrayList<>();
        currentPlayerIndex = 0;
        onNextTurnButtonClicked();
    }

    public void initializePlayers(){
        String[] names = GameData.getPlayerNames();
        for(int i = 0; i < numPlayers; i++){
            //add player to playerlist
        }
    }

    @FXML
    void onNextTurnButtonClicked(){
        currentPlayerIndex += 1;
        currentPlayerIndex %= numPlayers;
        currentPlayer = playerList.get(currentPlayerIndex);
    }

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
