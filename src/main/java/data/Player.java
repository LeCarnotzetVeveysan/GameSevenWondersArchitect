package data;

import token.LaurelToken;
import token.MaterialToken;
import token.ProgressToken;
import token.ScienceToken;
import token.Fighter;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final Wonder wonder;
    private boolean hasBuiltWonder = false;

    private final ArrayList<ProgressToken> progressTokens = new ArrayList<>();
    private final ArrayList<LaurelToken> laurelTokens = new ArrayList<>();
    private final ArrayList<MaterialToken> materialTokens = new ArrayList<>();
    private final ArrayList<ScienceToken> scienceTokens = new ArrayList<>();
    private final ArrayList<Fighter> fighters = new ArrayList<>();

    private int militaryPoints = 0;
    private int shield = 0;

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

    public void removeFightersWithHorn() {
        this.removeFighter(Fighter.BARBARIAN);
        this.removeFighter(Fighter.ARCHER);
    }

    public void removeFighter(Fighter fighter) {
        fighters.remove(fighter);
    }

    public ArrayList<Fighter> getFighters() {
        return fighters;
    }

    public ArrayList<ProgressToken> getProgressTokens() {
        return progressTokens;
    }

    public void addProgressToken(ProgressToken progressToken) {
        progressTokens.add(progressToken);
        switch (progressToken) {
            case Tactic -> {
                this.addFighter(Fighter.CENTURION);
                this.addFighter(Fighter.CENTURION);
            }
            case Economy -> {
                for (int i = 0; i < materialTokens.size(); i++) {
                    if (materialTokens.get(i) == MaterialToken.GOLD) {
                        materialTokens.add(MaterialToken.GOLD);
                    }
                }
            }
        }
    }

    public ArrayList<LaurelToken> getLaurelTokens() {
        return laurelTokens;
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

    public void addShield(int shield) {
        this.shield += shield;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void setMilitaryPoints(int militaryPoints) {
        this.militaryPoints = militaryPoints;
    }

    public int getMilitaryPoints() {
        return militaryPoints;
    }

    public void addMilitaryPoints(int militaryPoints) {
        this.militaryPoints += militaryPoints;
    }

    public void setHasBuiltWonder(boolean hasBuiltWonder) {
        this.hasBuiltWonder = hasBuiltWonder;
    }

    public boolean isHasBuiltWonder() {
        return hasBuiltWonder;
    }

    public int[] getNumberOfTokens(){
        int[] tokens = new int[15];

        return tokens;
    }
}
