package token;

public enum ScienceToken {

    MECHANIC("mechanicToken.png"),
    ARCHITECT("architectToken.png"),
    LAW("lawToken.png");

    private String image;

    ScienceToken(String image) {
        this.image = "src/main/resources/images/tokens-science/" + image;
    }

    public String getImage() {
        return image;
    }

}
