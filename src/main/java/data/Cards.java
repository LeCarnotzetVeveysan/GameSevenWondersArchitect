package data;

import token.Fighter;
import token.LaurelToken;
import token.MaterialToken;
import token.ScienceToken;

public enum Cards {

    MAT_WOOD("Material", "card-material-wood-lumberjack"),
    MAT_GLASS("Material", "card-material-glass-women"),
    MAT_BRICK("Material", "card-material-brick-women"),
    MAT_STONE("Material", "card-material-stone-stonecutter"),
    MAT_PAPER("Material", "card-material-papyrus-women"),
    MAT_GOLD("Material", "card-material-gold-vizir"),
    LAU_EMPEROR("Laurel", "card-politic-emperor-3laurel"),
    LAU_CAT("Laurel", "card-politic-women-2laurel-cat"),
    SCI_ARCHITECT("Science", "card-progress-architect"),
    SCI_LAW("Science", "card-progress-law"),
    SCI_MECHANIC("Science", "card-progress-mechanic"),
    COM_CENTURION("War", "card-war-centurion"),
    COM_BARBARIAN("War", "card-war-barbarian-1horn"),
    COM_ARCHER("War", "card-war-archer-2horn");

    private final String type;
    private final String frontImg;

    Cards(String type, String frontImg) {
        this.type = type;
        this.frontImg = "cards/" + frontImg;
    }

    public String getType() {
        return type;
    }

    public String getFront() {
        return frontImg;
    }

    public Fighter getMilitaryCardToken() {
        return switch (this) {
            case COM_CENTURION -> Fighter.CENTURION;
            case COM_BARBARIAN -> Fighter.BARBARIAN;
            case COM_ARCHER -> Fighter.ARCHER;
            default -> null;
        };
    }

    public LaurelToken getLaurelCardToken() {
        return switch (this) {
            case LAU_EMPEROR -> LaurelToken.LAUREL3;
            case LAU_CAT -> LaurelToken.LAUREL2;
            default -> null;
        };
    }

    public void getCardTokenToPlayer(Player player) {
        switch (this) {
            case MAT_GOLD -> player.addMaterialToken(MaterialToken.GOLD);
            case MAT_BRICK -> player.addMaterialToken(MaterialToken.BRICK);
            case MAT_GLASS -> player.addMaterialToken(MaterialToken.GLASS);
            case MAT_STONE -> player.addMaterialToken(MaterialToken.STONE);
            case MAT_PAPER -> player.addMaterialToken(MaterialToken.PAPER);
            case MAT_WOOD -> player.addMaterialToken(MaterialToken.WOOD);
            case LAU_EMPEROR -> player.addLaurelToken(LaurelToken.LAUREL3);
            case LAU_CAT -> player.addLaurelToken(LaurelToken.LAUREL2);
            case SCI_ARCHITECT -> player.addScienceToken(ScienceToken.ARCHITECT);
            case SCI_LAW -> player.addScienceToken(ScienceToken.LAW);
            case SCI_MECHANIC -> player.addScienceToken(ScienceToken.MECHANIC);
            case COM_ARCHER -> player.addFighter(Fighter.ARCHER);
            case COM_BARBARIAN -> player.addFighter(Fighter.BARBARIAN);
            case COM_CENTURION -> player.addFighter(Fighter.CENTURION);
        }
    }

}

