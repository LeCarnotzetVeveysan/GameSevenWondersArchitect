package data;

public enum Wonder {

    Alexandrie("Alexandrie", "Prenez la premi�re carte d'une pioche au choix, n'importe où sur la table, et posez-la devant vous",
            new boolean[]{false, true, false, true, false}, new int[]{2, 2, 3, 3, 4},
            new boolean[]{false, true, false, true, false}, new int[]{4, 3, 6, 5, 7},
            "wonder-alexandrie.png"),

    Halicarnasse("Halicarnasse", "Prenez les 5 premières cartes de la pioche à votre gauche ou à votre droite, choisissez-en 1 et posez-la devant vous" + "Mélangez-les cartes restantes dans leur pioche",
            new boolean[]{false, true, false, true, false}, new int[]{2, 2, 3, 3, 4},
            new boolean[]{false, false, true, true, false}, new int[]{3, 3, 6, 5, 7},
            "wonder-halicarnasse.png"),

    Ephese("Ephese", "Prenez la première carte de la pioche centrale et posez-la devant vous",
            new boolean[]{false, true, false, true, false}, new int[]{2, 2, 3, 3, 4},
            new boolean[]{false, true, true, true, false}, new int[]{3, 3, 4, 5, 7},
            "wonder-ephese.png"),

    Olympie("Olympie", "Prenez la première carte de la pioche à votre cauche et de celle à votre droite, et posez-les devant vous",
            new boolean[]{false, true, false, true, false}, new int[]{2, 2, 3, 3, 4},
            new boolean[]{false, true, false, true, false}, new int[]{3, 2, 5, 5, 7},
            "wonder-olympie.png"),

    Babylon("Babylone", "Choisissez 1 jeton Progrès parmi les 4 disponibles, et posez-le devant vous",
            new boolean[]{false, true, false, false, true}, new int[]{2, 2, 3, 4, 3},
            new boolean[]{false, true, false, false, true}, new int[]{3, 0, 5, 7, 5},
            "wonder-babylone.png"),

    Rhodes("Rhodes", "Ajoutez 1 Bouclier à votre total de Boucliers",
            new boolean[]{false, true, false, true, false}, new int[]{2, 2, 3, 3, 4},
            new boolean[]{false, true, false, true, false}, new int[]{4, 4, 5, 6, 7},
            "wonder-rhodes.png"),

    Gizeh("Gizeh", "Cette merveille n'a pas d'effet particulier, mais rapporte plus de points de victoire que les autres Merveilles",
            new boolean[]{false, true, false, true, false}, new int[]{2, 2, 3, 3, 4},
            new boolean[]{false, false, false, false, false}, new int[]{4, 5, 6, 7, 8},
            "wonder-gizeh.png");

    // ------------------------------------------------------------------------

    private final String name;
    private final String effectDescription;
    private final String wonderDeck;

    private int wonderLevel = 0;

    private final boolean[] sameMaterials;
    private final int[] nbMaterials;

    private final int[] levelPoints;
    private final boolean[] levelAction;


    // ------------------------------------------------------------------------

    Wonder(String name, String effectDescription, boolean[] sameMaterials, int[] nbMaterials, boolean[] levelAction, int[] levelPoints, String wonderDeck) {
        this.name = name;
        this.effectDescription = effectDescription;
        this.sameMaterials = sameMaterials;
        this.nbMaterials = nbMaterials;
        this.levelAction = levelAction;
        this.levelPoints = levelPoints;
        this.wonderDeck = "src/main/resources/images/decks/" + wonderDeck;
    }

    // ------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public String getEffectDescription() {
        return effectDescription;
    }

    public String getWonderDeck() {
        return wonderDeck;
    }

    public int getWonderLevel() {
        return wonderLevel;
    }

    public void setWonderLevel(int wonderLevel) {
        this.wonderLevel = wonderLevel;
    }
    public void addWonderLevel() {
        this.wonderLevel++;
    }

    public boolean[] getSameMaterials() {
        return sameMaterials;
    }

    public int[] getNbMaterials() {
        return nbMaterials;
    }

    public int[] getLevelPoints() {
        return levelPoints;
    }

    public boolean[] getLevelAction() {
        return levelAction;
    }

    public void eventAction() {
        switch (this) {
            case Alexandrie:
                alexandrieAction();
                break;
            case Halicarnasse:
                halicarnasseAction();
                break;
            case Ephese:
                epheseAction();
                break;
            case Olympie:
                olympieAction();
                break;
            case Babylon:
                babylonAction();
                break;
            case Rhodes:
                rhodesAction();
                break;
            case Gizeh:
                gizehAction();
                break;
        }
    }

    public void alexandrieAction() {
        // prendre la première carte au choix parmi les 3 decks (gauche, droite et milieu)
    }

    public void halicarnasseAction() {
        // parmi les 5 premières carte de la pioche à gauche et à droite, choisissez-en une
    }

    public void epheseAction() {
        // prendre la première carte de la pioche centrale
    }

    public void olympieAction() {
        // prendre les cartes de la pioche de droite et de gauche
    }

    public void babylonAction() {
        // choisir un jeton progrès parmi les 4 disponibles
    }

    public void rhodesAction() {
        // incrémenter le total de bouclier de 1 de manière permanente
    }

    public void gizehAction() {
        // does nothing
    }

    // ------------------------------------------------------------------------

}