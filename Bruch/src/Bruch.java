/**
 * Klasse zur Repr&auml;sentation eines gek&uuml;rzten Dezimalbruchs. 
 */
public class Bruch {

	/**
	 * 
	 */
	private int zaehler, nenner;
	

	/**
	 * Erzeugt einen neuen Bruch mit dem Zaehler 1 und dem Nenner 1.
	 * Der Bruch representiert somit den Wert 1.
	 */
	public Bruch() {
		this.zaehler = this.nenner = 1;
	}
	
	/**
	 * Erzeugt einen neuen Bruch mit dem Zaehler zaehler und dem Nenner 1.
	 * Der Bruch representiert den Wert des Zaehlers.
	 * @param zaehler
	 */
	public Bruch(int zaehler) {
		this.zaehler = zaehler;
		this.nenner = 1;
	}
	
	/**
	 * Erzeugt einen neuen Bruch mit dem Zaehler zaehler und dem Nenner nenner.
	 * @param zaehler
	 * @param nenner
	 */
	public Bruch(int zaehler, int nenner) {
		if(nenner == 0)
			throw new IllegalArgumentException("Nenner muss von Null verschieden sein.");
		this.zaehler = zaehler;
		setNenner(nenner); // Kuertzt den Bruch direkt.
	}

	/**
	 * Addiert den Bruch b2 zum Bruch.
	 * @param b2 Anderer Summand
	 * @return Referenz auf einen Bruch welcher die Summe enthaelt.
	 */
	public Bruch add(Bruch b2){
		int n3 = this.nenner*b2.getNenner();
		int z3 = this.zaehler*b2.getNenner() + b2.getZaehler() * this.nenner;
		return new Bruch(z3, n3);
	}
	/**
	 * Substituiert b2 vom Bruch.
	 * @param b2 der Substituent
	 * @return Differrenz Bruch-b2.
	 */
	public Bruch sub(Bruch b2) {
		Bruch b3 = new Bruch(b2.zaehler, b2.nenner * -1);
		return add(b3);
	}
	/**
	 * Berechent das Produkt des Bruches mit einem Anderen Bruch b2.
	 * @param b2 anderer Bruch.
	 * @return Referenz auf ein neuen Bruch welcher das Produkt enthaelt.
	 */
	public Bruch mul(Bruch b2) {
		return new Bruch(
				this.zaehler * b2.zaehler,
				this.nenner * b2.nenner
				);
	}
	
	/**
	 * Berechent den Quotienten des Bruches mit einem Anderen Bruch b2.
	 * @param b2 Bruch durch den geteilt werden soll.
	 * @return Referenz auf ein neuen Bruch welcher den Quotienten enthaelt.
	 */
	public Bruch div(Bruch b2) {
		return mul(b2.getKehrWert());
	}
	
	/**
	 * Berechent den Kehrwert des Bruches.
	 * @return Referenz auf ein neuen Bruch welcher den Kehrwert des Bruches enthaelt.
	 */
	public Bruch getKehrWert() {
		return new Bruch(nenner, zaehler);
	}
	
	/**
	 * Berechnet den groeßten gemeinsamen Teiler von a, b.
	 * @param a Zahl 1
	 * @param b Zahl 2
	 * @return ggt
	 */
	int ggt(int a, int b) {
		return b == 0 ? a : ggt(b, a % b);
	}
	
	/**
	 * Kuertzt den Bruch
	 */
	void kuerze() {
		int ggt =  ggt(nenner, zaehler);
		nenner 	/= ggt;
		zaehler /= ggt;
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
		this.nenner = nenner;
		kuerze();
	}
	
	@Override
	public boolean equals(Object arg0) {
//		System.out.println(zaehler + " / " + nenner);
		if (!(arg0 instanceof Bruch) ){
			return false;
		}else if(nenner != ((Bruch) arg0).getNenner()) {
			return false;
		}else if(zaehler != ((Bruch) arg0).getZaehler()) {
			return false;
		}
		return true;
	}

	

}
