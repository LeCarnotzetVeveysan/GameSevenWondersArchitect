package token;

public enum Fighter {

    ARCHER(2),
    BARBARIAN(1),
    CENTURION(0);

<<<<<<< HEAD
    private int nbHorn;
=======
    private final int nbHorn;
>>>>>>> bruce

    Fighter(int nbHorn) {
        this.nbHorn = nbHorn;
    }

    public int getNbHorn() {
        return nbHorn;
    }

}
