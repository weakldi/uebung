/**
 * Aufgabe 46 (WiSe 2017/18).
 */
public class ICERunner {

    public void run() {
        // Erzeuge ein neues Objekt.
       	ICE ice = new ICE((short) 0x4142, "AB");

        // Beschleunige sechsmal (hier ohne Schleifenkonstrukt).
        ice.beschelunigen();
        ice.beschelunigen();
        ice.beschelunigen();
        ice.beschelunigen();
        ice.beschelunigen();
        ice.beschelunigen();

        // Wiederhole viermal:
        ice.bremsAb();
        System.out.printf("Geschwindigkeit: %2d%n", ice.getGeschwindigkeit());
        ice.bremsAb();
        System.out.printf("Geschwindigkeit: %2d%n", ice.getGeschwindigkeit());
        ice.bremsAb();
        System.out.printf("Geschwindigkeit: %2d%n", ice.getGeschwindigkeit());
        ice.bremsAb();
        System.out.printf("Geschwindigkeit: %2d%n", ice.getGeschwindigkeit());
        // [Hier Programmtext ergaenzen]
    }

    public static void main(String[] args) {
        ICERunner einICERunner = new ICERunner();
        einICERunner.run();
    }

}
