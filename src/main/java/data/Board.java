package data;

import java.util.ArrayList;

public class Board {

    private final Initializers initializers = new Initializers();

    private final ArrayList<Player> players;
    private final ArrayList<Deck> decks;
    private final ProgressTokenStack progressTokens;

    private int currentPlayerIndex;

    private boolean isCatTaken;
    private boolean canNextTurn;
    private boolean canDrawProgressToken;
    private boolean hasDrawnCard;
    private boolean canDrawCard;

    int combatTokensNeeded;
    int combatTokensFlipped = 0;

    public Board() {
        players = initializers.initPlayers();
        decks = initializers.initDecks(players);
        progressTokens = initializers.initProgressTokens();
        combatTokensNeeded = initializers.initNbCombatTokensNeeded(this.players.size());
        isCatTaken = false;
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

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
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

    public boolean getCanNextTurn(){ return canNextTurn; }

    public void setCanNextTurn(boolean input){ canNextTurn = input; }

    public boolean getCanDrawCard(){ return canDrawCard; }

    public void setCanDrawCard(boolean input) { canDrawCard = input; }

    public boolean getCanDrawProgressToken(){ return canDrawProgressToken; }

    public void setCanDrawProgressToken(boolean input){ canDrawProgressToken = input; }

    public boolean getHasDrawnCard(){ return hasDrawnCard; }

    public void setHasDrawnCard(boolean input){ hasDrawnCard = input; }
}
