package classesprof;

import java.util.Arrays;
import java.util.List;

public class CardDecksProf {

	public static class CardTypeQuantity {
		public final int quantity;
		public final CardTypeProf cardTypeProf;
		public CardTypeQuantity(int quantity, CardTypeProf cardTypeProf) {
			this.quantity = quantity;
			this.cardTypeProf = cardTypeProf;
		}
	}
	
	/** CardProf Types x Quantities for Gizeh Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Gizeh = Arrays.asList(new CardTypeQuantity[] {
			// materialProf
			new CardTypeQuantity(2, CardTypeProf.CardMaterialWood), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialPaper), //
			new CardTypeQuantity(1, CardTypeProf.CardMaterialBrick), // 2-1
			new CardTypeQuantity(2, CardTypeProf.CardMaterialStone), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialGlass), //
			new CardTypeQuantity(3, CardTypeProf.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(1, CardTypeProf.CardScienceLaw), //
			new CardTypeQuantity(1, CardTypeProf.CardScienceMechanic), //
			new CardTypeQuantity(2, CardTypeProf.CardScienceArchitect), //
			// war
			new CardTypeQuantity(2, CardTypeProf.CardWar_barbarian), //
			new CardTypeQuantity(2, CardTypeProf.CardWar_centurion), //
			new CardTypeQuantity(0, CardTypeProf.CardWar_archer), // 0 !
			// politics
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_emperor), //
			new CardTypeQuantity(3, CardTypeProf.CardPolitic_cat), //
	});

	/** CardProf Types x Quantities for Rhodes Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Rhodes = Arrays.asList(new CardTypeQuantity[] {
			// materialProf
			new CardTypeQuantity(2, CardTypeProf.CardMaterialWood), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialPaper), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialBrick), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialStone), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialGlass), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialGold), //
			// science
			new CardTypeQuantity(1, CardTypeProf.CardScienceLaw), //
			new CardTypeQuantity(2, CardTypeProf.CardScienceMechanic), //
			new CardTypeQuantity(1, CardTypeProf.CardScienceArchitect), //
			// war
			new CardTypeQuantity(2, CardTypeProf.CardWar_barbarian), //
			new CardTypeQuantity(2, CardTypeProf.CardWar_centurion), //
			new CardTypeQuantity(1, CardTypeProf.CardWar_archer), //
			// politics
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_emperor), //
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_cat), //
	});

	/** CardProf Types x Quantities for Babylon Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Babylon = Arrays.asList(new CardTypeQuantity[] {
			// materialProf
			new CardTypeQuantity(2, CardTypeProf.CardMaterialWood), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialPaper), //
			new CardTypeQuantity(2-1, CardTypeProf.CardMaterialBrick), // 2-1
			new CardTypeQuantity(2, CardTypeProf.CardMaterialStone), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialGlass), //
			new CardTypeQuantity(2+1, CardTypeProf.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(1, CardTypeProf.CardScienceLaw), //
			new CardTypeQuantity(2, CardTypeProf.CardScienceMechanic), //
			new CardTypeQuantity(2, CardTypeProf.CardScienceArchitect), //
			// war
			new CardTypeQuantity(1, CardTypeProf.CardWar_barbarian), //
			new CardTypeQuantity(2, CardTypeProf.CardWar_centurion), //
			new CardTypeQuantity(1, CardTypeProf.CardWar_archer), //
			// politics
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_emperor), //
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_cat), //
	});
	
	/** CardProf Types x Quantities for Halicarnasse Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Halicarnasse = Arrays.asList(new CardTypeQuantity[] {
			// materialProf
			new CardTypeQuantity(2, CardTypeProf.CardMaterialWood), //
			new CardTypeQuantity(1, CardTypeProf.CardMaterialPaper), // 2-1
			new CardTypeQuantity(2, CardTypeProf.CardMaterialBrick), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialStone), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialGlass), //
			new CardTypeQuantity(3, CardTypeProf.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(2, CardTypeProf.CardScienceLaw), //
			new CardTypeQuantity(1, CardTypeProf.CardScienceMechanic), //
			new CardTypeQuantity(1, CardTypeProf.CardScienceArchitect), //
			// war
			new CardTypeQuantity(2, CardTypeProf.CardWar_barbarian), //
			new CardTypeQuantity(2, CardTypeProf.CardWar_centurion), //
			new CardTypeQuantity(1, CardTypeProf.CardWar_archer), //
			// politics
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_emperor), //
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_cat), //
	});

	/** CardProf Types x Quantities for Alexandrie Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Alexandrie = Arrays.asList(new CardTypeQuantity[] {
			// materialProf
			new CardTypeQuantity(2, CardTypeProf.CardMaterialWood), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialPaper), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialBrick), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialStone), //
			new CardTypeQuantity(1, CardTypeProf.CardMaterialGlass), // 2-1
			new CardTypeQuantity(4, CardTypeProf.CardMaterialGold), // 2+2
			// science
			new CardTypeQuantity(1, CardTypeProf.CardScienceLaw), //
			new CardTypeQuantity(2, CardTypeProf.CardScienceMechanic), //
			new CardTypeQuantity(1, CardTypeProf.CardScienceArchitect), //
			// war
			new CardTypeQuantity(1, CardTypeProf.CardWar_barbarian), //
			new CardTypeQuantity(2, CardTypeProf.CardWar_centurion), //
			new CardTypeQuantity(1, CardTypeProf.CardWar_archer), //
			// politics
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_emperor), //
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_cat), //
	});

	/** CardProf Types x Quantities for Ephese Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Ephese = Arrays.asList(new CardTypeQuantity[] {
			// materialProf
			new CardTypeQuantity(2, CardTypeProf.CardMaterialWood), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialPaper), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialBrick), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialStone), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialGlass), //
			new CardTypeQuantity(3, CardTypeProf.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(2, CardTypeProf.CardScienceLaw), //
			new CardTypeQuantity(1, CardTypeProf.CardScienceMechanic), //
			new CardTypeQuantity(2, CardTypeProf.CardScienceArchitect), //
			// war
			new CardTypeQuantity(1, CardTypeProf.CardWar_barbarian), //
			new CardTypeQuantity(2, CardTypeProf.CardWar_centurion), //
			new CardTypeQuantity(1, CardTypeProf.CardWar_archer), //
			// politics
			new CardTypeQuantity(1, CardTypeProf.CardPolitic_emperor), //
			new CardTypeQuantity(2, CardTypeProf.CardPolitic_cat), //
	});

	/** CardProf Types x Quantities for Olympie Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Olympie = Arrays.asList(new CardTypeQuantity[] {
			// materialProf
			new CardTypeQuantity(1, CardTypeProf.CardMaterialWood), // 2-1
			new CardTypeQuantity(2, CardTypeProf.CardMaterialPaper), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialBrick), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialStone), //
			new CardTypeQuantity(2, CardTypeProf.CardMaterialGlass), //
			new CardTypeQuantity(3, CardTypeProf.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(2, CardTypeProf.CardScienceLaw), //
			new CardTypeQuantity(1, CardTypeProf.CardScienceMechanic), //
			new CardTypeQuantity(1, CardTypeProf.CardScienceArchitect), //
			// war
			new CardTypeQuantity(2, CardTypeProf.CardWar_barbarian), //
			new CardTypeQuantity(2, CardTypeProf.CardWar_centurion), //
			new CardTypeQuantity(1, CardTypeProf.CardWar_archer), //
			// politics
			new CardTypeQuantity(1, CardTypeProf.CardPolitic_emperor), //
			new CardTypeQuantity(3, CardTypeProf.CardPolitic_cat), //
	});

	/** CardProf Types x Quantities for extra Question Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Extra = Arrays.asList(new CardTypeQuantity[] {
			// materialProf
			new CardTypeQuantity(4, CardTypeProf.CardMaterialWood), //
			new CardTypeQuantity(4, CardTypeProf.CardMaterialPaper), //
			new CardTypeQuantity(4, CardTypeProf.CardMaterialBrick), //
			new CardTypeQuantity(4, CardTypeProf.CardMaterialStone), //
			new CardTypeQuantity(4, CardTypeProf.CardMaterialGlass), //
			new CardTypeQuantity(6, CardTypeProf.CardMaterialGold), //
			// science
			new CardTypeQuantity(4, CardTypeProf.CardScienceLaw), //
			new CardTypeQuantity(4, CardTypeProf.CardScienceMechanic), //
			new CardTypeQuantity(4, CardTypeProf.CardScienceArchitect), //
			// war
			new CardTypeQuantity(4, CardTypeProf.CardWar_barbarian), //
			new CardTypeQuantity(4, CardTypeProf.CardWar_centurion), //
			new CardTypeQuantity(2, CardTypeProf.CardWar_archer), //
			// politics
			new CardTypeQuantity(4, CardTypeProf.CardPolitic_emperor), //
			new CardTypeQuantity(8, CardTypeProf.CardPolitic_cat), //
	});
}
