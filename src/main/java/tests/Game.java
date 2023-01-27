package tests;

import data.Data;
import data.Deck;
import data.Player;
import data.ProgressTokenStack;

import java.util.ArrayList;

public class Game {

    private Data data = new Data();

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private ProgressTokenStack progressTokens;

    private int currentPlayerIndex = 0;

    private int combatTokensNeeded;
    private int combatTokensFlipped;

    public void initializeBoard(ArrayList<String> playerNames) {
        players = data.initializePlayers(playerNames);
        decks = data.initializeDecks(players);
        progressTokens = data.initiatializeProgressTokens();
    }

    public void nextTurn() {
        if (currentPlayerIndex == players.size() - 1) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public ProgressTokenStack getProgressTokens() {
        return progressTokens;
    }

}
