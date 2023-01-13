package classesprof;

/**
 * type of cards
 */
public enum CardTypeProf {

	// MaterialProf Cards
	CardMaterialWood("materialProf:wood", MaterialProf.Wood, "card-materialProf-wood-lumberjack.png"), //
	CardMaterialPaper("materialProf:paper", MaterialProf.Paper, "card-materialProf-paper-women.png"), //
	CardMaterialBrick("materialProf:brick", MaterialProf.Brick, "card-materialProf-brick-women.png"), //
	CardMaterialStone("materialProf:stone", MaterialProf.Stone, "card-materialProf-stone-stonecutter.png"), //
	CardMaterialGlass("materialProf:glass", MaterialProf.Glass, "card-materialProf-glass-women.png"), //
	// joker (mandatory replacing any materialProf)
	CardMaterialGold("materialProf:gold", MaterialProf.Gold, "card-materialProf-gold-vizir.png"), //
	
	// Science cards
	CardScienceLaw("science:law", ScienceCategoryProf.Law, "card-progress-law.png"), //
	CardScienceMechanic("science:mechanic", ScienceCategoryProf.Mechanic, "card-progress-mechanic.png"), //
	CardScienceArchitect("science:architect", ScienceCategoryProf.Architect, "card-progress-architect.png"), //
	
	// War Cards
	CardWar_barbarian("war:barbarian", 1, 1, "card-war-barbarian-1corn.png"), //
	CardWar_centurion("war:centurion", 1, 0, "card-war-centurion.png"),  //
	CardWar_archer("war:archer", 1, 2, "card-war-archer-2corns.png"), //

	// Polics Cards
	CardPolitic_emperor("politic:emperor", 3, false, "card-politic-emperor-3laurel.png"), //
	CardPolitic_cat("politic:cat", 2, true, "card-politic-women-2laurel-cat.png") //
	;

	// ------------------------------------------------------------------------
	
	public final String cardDisplayName;
	
	public final CardCategoryProf cardCategoryProf;
	
	/** materialProf of the card, meaningfull only cardCategoryProf==MaterialProf */
	public final MaterialProf materialProf;

	/** drawing on the card, meaningfull only cardCategoryProf==Science */
	public final ScienceCategoryProf scienceCategoryProf;

	/** number of shields, meaningfull only cardCategoryProf==War */
	public final int shieldCount;
	/** number of corns, meaningfull only cardCategoryProf==War */
	public final int cornCount;
	
	/** number of laurel, meaningfull only cardCategoryProf==Politic */
	public final int laurelCount;
	/** with cat, meaningfull only cardCategoryProf==Politic */
	public final boolean cat;
	
	public final String imageResource;

	// ------------------------------------------------------------------------

	private CardTypeProf(String cardDisplayName, CardCategoryProf cardCategoryProf, //
						 MaterialProf materialProf, // only when cardCategoryProf==MaterialProf
						 ScienceCategoryProf scienceCategoryProf, // only when cardCategoryProf==Science
						 int shieldCount, int cornCount, // only when cardCategoryProf==War
						 int laurelCount, boolean cat, // only when cardCategoryProf==Politic
						 String imageResource) {
		this.cardDisplayName = cardDisplayName;
		this.cardCategoryProf = cardCategoryProf;
		this.materialProf = materialProf;
		this.scienceCategoryProf = scienceCategoryProf;
		this.shieldCount = shieldCount;
		this.cornCount = cornCount;
		this.laurelCount = laurelCount;
		this.cat = cat;
		this.imageResource = "images/cards/" + imageResource;
	}
	
	// for MaterialProf card
	private CardTypeProf(String cardDisplayName, MaterialProf materialProf, String imageResource) {
		this(cardDisplayName, CardCategoryProf.MaterialCard, materialProf, null, 0, 0, 0, false, imageResource);
	}
	// for Science card
	private CardTypeProf(String cardDisplayName, ScienceCategoryProf scienceCategoryProf, String imageResource) {
		this(cardDisplayName, CardCategoryProf.ProgressCard, null, scienceCategoryProf, 0, 0, 0, false, imageResource);
	}
	// for War card
	private CardTypeProf(String cardDisplayName, int shieldCount, int cornCount, String imageResource) {
		this(cardDisplayName, CardCategoryProf.WarCard, null, null, shieldCount, cornCount, 0, false, imageResource);
	}
	// for Politic card
	private CardTypeProf(String cardDisplayName, int laurelCount, boolean cat, String imageResource) {
		this(cardDisplayName, CardCategoryProf.PoliticCard, null, null, 0, 0, laurelCount, cat, imageResource);
	}

}
