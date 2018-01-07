/**
 * L&ouml;sung zu Aufgabe 46 (WiSe 2017/2018).
 * (Erg#&auml;nze: Modellierung ...)
 * @author [hier erg&auml;nzen]
 */
public class FidgetSpinnerArm {
	// Vereinbare die folgenden Attribute:
  	// Durchmesser des ersten Halbstifts
	private double d1,
	// L&auml;nge des ersten Halbstifts.
	l1,
	// Durchmesser des zweiten Halbstifts.
	d2,
	// L&auml;nge des zweiten Halbstifts.
	l2;
	// Die nachfolgende Deklarationen nutzen Konstrukte aus Kapitel 11 und 12
	// (static/final), um oeffentlich sichtbare (public) Konstanten zu vereinbaren.
	public static final double APX_PI              = 3.14;
	public static final double GOLD_DICHTE         = 19.32;
	public static final double APX_WURZEL_FUENF    = 2.24;

	// Die Logik hinter dem nachfolgenden Konstruktor wird erst am
	// Donnerstag in der Vorlesung (Folien 9.66f.) erklaert. Aus diesem
	// Grund wird die Implementierung hier bereits vorgegeben.
	/**
	 * Konstruktor f&uuml;r den Fidget-Spinner-Arm.
	 * Dieser Konstruktor erwartet vier nicht-negative Werte, die den
	 * Durchmesser und die L&auml;nge des ersten bzw. zweiten Zylinders 
	 * beschreiben. Diese Werte m&uuml;ssen beim Erzeugen eines Arms 
	 * &uuml;bergeben werden und sind danach weder ver&auml;nderbar noch auslesbar.
	 * Als Einheit aller Ma&szlig;e wird "cm" angenommen.
	 * @param d1 Durchmesser des ersten Zylinders.
	 * @param l1 L&auml;nge des ersten Zylinders.
	 * @param d2 Durchmesser des zweiten Zylinders.
	 * @param l2 L&auml;nge des zweiten Zylinders.
	 */
	public FidgetSpinnerArm(double d1, double l1, double d2, double l2) {
		if (d1 < 0) {
			//  Entspricht vom Prinzip her dem aus Racket bekannten
			//  (error ...), d.h. es wird eine Fehlermeldung ausgeloest.
			throw new IllegalArgumentException("Durchmesser d1 darf nicht negativ sein.");
		}
		if (l1 < 0) {
			throw new IllegalArgumentException("Laenge l1 darf nicht negativ sein.");
		}
		if (d2 < 0) {
			throw new IllegalArgumentException("Durchmesser d2 darf nicht negativ sein.");
		}
		if (l2 < 0) {
			throw new IllegalArgumentException("Laenge l2 darf nicht negativ sein.");
		}
		// Speichere den Wert des Parameters d1 im Objekt-Attribut d1.
		this.d1 = d1;
		// Speichere den Wert des Parameters l1 im Objekt-Attribut l1.
		this.l1 = l1;
		// Speichere den Wert des Parameters d2 im Objekt-Attribut d2.
		this.d2 = d2;
		// Speichere den Wert des Parameters l2 im Objekt-Attribut l2.
		this.l2 = l2;
	}

	/**
	 * Runden einer gegebenen Zahl auf eine gegebene Anzahl an Nachkommastellen.
	 * @param x Zu rundende Zahl.
	 * @param n Anzahl der erwuenschten Nachkommastellen.
	 * @return Auf <I>n</I> Nachkommastellen abgerundeter Wert von <I>x</I>.
	 */
	double runde(double x, int n) {
		if (n<0) {
			throw new IllegalArgumentException("Anzahl der Nachkommastellen darf nicht negativ sein.");
		}
		double pow = Math.pow(10, n);
		return ((long)(x * pow))/pow;
	}
	/**
	 * Berechent den Betrag einer Zahl.
	 * @param n Zahl für die der Betrag berechnet werden soll.
	 * @return Betrag von n
	 */
	double abs(double n) {
		return n < 0 ? 
					n * -1 : 	//true 
					n;			//false
	}
	
