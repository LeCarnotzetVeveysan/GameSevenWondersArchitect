package token;

public enum Fighter {

    ARCHER(2),
    BARBARIAN(1),
    CENTURION(0);

    private int nbHorn;

    Fighter(int nbHorn) {
        this.nbHorn = nbHorn;
    }

    public int getNbHorn() {
        return nbHorn;
    }

}
