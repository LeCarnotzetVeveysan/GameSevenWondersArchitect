package data;

public enum Cards {

    MAT_WOOD("wood", "Material", "card-material-wood-lumberjack.png"),
    MAT_GLASS("glass", "Material", "card-material-glass-women.png"),
    MAT_BRICK("brick", "Material", "card-material-brick-women.png"),
    MAT_STONE("stone", "Material", "card-material-stone-stonecutter.png"),
    MAT_PAPYRUS("papyrus", "Material", "card-material-papyrus-women.png"),
    MAT_GOLD("gold", "Material", "card-material-gold-vizir.png"),
    LAU_EMPEROR("emperor", "Laurel", "card-politic-emperor-3laurel.png"),
    LAU_CAT("women", "Laurel", "card-politic-women-2laurel-cat.png"),
    SCI_ARCHITECT("architect", "Science", "card-progress-architect.png"),
    SCI_LAW("law", "Science", "card-progress-law.png"),
    SCI_MECHANIC("mechanic", "Science", "card-progress-mechanic.png"),
    COM_CENTURION("centurion", "War", "card-war-centurion.png"),
    COM_BARBARIAN("barbarian", "War", "card-war-barbarian-1horn.png"),
    COM_ARCHER("archer", "War", "card-war-archer-2horn.png");

    private final String name;
    private final String type;
    private final String frontImg;

    Cards(String name, String type, String frontImg) {
        this.name = name;
        this.type = type;
        this.frontImg = "src/main/resources/images/cards/" + frontImg;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFront() {
        return frontImg;
    }

}
