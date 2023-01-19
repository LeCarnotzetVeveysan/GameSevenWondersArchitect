package token;

public enum MaterialToken {

    WOOD("woodToken.png"),
    GLASS("glassToken.png"),
    BRICK("brickToken.png"),
    STONE("stoneToken.png"),
    PAPER("paperToken.png"),
    GOLD("goldToken.png");

    private String image;

    MaterialToken(String image) {
        this.image = "tokens-materials/" + image;
    }

    public String getImage() {
        return image;
    }

}
