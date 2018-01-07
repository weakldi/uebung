import java.io.IOException;

/**
 * Klasse zum Erzeugen und rudiment&auml;ren Ausprobieren
 * eines FidgetSpinnerArms.
 */
public class FidgetSpinnerArmRunner {
	/**
	 * Mangels einer (offiziell bekannten) Test-Funktionalitaet
	 * koennen die Methoden nur dadurch "getestet" werden, dass
	 * Arme mit unterschiedlichen Massen konstruiert werden und
	 * im Anschluss alle abgeleiteten Attribute ausgelesen werden.
	 */
	public void run() {
		
		double d1 = 1.0;   // Bei Bedarf aendern.
		double l1 = 2.0;   // Bei Bedarf aendern.
		double d2 = 3.0;   // Bei Bedarf aendern.
		double l2 = 4.0;   // Bei Bedarf aendern.
		
		// Erzeugen eines neuen Objekts und speichern der Referenz
		// in der Variablen arm. Durch Versenden von Botschaften
		// ueber diese Referenz koennen die Methoden aufgerufen werden.
		FidgetSpinnerArm arm = new FidgetSpinnerArm(d1, l1, d2, l2);
		
		
		System.out.println("d1 = " + d1 + ", l1 = " + l1 + ", d2 = " + d2 + ", l2 = " + l2);
		System.out.println("(a) Gerundete Oberflaeche = " + arm.berechneGerundeteOberflaeche());
		System.out.println("(b) Gerundetes Volumen    = " + arm.berechneGerundetesVolumen());
		System.out.println("(c) Gerundete Masse       = " + arm.berechneGerundeteMasse());
	}

	// Ausfuehren dieser Methode in Eclipse durch Rechtsklick auf
	// den Klassennamen im Package Explorer, dann "Run As -> Java Application".
	public static void main(String[] args) {
		FidgetSpinnerArmRunner fsr = new FidgetSpinnerArmRunner();
		fsr.run();
	}

}
