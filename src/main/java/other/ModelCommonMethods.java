package other;

import mainClasses.Game;
import data.Deck;
import data.Player;
import data.Cards;
import token.MaterialToken;
import token.ProgressToken;

import java.util.*;

public class ModelCommonMethods {

    Game game = new Game();

    private void drawCard(ArrayList<Deck> decks, ArrayList<Player> players, int currentPlayerIndex, int targetDeckIndex, int cardIndex) {
        // Récupère la carte à l'index spécifié dans le deck cible
        Cards drawnCard = decks.get(targetDeckIndex).getDeck().get(cardIndex);
        // Attribue la carte au joueur qui la pioche
        drawnCard.getCardToken(players.get(currentPlayerIndex));
        // Retire la carte du deck cible
        decks.get(targetDeckIndex).getDeck().remove(cardIndex);
        // Vérifie si le joueur a atteint un niveau de merveille
        chkLevelUpWonder(players.get(currentPlayerIndex));
    }

    public void drawLeftDeckCard(ArrayList<Deck> decks, ArrayList<Player> players, int currentPlayerIndex, int selectedCardIndex) {
        // Trouve l'index du joueur à gauche
        int leftPlayerIndex = (currentPlayerIndex == 0) ? players.size() - 1 : currentPlayerIndex - 1;
        // Pioche une carte depuis le deck du joueur à gauche
        drawCard(decks, players, currentPlayerIndex, leftPlayerIndex, selectedCardIndex);
    }

    public void drawMiddleDeckCard(ArrayList<Deck> decks, ArrayList<Player> players, int currentPlayerIndex, int selectedCardIndex) {
        // Le deck du milieu est toujours le dernier élément de la liste de decks
        int middleDeckIndex = players.size();
        // Pioche une carte depuis le deck du milieu
        drawCard(decks, players, currentPlayerIndex, middleDeckIndex, selectedCardIndex);
    }

    public void drawRightDeckCard(ArrayList<Deck> decks, ArrayList<Player> players, int currentPlayerIndex, int selectedCardIndex) {
        // Trouve l'index du joueur à droite
        int rightPlayerIndex = (currentPlayerIndex == players.size() - 1) ? 0 : currentPlayerIndex + 1;
        // Pioche une carte depuis le deck du joueur à droite
        drawCard(decks, players, currentPlayerIndex, rightPlayerIndex, selectedCardIndex);
    }

    public void drawSelectedProgressToken(ArrayList<ProgressToken> progressTokens, ArrayList<Player> players, int currentPlayerIndex, int selectedTokenIndex) {
        // Ajoute le jeton de progrès sélectionné au joueur actuel
        players.get(currentPlayerIndex).addProgressToken(progressTokens.get(selectedTokenIndex));
        // Retire le jeton de progrès de la liste de jetons de progrès
        progressTokens.remove(selectedTokenIndex);
    }

    public void chkLevelUpWonder(Player player) {
        // Génère une liste de jetons de matériaux pour le joueur
        ArrayList<Long> elementTab = elementSimDiffGenerator(player);
        // Tableau de jetons de matériaux
        MaterialToken[] elementTabToToken = {MaterialToken.WOOD, MaterialToken.GLASS, MaterialToken.BRICK, MaterialToken.STONE, MaterialToken.PAPER};
        // Crée une map pour stocker le nombre de niveaux dans chaque étape
        Map<Integer, Long> levelsInStages = getNbLevelsInEachStages(player);

        for (int i = 0; i < player.getWonder().getNbLevelsInStages().length; i++) {
            // Vérifie si les étages précédents ont été construits
            boolean previousStagesBuilt = player.getWonder().getIsStageBuilt()[i];

            if (!player.getWonder().getIsStageBuilt()[i] && previousStagesBuilt) {
                // Récupère le numéro de l'étape en cours de construction
                int stage = player.getWonder().getNbLevelsInStages()[i];
                // Récupère le nombre de niveaux dans l'étape en cours de construction
                long levelsInCurrentStage = levelsInStages.get(stage);
                if (player.getWonder().getSameMaterials()[i]) {
                    // Vérifie si le joueur a les jetons de matériaux requis pour construire un niveau avec des matériaux identiques
                    updateSameMat(player, elementTab, elementTabToToken, levelsInStages, i, stage, levelsInCurrentStage);
                } else {
                    // Vérifie si le joueur a les jetons de matériaux requis pour construire un niveau avec des matériaux différents
                    updateDiffMat(player, elementTab, levelsInStages, i, stage, levelsInCurrentStage);
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

    private static void updateDiffMat(Player player, ArrayList<Long> elementTab, Map<Integer, Long> levelsInStages, int i, int stage, long levelsInCurrentStage) {
        if (elementTab.get(5) == player.getWonder().getNbMaterials()[i]) {
            int uniqueCount = 0;
            HashSet<MaterialToken> setToRemove = new HashSet<>();
            for (int m = 0; m < player.getWonder().getNbMaterials()[i]; i++) {
                if (!setToRemove.contains(player.getMaterialTokens().get(i))) {
                    setToRemove.add(player.getMaterialTokens().get(i));
                    uniqueCount++;
                }
                if (uniqueCount == player.getWonder().getNbMaterials()[i]) {
                    break;
                }
            }
            // remove elements from list
            player.getMaterialTokens().removeAll(setToRemove);
            levelUpWonder(player, i);
            levelsInStages.put(stage, levelsInCurrentStage - 1);
        }
    }

    private static void updateSameMat(Player player, ArrayList<Long> elementTab, MaterialToken[] elementTabToToken, Map<Integer, Long> levelsInStages, int i, int stage, long levelsInCurrentStage) {
        for (int j = 0; j <= 4; j++) {
            if (elementTab.get(j) == player.getWonder().getNbMaterials()[i]) {
                for (int n = 0; n <= player.getWonder().getNbMaterials()[i]; n++) {
                    player.removeMaterialToken(elementTabToToken[j]);
                }
                levelUpWonder(player, i);
                levelsInStages.put(stage, levelsInCurrentStage - 1);
                break;
            }
        }
    }

    private static void levelUpWonder(Player player, int i) {
        player.getWonder().setIsStageBuilt(i, true);
        chkActionWonder(player, i);
        // vérifie si le joueur a construit toutes les étapes de la merveille
        if (player.getWonder().getIsStageBuilt()[player.getWonder().getIsStageBuilt().length - 1]) {
            player.setHasBuiltWonder(true);
            // afficher le tableau de score
        }
    }

    private static void chkActionWonder(Player player, int i) {
        if (player.getWonder().getLevelAction()[i]) {
            player.getWonder().eventAction();
        }
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

    public void checkPlayerWar(ArrayList<Player> players) {
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

        game.setCombatTokensFlipped(0);
    }

}
