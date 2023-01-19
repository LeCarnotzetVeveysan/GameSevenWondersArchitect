package controllers;

import data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import token.ProgressToken;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static other.UICommonMethods.setImage;

public class GameSceneController {

    @FXML
    private ImageView startCatIV, centralDeckIV, leftDeckIV, rightDeckIV;

    @FXML
    private ImageView progressToken1IV, progressToken2IV, progressToken3IV, progressToken4IV;

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
    private Board gameBoard;
    private int numPlayers = GameData.getNumberOfPlayers();
    private int currentPlayerIndex;
    private Player currentPlayer;
    private ArrayList<Player> playerList;
    private ArrayList<Deck> deckList;
    private Deck centralDeck, rightDeck, leftDeck;

    public void initialize() throws FileNotFoundException {

        gameBoard = new Board();
        deckList = gameBoard.getDecks();
        playerList = gameBoard.getPlayers();
        currentPlayerIndex = -1;

        switchToNextPlayer();

        updateDecks();

        updateImages();

    }

    public void updateImages() throws FileNotFoundException {
        updateDeckImages();
        updateProgressTokenImages();
        updatePeaceTokenImages();
    }

    private void updatePeaceTokenImages() {
    }

    private void updateProgressTokenImages() {
        ProgressTokenStack stack = gameBoard.getProgressTokens();

    }

    private void updateDeckImages() throws FileNotFoundException {
        setImage(leftDeckIV, leftDeck.getCardAtIndex(0).getFront());
        setImage(rightDeckIV, rightDeck.getCardAtIndex(0).getFront());
    }

    private void updateDecks() {
        centralDeck = deckList.get(numPlayers);
        rightDeck = deckList.get(currentPlayerIndex);
        leftDeck = currentPlayerIndex == 0 ? deckList.get(numPlayers - 1) : deckList.get(currentPlayerIndex - 1);
    }

    void switchToNextPlayer() throws FileNotFoundException {
        if (currentPlayerIndex == playerList.size() - 1) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
        currentPlayer = playerList.get(currentPlayerIndex);
        updateDecks();
        updateImages();
    }

    @FXML
    void onNextTurnButtonClick() throws FileNotFoundException {
        switchToNextPlayer();
    }

    public void onMainDeckButtonClick() throws FileNotFoundException {
        Cards drawnCard = centralDeck.drawTopCard();
        drawnCard.getCardTokenToPlayer(currentPlayer);

        updateImages();
    }

    public void onLeftDeckButtonClick() throws FileNotFoundException {
        Cards drawnCard = leftDeck.drawTopCard();
        drawnCard.getCardTokenToPlayer(currentPlayer);

        updateImages();
    }

    public void onRightDeckButtonClick() throws FileNotFoundException {
        Cards drawnCard = rightDeck.drawTopCard();
        drawnCard.getCardTokenToPlayer(currentPlayer);

        updateImages();
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
