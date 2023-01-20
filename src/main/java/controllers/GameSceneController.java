package controllers;

import data.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import token.ProgressToken;
import other.ModelCommonMethods;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static other.ModelCommonMethods.*;
import static other.UICommonMethods.setImage;

public class GameSceneController {

    @FXML
    private ImageView startCatIV, playerCatIV, centralDeckIV, leftDeckIV, rightDeckIV;
    @FXML
    private HBox progressTokenIVHB, peaceTokenIVHB;
    @FXML
    private ImageView progressToken1IV, progressToken2IV, progressToken3IV, progressToken4IV;
    @FXML
    private ImageView peaceToken1IV, peaceToken2IV, peaceToken3IV, peaceToken4IV, peaceToken5IV, peaceToken6IV;
    private ArrayList<ImageView> progressTokenIVs, peaceTokenIVs;



    @FXML
    private Label Player1Name, Player2Name, Player3Name, Player4Name, Player5Name, Player6Name, Player7Name;

    @FXML
    private TitledPane HoverPane;
    @FXML
    private Label LabelHover1, LabelHover2, LabelHover3, LabelHover4, LabelHover5, LabelHover6, LabelHover7;

    @FXML
    private Label InfoPlayer;

    @FXML
    private Label Materials, WarPoints, WinPoints, JetonsSciencesJoueur;

    //Game variables
    private Board gameBoard;
    private int numPlayers = GameData.getNumberOfPlayers();
    private Player currentPlayer;
    private ArrayList<Player> playerList;
    private ArrayList<Deck> deckList;
    private Deck centralDeck, rightDeck, leftDeck;
    private int hoveredPlayer;

