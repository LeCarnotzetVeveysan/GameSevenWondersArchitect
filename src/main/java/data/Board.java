package data;

import java.util.ArrayList;

public class Board {

    private final Initializers initializers = new Initializers();

    private final ArrayList<Player> players;
    private final ArrayList<Deck> decks;
    private final ProgressTokenStack progressTokens;

    private int currentPlayerIndex = 0;

    private boolean isCatTaken;

    int combatTokensNeeded;
    int combatTokensFlipped;

    public Board() {
        players = initializers.initPlayers();
        decks = initializers.initDecks(players);
        progressTokens = initializers.initProgressTokens();
        combatTokensNeeded = initializers.initNbCombatTokensNeeded(this.players.size());
        isCatTaken = false;
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

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
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

    public boolean isCatTaken() {
        return isCatTaken;
    }

    public void catIsNowTaken(){
        isCatTaken = true;
    }

}
