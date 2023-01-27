package utils;

import data.*;
import token.*;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModelCommonMethods {

    public static boolean isDeckEmpty(Deck inputDeck){
        return inputDeck.getDeck().isEmpty();
    }

    public static void drawCard(Board board, Deck targetdeck, Player player, int cardIndex) {
        // Récupère la carte à l'index spécifié dans le deck cible
        Cards drawnCard = targetdeck.getCardAtIndex(cardIndex);
        // Attribue la carte au joueur qui la pioche et vérifie si le joueur a le progrès Economy
        drawCardWithChkProgress(player, drawnCard, board);
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
        board.setCanNextTurn(!board.getCanDrawProgressToken() && !board.getCanDrawCard());
    }

    public static void drawLeftDeckCard(Board board, int selectedCardIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        Player currentPlayer = board.getPlayers().get(currentPlayerIndex);

        // Trouve l'index du joueur à gauche
        int nbPlayers = board.getPlayers().size();
        int leftPlayerIndex = (currentPlayerIndex == 0) ? nbPlayers - 1 : currentPlayerIndex - 1;

        Deck targetdeck = board.getDecks().get(leftPlayerIndex);
        if(!isDeckEmpty(targetdeck)){
            board.setCanDrawCard(false);
            board.setHasDrawnCard(true);
            board.setCanNextTurn(false);
            // Pioche une carte depuis le deck du joueur à gauche
            drawCard(board, targetdeck, currentPlayer, selectedCardIndex);
        }

    }

    public static void drawMiddleDeckCard(Board board, int selectedCardIndex) {
        int middleDeckIndex = board.getPlayers().size();
        Player currentPlayer = board.getPlayers().get(board.getCurrentPlayerIndex());

        Deck targetDeck = board.getDecks().get(middleDeckIndex);
        if(!isDeckEmpty(targetDeck)){
            board.setCanDrawCard(false);
            board.setHasDrawnCard(true);
            board.setCanNextTurn(false);
            // Pioche une carte depuis le deck du joueur à gauche
            drawCard(board, targetDeck, currentPlayer, selectedCardIndex);
        }
    }

    public static void drawRightDeckCard(Board board, int selectedCardIndex) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        Player currentPlayer = board.getPlayers().get(currentPlayerIndex);

        Deck targetDeck = board.getDecks().get(currentPlayerIndex);
        if(!isDeckEmpty(targetDeck)){
            board.setCanDrawCard(false);
            board.setHasDrawnCard(true);
            board.setCanNextTurn(true);
            // Pioche une carte depuis le deck du joueur à gauche
            drawCard(board, targetDeck, currentPlayer, selectedCardIndex);
        }
    }

    public static void drawCardWithChkProgress(Player player, Cards drawnCard, Board board) {
        if (verifPlayerProgressToken(player, ProgressToken.Economy) && verifDrawnCard(drawnCard, Cards.MAT_GOLD)) {
            drawnCard.getCardTokenToPlayer(player);
            drawnCard.getCardTokenToPlayer(player);
        } else {
            drawnCard.getCardTokenToPlayer(player);
        }
        if (player.getProgressTokens().contains(ProgressToken.Urbanism) && (verifDrawnCard(drawnCard, Cards.MAT_WOOD) || verifDrawnCard(drawnCard, Cards.MAT_BRICK))) {
            board.setCanDrawCard(true);
        }
        if (player.getProgressTokens().contains(ProgressToken.ArtsAndCrafts) && (verifDrawnCard(drawnCard, Cards.MAT_PAPER) || verifDrawnCard(drawnCard, Cards.MAT_GLASS))) {
            board.setCanDrawCard(true);
        }
        if (player.getProgressTokens().contains(ProgressToken.Jewelry) && (verifDrawnCard(drawnCard, Cards.MAT_STONE) || verifDrawnCard(drawnCard, Cards.MAT_GOLD))) {
            board.setCanDrawCard(true);
        }
        if (player.getProgressTokens().contains(ProgressToken.Science) && drawnCard.getType().equals("Science")) {
            board.setCanDrawCard(true);
        }
        if (player.getProgressTokens().contains(ProgressToken.Propaganda) && drawnCard.getType().equals("Military") && (drawnCard.getMilitaryCardToken() == Fighter.ARCHER || drawnCard.getMilitaryCardToken() == Fighter.BARBARIAN)) {
            board.setCanDrawCard(true);
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

        Map<ScienceToken, Long> countSimilar = player.getScienceTokens().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long countDifferent = player.getScienceTokens().stream()
                .distinct()
                .count();
        boolean similarRemoved = false;
        boolean differentRemoved = false;

        for (Map.Entry<ScienceToken, Long> entry : countSimilar.entrySet()) {
            if (entry.getValue() >= 2) {
                for (int i = 0; i < 2; i++) {
                    player.getScienceTokens().remove(entry.getKey());
                }
                similarRemoved = true;
                break;
            }
        }


        if (countDifferent >= 3) {
            List<ScienceToken> differents = player.getScienceTokens().stream().distinct().toList();
            for (int i = 0; i < 3; i++) {
                player.getScienceTokens().remove(differents.get(i));
            }
            differentRemoved = true;
        }
        if (similarRemoved || differentRemoved) {
            //appel de la méthode additionnelle
            showProgressTokenToDraw(board);
        }
    }

    public static void showProgressTokenToDraw(Board board) {
        // active les boutons de progress tokens pour pouvoir en piocher
        board.setCanDrawCard(false);
        board.setCanDrawProgressToken(true);
        board.setCanNextTurn(false);
    }

    public static void chkLevelUpWonder(Board board) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player currentPlayer = board.getPlayers().get(board.getCurrentPlayerIndex());

        // Tableau de jetons de matériaux
        MaterialToken[] elementTabToToken = {MaterialToken.WOOD, MaterialToken.GLASS, MaterialToken.BRICK, MaterialToken.STONE, MaterialToken.PAPER};

        for (int i = 0; i < wonder.getNbLevelsInStages().length; i++) {
            // Génère une liste de jetons de matériaux pour le joueur
            ArrayList<Long> materialTab = materialSimDiffGenerator(board);
            for (int n = 0; n < wonder.getNbLevelsInStages()[i]; n++) {
                int currentLevel = i != 0 ? currentStageCalc(i, wonder.getNbLevelsInStages()) + n : n;
                boolean previousStageBuild = i == 0 || verifPreviousStageBuilt(currentPlayer, i);

                System.out.println("currentLevel : " + currentLevel);
                System.out.println(materialTab);
                System.out.println("previousStageBuild : " + previousStageBuild);
                System.out.println("wonder.getIsStageBuilt()[currentLevel] : " + wonder.getIsStageBuilt()[currentLevel]);
                System.out.println("wonder.getSameMaterials()[i] : " + wonder.getSameMaterials()[i]);

                if (!wonder.getIsStageBuilt()[currentLevel] && previousStageBuild) {
                    // Récupère le nombre de niveaux dans l'étape en cours de construction
                    if (wonder.getSameMaterials()[currentLevel]) {
                        // Vérifie si le joueur a les jetons de matériaux requis pour construire un niveau avec des matériaux identiques
                        if (updateSameMat(board, materialTab, elementTabToToken, currentLevel)) {
                            break;
                        }
                    } else {
                        // Vérifie si le joueur a les jetons de matériaux requis pour construire un niveau avec des matériaux différents
                        if(updateDiffMat(board, materialTab, currentLevel)) {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(wonder.getIsStageBuilt()));
    }


    public static boolean verifPreviousStageBuilt(Player player, int currentStage) {
        if(currentStage == 0) return true;
        for (int i = 0; i < currentStage; i++) {
            int start = 0;
            for (int j = 0; j < i; j++) {
                start += player.getWonder().getNbLevelsInStages()[j];
            }
            int end = start + player.getWonder().getNbLevelsInStages()[i];
            for(int k = start; k < end; k++) {
                if (!player.getWonder().getIsStageBuilt()[k]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int currentStageCalc(int currentStage, int[] nbLevelsInStages) {
        int currentLevel = 0;
        for (int i = 0; i < currentStage; i++) {
            currentLevel += nbLevelsInStages[i];
        }
        return currentLevel;
    }

    private static boolean updateDiffMat(Board board, ArrayList<Long> elementTab, int currenLevel) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());

        System.out.println("element diff " + (elementTab.get(elementTab.size()-1)));
        System.out.println(elementTab);

        if ((elementTab.get(elementTab.size()-1) >= wonder.getNbMaterials()[currenLevel])) {
            System.out.println("passage diff mat");
            int uniqueCount = 0;
            HashSet<MaterialToken> setToRemove = new HashSet<>();
            for (int m = 0; m < wonder.getNbMaterials()[currenLevel]; m++) {
                if(m < player.getMaterialTokens().size()){
                    if (!setToRemove.contains(player.getMaterialTokens().get(m))) {
                        setToRemove.add(player.getMaterialTokens().get(m));
                        uniqueCount++;
                    }
                    if (uniqueCount == wonder.getNbMaterials()[currenLevel]) {
                        break;
                    }
                }
            }
            chkArchitecture(player, board);
            // remove elements from list
            player.getMaterialTokens().removeAll(setToRemove);
            levelUpWonder(board, currenLevel);
            return true;
        } else {
            return false;
        }
    }

    private static boolean updateSameMat(Board board, ArrayList<Long> elementTab, MaterialToken[] elementTabToToken, int currentLevel) {
        Wonder wonder = board.getPlayers().get(board.getCurrentPlayerIndex()).getWonder();
        Player player = board.getPlayers().get(board.getCurrentPlayerIndex());

        for (int j = 0; j < elementTab.size() - 2; j++) {
            if (elementTab.get(j) == wonder.getNbMaterials()[currentLevel]) {
                for (int n = 0; n < wonder.getNbMaterials()[currentLevel]; n++) {
                    player.removeMaterialToken(elementTabToToken[j]);
                    System.out.println(n);
                }
                chkArchitecture(player, board);
                levelUpWonder(board, currentLevel);
                return true;
            }
        }

        return false;
    }

    public static void chkArchitecture(Player player, Board board) {
        if (player.getProgressTokens().contains(ProgressToken.Architecture)) {
            board.setCanDrawCard(true);
        }
    }

    private static void levelUpWonder(Board board, int i) {
        System.out.println("level upppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp");

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
            try {
                wonder.eventAction(board);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

    public static int[][] getScoreBoard(ArrayList<Player> players){
        int numPlayers = players.size();
        int[][] scores = new int[numPlayers][5];
        for(int i = 0; i < numPlayers; i++){
            Player player = players.get(i);
            scores[i][0] = getWonderLaurelPoints(player);
            scores[i][1] = getBlueRedLaurelPoints(player);
            scores[i][2] = player.getHasCat() ? 2 : 0;
            scores[i][3] = getGreenLaurelPoints(player);
            scores[i][4] = getCultureScore(player) + getPoliticsScore(player) + getStrategyScore(player) + getEducationScore(player);
            scores[i][5] = scores[i][0] + scores[i][1] + scores[i][2] + scores[i][3] + scores[i][4];
        }
        return scores;
    }

    public static int getWonderLaurelPoints(Player player){
        //faire la sommes des points des étages de la merveille qui sont construits
        int nbStage = player.getWonder().getNbLevelsInStages().length;
        int score = 0;
        for (int i =0; i < nbStage; i++){
            if (player.getWonder().getIsStageBuilt()[i] == true){
                score = score + player.getWonder().getLevelPoints()[i];
            }
        }
        return score;

    }

    public static int getBlueRedLaurelPoints(Player player){
        //faire la sommes des points des laurelsTokens
        int score = 0;
        long countLaurelBlue2 = player.getLaurelTokens().stream()
                .filter(s-> s.equals(LaurelToken.LAUREL_BLUE_2)).count();
        long countLaurelBlue3 = player.getLaurelTokens().stream()
                .filter(s-> s.equals(LaurelToken.LAUREL_BLUE_3)).count();
        long countLaurelRed3 = player.getLaurelTokens().stream()
                .filter(s-> s.equals(LaurelToken.LAUREL_RED_3)).count();
        score = (int) ((countLaurelBlue3*3) + (countLaurelBlue2*2) + (countLaurelRed3*3));
        return score;
    }

    public static int getGreenLaurelPoints(Player player){
        int score = 0;
        //regarder si il a progress tokens et faire en fonction
        if (player.getProgressTokens().contains(ProgressToken.Decoration)){
            score += getDecorationScore(player);
        }

        return score;
    }

    public static int getDecorationScore(Player player){
        //retourner état avancement merveille
        int score = 4;
        int nbLevels = player.getWonder().getNbLevelsInStages().length;
        if (player.getWonder().getIsStageBuilt()[nbLevels]){
            score = 6;
        }
        return score;
    }

    public static int getPoliticsScore(Player player){
        //retourner nombre de jetons bleus avec un chat
        int score = 0;
        if (player.getProgressTokens().contains(ProgressToken.Politic)){
            long countLaurelBlue2 = player.getLaurelTokens().stream()
                    .filter(s-> s.equals(LaurelToken.LAUREL_BLUE_2)).count();
            score = (int) countLaurelBlue2;
        }
        return score;
    }

    public static int getStrategyScore(Player player){
        //retourner nombre de jetons victoire militair rouges
        int score = 0;
        if (player.getProgressTokens().contains(ProgressToken.Strategy)){
            score = player.getMilitaryPoints();
        }
        return score;
    }

    public static int getEducationScore(Player player){
        //retourner nombre jetons progrès
        int score = 0;
        if (player.getProgressTokens().contains(ProgressToken.Education)){
            score = player.getProgressTokens().size()*2;
        }
        return score;
    }

    public static int getCultureScore(Player player){
        //retourner 4 si un jeton et 12 si 2
        int score = 0;
        long countCulture = player.getProgressTokens().stream()
                .filter(s-> s.equals(ProgressToken.Culture)).count();
        if (countCulture == 1){
            score = 4;
        }
        else if (countCulture == 2) {
            score = 12;
        }
        return score;
    }




}
