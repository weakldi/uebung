/**
 * Klasse Rechteck.
 * Representiert ein Rechteck.
 */
public class RechteckUmfang {
	/**
	 * 
	 */
	private double laenge, umfang;

	/**
	 * Konstruktor des Rechtecks.
	 * Erwartet eine Laenge laenge und den Umfang umfang des Rechtecks.
	 * @param laenge Laenge des Rechtecks.
	 * @param umfang Umfang des Rechtecks.
	 */
	public RechteckUmfang(double laenge, double umfang) {
		super();
		this.laenge = laenge;
		this.umfang = umfang;
	}
	
	/**
	 * Gibt die Breite des Rechtecks zurueck.
	 * @return Die Breite des Rechtecks
	 */
	
	public double getBreite() {
		return (umfang - 2 * laenge) / 2.0;
	}
	/**
	 * Gibt die Leange des Rechtecks zurueck. 
	 * @return Die Laenge des Rechtecks
	 */
	public double getLaenge() {
		return laenge;
	}
	
	/**
	 * Gibt den Umfang des Rechtecks zurueck.
	 * @return Den Umfang des Rechtecks
	 */
	public double getUmfang() {
		return umfang;
	}
	
	/**
	 * Gibt den Fleacheninhalt des Rechtecks zurueck.
	 * @return Den Flaecheninhalt des Rechtecks
	 */
	public double getFlaeche() {
		return laenge * getBreite();
	}

	
	
	
}
