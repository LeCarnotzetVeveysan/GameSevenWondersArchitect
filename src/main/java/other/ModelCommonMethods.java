<<<<<<< HEAD
package other;

import data.Deck;
import data.Player;
import token.MaterialToken;
import token.ProgressToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void levelUpWonder(Player player) {
        ArrayList<Long> elementTab = elementSimDiffGenerator(player);

        
    }

    public ArrayList<Long> elementSimDiffGenerator(Player player) {
        MaterialToken[] similarMaterials = MaterialToken.values();

        // dans l'odre : wood, glass, brick, stone, paper et nombre de diff
        // pour vérif si contient des éléments similaires : boucle entre 0 et 4
        // pour vérif le nombre d'éléments différents : index 5
        ArrayList<Long> elementTab = new ArrayList<>();

        for (MaterialToken mat: similarMaterials) {
            long countSimilar = player.getMaterialTokens().stream()
                    .filter(s-> s.equals(MaterialToken.GOLD) || s.equals(mat))
                    .count();
            elementTab.add(countSimilar);
        }

        long countGold = player.getMaterialTokens().stream()
                .filter(s-> s.equals(MaterialToken.GOLD))
                .count();
        long countDifferent = player.getMaterialTokens().stream()
                .filter(s-> !s.equals(MaterialToken.GOLD))
                .distinct()
                .count()
                + countGold;
        elementTab.add(countDifferent);

        return elementTab;
    }

}
=======
package other;

import data.*;
import token.MaterialToken;

import java.util.*;

public class ModelCommonMethods {

    private void drawCard(Board board, Deck targetdeck, Player player, int cardIndex) {
        // Récupère la carte à l'index spécifié dans le deck cible
        Cards drawnCard = targetdeck.getDeck().get(cardIndex);
        // Attribue la carte au joueur qui la pioche
        drawnCard.getCardToken(player);
        // Retire la carte du deck cible
        targetdeck.getDeck().remove(cardIndex);
        // Vérifie si le joueur a atteint un niveau de merveille
        chkLevelUpWonder(board);
    }

    public void drawLeftDeckCard(Board board, int selectedCardIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        Player currentPlayer = board.getPlayers().get(currentPlayerIndex);
        // Trouve l'index du joueur à gauche
        int nbPlayers = board.getPlayers().size();
        int leftPlayerIndex = (currentPlayerIndex == 0) ? nbPlayers - 1 : currentPlayerIndex - 1;
        Deck targetdeck = board.getDecks().get(leftPlayerIndex);
        // Pioche une carte depuis le deck du joueur à gauche
        drawCard(board, targetdeck, currentPlayer, selectedCardIndex);
    }

    public void drawMiddleDeckCard(Board board, int selectedCardIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        Player currentPlayer = board.getPlayers().get(currentPlayerIndex);
        // Le deck du milieu est toujours le dernier élément de la liste de decks
        int middleDeckIndex = board.getPlayers().size();
        Deck targetdeck = board.getDecks().get(middleDeckIndex);
        // Pioche une carte depuis le deck du milieu
        drawCard(board, targetdeck, currentPlayer, selectedCardIndex);
    }

    public void drawRightDeckCard(Board board, int selectedCardIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        Player currentPlayer = board.getPlayers().get(currentPlayerIndex);
        // Trouve l'index du joueur à droite
        int nbPlayers = board.getPlayers().size();
        int rightPlayerIndex = (currentPlayerIndex == nbPlayers - 1) ? 0 : currentPlayerIndex + 1;
        Deck targetdeck = board.getDecks().get(rightPlayerIndex);
        // Pioche une carte depuis le deck du joueur à droite
        drawCard(board, targetdeck, currentPlayer, selectedCardIndex);
    }

    public void drawSelectedProgressToken(Board board, int selectedTokenIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        ArrayList<Player> players = board.getPlayers();
        ProgressTokenStack progressTokens = board.getProgressTokens();
        // Ajoute le jeton de progrès sélectionné au joueur actuel
        players.get(currentPlayerIndex).addProgressToken(progressTokens.getProgressTokens().get(selectedTokenIndex));
        // Retire le jeton de progrès de la liste de jetons de progrès
        progressTokens.getProgressTokens().remove(selectedTokenIndex);
    }

    public void chkLevelUpWonder(Board board) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player currentPlayer = board.getPlayers().get(board.getCurrentPlayerIndex());

        // Génère une liste de jetons de matériaux pour le joueur
        ArrayList<Long> elementTab = elementSimDiffGenerator(board);
        // Tableau de jetons de matériaux
        MaterialToken[] elementTabToToken = {MaterialToken.WOOD, MaterialToken.GLASS, MaterialToken.BRICK, MaterialToken.STONE, MaterialToken.PAPER};
        // Crée une map pour stocker le nombre de niveaux dans chaque étape
        Map<Integer, Long> levelsInStages = getNbLevelsInEachStages(currentPlayer);

