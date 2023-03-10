package token;

public enum ProgressToken {

    Urbanism("Lorsque vous prenez une carte grise 'bois' ou 'brique', " //
                    + "choisissez 1 carte supplémentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-culture"),

    ArtsAndCrafts("Lorsque vous prenez une carte grise 'papier' ou 'verre', " //
                    + "choisissez 1 carte supplémentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-artsAndCrafts"),

    Jewelry("Lorsque vous prenez une carte grise 'pierre' ou une carte jaune, " //
                    + "choisissez 1 carte suppl�mentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-jewelry"),

    Science("Lorsque vous prenez une carte verte, " //
                    + "choisissez 1 carte supplémentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-science"),

    Propaganda("Lorsque vous prenez une carte Rouge avec 1 ou 2 ic�nes 'corne', " //
                    + "choisissez 1 carte supplémentaire parmi les 3 disponibles et posez-la devant vous", //
            "token-propaganda"),

    Architecture("Lorsque vous construisez un étape, " //
                    + "choisissez 1 carte parmi les 3 disponibles et posez-la devant vous", //
            "token-architecture"),

    Economy("1 carte jaune en votre possession vous offre 2 pièces au lieu d'une seule", //
            "token-economy"),

    Ingeniery("Lorsque vous construisez un étape, "
                    + "vous pouvez utiliser n'importe quelle ressource sans tenir compte de la restriction 'identique' ou 'différente'", //
            "token-ingeniery"),

    Tactic("Ajoutez 2 Boucliers à votre total de Boucliers", //
            "token-tactic"),

    Decoration("A la fin de la partie, " //
                    + "gagnez 4 Points de victoire si votre Merveille est encore en construction, " //
                    + "ou 6 Points de victoire si vous avez terminé sa construction", //
            "token-decoration"),

    Politic("A la fin de la partie, " //
                    + "gagnez 1 Point de victoire par icone 'chat', présente sur vos cartes bleues", //
            "token-politic"),

    Strategy("A la fin de la partie, " //
                    + "gagnez 1 Point de victoire par jeton militaire en votre possession", //
            "token-strategy"),

    Education("A la fin de la partie, " //
                    + "gagnez 2 Points de victoire par jeton de Progrès en votre possession (celui-ci y compris)", //
            "token-education"),

    Culture("Ce jeton est présent en 2 exemplaires. A la fin de la partie, " //
                    + " gagnez 4 Points de victoire si vous possédez 1, ou 12 Points de victoire si vous possédez les 2", //
            "token-culture");

    private final String effectDescription;

    private final String imageResource;

    // ------------------------------------------------------------------------

    ProgressToken(String effectDescription, String imageResource) {
        this.effectDescription = effectDescription;
        this.imageResource = "tokens-progress/" + imageResource;
    }

    public String getImageResource(){
        return imageResource;
    }

}