	/**
	 * Approximative Berechung der Fl&auml;che eine Kreisscheibe f&uuml;r einen gegebenen Durchmesser. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser der Kreisscheibe.
	 * @return Approximierte Fl&auml;che der Kreisscheibe.
	 */
	double berechneKreisflaeche(double d) {
		if (d < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		return APX_PI*(d/2)*(d/2);
	}

	/**
	 * Approximative Berechung des Volumens eines Kegels f&uuml;r einen gegebenen 
	 * Durchmesser, der auch der H&ouml;he entspricht. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser des Kegels.
	 * @return Approximiertes Volumen des Kegels.
	 */
	double berechneKegelvolumen(double d) {
		if (d < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		return 1/3.0*berechneZylindervolumen(d, d);
	}

	/**
	 * Approximative Berechung des Volumens eines Zylinders f&uuml;r einen gegebenen Durchmesser
	 * und eine gegebene L&auml;nge.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser der Zylinders.
	 * @param l L&auml;nge des Zylinders
	 * @return Approximiertes Volumen des Zylinders.
	 */
	double berechneZylindervolumen(double d, double l) {
		if (d < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		if (l < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Laenge darf nicht negativ sein.");
		}
		return berechneKreisflaeche(d)*l;
	}

	/**
	 * Approximative, ungerundete Berechung des Volumens des Arms.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximiertes Volumen des Arms.
	 */
	double berechneUngerundetesVolumen() {
		return berechneKegelvolumen(d1)+berechneZylindervolumen(d1, l1)+berechneZylindervolumen(d2, l2);
	}
	
	/**
	 * Approximative Berechung der Manelfl&auml;che eines Kegels f&uuml;r einen gegebenen 
	 * Durchmesser, der auch der H&ouml;he entspricht. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser des Kegels.
	 * @return Approximierte Mantelfl&auml;che des Kegels.
	 */
	double berechneKegelmantelflaeche(double d) {
		if (d < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}

		return APX_PI * (d/2) * d * (APX_WURZEL_FUENF / 2.0);
	}
	/**
	 * Berechnet die Oberfl&auml;che eines Ringes.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d1 Durchmaesser eines der beiden Kreise die den Ring beschraenken.
	 * @param d2 Durchmaesser des anderen Kreise die den Ring beschraenken.
	 * @return
	 */
	double berechneRingflaeche(double d1, double d2) {
		if (d1 < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser d1 darf nicht negativ sein.");
		}
		if (d2 < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser d2 darf nicht negativ sein.");
		}
		
		return abs(berechneKreisflaeche(d1)-berechneKreisflaeche(d2));
	}
	
	/**
	 * Approximative Berechung der Oberfl&auml;che eines Kegels f&uuml;r einen gegebenen 
	 * Durchmesser, der auch der H&ouml;he entspricht. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser des Kegels.
	 * @return Approximierte Oberfl&auml;che des Kegels.
	 */
	double berechneKegeloberflaeche(double d) {
		if (d < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}

		return berechneKegelmantelflaeche(d) + berechneKreisflaeche(d);
	}
	/**
	 * Approximative Berechung der Mantelfl&auml;che eines Zylinders. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser des Zylinders.
	 * @param l L&auml;enge des Zylinders
	 * @return Approximierte Mantelfl&auml;che des Zylinders.
	 */
	double berechneZylindermantelflaeche(double d,double l) {
		if (d < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		if (l < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Laenge darf nicht negativ sein.");
		}
		return APX_PI*d*l;
	}
	/**
	 * Approximative Berechung der Oberfl&auml;che eines Zylinders f&uuml;r einen gegebenen 
	 * Durchmesser und eine gegebene L&auml;nge.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser der Zylinders.
	 * @param l L&auml;nge des Zylinders
	 * @return Approximierte Oberfl&auml;che des Zylinders.
	 */
	double berechneZylinderoberflaeche(double d, double l) {
		if (d < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		if (l < 0 /* true loeschen, Test auf ungueltigen Parameter eintragen */) {
			throw new IllegalArgumentException("Laenge darf nicht negativ sein.");
		}

		return 2*berechneKreisflaeche(d)+berechneZylindermantelflaeche(d, l);
	}
	
	/**
	 * Approximative Berechung der Oberfl&auml;che des Armes.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximierte Oberfl&auml;che des Armes.
	 */
	double berechneUngerundeteOberflaeche() {
		return berechneKegelmantelflaeche(d1) + 		//Kegel
				berechneZylindermantelflaeche(d1, l1) + //Erster Zylinder
				berechneRingflaeche(d1, d2) +   		//Schnittflaeche zwischen dem erstem und dem zweitem Zylinder
				berechneZylindermantelflaeche(d2, l2) + berechneKreisflaeche(d2); //Zweiter Zylider
	}

	/**
	 * Approximative Berechnung der Masse des Armes.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximierte Masse des Armes.
	 */
	double berechneUngerundeteMasse() {
	    return 0.0;
	}

	/**
	 * Approximative, auf drei Nachkommastellen gerundete Berechnung des Volumens
	 * des Arms. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximatives, auf drei Nachkommastellen gerundetes Volumen. 
	 */
	public double berechneGerundetesVolumen() {
		return runde(berechneUngerundetesVolumen(), 3);
	}

	/**
	 * Approximative, auf zwei Nachkommastellen gerundete Berechnung der Oberfl&auml;che
	 * des Arms. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximatives, auf zwei Nachkommastellen gerundetes Volumen. 
	 */
	public double berechneGerundeteOberflaeche() {
		return runde(berechneUngerundeteOberflaeche(), 2);
	}

	/**
	 * Approximative, auf zwei Nachkommastellen gerundete Berechnung der Masse (in g)
	 * des Stifts bei einer Dichte von 19,32 g/cm<SUP>3</SUP>. 
	 * Bei der Berechnung wird als Approximation von PI der Wert 3,14 verwendet.
	 * @return Approximative, auf zwei Nachkommastellen gerundete Masse in Gramm. 
	 */
	public double berechneGerundeteMasse() {
		return berechneUngerundetesVolumen()*GOLD_DICHTE;
	}

}
