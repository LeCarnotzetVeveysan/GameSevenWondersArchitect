package controllers;

import data.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import token.ProgressToken;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static other.ModelCommonMethods.*;
import static other.UICommonMethods.setImage;

public class GameSceneController {

    public Label playerNameLabel;

    @FXML
    private ImageView startCatIV, playerCatIV, centralDeckIV, leftDeckIV, rightDeckIV;
    @FXML
    private StackPane wonderSP;
    @FXML
    private ImageView stage0IV, stage1IV, stage2IV, stage3IV, stage4IV;
    @FXML
    private HBox progressTokenBTHB, peaceTokenIVHB;
    @FXML
    private Button progressToken1BT, progressToken2BT, progressToken3BT, progressToken4BT;
    @FXML
    private ImageView progressToken1IV, progressToken2IV, progressToken3IV, progressToken4IV;
    @FXML
    private ImageView peaceToken1IV, peaceToken2IV, peaceToken3IV, peaceToken4IV, peaceToken5IV, peaceToken6IV;
    private ArrayList<ImageView> peaceTokenIVs;
    private static ArrayList<Button> progressTokenBTs;

    @FXML
    private ImageView playerWonderIV;

    @FXML
    private HBox playerProgressTokenIVHB, playerMaterialTokenSPHB, playerScienceTokenSPHB, playerLaurelTokenSPHB, playerShieldTokenSPHB;
    @FXML
    private ImageView playerProgTok1IV, playerProgTok2IV,playerProgTok3IV,playerProgTok4IV,playerProgTok5IV,playerProgTok6IV,playerProgTok7IV,playerProgTok8IV;
    @FXML
    private StackPane woodTokenSP, brickTokenSP, glassTokenSP, paperTokenSP, stoneTokenSP, goldTokenSP;
    @FXML
    private StackPane shieldWithoutHornSP, shieldWithHornSP;
    @FXML
    private StackPane architectTokenSP, lawTokenSP, mechanicTokenSP;
    @FXML
    private StackPane laurelRed3TokenSP, laurelBlue2TokenSP, laurelBlue3TokenSP;
    @FXML
    private Label woodTokenLabel, brickTokenLabel, glassTokenLabel, paperTokenLabel, stoneTokenLabel, goldTokenLabel;
    @FXML
    private Label shieldWithoutHornLabel, shieldWithHornLabel;
    @FXML
    private Label architectTokenLabel, lawTokenLabel, mechanicTokenLabel;
    @FXML
    private Label laurelRed3TokenLabel, laurelBlue2TokenLabel, laurelBlue3TokenLabel;
    private ArrayList<ImageView> playerProgressTokenIVs;
    private ArrayList<StackPane> playerMaterialTokenSPs, playerShieldTokenSPs, playerScienceTokenSPs, playerLaurelTokenSPs;


    @FXML
    private Label Player1Name, Player2Name, Player3Name, Player4Name, Player5Name, Player6Name, Player7Name;

    @FXML
    private TitledPane HoverPane;
    @FXML
    private Label LabelHover1, LabelHover2, LabelHover3, LabelHover4, LabelHover5, LabelHover6, LabelHover7;

    @FXML
    private Label InfoPlayer;

    @FXML
    private Button nextTurnButton, centralDeckButton, leftDeckButton, rightDeckButton;

    //Game variables
    private Board gameBoard;
    private final int numPlayers = GameData.getNumberOfPlayers();
    private Player currentPlayer;
    private ArrayList<Player> playerList;
    private ArrayList<Deck> deckList;
    private Deck centralDeck, rightDeck, leftDeck;
    private int hoveredPlayer;

