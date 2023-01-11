package data;

import token.LaurelToken;
import token.MaterialToken;
import token.ProgressToken;
import token.ShieldToken;
import token.ScienceToken;

import java.util.ArrayList;

public class Player {

    private String name;
    private Wonder wonder;

    private String nameDeck;

    private ArrayList<ShieldToken> shieldTokens = new ArrayList<>();
    private ArrayList<ProgressToken> progressTokens = new ArrayList<>();
    private ArrayList<LaurelToken> laurelTokens = new ArrayList<>();
    private ArrayList<MaterialToken> materialTokens = new ArrayList<>();
    private ArrayList<ScienceToken> scienceTokens = new ArrayList<>();

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

    public void addShieldToken(ShieldToken shieldToken) {
        shieldTokens.add(shieldToken);
    }

    public void addProgressToken(ProgressToken progressToken) {
        progressTokens.add(progressToken);
    }

    public void addLaurelToken(LaurelToken laurelToken) {
        laurelTokens.add(laurelToken);
    }

    public ArrayList<MaterialToken> getMaterialTokens() {
        return materialTokens;
    }

    public ArrayList<ScienceToken> getScienceTokens() {
        return scienceTokens;
    }

    public void addMaterial(MaterialToken materialToken) {
        materialTokens.add(materialToken);
    }

    public void addScience(ScienceToken scienceToken) {
        scienceTokens.add(scienceToken);
    }

    public void removeMaterial(MaterialToken materialToken) {
        materialTokens.remove(materialToken);
    }

    public void removeScience(ScienceToken scienceToken) {
        scienceTokens.remove(scienceToken);
    }

    public void setHasCat(boolean hasCat) {
        this.hasCat = hasCat;
    }

    public boolean getHasCat() {
        return hasCat;
    }

}
