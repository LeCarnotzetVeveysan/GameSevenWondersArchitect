package classes;

import java.util.ArrayList;

public class Game {

    private Data data = new Data();

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private progressTokenStack progressTokens;

    int combatTokensNeeded;
    int combatTokensFlipped;

    public void initializeBoard(ArrayList<String> playerNames) {
        players = data.initializePlayers(playerNames);
        decks = data.initializeDecks(players);
        progressTokens = data.initiatializeProgressTokens();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public progressTokenStack getProgressTokens() {
        return progressTokens;
    }

}
