package token;

public enum LaurelToken {

    LAUREL2("laurel2Token.png"),
    LAUREL3("laurel3Token.png");

    private String image;

    LaurelToken(String image) {
        this.image = "src/main/resources/images/tokens-laurel/" + image;
    }

    public String getImage() {
        return image;
    }

}
