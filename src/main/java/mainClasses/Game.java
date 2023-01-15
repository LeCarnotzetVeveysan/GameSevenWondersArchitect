package mainClasses;

import data.Initializers;
import data.Deck;
import data.Player;
import data.ProgressTokenStack;

import java.util.ArrayList;

public class Game {

    private Initializers initializers = new Initializers();

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private ProgressTokenStack progressTokens;

    private int currentPlayerIndex = 0;

    int combatTokensNeeded;
    int combatTokensFlipped;

    public void initializeBoard(ArrayList<String> playerNames) {
        players = initializers.players(playerNames);
        decks = initializers.decks(players);
        progressTokens = initializers.progressTokens();
        combatTokensNeeded = initializers.nbCombatTokensNeeded(players.size());
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

    public void addCombatTokensFlipped(int combatTokensFlipped) {
        this.combatTokensFlipped += combatTokensFlipped;
    }

    public void setCombatTokensFlipped(int combatTokensFlipped) {
        this.combatTokensFlipped = combatTokensFlipped;
    }

    public int getCombatTokensFlipped() {
        return combatTokensFlipped;
    }

    public int getCombatTokensNeeded() {
        return combatTokensNeeded;
    }

}