    public void initialize() throws FileNotFoundException {

        initIVs();

        gameBoard = new Board();
        deckList = gameBoard.getDecks();
        playerList = gameBoard.getPlayers();
        gameBoard.setCurrentPlayerIndex(-1);

        switchToNextPlayer();

        updateDecks();

        updateImages();

        LabelHover1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hoveredPlayer =1;
                Hovered();
            }
        });
        LabelHover1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HoverPane.setVisible(false);
            }
        });
        LabelHover2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hoveredPlayer =2;
                Hovered();
            }
        });
        LabelHover2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HoverPane.setVisible(false);
            }
        });
        LabelHover3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hoveredPlayer =3;
                Hovered();
            }
        });
        LabelHover3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HoverPane.setVisible(false);
            }
        });
        LabelHover4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hoveredPlayer =4;
                Hovered();
            }
        });
        LabelHover4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HoverPane.setVisible(false);
            }
        });
        LabelHover5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hoveredPlayer =5;
                Hovered();
            }
        });
        LabelHover5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HoverPane.setVisible(false);
            }
        });
        LabelHover6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hoveredPlayer =6;
                Hovered();
            }
        });
        LabelHover6.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HoverPane.setVisible(false);
            }
        });
        LabelHover7.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hoveredPlayer =7;
                Hovered();
            }
        });
        LabelHover7.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HoverPane.setVisible(false);
            }
        });
    }

    private void initIVs() {
        initProgressTokenIVs();
        initPeaceTokenIVs();
        initMaterialTokenIVs();
        initScienceTokenIVs();
        initWarTokenIVs();
        initLaurelTokenIVs();
        initPlayerProgressTokensIVs();
    }

    private void initPlayerProgressTokensIVs() {
    }

    private void initLaurelTokenIVs() {
        
    }

    private void initWarTokenIVs() {
        
    }

    private void initScienceTokenIVs() {
        
    }

    private void initMaterialTokenIVs() {
        
    }

    private void initPeaceTokenIVs() {
        peaceTokenIVs = new ArrayList<>();
        peaceTokenIVs.add(peaceToken1IV);
        peaceTokenIVs.add(peaceToken2IV);
        peaceTokenIVs.add(peaceToken3IV);
        peaceTokenIVs.add(peaceToken4IV);
        peaceTokenIVs.add(peaceToken5IV);
        peaceTokenIVs.add(peaceToken6IV);
    }

    private void initProgressTokenIVs() {
        progressTokenIVs = new ArrayList<>();
        progressTokenIVs.add(progressToken1IV);
        progressTokenIVs.add(progressToken2IV);
        progressTokenIVs.add(progressToken3IV);
        progressTokenIVs.add(progressToken4IV);
    }

    public void updateImages() throws FileNotFoundException {
        updateDeckImages();
        updateProgressTokenImages();
        updatePeaceTokenImages();
        updateCatImages();
        updatePlayerTokenIVsAndLabels();
    }

    private void updatePlayerTokenIVsAndLabels() {
    }

    private void updateCatImages() {
        if(gameBoard.isCatTaken()){
            startCatIV.setVisible(false);
        } else {
            startCatIV.setVisible(true);
        }
        if(currentPlayer.getHasCat()){
            playerCatIV.setVisible(true);
        } else {
            playerCatIV.setVisible(false);
        }
    }

    private void updatePeaceTokenImages() throws FileNotFoundException {
        for(ImageView iv : peaceTokenIVs){ setImage(iv,"tokens-conflict/conflictPeaceToken");}

        int tokensNeeded = gameBoard.getCombatTokensNeeded();
        int tokensFlipped = gameBoard.getCombatTokensFlipped();
        ArrayList<ImageView> imageViews = new ArrayList<>();

        for(int i = 0; i < tokensFlipped; i++){
            setImage(peaceTokenIVs.get(i), "tokens-conflict/conflictWarToken");
        }

        for(int i = 0; i < tokensNeeded; i++){
            imageViews.add(peaceTokenIVs.get(i));
        }

        peaceTokenIVHB.getChildren().clear();
        for(ImageView iv : imageViews){
            peaceTokenIVHB.getChildren().add(iv);
        }

    }

    private void updateProgressTokenImages() throws FileNotFoundException {
        ArrayList<ProgressToken> stack = gameBoard.getProgressTokens().getProgressTokens();
        ArrayList<ImageView> imageViews = new ArrayList<>();
        if(stack.size() >= 4){
            imageViews.addAll(progressTokenIVs);
            setImage(progressToken1IV, "tokens-progress/back/token-back");
            setImage(progressToken2IV, stack.get(stack.size()-3).getImageResource());
            setImage(progressToken3IV, stack.get(stack.size()-2).getImageResource());
            setImage(progressToken4IV, stack.get(stack.size()-1).getImageResource());
        } else if (stack.size() == 3){
            for(int i = 0; i < 3; i++){ imageViews.add(progressTokenIVs.get(i)); }
            setImage(progressToken1IV, stack.get(0).getImageResource());
            setImage(progressToken2IV, stack.get(1).getImageResource());
            setImage(progressToken3IV, stack.get(2).getImageResource());
        } else if (stack.size() == 2){
            for(int i = 0; i < 2; i++){ imageViews.add(progressTokenIVs.get(i)); }
            setImage(progressToken1IV, stack.get(0).getImageResource());
            setImage(progressToken2IV, stack.get(1).getImageResource());
        } else if (stack.size() == 1){
            imageViews.add(progressToken1IV);
            setImage(progressToken1IV, stack.get(0).getImageResource());
        }
        progressTokenIVHB.getChildren().clear();
        for(ImageView iv : imageViews){
            progressTokenIVHB.getChildren().add(iv);
        }
    }

    private void updateDeckImages() throws FileNotFoundException {
        if (leftDeck.getDeck().size() > 0){
            setImage(leftDeckIV, leftDeck.getCardAtIndex(0).getFront());
        } else {
            setImage(leftDeckIV, leftDeck.getBackCardImg());
        }
        if (rightDeck.getDeck().size() > 0){
            setImage(rightDeckIV, rightDeck.getCardAtIndex(0).getFront());
        } else {
            setImage(rightDeckIV, rightDeck.getBackCardImg());
        }
    }

    private void updateDecks() {
        centralDeck = deckList.get(numPlayers);
        rightDeck = deckList.get(gameBoard.getCurrentPlayerIndex());
        leftDeck = gameBoard.getCurrentPlayerIndex() == 0 ? deckList.get(numPlayers - 1) : deckList.get(gameBoard.getCurrentPlayerIndex() - 1);
    }

    void switchToNextPlayer() throws FileNotFoundException {
        if (gameBoard.getCurrentPlayerIndex() == playerList.size() - 1) {
            gameBoard.setCurrentPlayerIndex(0);
        } else {
            gameBoard.setCurrentPlayerIndex(gameBoard.getCurrentPlayerIndex() + 1);
        }
        currentPlayer = playerList.get(gameBoard.getCurrentPlayerIndex());
        updateDecks();
        updateImages();
    }

    @FXML
    void onNextTurnButtonClick() throws FileNotFoundException {
        checkForWar();
        switchToNextPlayer();
    }

    private void checkForWar() {
        if(gameBoard.getCombatTokensFlipped() >= gameBoard.getCombatTokensNeeded()){
            System.out.println("AOUH ! AOUH ! AOUH !");
            gameBoard.setCombatTokensFlipped(0);
        }
        checkPlayerWar(gameBoard, playerList);
    }

    public void onMainDeckButtonClick() throws FileNotFoundException {
        if (centralDeck.getDeck().size() > 0) {
            drawMiddleDeckCard(gameBoard, 0);
            updateImages();
        }
        updateImages();
    }

    public void onLeftDeckButtonClick() throws FileNotFoundException {
        if (leftDeck.getDeck().size() > 0) {
            drawLeftDeckCard(gameBoard, 0);
            updateImages();
        }
        updateImages();
    }

    public void onRightDeckButtonClick() throws FileNotFoundException {
        if (rightDeck.getDeck().size() > 0) {
            drawRightDeckCard(gameBoard, 0);
            updateImages();
        }
        updateImages();
    }

    public void Hovered(){
        HoverPane.setVisible(true);
        //Set Label InfoPlayer en fonction du joueur qui a été hover ( donc valeur de hoveredPlayer )
        InfoPlayer.setText("Player "+ hoveredPlayer + " hovered");
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
    void Science4Clicked(ActionEvent event) {

    }


}