    public void initialize() throws IOException {
        Label[] Hovers = new Label[]{LabelHover1, LabelHover2, LabelHover3, LabelHover4, LabelHover5, LabelHover6, LabelHover7};

        Label[] playerNames = new Label[]{Player1Name, Player2Name, Player3Name, Player4Name, Player5Name, Player6Name, Player7Name};

        initIVsAndSPs();
        initHoverMethods();

        gameBoard = new Board();
        deckList = gameBoard.getDecks();
        playerList = gameBoard.getPlayers();
        gameBoard.setCurrentPlayerIndex(-1);

        for (int i = 0; i < GameInitController.numberOfPlayers; i++){
            playerNames[i].setText(gameBoard.getPlayers().get(i).getName());
        }

        for (int i = 7; i > GameInitController.numberOfPlayers; i--){
            playerNames[i-1].setVisible(false);
            Hovers[i-1].setVisible(false);
            Hovers[i-1].setDisable(true);
        }

        switchToNextPlayer();
        updateDecks();
        updateScene();
    }

    private void initHoverMethods() {
        Label[] Hovers = new Label[]{LabelHover1, LabelHover2, LabelHover3, LabelHover4, LabelHover5, LabelHover6, LabelHover7};
        for (int i = 0; i < GameInitController.numberOfPlayers; i++){
            int finalI = i;
            Hovers[i].setOnMouseEntered(event -> { hoveredPlayer = finalI + 1; Hovered(); });
            Hovers[i].setOnMouseExited(event -> HoverPane.setVisible(false));
        }
    }
     
    private void initIVsAndSPs() {
        initProgressTokenBTs();

        initPeaceTokenIVs();
        initMaterialTokenSPs();
        initScienceTokenSPs();
        initWarTokenSPs();
        initLaurelTokenSPs();
        initPlayerProgressTokensIVs();
    }

    public void updateScene() throws IOException {
        updateButtons();
        updateImages();
    }

    private void updateButtons() {
        updateNextTurnButton();
        updateDeckButtons();
        updateProgressButtons();
    }

    private void updateProgressButtons() {
        if(gameBoard.getCanDrawProgressToken()){
            progressToken1BT.setDisable(false);
            progressToken2BT.setDisable(false);
            progressToken3BT.setDisable(false);
            progressToken4BT.setDisable(false);
        } else {
            progressToken1BT.setDisable(true);
            progressToken2BT.setDisable(true);
            progressToken3BT.setDisable(true);
            progressToken4BT.setDisable(true);
        }

    }

    private void updateDeckButtons() {
        if(gameBoard.getCanDrawCard()){
            centralDeckButton.setDisable(false);
            rightDeckButton.setDisable(false);
            leftDeckButton.setDisable(false);
        } else {
            centralDeckButton.setDisable(true);
            rightDeckButton.setDisable(true);
            leftDeckButton.setDisable(true);
        }

    }

    private void updateNextTurnButton() {
        nextTurnButton.setDisable(!gameBoard.getCanNextTurn());
    }

    public void updateImages() throws IOException {
        updateDeckImages();
        updateProgressTokenImages();
        //updatePeaceTokenImages();
        updateCatImages();
        updatePlayerImages();
    }

    private void updatePlayerImages() throws IOException {
        loadWonderLayout();
        updatePlayerTokenSPs();
        updatePlayerTokenLabels();
        updatePlayerWonderIVs();
        updatePlayerProgressTokenIVs();
    }

    private void loadWonderLayout() throws IOException {

        String file = "/wonder-layouts/" + currentPlayer.getWonder().getName().toLowerCase() + "-350.fxml";
        URL url = getClass().getResource(file);
        if (url == null) {
            System.out.println("FXML file not found.");
        } else {
            FXMLLoader loader = new FXMLLoader(url);
            AnchorPane anchorPane = loader.load();
            wonderSP.getChildren().clear();
            wonderSP.getChildren().add(anchorPane);
            Node[] children = anchorPane.getChildren().toArray(new Node[0]);
            stage0IV = (ImageView) children[0];
            stage1IV = (ImageView) children[1];
            stage2IV = (ImageView) children[2];
            stage3IV = (ImageView) children[3];
            stage4IV = (ImageView) children[4];
        }
    }



