package other;

import data.Deck;
import data.Player;
import token.MaterialToken;
import token.ProgressToken;

import java.util.*;
import java.util.stream.Stream;

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

    public void chkLevelUpWonder(Player player) {
        ArrayList<Long> elementTab = elementSimDiffGenerator(player);
        MaterialToken[] elementTabToToken = {MaterialToken.WOOD, MaterialToken.GLASS, MaterialToken.BRICK, MaterialToken.STONE, MaterialToken.PAPER};

        Map<Integer, Long> levelsInStages = new HashMap<>();
        for (int i = 0; i < player.getWonder().getNbLevelsInStages().length; i++) {
            int stage = player.getWonder().getNbLevelsInStages()[i];
            if (levelsInStages.containsKey(stage)) {
                levelsInStages.put(stage, levelsInStages.get(stage) + 1);
            } else {
                levelsInStages.put(stage, 1L);
            }
        }

        for (int i = 0; i < player.getWonder().getNbLevelsInStages().length; i++) {
            if (!player.getWonder().getIsStageBuilt()[i]) {
                int stage = player.getWonder().getNbLevelsInStages()[i];
                long levelsInCurrentStage = levelsInStages.get(stage);
                if (player.getWonder().getSameMaterials()[i]) {
                    for (int j = 0; j <= 4; j++) {
                        if (elementTab.get(j) == player.getWonder().getNbMaterials()[i]) {
                            for (int n = 0; n <= player.getWonder().getNbMaterials()[i]; n++) {
                                player.removeMaterialToken(elementTabToToken[j]);
                            }
                            player.getWonder().setIsStageBuilt(i, true);
                            chkActionWonder(player, i);
                            levelsInStages.put(stage, levelsInCurrentStage - 1);
                            break;
                        }
                    }
                } else {
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
                        player.getWonder().setIsStageBuilt(i, true);
                        chkActionWonder(player, i);
                        levelsInStages.put(stage, levelsInCurrentStage - 1);
                    }
                }
            }
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

}
