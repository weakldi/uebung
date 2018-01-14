


/**
 * &Uuml;berpr&uuml;fung der Eigenschaft, ein Palindrom zu sein.
 */
public class PalindromPruefer {

//	static {
//		char c = 65;
//		for ( ; c <= 'Z';c ++) {
//			System.out.printf("%8s -> %s\n", Integer.toBinaryString(lower(c)), ""+lower(c));
//		}
//		c = 'a';
//		for ( ; c <= 'z';c ++) {
//			System.out.printf("%8s -> %s\n", Integer.toBinaryString(c), ""+c);
//		}
//	}
    /**
     * &Uuml;berpr&uuml;fe, ob die &uuml;bergebene Zeichenkette
     * ein Palindrom ist. Hierbei soll nicht zwischen Gross- und
     * Kleinbuchstaben unterschieden werden.
     * @param eingabe Zu testende Zeichenkette.
     * @return <CODE>true</CODE>, wenn die Zeichenkette ein Palindrom
     *         ist, <CODE>false</CODE> sonst.
     */
    public boolean istPalindrom(String eingabe) {
    	// Auf falsche eingaben überprüfen.
    	if(eingabe == null)
    		throw new IllegalArgumentException("Argument darf nicht null sein.");
    	
    	// Chararray des Strings abrufen, weil ich die charAt(int ) Methode nicht aufrufen will. 
	    char[] c_eingabe = eingabe.toCharArray();
	    
	    // Das Array auf eine überprüfen indem zuerst die beiden äußeren Zeichen auf gleichheit geprüft werden.
	    // Danach werden die Zeichen eins weiter innen überprüft. Dies wird wiederholt bis 
	    // das gesammte Array geprüeft ist.
	    // Falls das Array eine ungerade anzahl von Elementen besitzt wird das mittlere Element nicht 
	    // geprüeft. Dies ist egal, da das Element in der Mitte steht und deswegen die Symetrie nicht stört.
		for (int i = 0; i < c_eingabe.length/2; i++) {
			//Beide Zeichen werden zu einem kleinbuchstaben konvertiert und verglichen.
			// Altenrnativ koennte die Character.toLowerCase() an der Stelle von lower() verwendet werden.
			if(lower(c_eingabe[i]) != lower(c_eingabe[c_eingabe.length-1 - i]))
				return false; // Gibt false zurück sobalt ein Fehler gefunden wird.
		}
		// Falls kein Fehler gefunden wurde wird true zurückgegeben.
	    return true; 
    }

    /**
     * &Uuml;berpr&uuml;fe, ob die &uuml;bergebene Zeichenkette
     * ein Satzpalindrom ist. Hierbei soll nicht zwischen Gross- und
     * Kleinbuchstaben unterschieden werden.
     * @param eingabe Zu testende Zeichenkette.
     * @return <CODE>true</CODE>, wenn die Zeichenkette ein Palindrom
     *         ist, <CODE>false</CODE> sonst.
     */
    public boolean istSatzPalindrom(String eingabe) {
    	// Auf falsche eingaben überprüfen.
    	if(eingabe == null)
    		throw new IllegalArgumentException("Argument darf nicht null sein.");
    	
    	// Entfährnt alle whitspace-Zeichen und alle Satztzeichen und überprüft den String.
        return istPalindrom(
        		eingabe.replaceAll("\\s|\\p{Punct}", "")); 

    }
    
    /**
     * Wandelt ein Großbuchstaben in einen Kleinbuchstaben um.
     * Die Nummer des Zeichens muss aus der ASCII-Tabelle sein, 
     * weil die Konvertierung sonst fehlschlägt.
     * @param c
     * @return
     */
    public static char lower(char c) {
    	
    	// Damit die Zeichen konvertiret werden sollen mussen die Zeichen im Beireich der Buchstaben liegen.
    	// Dies wird hier geprüeft.
    	if(c < 'A' || c > 'Z' && c < 'a' || c > 'z')
    		return c;
    	
    	// Großbuchsaben:	 10xxxxx
    	// Kleinbuchstaben:	 11xxxxx
    	// Wandelt Zeichen mit or um. Alternativ koennte man auch
    	// eine Subrtaktion oder Addition nutzten.
    	return (char) (c | 0b1100000);
    }

}