    private void updatePlayerProgressTokenIVs() throws FileNotFoundException {

        for(ImageView iv : playerProgressTokenIVs){ setImage(iv,"tokens-progress/back/token-back");}

        ArrayList<ImageView> imageViews = new ArrayList<>();
        ArrayList<ProgressToken> tokens = currentPlayer.getProgressTokens();

        for(int i = 0; i < tokens.size(); i++){
            setImage(playerProgressTokenIVs.get(i), tokens.get(i).getImageResource());
            imageViews.add(playerProgressTokenIVs.get(i));
        }

        playerProgressTokenIVHB.getChildren().clear();
        for(ImageView iv : imageViews){
            playerProgressTokenIVHB.getChildren().add(iv);
        }
    }

    private void updatePlayerWonderIVs() throws FileNotFoundException {

        Wonder wonder = currentPlayer.getWonder();
        boolean[] built = wonder.getIsStageBuilt();
        ImageView[] ivs = new ImageView[]{stage0IV, stage1IV, stage2IV, stage3IV, stage4IV};

        String name = wonder.getName().toLowerCase();
        String path = "wonders/" + name + "/" + name;

        for(int i = 0; i <= 4; i++){
            String tempPath;
            if(built[i]){
                tempPath = path + "_" + i + "_built";
            } else {
                tempPath = path + "_" + i + "_unbuilt";
            }
            setImage(ivs[i], tempPath);
        }

    }

    private void updatePlayerTokenLabels() {
        int[] tokens = currentPlayer.getNumberOfTokens();
        woodTokenLabel.setText("x" + tokens[0]);
        brickTokenLabel.setText("x" + tokens[1]);
        glassTokenLabel.setText("x" + tokens[2]);
        paperTokenLabel.setText("x" + tokens[3]);
        stoneTokenLabel.setText("x" + tokens[4]);
        goldTokenLabel.setText("x" + tokens[5]);

        architectTokenLabel.setText("x" + tokens[6]);
        lawTokenLabel.setText("x" + tokens[7]);
        mechanicTokenLabel.setText("x" + tokens[8]);

        laurelRed3TokenLabel.setText("x" + tokens[9]);
        laurelBlue2TokenLabel.setText("x" + tokens[10]);
        laurelBlue3TokenLabel.setText("x" + tokens[11]);

        shieldWithoutHornLabel.setText(String.valueOf(tokens[12]));
        shieldWithHornLabel.setText(String.valueOf(tokens[13]));
    }

    private void updatePlayerTokenSPs() {
        updatePlayerMaterialTokenSPs();
        updatePlayerScienceTokenSPs();
        updatePlayerShieldTokenSPs();
        updatePlayerLaurelTokenIVs();
    }

    private void updatePlayerLaurelTokenIVs() {
        ArrayList<StackPane> stackPanes = new ArrayList<>();
        int[] tokens = currentPlayer.getNumberOfTokens();

        for(int i = 9; i <= 11;i++){
            if(tokens[i] > 0){
                stackPanes.add(playerLaurelTokenSPs.get(i-9));
            }
        }
        playerLaurelTokenSPHB.getChildren().clear();
        for(StackPane sp : stackPanes){
            playerLaurelTokenSPHB.getChildren().add(sp);
        }
    }

    private void updatePlayerShieldTokenSPs() {
        ArrayList<StackPane> stackPanes = new ArrayList<>();
        int[] tokens = currentPlayer.getNumberOfTokens();

        for(int i = 12; i <= 13;i++){
            if(tokens[i] > 0){
                stackPanes.add(playerShieldTokenSPs.get(i-12));
            }
        }

        playerShieldTokenSPHB.getChildren().clear();
        for(StackPane sp : stackPanes){
            playerShieldTokenSPHB.getChildren().add(sp);
        }
        
    }

    private void updatePlayerScienceTokenSPs() {
        ArrayList<StackPane> stackPanes = new ArrayList<>();
        int[] tokens = currentPlayer.getNumberOfTokens();

        for(int i = 6; i <= 8;i++){
            if(tokens[i] > 0){
                stackPanes.add(playerScienceTokenSPs.get(i-6));
            }
        }

        playerScienceTokenSPHB.getChildren().clear();
        for(StackPane sp : stackPanes){
            playerScienceTokenSPHB.getChildren().add(sp);
        }
    }

