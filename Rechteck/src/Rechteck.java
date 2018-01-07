/**
 * Klasse Rechteck.
 * Representiert ein Rechteck das durch seine Laenge und seine Breite definiert wird.
 */
public class Rechteck {
	//Länge und Breite des Rechtecks
	private double breite, laenge;
	/**
	 * Konstruktor des Rechteks.
	 * @param breite Breite des Rechtecks.	
	 * @param laenge Laenge des Rechtecks
	 */
	public Rechteck(double breite, double laenge) {
		super();
		this.breite = breite;
		this.laenge = laenge;
	}
	/**
	 * 
	 * @return Die Breite des Rechtecks.
	 */
	public double getBreite() {
		return breite;
	}

	/**
	 * 
	 * @return Die Laenge des Rechtecks.
	 */
	public double getLaenge() {
		return laenge;
	}
	/**
	 * 
	 * @return Den Umfang des Rechtecks.
	 */
	public double getUmfang() {
		return 2 * (laenge + breite);
	}
	/**
	 * 
	 * @return Den Flaecheninhalt des Rechtecks.
	 */
	public double getFlaeche() {
		return laenge * breite;
	}
}
