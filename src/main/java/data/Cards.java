<<<<<<< HEAD
package data;

import token.Fighter;
import token.LaurelToken;
import token.MaterialToken;
import token.ScienceToken;

public enum Cards {

    MAT_WOOD("Material", "card-material-wood-lumberjack.png"),
    MAT_GLASS("Material", "card-material-glass-women.png"),
    MAT_BRICK("Material", "card-material-brick-women.png"),
    MAT_STONE("Material", "card-material-stone-stonecutter.png"),
    MAT_PAPER("Material", "card-material-papyrus-women.png"),
    MAT_GOLD("Material", "card-material-gold-vizir.png"),
    LAU_EMPEROR("Laurel", "card-politic-emperor-3laurel.png"),
    LAU_CAT("Laurel", "card-politic-women-2laurel-cat.png"),
    SCI_ARCHITECT("Science", "card-progress-architect.png"),
    SCI_LAW("Science", "card-progress-law.png"),
    SCI_MECHANIC("Science", "card-progress-mechanic.png"),
    COM_CENTURION("War", "card-war-centurion.png"),
    COM_BARBARIAN("War", "card-war-barbarian-1horn.png"),
    COM_ARCHER("War", "card-war-archer-2horn.png");

    private final String type;
    private final String frontImg;

    Cards(String type, String frontImg) {
        this.type = type;
        this.frontImg = "src/main/resources/images/cards/" + frontImg;
    }

    public String getType() {
        return type;
    }

    public String getFront() {
        return frontImg;
    }

    public void getCardToken(Player player) {
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
=======
package data;

import other.ModelCommonMethods;
import token.Fighter;
import token.LaurelToken;
import token.MaterialToken;
import token.ScienceToken;

public enum Cards {

    MAT_WOOD("Material", "card-material-wood-lumberjack.png"),
    MAT_GLASS("Material", "card-material-glass-women.png"),
    MAT_BRICK("Material", "card-material-brick-women.png"),
    MAT_STONE("Material", "card-material-stone-stonecutter.png"),
    MAT_PAPER("Material", "card-material-papyrus-women.png"),
    MAT_GOLD("Material", "card-material-gold-vizir.png"),
    LAU_EMPEROR("Laurel", "card-politic-emperor-3laurel.png"),
    LAU_CAT("Laurel", "card-politic-women-2laurel-cat.png"),
    SCI_ARCHITECT("Science", "card-progress-architect.png"),
    SCI_LAW("Science", "card-progress-law.png"),
    SCI_MECHANIC("Science", "card-progress-mechanic.png"),
    COM_CENTURION("War", "card-war-centurion.png"),
    COM_BARBARIAN("War", "card-war-barbarian-1horn.png"),
    COM_ARCHER("War", "card-war-archer-2horn.png");

    private final String type;
    private final String frontImg;

    Cards(String type, String frontImg) {
        this.type = type;
        this.frontImg = "src/main/resources/images/cards/" + frontImg;
    }

    public String getType() {
        return type;
    }

    public String getFront() {
        return frontImg;
    }

    public void getCardToken(Player player) {
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
>>>>>>> bruce