    private void updatePlayerMaterialTokenSPs() {
        ArrayList<StackPane> stackPanes = new ArrayList<>();
        int[] tokens = currentPlayer.getNumberOfTokens();

        for(int i = 0; i <= 5;i++){
            if(tokens[i] > 0){
                stackPanes.add(playerMaterialTokenSPs.get(i));
            }
        }

        playerMaterialTokenSPHB.getChildren().clear();
        for(StackPane sp : stackPanes){
            playerMaterialTokenSPHB.getChildren().add(sp);
        }
    }

    private void updateCatImages() {
        startCatIV.setVisible(!gameBoard.isCatTaken());
        playerCatIV.setVisible(currentPlayer.getHasCat());
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
        ArrayList<Button> buttons = new ArrayList<>();
        if(stack.size() >= 4){
            buttons.addAll(progressTokenBTs);
            setImage(progressToken1IV, "tokens-progress/back/token-back");
            setImage(progressToken2IV, stack.get(1).getImageResource());
            setImage(progressToken3IV, stack.get(2).getImageResource());
            setImage(progressToken4IV, stack.get(3).getImageResource());
        } else if (stack.size() == 3){
            for(int i = 0; i < 3; i++){ buttons.add(progressTokenBTs.get(i)); }
            setImage(progressToken1IV, stack.get(0).getImageResource());
            setImage(progressToken2IV, stack.get(1).getImageResource());
            setImage(progressToken3IV, stack.get(2).getImageResource());
        } else if (stack.size() == 2){
            for(int i = 0; i < 2; i++){ buttons.add(progressTokenBTs.get(i)); }
            setImage(progressToken1IV, stack.get(0).getImageResource());
            setImage(progressToken2IV, stack.get(1).getImageResource());
        } else if (stack.size() == 1){
            buttons.add(progressToken1BT);
            setImage(progressToken1IV, stack.get(0).getImageResource());
        }
        progressTokenBTHB.getChildren().clear();
        for(Button bt : buttons){
            progressTokenBTHB.getChildren().add(bt);
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
        if(!gameBoard.getHasDrawnCard() && currentPlayer.getHasCat()){
            setImage(centralDeckIV, centralDeck.getCardAtIndex(0).getFront());
        } else {
            setImage(centralDeckIV, centralDeck.getBackCardImg());
        }
    }

    private void updateDecks() {
        centralDeck = deckList.get(numPlayers);
        rightDeck = deckList.get(gameBoard.getCurrentPlayerIndex());
        leftDeck = gameBoard.getCurrentPlayerIndex() == 0 ? deckList.get(numPlayers - 1) : deckList.get(gameBoard.getCurrentPlayerIndex() - 1);
    }

    void switchToNextPlayer() throws IOException {
        if (gameBoard.getCurrentPlayerIndex() == playerList.size() - 1) {
            gameBoard.setCurrentPlayerIndex(0);
        } else {
            gameBoard.setCurrentPlayerIndex(gameBoard.getCurrentPlayerIndex() + 1);
        }
        currentPlayer = playerList.get(gameBoard.getCurrentPlayerIndex());
        gameBoard.setHasDrawnCard(false);
        gameBoard.setCanDrawCard(true);
        gameBoard.setCanNextTurn(false);
        playerNameLabel.setText(currentPlayer.getName());
        updateDecks();
        updateImages();
    }

    @FXML
    void onNextTurnButtonClick() throws IOException {
        checkForWar();
        switchToNextPlayer();
        updateDecks();
        updateScene();
    }

    private void checkForWar() {
        if(gameBoard.getCombatTokensFlipped() >= gameBoard.getCombatTokensNeeded()){
            System.out.println("AOUH ! AOUH ! AOUH !");
            gameBoard.setCombatTokensFlipped(0);
        }
        checkPlayerWar(gameBoard, playerList);
    }

    public void onMainDeckButtonClick() throws IOException {
        if (centralDeck.getDeck().size() > 0) {
            drawMiddleDeckCard(gameBoard, 0);
        }
        updateScene();
    }

    public void onLeftDeckButtonClick() throws IOException {
        if (leftDeck.getDeck().size() > 0) {
            drawLeftDeckCard(gameBoard, 0);
        }
        updateScene();
    }

    public void onRightDeckButtonClick() throws IOException {
        if (rightDeck.getDeck().size() > 0) {
            drawRightDeckCard(gameBoard, 0);
        }
        updateScene();
    }

    public void Hovered(){
        HoverPane.setVisible(true);
        //Set Label InfoPlayer en fonction du joueur qui a été hover ( donc valeur de hoveredPlayer )
        InfoPlayer.setText("Player "+ hoveredPlayer + " hovered");
    }

    @FXML

    public void onProgressToken1Click() throws IOException {
        System.out.println("progress token 1 click");
        gameBoard.setCanDrawProgressToken(false);
        drawSelectedProgressToken(gameBoard,0);
        updateScene();
    }

    @FXML
    public void onProgressToken2Click() throws IOException {
        gameBoard.setCanDrawProgressToken(false);
        drawSelectedProgressToken(gameBoard,1);
        updateScene();
    }

    @FXML
    public void onProgressToken3Click() throws IOException {
        gameBoard.setCanDrawProgressToken(false);
        drawSelectedProgressToken(gameBoard,2);
        updateScene();
    }

    @FXML
    public void onProgressToken4Click() throws IOException {
        gameBoard.setCanDrawProgressToken(false);
        drawSelectedProgressToken(gameBoard,3);
        updateScene();
    }

    //initialization Methods
    private void initPlayerProgressTokensIVs() {
        playerProgressTokenIVs = new ArrayList<>();
        playerProgressTokenIVs.add(playerProgTok1IV);
        playerProgressTokenIVs.add(playerProgTok2IV);
        playerProgressTokenIVs.add(playerProgTok3IV);
        playerProgressTokenIVs.add(playerProgTok4IV);
        playerProgressTokenIVs.add(playerProgTok5IV);
        playerProgressTokenIVs.add(playerProgTok6IV);
        playerProgressTokenIVs.add(playerProgTok7IV);
        playerProgressTokenIVs.add(playerProgTok8IV);
    }

    private void initLaurelTokenSPs() {
        playerLaurelTokenSPs = new ArrayList<>();
        playerLaurelTokenSPs.add(laurelRed3TokenSP);
        playerLaurelTokenSPs.add(laurelBlue2TokenSP);
        playerLaurelTokenSPs.add(laurelBlue3TokenSP);
    }

    private void initWarTokenSPs() {
        playerShieldTokenSPs = new ArrayList<>();
        playerShieldTokenSPs.add(shieldWithoutHornSP);
        playerShieldTokenSPs.add(shieldWithHornSP);
    }

    private void initScienceTokenSPs() {
        playerScienceTokenSPs = new ArrayList<>();
        playerScienceTokenSPs.add(architectTokenSP);
        playerScienceTokenSPs.add(lawTokenSP);
        playerScienceTokenSPs.add(mechanicTokenSP);
    }

    private void initMaterialTokenSPs() {
        playerMaterialTokenSPs = new ArrayList<>();
        playerMaterialTokenSPs.add(woodTokenSP);
        playerMaterialTokenSPs.add(brickTokenSP);
        playerMaterialTokenSPs.add(glassTokenSP);
        playerMaterialTokenSPs.add(paperTokenSP);
        playerMaterialTokenSPs.add(stoneTokenSP);
        playerMaterialTokenSPs.add(goldTokenSP);
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


    private void initProgressTokenBTs() {
        progressTokenBTs = new ArrayList<>();
        progressTokenBTs.add(progressToken1BT);
        progressTokenBTs.add(progressToken2BT);
        progressTokenBTs.add(progressToken3BT);
        progressTokenBTs.add(progressToken4BT);
    }

}
