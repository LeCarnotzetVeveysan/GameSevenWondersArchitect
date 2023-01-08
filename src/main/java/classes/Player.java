package classes;

import java.util.ArrayList;

public class Player {

    String playerName;
    Wonder wonder;

    ArrayList<ShieldToken> shieldTokens = new ArrayList<>();
    ArrayList<ProgressToken> progressTokens = new ArrayList<>();
    ArrayList<LaurelToken> laurelTokens = new ArrayList<>();
    ArrayList<MaterialToken> materials = new ArrayList<>();

    boolean hasCat = false;

    public Player(String playerName, Wonder wonder) {
        this.playerName = playerName;
        this.wonder = wonder;
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

    public void addMaterial(MaterialToken material) {
        materials.add(material);
    }

    public void removeMaterial(MaterialToken material) {
        materials.remove(material);
    }

    public void setHasCat(boolean hasCat) {
        this.hasCat = hasCat;
    }

    public boolean getHasCat() {
        return hasCat;
    }

}
