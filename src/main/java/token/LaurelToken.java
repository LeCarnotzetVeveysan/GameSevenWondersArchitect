package token;

public enum LaurelToken {

    LAUREL_BLUE_2("laurel2Token"),
    LAUREL_BLUE_3("laurel-3-redToken"),
    LAUREL_RED_3("laurel-3-redToken");

    private String image;

    LaurelToken(String image) {
        this.image = "tokens-laurel/" + image;
    }

    public String getImage() {
        return image;
    }

}
