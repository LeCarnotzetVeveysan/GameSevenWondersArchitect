package other;

import data.Deck;
import data.Player;

import java.util.ArrayList;

public class ModelCommonMethods {

    public void nextTurn() {

    }

    public void drawLeftDeck(ArrayList<Deck> decks, ArrayList<Player> players, int crntPlayerIndex) {
        int leftPlayerIndex;

        if (crntPlayerIndex == 0) {
            leftPlayerIndex = players.size() - 1;
        } else {
            leftPlayerIndex = crntPlayerIndex - 1;
        }

        if (decks.get(leftPlayerIndex).getDeck().get(0).getType().equals("Material")) {

        }
    }

    public void drawMiddleDeck() {

    }

    public void drawRightDeck() {

    }

    public void drawProgressToken() {

    }

}
