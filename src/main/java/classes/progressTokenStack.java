package classes;

import java.util.ArrayList;

public class progressTokenStack {

    ArrayList<ProgressToken> progressTokens = new ArrayList<>();
    String backTokenImg;

    public progressTokenStack(int nbUrba, int nbArtAndCrafts, int nbJewelry, int nbScience, int nbPropaganda, int nbArchi, int nbEconomy, int nbIngeniery, int nbTactic, int nbDeco, int nbPolitic, int nbStrategy, int nbEducation, int nbCulture, String backTokenImg) {
        this.backTokenImg = backTokenImg;

        for (int i = 0; i < nbUrba; i++) {
            progressTokens.add(ProgressToken.Urbanism);
        }
        for (int i = 0; i < nbArtAndCrafts; i++) {
            progressTokens.add(ProgressToken.ArtsAndCrafts);
        }
        for (int i = 0; i < nbJewelry; i++) {
            progressTokens.add(ProgressToken.Jewelry);
        }
        for (int i = 0; i < nbScience; i++) {
            progressTokens.add(ProgressToken.Science);
        }
        for (int i = 0; i < nbPropaganda; i++) {
            progressTokens.add(ProgressToken.Propaganda);
        }
        for (int i = 0; i < nbArchi; i++) {
            progressTokens.add(ProgressToken.Architecture);
        }
        for (int i = 0; i < nbEconomy; i++) {
            progressTokens.add(ProgressToken.Economy);
        }
        for (int i = 0; i < nbIngeniery; i++) {
            progressTokens.add(ProgressToken.Ingeniery);
        }
        for (int i = 0; i < nbTactic; i++) {
            progressTokens.add(ProgressToken.Tactic);
        }
        for (int i = 0; i < nbDeco; i++) {
            progressTokens.add(ProgressToken.Decoration);
        }
        for (int i = 0; i < nbPolitic; i++) {
            progressTokens.add(ProgressToken.Politic);
        }
        for (int i = 0; i < nbStrategy; i++) {
            progressTokens.add(ProgressToken.Strategy);
        }
        for (int i = 0; i < nbEducation; i++) {
            progressTokens.add(ProgressToken.Education);
        }
        for (int i = 0; i < nbCulture; i++) {
            progressTokens.add(ProgressToken.Culture);
        }

        shuffle();
    }

    public void shuffle() {
        for (int i = 0; i < progressTokens.size(); i++) {
            int random = (int) (Math.random() * progressTokens.size());
            ProgressToken temp = progressTokens.get(i);
            progressTokens.set(i, progressTokens.get(random));
            progressTokens.set(random, temp);
        }
    }

    public ArrayList<ProgressToken> getProgressTokens() {
        return progressTokens;
    }

    public ProgressToken drawToken(int index) {
        return progressTokens.remove(index);
    }

    public String getBackTokenImg() {
        return backTokenImg;
    }
}
