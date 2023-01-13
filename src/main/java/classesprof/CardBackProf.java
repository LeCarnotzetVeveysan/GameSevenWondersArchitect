package classesprof;

public enum CardBackProf {

	CentralDeck(null), //
	
	Alexandrie(WonderProf.Alexandrie), //
	Halicarnasse(WonderProf.Halicarnasse),
	Ephese(WonderProf.Ephese), //
	Olympie(WonderProf.Olympie), //,
	Babylone(WonderProf.Babylone), //
	Rhodes(WonderProf.Rhodes), //
	Gizeh(WonderProf.Gizeh); //
	
	public final boolean centralDeck;
	// set only when not centralDeck
	public final WonderProf wonderProfDeck;
	
	private CardBackProf(WonderProf wonderProfDeck) {
		this.centralDeck = (wonderProfDeck == null);
		this.wonderProfDeck = wonderProfDeck;
	}
	
}
