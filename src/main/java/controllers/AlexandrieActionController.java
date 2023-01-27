package controllers;

import data.Board;
import data.Deck;
import data.GameData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static other.ModelCommonMethods.drawCard;
import static other.UICommonMethods.getTextFromLangDict;
import static other.UICommonMethods.setImage;

public class AlexandrieActionController {

    @FXML
    private Label selectCardLB;
    @FXML
    private ImageView card1IV, card2IV, card3IV, card4IV, card5IV, card6IV, card7IV, card8IV;

    private Board board;
    private ArrayList<Deck> decks;
    private int actionPlayerIndex;

    public void initialize() throws IOException {
        selectCardLB.setText(getTextFromLangDict("selectCard"));
        ImageView[] imageViews = new ImageView[]{card1IV, card2IV, card3IV, card4IV, card5IV, card6IV, card7IV, card8IV};
        board = GameData.getBoard();
        decks = board.getDecks();
        actionPlayerIndex = GameData.getActionPlayerIndex();

        for(ImageView iv : imageViews) {
            iv.setDisable(true);
        }
        for(int i = 0; i < decks.size() - 2; i++){
            imageViews[i].setDisable(false);
            if(decks.get(i).getDeck().size() > 0){
                setImage(imageViews[i], decks.get(i).getCardAtIndex(0).getFront());
            }
        }
        if(decks.get(decks.size() - 1).getDeck().size() > 0){
            setImage(imageViews[decks.size() -1], decks.get(decks.size() -1).getCardAtIndex(0).getFront());
        }
    }

    public void onCard1Clicked() throws IOException {
        drawCard(board,decks.get(0),board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card1IV.getScene().getWindow();
        stage.close();
    }

    public void onCard2Clicked() throws IOException {
        drawCard(board,decks.get(1),board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card2IV.getScene().getWindow();
        stage.close();
    }

    public void onCard3Clicked() throws IOException {
        drawCard(board,decks.get(2),board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card3IV.getScene().getWindow();
        stage.close();
    }

    public void onCard4Clicked() throws IOException {
        drawCard(board,decks.get(3),board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card4IV.getScene().getWindow();
        stage.close();
    }

    public void onCard5Clicked() throws IOException {
        drawCard(board,decks.get(4),board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card5IV.getScene().getWindow();
        stage.close();
    }

    public void onCard6Clicked() throws IOException {
        drawCard(board,decks.get(5),board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card1IV.getScene().getWindow();
        stage.close();
    }

    public void onCard7Clicked() throws IOException {
        drawCard(board,decks.get(6),board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card1IV.getScene().getWindow();
        stage.close();
    }

    public void onCard8Clicked() throws IOException {
        drawCard(board,decks.get(decks.size() - 1),board.getPlayers().get(actionPlayerIndex),0);
        GameData.setBoard(board);
        Stage stage = (Stage) card1IV.getScene().getWindow();
        stage.close();
    }

}
