package classes;

import java.util.ArrayList;

public class Player {

    String playerName;
    Wonder wonder;

    ArrayList<ShieldToken> shieldTokens = new ArrayList<ShieldToken>();
    ArrayList<ProgressToken> progressTokens = new ArrayList<ProgressToken>();
    ArrayList<LaurelToken> laurelTokens = new ArrayList<LaurelToken>();
    ArrayList<MaterialToken> materials = new ArrayList<MaterialToken>();

    boolean hasCat;

}