        for (int i = 0; i < wonder.getNbLevelsInStages().length; i++) {
            // Vérifie si les étages précédents ont été construits
            boolean previousStagesBuilt = wonder.getIsStageBuilt()[i];

            if (!wonder.getIsStageBuilt()[i] && previousStagesBuilt) {
                // Récupère le numéro de l'étape en cours de construction
                int stage = wonder.getNbLevelsInStages()[i];
                // Récupère le nombre de niveaux dans l'étape en cours de construction
                long levelsInCurrentStage = levelsInStages.get(stage);
                if (wonder.getSameMaterials()[i]) {
                    // Vérifie si le joueur a les jetons de matériaux requis pour construire un niveau avec des matériaux identiques
                    updateSameMat(board, elementTab, elementTabToToken, levelsInStages, i, stage, levelsInCurrentStage);
                } else {
                    // Vérifie si le joueur a les jetons de matériaux requis pour construire un niveau avec des matériaux différents
                    updateDiffMat(board, elementTab, levelsInStages, i, stage, levelsInCurrentStage);
                }
            }

        }
    }

    private static Map<Integer, Long> getNbLevelsInEachStages(Player player) {
        Map<Integer, Long> levelsInStages = new HashMap<>();
        for (int i = 0; i < player.getWonder().getNbLevelsInStages().length; i++) {
            int stage = player.getWonder().getNbLevelsInStages()[i];
            if (levelsInStages.containsKey(stage)) {
                levelsInStages.put(stage, levelsInStages.get(stage) + 1);
            } else {
                levelsInStages.put(stage, 1L);
            }
        }
        return levelsInStages;
    }

    private static void updateDiffMat(Board board, ArrayList<Long> elementTab, Map<Integer, Long> levelsInStages, int i, int stage, long levelsInCurrentStage) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());

        if (elementTab.get(5) == wonder.getNbMaterials()[i]) {
            int uniqueCount = 0;
            HashSet<MaterialToken> setToRemove = new HashSet<>();
            for (int m = 0; m < wonder.getNbMaterials()[i]; i++) {
                if (!setToRemove.contains(player.getMaterialTokens().get(i))) {
                    setToRemove.add(player.getMaterialTokens().get(i));
                    uniqueCount++;
                }
                if (uniqueCount == wonder.getNbMaterials()[i]) {
                    break;
                }
            }
            // remove elements from list
            player.getMaterialTokens().removeAll(setToRemove);
            levelUpWonder(board, i);
            levelsInStages.put(stage, levelsInCurrentStage - 1);
        }
    }

    private static void updateSameMat(Board board, ArrayList<Long> elementTab, MaterialToken[] elementTabToToken, Map<Integer, Long> levelsInStages, int i, int stage, long levelsInCurrentStage) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());

        for (int j = 0; j <= 4; j++) {
            if (elementTab.get(j) == wonder.getNbMaterials()[i]) {
                for (int n = 0; n <= wonder.getNbMaterials()[i]; n++) {
                    player.removeMaterialToken(elementTabToToken[j]);
                }
                levelUpWonder(board, i);
                levelsInStages.put(stage, levelsInCurrentStage - 1);
                break;
            }
        }
    }

    private static void levelUpWonder(Board board, int i) {
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();

        wonder.setIsStageBuilt(i, true);
        chkActionWonder(board, i);
        // vérifie si le joueur a construit toutes les étapes de la merveille
        if (wonder.getIsStageBuilt()[wonder.getIsStageBuilt().length - 1]) {
            player.setHasBuiltWonder(true);
            // afficher le tableau de score
        }
    }

    private static void chkActionWonder(Board board, int i) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();

        if (wonder.getLevelAction()[i]) {
            wonder.eventAction(board);
        }
    }

    public ArrayList<Long> elementSimDiffGenerator(Board board) {
        MaterialToken[] similarMaterials = MaterialToken.values();
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());

        // dans l'odre : wood, glass, brick, stone, paper et nombre de diff
        // pour vérif si contient des éléments similaires : boucle entre 0 et 4
        // pour vérif le nombre d'éléments différents : index 5
        ArrayList<Long> elementTab = new ArrayList<>();

        for (MaterialToken mat: similarMaterials) {
            long countSimilar = player.getMaterialTokens().stream()
                    .filter(s-> s.equals(MaterialToken.GOLD) || s.equals(mat))
                    .count();
            elementTab.add(countSimilar);
        }

        long countGold = player.getMaterialTokens().stream()
                .filter(s-> s.equals(MaterialToken.GOLD))
                .count();
        long countDifferent = player.getMaterialTokens().stream()
                .filter(s-> !s.equals(MaterialToken.GOLD))
                .distinct()
                .count()
                + countGold;
        elementTab.add(countDifferent);

        return elementTab;
    }

    public void checkPlayerWar(Board board, ArrayList<Player> players) {
        final int NUM_PLAYERS = players.size();

        for (int currentPlayerIndex = 0; currentPlayerIndex < NUM_PLAYERS; currentPlayerIndex++) {
            int currentPlayerShield = players.get(currentPlayerIndex).getShield();
            int leftNeighborShield = players.get((currentPlayerIndex - 1 + NUM_PLAYERS) % NUM_PLAYERS).getShield();
            int rightNeighborShield = players.get((currentPlayerIndex + 1) % NUM_PLAYERS).getShield();

            if (currentPlayerShield > leftNeighborShield) {
                players.get(currentPlayerIndex).addMilitaryPoints(1);
            }
            if (currentPlayerShield > rightNeighborShield) {
                players.get(currentPlayerIndex).addMilitaryPoints(1);
            }
            // retire les fighters qui n'ont pas de horn
            players.get(currentPlayerIndex).removeFightersWithHorn();
        }

        board.setCombatTokensFlipped(0);
    }

}
>>>>>>> bruce
