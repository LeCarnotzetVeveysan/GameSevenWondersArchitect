package token;

public enum ShieldToken {

    SHIELDCOUNTER("shieldCounterToken.png"),
    SHIELDHORN("shieldHornToken.png"),
    SHIELD("shieldToken.png");

    private String image;

    ShieldToken(String image) {
        this.image = "src/main/resources/images/tokens-conflict/" + image;
    }

    public String getImage() {
        return image;
    }
}
