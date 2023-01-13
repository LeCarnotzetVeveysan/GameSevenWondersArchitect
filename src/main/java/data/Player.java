package data;

import token.LaurelToken;
import token.MaterialToken;
import token.ProgressToken;
import token.ScienceToken;
import token.Fighter;

import java.util.ArrayList;

public class Player {

    private String name;
    private Wonder wonder;

    private String nameDeck;

    private ArrayList<ProgressToken> progressTokens = new ArrayList<>();
    private ArrayList<LaurelToken> laurelTokens = new ArrayList<>();
    private ArrayList<MaterialToken> materialTokens = new ArrayList<>();
    private ArrayList<ScienceToken> scienceTokens = new ArrayList<>();
    private ArrayList<Fighter> fighters = new ArrayList<>();

    private boolean hasCat = false;

    public Player(String playerName, Wonder wonder) {
        this.name = playerName;
        this.wonder = wonder;
    }

    public String getName() {
        return name;
    }

    public Wonder getWonder() {
        return wonder;
    }

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public void removeFighter(Fighter fighter) {
        fighters.remove(fighter);
    }

    public ArrayList<Fighter> getFighters() {
        return fighters;
    }

    public void addProgressToken(ProgressToken progressToken) {
        progressTokens.add(progressToken);
    }

    public void addLaurelToken(LaurelToken laurelToken) {
        laurelTokens.add(laurelToken);
    }

    public void removeLaurelToken(LaurelToken laurelToken) {
        laurelTokens.remove(laurelToken);
    }

    public ArrayList<MaterialToken> getMaterialTokens() {
        return materialTokens;
    }

    public ArrayList<ScienceToken> getScienceTokens() {
        return scienceTokens;
    }

    public void addMaterialToken(MaterialToken materialToken) {
        materialTokens.add(materialToken);
    }

    public void addScienceToken(ScienceToken scienceToken) {
        scienceTokens.add(scienceToken);
    }

    public void removeMaterialToken(MaterialToken materialToken) {
        materialTokens.remove(materialToken);
    }

    public void removeScienceToken(ScienceToken scienceToken) {
        scienceTokens.remove(scienceToken);
    }

    public void setHasCat(boolean hasCat) {
        this.hasCat = hasCat;
    }

    public boolean getHasCat() {
        return hasCat;
    }

}
