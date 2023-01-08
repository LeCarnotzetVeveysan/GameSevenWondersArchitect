package classes;

public enum Wonder {

    // valeur de sameMaterials et nbMaterials à changer
    Alexandrie("Alexandrie", "Prenez la premi�re carte d'une pioche au choix, n'importe o� sur la table, et posez-la devant vous",
            new boolean[]{false, false, true, true, false}, new int[]{2, 3, 3, 2, 4}),

    // valeur de sameMaterials et nbMaterials à changer
    Halicarnasse("Halicarnasse", "Prenez les 5 premi�res cartes de la pioche � votre gauche ou � votre droite, choisissez-en 1 et posez-la devant vous" + "M�langez-les cartes restantes dans leur pioche",
            new boolean[]{false, true, true, false, false}, new int[]{2, 2, 3, 3, 4}),

    // valeur de sameMaterials et nbMaterials à changer
    Ephese("Ephese", "Prenez la premi�re carte de la pioche centrale et posez-la devant vous",
            new boolean[]{false, false, true, true, false}, new int[]{2, 3, 3, 2, 4}),

    // valeur de sameMaterials et nbMaterials à changer
    Olympie("Olympie", "Prenez la premi�re carte de la pioche � votre cauche et de celle � votre droite, et posez-les devant vous",
            new boolean[]{false, true, true, false, false}, new int[]{2, 2, 3, 3, 4}),

    // valeur de sameMaterials et nbMaterials à changer
    Babylon("Babylone", "Choisissez 1 jeton Progr�s parmi les 4 disponibles, et posez-le devant vous",
            new boolean[]{false, true, false, false, true}, new int[]{2, 2, 2, 3, 3}),

    // valeur de sameMaterials et nbMaterials à changer
    Rhodes("Rhodes", "Ajoutez 1 Bouclier � votre total de Boucliers",
            new boolean[]{true, false, false, true, false}, new int[]{2, 2, 3, 3, 4}),

    // valeur de sameMaterials et nbMaterials à changer
    Gizeh("Gizeh", "Cette merveille n'a pas d'effet particulier, mais rapporte plus de points de victoire que les autres Merveilles",
            new boolean[]{true, false, true, false, false}, new int[]{2, 3, 3, 3, 4});

    // ------------------------------------------------------------------------

    final String name;
    final String effectDescription;

    int wonderLevel;

    int numberOfStages = 5;

    boolean[] sameMaterials = new boolean[numberOfStages];
    int[] nbMaterials = new int[numberOfStages];

    int[] levelPoints = new int[numberOfStages];
    boolean[] levelAction = new boolean[numberOfStages];


    // ------------------------------------------------------------------------

    Wonder(String name, String effectDescription, boolean[] sameMaterials, int[] nbMaterials) {
        this.name = name;
        this.effectDescription = effectDescription;
    }

    // ------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public String getEffectDescription() {
        return effectDescription;
    }


    public int getWonderLevel() {
        return wonderLevel;
    }

    public void setWonderLevel(int wonderLevel) {
        this.wonderLevel = wonderLevel;
    }

    public int getNumberOfStages() {
        return numberOfStages;
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

    public void setSameMaterials(boolean[] sameMaterials) {
        this.sameMaterials = sameMaterials;
    }

    public void setNbMaterials(int[] nbMaterials) {
        this.nbMaterials = nbMaterials;
    }

    public void setLevelPoints(int[] levelPoints) {
        this.levelPoints = levelPoints;
    }

    public void setLevelAction(boolean[] levelAction) {
        this.levelAction = levelAction;
    }

    public void setSameMaterials(int index, boolean sameMaterials) {
        this.sameMaterials[index] = sameMaterials;
    }

    public void setNbMaterials(int index, int nbMaterials) {
        this.nbMaterials[index] = nbMaterials;
    }

    public void setLevelPoints(int index, int levelPoints) {
        this.levelPoints[index] = levelPoints;
    }

    public void setLevelAction(int index, boolean levelAction) {
        this.levelAction[index] = levelAction;
    }

    // ------------------------------------------------------------------------

}
