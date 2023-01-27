package controllers;

import data.Board;
import data.Deck;
import data.GameData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static other.ModelCommonMethods.drawCard;
import static other.UICommonMethods.setImage;

public class HalicarnasseActionController {

    @FXML
    private Button leftDeckButton, rightDeckButton;
    @FXML
    private Button card1Button, card2Button, card3Button, card4Button, card5Button;
    @FXML
    private ImageView card1IV, card2IV, card3IV, card4IV, card5IV;
    private Button[] cardButtons;
    private ImageView[] imageViews;
    private ArrayList<Deck> decks;
    private Deck deck;
    private Board board;
    private int actionPlayerIndex;

    public void initialize(){
        cardButtons = new Button[]{ card1Button, card2Button, card3Button, card4Button, card5Button };
        imageViews = new ImageView[]{card1IV, card2IV, card3IV, card4IV, card5IV};
        for(Button bt : cardButtons) {
            bt.setDisable(true);
        }
        board = GameData.getBoard();
        decks = board.getDecks();
        actionPlayerIndex = GameData.getActionPlayerIndex();
    }

    public void onLeftDeckButtonClick(MouseEvent mouseEvent) throws FileNotFoundException {
        if(GameData.getActionPlayerIndex() == 0){
            deck = decks.get(decks.size() - 2);
        } else {
            deck = decks.get(GameData.getActionPlayerIndex());
        }
        leftDeckButton.setDisable(true);
        rightDeckButton.setDisable(true);
        int limit = Math.min(5, deck.getDeck().size() - 1);
        for(int i = 0; i < limit; i++){
            setImage(imageViews[i],deck.getDeck().get(i).getFront());
            cardButtons[i].setDisable(false);
        }
    }

    public void onRightDeckButtonClick() throws FileNotFoundException {
        deck = decks.get(GameData.getActionPlayerIndex());
        leftDeckButton.setDisable(true);
        rightDeckButton.setDisable(true);
        int limit = Math.min(5, deck.getDeck().size() - 1);
        for(int i = 0; i < limit; i++){
            setImage(imageViews[i],deck.getDeck().get(i).getFront());
            cardButtons[i].setDisable(false);
        }
    }

    public void onCard1Chosen(MouseEvent mouseEvent) throws IOException {
        drawCard(board,deck,board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card1Button.getScene().getWindow();
        stage.close();
    }

    public void onCard2Chosen(MouseEvent mouseEvent) throws IOException {
        drawCard(board,deck,board.getPlayers().get(actionPlayerIndex),1);
        GameData.setBoard(board);
        Stage stage = (Stage) card2Button.getScene().getWindow();
        stage.close();
    }

    public void onCard3Chosen(MouseEvent mouseEvent) throws IOException {
        drawCard(board,deck,board.getPlayers().get(actionPlayerIndex),2);
        GameData.setBoard(board);
        Stage stage = (Stage) card3Button.getScene().getWindow();
        stage.close();
    }

    public void onCard4Chosen(MouseEvent mouseEvent) throws IOException {
        drawCard(board,deck,board.getPlayers().get(actionPlayerIndex),3);
        GameData.setBoard(board);
        Stage stage = (Stage) card4Button.getScene().getWindow();
        stage.close();
    }

    public void onCard5Chosen(MouseEvent mouseEvent) throws IOException {
        drawCard(board,deck,board.getPlayers().get(actionPlayerIndex),4);
        GameData.setBoard(board);
        Stage stage = (Stage) card5Button.getScene().getWindow();
        stage.close();
    }
}
