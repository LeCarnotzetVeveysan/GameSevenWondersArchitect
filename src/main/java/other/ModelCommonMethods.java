package other;

import data.*;
import token.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModelCommonMethods {

    public static void drawCard(Board board, Deck targetdeck, Player player, int cardIndex) {
        // Récupère la carte à l'index spécifié dans le deck cible
        Cards drawnCard = targetdeck.getCardAtIndex(cardIndex);
        // Attribue la carte au joueur qui la pioche et vérifie si le joueur a le progrès Economy
        drawCardWithChkProgress(player, drawnCard);
        // Vérifie si la carte contenait un chat Bastet
        verifCardHasCat(board, drawnCard);
        // Vérifie si la carte était un ARCHER ou BARBARIAN
        verifCardHasFighter(board, drawnCard);
        // Retire la carte du deck cible
        targetdeck.getDeck().remove(cardIndex);
        // Vérifie si le joueur peut piocher un progress token
        chkProgressTokenDrawingStatus(board);
        // Vérifie si le joueur a atteint un niveau de merveille
        chkLevelUpWonder(board);
        System.out.println(player.getMaterialTokens());
    }

    public static void drawLeftDeckCard(Board board, int selectedCardIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        Player currentPlayer = board.getPlayers().get(currentPlayerIndex);

        // Trouve l'index du joueur à gauche
        int nbPlayers = board.getPlayers().size();
        int leftPlayerIndex = (currentPlayerIndex == 0) ? nbPlayers - 1 : currentPlayerIndex - 1;

        Deck targetdeck = board.getDecks().get(leftPlayerIndex);
        // Pioche une carte depuis le deck du joueur à gauche
        drawCard(board, targetdeck, currentPlayer, selectedCardIndex);
    }

    public static void drawMiddleDeckCard(Board board, int selectedCardIndex) {
        int middleDeckIndex = board.getPlayers().size();
        Player currentPlayer = board.getPlayers().get(board.getCurrentPlayerIndex());

        Deck targetdeck = board.getDecks().get(middleDeckIndex);
        // Pioche une carte depuis le deck du milieu
        drawCard(board, targetdeck, currentPlayer, selectedCardIndex);
    }

    public static void drawRightDeckCard(Board board, int selectedCardIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        Player currentPlayer = board.getPlayers().get(currentPlayerIndex);

        Deck targetdeck = board.getDecks().get(currentPlayerIndex);
        // Pioche une carte depuis le deck du joueur à droite
        drawCard(board, targetdeck, currentPlayer, selectedCardIndex);
    }

    public static void drawCardWithChkProgress(Player player, Cards drawnCard) {
        if (verifPlayerProgressToken(player, ProgressToken.Economy) && verifDrawnCard(drawnCard, Cards.MAT_GOLD)) {
            drawnCard.getCardTokenToPlayer(player);
            drawnCard.getCardTokenToPlayer(player);
        } else {
            drawnCard.getCardTokenToPlayer(player);
        }
        if (player.getProgressTokens().contains(ProgressToken.Urbanism) && (verifDrawnCard(drawnCard, Cards.MAT_WOOD) || verifDrawnCard(drawnCard, Cards.MAT_BRICK))) {
            // pioche parmi les 3
        }
        if (player.getProgressTokens().contains(ProgressToken.ArtsAndCrafts) && (verifDrawnCard(drawnCard, Cards.MAT_PAPER) || verifDrawnCard(drawnCard, Cards.MAT_GLASS))) {
            // pioche parmi les 3
        }
        if (player.getProgressTokens().contains(ProgressToken.Jewelry) && (verifDrawnCard(drawnCard, Cards.MAT_STONE) || verifDrawnCard(drawnCard, Cards.MAT_GOLD))) {
            // pioche parmi les 3
        }
        if (player.getProgressTokens().contains(ProgressToken.Science) && drawnCard.getType().equals("Science")) {
            // pioche parmi les 3
        }
        if (player.getProgressTokens().contains(ProgressToken.Propaganda) && drawnCard.getType().equals("Military") && (drawnCard.getMilitaryCardToken() == Fighter.ARCHER || drawnCard.getMilitaryCardToken() == Fighter.BARBARIAN)) {
            // pioche parmi les 3
        }
    }

    public static boolean verifPlayerProgressToken(Player player, ProgressToken progressToken) {
        return player.getProgressTokens().contains(progressToken);
    }

    public static boolean verifDrawnCard(Cards drawnCard, Cards cardToCheck) {
        return drawnCard == cardToCheck;
    }

    public static void verifCardHasCat(Board board, Cards drawnCard) {
        ArrayList<Player> players = board.getPlayers();
        Player player = players.get(board.getCurrentPlayerIndex());

        if (drawnCard.getLaurelCardToken() == LaurelToken.LAUREL_BLUE_2) {
            for (Player p : players) {
                if (p != player) {
                    p.setHasCat(false);
                }
            }
            player.setHasCat(true);
            board.catIsNowTaken();
        }
    }

    public static void verifCardHasFighter(Board board, Cards drawnCard) {
        if (drawnCard.getMilitaryCardToken() == Fighter.ARCHER) {
            board.setCombatTokensFlipped(board.getCombatTokensFlipped() + 2);
        } else if (drawnCard.getMilitaryCardToken() == Fighter.BARBARIAN) {
            board.setCombatTokensFlipped(board.getCombatTokensFlipped() + 1);
        }
    }

    public static void drawSelectedProgressToken(Board board, int selectedTokenIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        ArrayList<Player> players = board.getPlayers();
        ProgressTokenStack progressTokens = board.getProgressTokens();
        // Ajoute le jeton de progrès sélectionné au joueur actuel
        players.get(currentPlayerIndex).addProgressToken(progressTokens.getProgressTokens().get(selectedTokenIndex));
        // Retire le jeton de progrès de la liste de jetons de progrès
        progressTokens.getProgressTokens().remove(selectedTokenIndex);
    }

    public static void chkProgressTokenDrawingStatus(Board board) {
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());

        Map<ProgressToken, Long> countSimilar = player.getProgressTokens().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        boolean similarRemoved = false;
        boolean differentRemoved = false;

        for (Map.Entry<ProgressToken, Long> entry : countSimilar.entrySet()) {
            if (entry.getValue() >= 2) {
                for (int i = 0; i < 2; i++) {
                    player.getProgressTokens().remove(entry.getKey());
                }
                similarRemoved = true;
                break;
            }
        }
        long countDifferent = player.getProgressTokens().size() - countSimilar.size();
        if (countDifferent >= 3) {
            List<ProgressToken> differents = player.getProgressTokens().stream().distinct().toList();
            for (int i = 0; i < 3; i++) {
                player.getProgressTokens().remove(differents.get(i));
            }
            differentRemoved = true;
        }
        if (similarRemoved || differentRemoved) {
            //appel de la méthode additionnelle
            showProgressTokenToDraw();
        }
    }

    public static void showProgressTokenToDraw() {
        // active les boutons de progress tokens pour pouvoir en piocher
    }

    public static void chkLevelUpWonder(Board board) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player currentPlayer = board.getPlayers().get(board.getCurrentPlayerIndex());

        // Génère une liste de jetons de matériaux pour le joueur
        ArrayList<Long> materialTab = materialSimDiffGenerator(board);
        // Tableau de jetons de matériaux
        MaterialToken[] elementTabToToken = {MaterialToken.WOOD, MaterialToken.GLASS, MaterialToken.BRICK, MaterialToken.STONE, MaterialToken.PAPER};

        for (int i = 0; i < wonder.getNbLevelsInStages().length; i++) {
            for (int n = 0; n < wonder.getNbLevelsInStages()[i]; n++) {
                boolean previousStageBuild = verifPreviousStageBuilt(currentPlayer);
            }
        }
    }

    public static boolean verifPreviousStageBuilt(Player player) {
        // faire une boucle vérifiant l'étage précédent et dans le cas où tous les niveaux de l'étage sont construits, return true
    }

    /*
    public static void chkLevelUpWonder(Board board) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player currentPlayer = board.getPlayers().get(board.getCurrentPlayerIndex());

        // Génère une liste de jetons de matériaux pour le joueur
        ArrayList<Long> materialTab = materialSimDiffGenerator(board);
        // Tableau de jetons de matériaux
        MaterialToken[] elementTabToToken = {MaterialToken.WOOD, MaterialToken.GLASS, MaterialToken.BRICK, MaterialToken.STONE, MaterialToken.PAPER, MaterialToken.GOLD};
        // Crée une map pour stocker le nombre de niveaux dans chaque étape
        Map<Integer, Long> levelsInStages = getNbLevelsInEachStages(currentPlayer);

        for (int i = 0; i < wonder.getNbLevelsInStages().length; i++) {
            // Vérifie si les étages précédents ont été construits
            boolean previousStagesBuilt = (i == 0) || (wonder.getIsStageBuilt()[i - 1]);
            System.out.println("i" + i);
            System.out.println("previousStagesBuilt = " + previousStagesBuilt);
            System.out.println("levelsInStages.get(i) = " + levelsInStages.get(i));
            System.out.println("wonder.getNbLevelsInStages()[i] = " + wonder.getNbLevelsInStages()[i]);
            System.out.println("wonder.getNbMaterials()[i]" + wonder.getNbMaterials()[i]);
            System.out.println("wonder.getSameMaterials()[i]" + wonder.getSameMaterials()[i]);
            if (!wonder.getIsStageBuilt()[i] && previousStagesBuilt) {
                // Récupère le numéro de l'étape en cours de construction
                int stage = wonder.getNbLevelsInStages()[i];
                // Récupère le nombre de niveaux dans l'étape en cours de construction
                long levelsInCurrentStage = levelsInStages.get(stage);
                if (wonder.getSameMaterials()[i]) {
                    // Vérifie si le joueur a les jetons de matériaux requis pour construire un niveau avec des matériaux identiques
                    if (updateSameMat(board, materialTab, elementTabToToken, levelsInStages, i, stage, levelsInCurrentStage)) {
                        break;
                    }
                } else {
                    // Vérifie si le joueur a les jetons de matériaux requis pour construire un niveau avec des matériaux différents
                    if(updateDiffMat(board, materialTab, levelsInStages, i, stage, levelsInCurrentStage)) {
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(wonder.getIsStageBuilt()));
        }
    }
     */

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

    private static boolean updateDiffMat(Board board, ArrayList<Long> elementTab, Map<Integer, Long> levelsInStages, int i, int stage, long levelsInCurrentStage) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());

        System.out.println("element diff " + (elementTab.get(elementTab.size()-1)));
        System.out.println(elementTab);

        if ((elementTab.get(elementTab.size()-1) >= wonder.getNbMaterials()[i])) {
            System.out.println("passage diff mat");
            int uniqueCount = 0;
            HashSet<MaterialToken> setToRemove = new HashSet<>();
            for (int m = 0; m < wonder.getNbMaterials()[i]; m++) {
                if (!setToRemove.contains(player.getMaterialTokens().get(m))) {
                    setToRemove.add(player.getMaterialTokens().get(m));
                    uniqueCount++;
                }
                if (uniqueCount == wonder.getNbMaterials()[i]) {
                    break;
                }
            }
            chkArchitecture(player);
            // remove elements from list
            player.getMaterialTokens().removeAll(setToRemove);
            levelUpWonder(board, i);
            levelsInStages.put(stage, levelsInCurrentStage - 1);
            return true;
        } else {
            return false;
        }
    }

    private static boolean updateSameMat(Board board, ArrayList<Long> elementTab, MaterialToken[] elementTabToToken, Map<Integer, Long> levelsInStages, int i, int stage, long levelsInCurrentStage) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());
        // nom de variable pour savoir si des jetons de matériaux ont été retirés
        boolean materialRemoved = false;

        for (int j = 0; j <= elementTab.size() - 2; j++) {
            if (elementTab.get(j) == wonder.getNbMaterials()[i]) {
                for (int n = 0; n < wonder.getNbMaterials()[i]; n++) {
                    player.removeMaterialToken(elementTabToToken[j]);
                    System.out.println(n);
                }
                chkArchitecture(player);
                levelUpWonder(board, i);
                levelsInStages.put(stage, levelsInCurrentStage - 1);
                materialRemoved = true;
                break;
            }
        }

        return materialRemoved;
    }

    public static void chkArchitecture(Player player) {
        if (player.getProgressTokens().contains(ProgressToken.Architecture)) {
            // pioche parmi les 3
        }
    }

    private static void levelUpWonder(Board board, int i) {
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();

        wonder.getIsStageBuilt()[i] = true;
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

    public static ArrayList<Long> materialSimDiffGenerator(Board board) {
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

    public static void checkPlayerWar(Board board, ArrayList<Player> players) {
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
