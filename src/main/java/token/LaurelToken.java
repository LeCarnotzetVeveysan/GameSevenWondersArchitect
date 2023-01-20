package token;

public enum LaurelToken {

    LAUREL_BLUE_2("laurel-2-blueToken"),
    LAUREL_BLUE_3("laurel-3-blueToken"),
    LAUREL_RED_3("laurel-3-redToken");

    private String image;

    LaurelToken(String image) {
        this.image = "tokens-laurel/" + image;
    }

    public String getImage() {
        return image;
    }

}
