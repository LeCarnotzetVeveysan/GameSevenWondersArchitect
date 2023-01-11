package token;

public enum ProgressToken {

    Urbanism("urbanism", //
            "Lorsque vous prenez une carte grise 'bois' ou 'brique', " //
                    + "choisissez 1 carte supplémentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-culture.png"),

    ArtsAndCrafts("Arts and crafts", //
            "Lorsque vous prenez une carte grise 'papier' ou 'verre', " //
                    + "choisissez 1 carte supplémentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-artsAndCrafts.png"),

    Jewelry("jewelry", //
            "Lorsque vous prenez une carte grise 'pierre' ou une carte jaune, " //
                    + "choisissez 1 carte suppl�mentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-jewelry.png"),

    Science("science", //
            "Lorsque vous prenez une carte verte, " //
                    + "choisissez 1 carte supplémentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-science.png"),

    Propaganda("propaganda", //
            "Lorsque vous prenez une carte Rouge avec 1 ou 2 ic�nes 'corne', " //
                    + "choisissez 1 carte supplémentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-propaganda.png"),

    Architecture("architecture", //
            "Lorsque vous construisez un étape, " //
                    + "choisissez 1 carte parmi les 3 disponibles et posez-la devant vous", //
            "token-architecture.png"),

    Economy("economy", //
            "1 carte jaune en votre possession vous offre 2 pièces au lieu d'une seule", //
            "token-economy.png"),

    Ingeniery("ingeniery", //
            "Lorsque vous construisez un étape, "
                    + "vous pouvez utiliser n'importe quelle ressource sans tenir compte de la restriction 'identique' ou 'différente'", //
            "token-ingeniery.png"),

    Tactic("tactic", //
            "Ajoutez 2 Boucliers à votre total de Boucliers", //
            "token-tactic.png"),

    Decoration("decoration", //
            "A la fin de la partie, " //
                    + "gagnez 4 Points de victoire si votre Merveille est encore en construction, " //
                    + "ou 6 Points de victoire si vous avez terminé sa construction", //
            "token-decoration.png"),

    Politic("politic", //
            "A la fin de la partie, " //
                    + "gagnez 1 Point de victoire par icone 'chat', présente sur vos cartes bleues", //
            "token-politic.png"),

    Strategy("strategy", //
            "A la fin de la partie, " //
                    + "gagnez 1 Point de victoire par jeton militaire en votre possession", //
            "token-strategy.png"),

    Education("education", //
            "A la fin de la partie, " //
                    + "gagnez 2 Points de victoire par jeton de Progrès en votre possession (celui-ci y compris)", //
            "token-education.png"),

    Culture("culture", //
            "Ce jeton est pr�sent en 2 exemplaires. A la fin de la partie, " //
                    + " gagnez 4 Points de victoire si vous possédez 1, ou 12 Points de victoire si vous poss�dez les 2", //
            "token-culture.png");

    private final String displayName;

    private final String effectDescription;

    private final String imageResource;

    // ------------------------------------------------------------------------

    ProgressToken(String displayName, String effectDescription, String imageResource) {
        this.displayName = displayName;
        this.effectDescription = effectDescription;
        this.imageResource = "images/tokens-progress/" + imageResource;
    }

}
