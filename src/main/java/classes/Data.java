package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Data {

    // decks
    private final Deck rodhosDeck = new Deck(2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, "card-back-rhodes.png");
    private final Deck halikarnassosDeck = new Deck(3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 1, 2, "card-back-halicarnasse.png");
    private final Deck gizahDeck = new Deck(3,2,1,2,2,2,1,2,1,2,3,2,0,2, "card-back-gizeh.png");
    private final Deck ephesosDeck = new Deck(3,2,2,2,2,2,1,2,2,1,2,2,1,1, "card-back-ephese.png");
    private final Deck olympiaDeck = new Deck(3,2,2,1,2,2,1,1,2,1,3,2,1,2, "card-back-olympie.png");
    private final Deck babylonDeck = new Deck(3,1,2,2,2,2,2,2,1,2,2,2,1,1, "card-back-babylon.png");
    private final Deck alexandriaDeck = new Deck(4,2,2,2,1,2,2,1,1,2,2,2,1,1, "card-back-alexandrie.png");
    private final Deck middleDeck = new Deck(6,4,4,4,4,4,4,4,4,4,8,4,2,4, "card-back-question.png");

    private Wonder[] wonders = {Wonder.Rhodes, Wonder.Halicarnasse, Wonder.Gizeh, Wonder.Ephese, Wonder.Olympie, Wonder.Babylon, Wonder.Alexandrie};
    private ArrayList<Wonder> usedWonders;

    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Deck> decks = new ArrayList<>();
    ArrayList<ProgressToken> progressTokens = new ArrayList<>();

    int combatTokensNeeded;
    int combatTokensFlipped;

    public void initializeBoard(ArrayList<String> playerNames) {
        // ajoute les joueurs à la partie
        addPlayers(playerNames);
        // Add decks to the list of decks
        decks.add(middleDeck);
        for (Player player : players) {
            switch (player.wonder.getName()) {
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
        // Add progress tokens to the list of progress tokens
        progressTokens.addAll(Arrays.asList(ProgressToken.values()));
        progressTokens.add(ProgressToken.Culture);
    }

    // ajoute à la liste des joueurs un nouveau joueur avec le nom passé en paramètre ainsi qu'un des wonders du jeu au hasard (chaque joueur aura un wonder différent)
    public void addPlayers(ArrayList<String> playerNames) {
        // Ajoutez chacun des joueurs demandés
        for (String playerName : playerNames) {
            // Sélectionnez au hasard un des wonders non utilisés
            Random random = new Random();
            int index = random.nextInt(wonders.length - usedWonders.size());
            Wonder wonder = wonders[index];
            while (usedWonders.contains(wonder)) {
                index = random.nextInt(wonders.length - usedWonders.size());
                wonder = wonders[index];
            }

            // Créez un nouveau joueur avec le nom et le wonder sélectionnés au hasard
            Player player = new Player(playerName, wonder);

            // Ajoutez le joueur à la liste des joueurs et marquez le wonder comme utilisé
            players.add(player);
            usedWonders.add(wonder);
        }
    }

}
