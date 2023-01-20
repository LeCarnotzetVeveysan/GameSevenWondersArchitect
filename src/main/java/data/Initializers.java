package data;

import java.util.ArrayList;
import java.util.Random;

public class Initializers {

    // decks
    private Deck rodhosDeck = new Deck(2,2,2,2,2,2,2,1,1,2,2,2,1,2,"card-back-rhodes.png");
    private Deck halikarnassosDeck = new Deck(3,2,2,2,2,1,1,1,2,2,2,2,1,2,"card-back-halicarnasse.png");
    private Deck gizahDeck = new Deck(3,2,1,2,2,2,1,2,1,2,3,2,0,2,"card-back-gizeh.png");
    private Deck ephesosDeck = new Deck(3,2,2,2,2,2,1,2,2,1,2,2,1,1,"card-back-ephese.png");
    private Deck olympiaDeck = new Deck(3,2,2,1,2,2,1,1,2,1,3,2,1,2,"card-back-olympie.png");
    private Deck babylonDeck = new Deck(3,1,2,2,2,2,2,2,1,2,2,2,1,1,"card-back-babylon.png");
    private Deck alexandriaDeck = new Deck(4,2,2,2,1,2,2,1,1,2,2,2,1,1,"card-back-alexandrie.png");
    private Deck middleDeck = new Deck(6,4,4,4,4,4,4,4,4,4,8,4,2,4,"card-back-question.png");

    // progress tokens
    private ProgressTokenStack progressTokens = new ProgressTokenStack(1,1,1,1,1,1,1,1,1,1,1,1,1,2,"token-back.png");

    private Wonder[] wonders = {Wonder.Rhodes, Wonder.Halicarnasse, Wonder.Gizeh, Wonder.Ephese, Wonder.Olympie, Wonder.Babylon, Wonder.Alexandrie};
    private ArrayList<Wonder> usedWonders = new ArrayList<>();

    // ajoute à la liste des joueurs un nouveau joueur avec le nom passé en paramètre ainsi qu'un des wonders du jeu au hasard (chaque joueur aura un wonder différent)
    public ArrayList<Player> initPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        String[] playerNames = GameData.getPlayerNames();
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
        return players;
    }

    public ArrayList<Deck> initDecks(ArrayList<Player> players) {
        ArrayList<Deck> decks = new ArrayList<>();
        // Add decks to the list of decks
        for (Player player : players) {
            switch (player.getWonder()) {
                case Alexandrie -> decks.add(alexandriaDeck);
                case Halicarnasse -> decks.add(halikarnassosDeck);
                case Ephese -> decks.add(ephesosDeck);
                case Olympie -> decks.add(olympiaDeck);
                case Babylon -> decks.add(babylonDeck);
                case Rhodes -> decks.add(rodhosDeck);
                case Gizeh -> decks.add(gizahDeck);
            }
        }
        decks.add(middleDeck);
        return decks;
    }

    public ProgressTokenStack initProgressTokens() {
        return progressTokens;
    }

    public int initNbCombatTokensNeeded(int nbPlayers) {
        // nombre de combat tokens nécessaire pour lancer une guerre
        return switch (nbPlayers) {
            case 2, 3 -> 3;
            case 4 -> 4;
            case 5 -> 5;
            case 6, 7 -> 6;
            default -> 0;
        };
    }

}
