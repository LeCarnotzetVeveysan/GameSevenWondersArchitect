
package tests;

import java.util.ArrayList;
import java.util.Arrays;

import token.MaterialToken;

public class test {

    public static void main(String[] args) {
        ArrayList<Long> matTab = materialSimDiffGenerator();
        System.out.println(matTab);
    }

    public static ArrayList<Long> materialSimDiffGenerator() {
        MaterialToken[] materialTokens = {MaterialToken.PAPER, MaterialToken.GLASS, MaterialToken.WOOD, MaterialToken.WOOD, MaterialToken.GOLD};

        // dans l'odre : wood, glass, brick, stone, paper et nombre de diff
        // pour vérif si contient des éléments similaires : boucle entre 0 et 4
        // pour vérif le nombre d'éléments différents : index 5
        ArrayList<Long> elementTab = new ArrayList<>();

        for (MaterialToken mat: materialTokens) {
            long countSimilar = Arrays.stream(materialTokens)
                    .filter(s-> s.equals(MaterialToken.GOLD) || s.equals(mat))
                    .count();
            elementTab.add(countSimilar);
        }

        long countGold = Arrays.stream(materialTokens)
                .filter(s-> s.equals(MaterialToken.GOLD))
                .count();
        long countDifferent = Arrays.stream(materialTokens)
                .filter(s-> !s.equals(MaterialToken.GOLD))
                .distinct()
                .count()
                + countGold;
        elementTab.add(countDifferent);

        return elementTab;
    }

}
