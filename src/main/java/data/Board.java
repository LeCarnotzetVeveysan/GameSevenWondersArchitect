package data;

import java.util.ArrayList;

public class Board {

    private final Initializers initializers = new Initializers();

    private final ArrayList<Player> players;
    private final ArrayList<Deck> decks;
    private final ProgressTokenStack progressTokens;

    private int currentPlayerIndex = 0;

    int combatTokensNeeded;
    int combatTokensFlipped;

    public Board(ArrayList<String> playerNames) {
        players = initializers.initPlayers(playerNames);
        decks = initializers.initDecks(players);
        progressTokens = initializers.initProgressTokens();
        combatTokensNeeded = initializers.initNbCombatTokensNeeded(this.players.size());
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
