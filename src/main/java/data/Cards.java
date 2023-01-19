package data;

import token.Fighter;
import token.LaurelToken;
import token.MaterialToken;
import token.ScienceToken;

public enum Cards {

    MAT_WOOD("Material", "material-wood-lumberjack"),
    MAT_GLASS("Material", "material-glass-woman"),
    MAT_BRICK("Material", "material-brick-woman"),
    MAT_STONE("Material", "material-stone-stonecutter"),
    MAT_PAPER("Material", "material-papyrus-woman"),
    MAT_GOLD("Material", "material-gold-vizir"),
    LAU_EMPEROR("Laurel", "politic-emperor"),
    LAU_CAT("Laurel", "politic-woman-cat"),
    SCI_ARCHITECT("Science", "progress-architect"),
    SCI_LAW("Science", "progress-law"),
    SCI_MECHANIC("Science", "progress-mechanic"),
    COM_CENTURION("War", "war-centurion"),
    COM_BARBARIAN("War", "war-barbarian"),
    COM_ARCHER("War", "war-archer");

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

