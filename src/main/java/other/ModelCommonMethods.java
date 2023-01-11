package other;

import data.Deck;
import data.Player;
import token.ProgressToken;

import java.util.ArrayList;

public class ModelCommonMethods {

    public void drawLeftDeck(ArrayList<Deck> decks, ArrayList<Player> players, int crntPlayerIndex) {
        int leftPlayerIndex;

        if (crntPlayerIndex == 0) {
            leftPlayerIndex = players.size() - 1;
        } else {
            leftPlayerIndex = crntPlayerIndex - 1;
        }

        drawDeck(decks, players, crntPlayerIndex, leftPlayerIndex);
    }

    public void drawMiddleDeck(ArrayList<Deck> decks, ArrayList<Player> players, int crntPlayerIndex) {
        int middleDeckIndex = players.size(); // middle deck is always the last deck in the array

        drawDeck(decks, players, crntPlayerIndex, middleDeckIndex);
    }

    public void drawRightDeck(ArrayList<Deck> decks, ArrayList<Player> players, int crntPlayerIndex) {
        int rightPlayerIndex;

        if (crntPlayerIndex == players.size() - 1) {
            rightPlayerIndex = 0;
        } else {
            rightPlayerIndex = crntPlayerIndex + 1;
        }

        drawDeck(decks, players, crntPlayerIndex, rightPlayerIndex);
    }

    private void drawDeck(ArrayList<Deck> decks, ArrayList<Player> players, int picker, int targetDeck) {
        decks.get(targetDeck).getDeck().get(0).getCardToken(players.get(picker));
        removeDrawCard(decks.get(targetDeck), 0);
    }

    public void removeDrawCard(Deck deck, int index) {
        deck.getDeck().remove(index);
    }

    // l'index 0 correspond à la pile inconnue sur les 4 tokens et les 1 2 3 correspondent aux 3 visibles
    public void drawSelectedProgressToken(ArrayList<ProgressToken> progressTokens, ArrayList<Player> players, int crntPlayerIndex, int selectedTokenIndex) {
        players.get(crntPlayerIndex).addProgressToken(progressTokens.get(selectedTokenIndex));
        removeDrawPToken(progressTokens, selectedTokenIndex);
    }

    public void removeDrawPToken(ArrayList<ProgressToken> progressTokens, int index) {
        progressTokens.remove(index);
    }

}
