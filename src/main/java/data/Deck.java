package data;

import java.util.ArrayList;

public class Deck {

    ArrayList<Cards> deck = new ArrayList<>();
    private String backCardImg;

    public Deck(int nbGold, int nbStone, int nbBrick, int nbWood, int nbPapyrus, int nbGlass, int nbMechanic, int nbArchitect, int nbLaw, int nbEmperor, int nbCat, int nbCenturion, int nbArcher, int nbBarbarian, String backCardImg) {

        this.backCardImg = "src/main/resources/images/cards/card-back/" + backCardImg;

        for (int i = 0; i < nbWood; i++) {
            deck.add(Cards.MAT_WOOD);
        }
        for (int i = 0; i < nbGlass; i++) {
            deck.add(Cards.MAT_GLASS);
        }
        for (int i = 0; i < nbBrick; i++) {
            deck.add(Cards.MAT_BRICK);
        }
        for (int i = 0; i < nbStone; i++) {
            deck.add(Cards.MAT_STONE);
        }
        for (int i = 0; i < nbPapyrus; i++) {
            deck.add(Cards.MAT_PAPER);
        }
        for (int i = 0; i < nbGold; i++) {
            deck.add(Cards.MAT_GOLD);
        }
        for (int i = 0; i < nbEmperor; i++) {
            deck.add(Cards.LAU_EMPEROR);
        }
        for (int i = 0; i < nbCat; i++) {
            deck.add(Cards.LAU_CAT);
        }
        for (int i = 0; i < nbArchitect; i++) {
            deck.add(Cards.SCI_ARCHITECT);
        }
        for (int i = 0; i < nbLaw; i++) {
            deck.add(Cards.SCI_LAW);
        }
        for (int i = 0; i < nbMechanic; i++) {
            deck.add(Cards.SCI_MECHANIC);
        }
        for (int i = 0; i < nbCenturion; i++) {
            deck.add(Cards.COM_CENTURION);
        }
        for (int i = 0; i < nbBarbarian; i++) {
            deck.add(Cards.COM_BARBARIAN);
        }
        for (int i = 0; i < nbArcher; i++) {
            deck.add(Cards.COM_ARCHER);
        }

        shuffle();
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int random = (int) (Math.random() * deck.size());
            Cards temp = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, temp);
        }
    }

    public ArrayList<Cards> getDeck() {
        return deck;
    }

    public String getBackCardImg() {
        return backCardImg;
    }

}
