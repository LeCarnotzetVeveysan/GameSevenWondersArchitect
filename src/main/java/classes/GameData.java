package classes;

import java.util.ArrayList;

public class GameData {

    private final Deck rodhosDeck = new Deck(2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2);
    private final Deck halikarnassosDeck = new Deck(3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 1, 2);
    private final Deck gizahDeck = new Deck(3,2,1,2,2,2,1,2,1,2,3,2,0,2);
    private final Deck ephesosDeck = new Deck(3,2,2,2,2,2,1,2,2,1,2,2,1,1);
    private final Deck olympiaDeck = new Deck(3,2,2,1,2,2,1,1,2,1,3,2,1,2);
    private final Deck babylonDeck = new Deck(3,1,2,2,2,2,2,2,1,2,2,2,1,1);
    private final Deck alexandriaDeck = new Deck(4,2,2,2,1,2,2,1,1,2,2,2,1,1);

    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Deck> decks = new ArrayList<>();
    ArrayList<ProgressToken> progressTokens = new ArrayList<>();

    int combatTokensNeeded;
    int combatTokensFlipped;

    public void initializeDecks() {
        for (Player player : players) {
            switch (player.wonder.getWonderName()) {
                case "Rodhos":
                    decks.add(rodhosDeck);
                    break;
                case "Halikarnassos":
                    decks.add(halikarnassosDeck);
                    break;
                case "Gizah":
                    decks.add(gizahDeck);
                    break;
                case "Ephesos":
                    decks.add(ephesosDeck);
                    break;
                case "Olympia":
                    decks.add(olympiaDeck);
                    break;
                case "Babylon":
                    decks.add(babylonDeck);
                    break;
                case "Alexandria":
                    decks.add(alexandriaDeck);
                    break;
            }
        }
    }

}
