/**
 * Klasse zur Repr&auml;sentation eines gek&uuml;rzten Dezimalbruchs. 
 */
public class Bruch {

	/*
	 * Hier Attributvereinbarungen ergaenzen.
	 */
	
	private int zaehler, nenner;
	
	/*
	 * Hier Konstruktoren ergaenzen.
	 */
	
	public Bruch() {
		this.zaehler = this.nenner = 1;
	}
	
	public Bruch(int zaehler) {
		this.zaehler = zaehler;
		this.nenner = 1;
	}
	
	/**
	 * @param zaehler
	 * @param nenner
	 */
	public Bruch(int zaehler, int nenner) {
		if(nenner == 0)
			throw new IllegalArgumentException("Nenner muss von Null verschieden sein.");
		this.zaehler = zaehler;
		setNenner(nenner); // Kuertzt den Bruch direkt.
	}
	/*
	 * Hier Methoden ergaenzen.
	 */
	
	public Bruch add(Bruch b2){
		int n3 = this.nenner*b2.getNenner();
		int z3 = this.zaehler*b2.getNenner() + b2.getZaehler() * this.nenner;
		return new Bruch(z3, n3);
	}
	
	public Bruch sub(Bruch b2) {
		b2.setNenner(b2.getNenner()*-1);
		return add(b2);
	}
	
	public Bruch mul(Bruch b2) {
		return new Bruch(
				this.zaehler * b2.zaehler,
				this.nenner * b2.nenner
				);
	}
	
	public Bruch div(Bruch b2) {
		return mul(b2.getKehrWert());
	}
	
	public Bruch getKehrWert() {
		return new Bruch(nenner, zaehler);
	}
	
	int ggt(int a, int b) {
		return b == 0 ? a : ggt(b, a % b);
	}
	
	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	/**
	 * Setzt den Nenner des Bruchs und k&uuml;rzt dann ggfs.
	 * @param Nenner Der neue Nenner des Bruchs.
	 */
	public void setNenner(int nenner) {
		// Beispiel zur Behandlung eines ungueltigen Parameters.
		if (nenner == 0) {
			throw new IllegalArgumentException("Nenner muss von Null verschieden sein.");
		}

		/*
		 * Hier ergaenzen.
		 */
	}

	

}
