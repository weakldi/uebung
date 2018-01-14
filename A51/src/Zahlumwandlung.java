/**
 * Umrechnung einer Zahl im Bereich [1..3000] in das r&ouml;mische Zahlsystem.
 */
public class Zahlumwandlung {
	private char[] symbole = new char[] {
		'I',
		'V',
		'X',
		'L',
		'C',
		'D',
		'M'
	};
	
	
	/**
	 * Wandel eine Natuerliche Zahl aus dem Bereich 1 bis 3000 in eine Roemische Zahl um.
	 * @param n Zahl die umgewandelt werden soll.
	 * @return Zahl n in der Roemischen Schreibweise.
	 */
	public String wandeleZahlUm(int n) {
		//Bereich ueberpruefen. (1 ... 3000)
		if(0 > n || n > 3000) {
			throw new IllegalArgumentException(String.format("Die Nummer n=%d muss im Interval [0, 3000] liegen. ", n));
		}
		//System.out.println(n);
		String nummerDec = n + "";
		String nummer = "";
		for (int i = 1, indexSymbols = 0; i <= nummerDec.length(); i++) {
			// Wert der i-er Stelle von n berechenen.
			int val = nummerDec.charAt(nummerDec.length() - i) - 48; //48 = ascii von '0'
			
			String numberSymbols = "";
			//Weil gleiche Zeichen fuer die Zahl nich mehr als 3 mal nebeneiander stehen duerfen muessen die Faelle val > 3 && < 9,
			// val == 9 und val <= 3 unterschieden werden.
			//
			if(val > 3 && val < 9) {
				int anzahlPrefix = (5-val); // Die anzahl der zu Subrtahierenden Zeichen wird berechnent.
				
				//String fuer die i-er Stelle zusammensetzten.
				numberSymbols = mul(symbole[indexSymbols], anzahlPrefix) + //Prefix (Zeichen die abgezogen werden muessen.
								symbole[indexSymbols+1] + 					//Zeichen der hoeheren einheit.
								mul(symbole[indexSymbols], val-5); // Aufüllen der fehlenden Werte um den Wert
																						// der i-ten Stelle zu ereichen.
			
			}
			//Weil fuer den Wert 9* 10 ^ i wieder vier Werte der kleinenern Einheit verwendet werden muessten muss der String 
			//mit dem naechst hoehren Zehner gebildet werden.
			else if(val == 9) {
				numberSymbols = symbole[indexSymbols]+""+symbole[indexSymbols+2];
			}else {
				//Wert kann mit val*Zeichen der Stelle 10^(i-1) gebildet werden.
				numberSymbols = mul(symbole[indexSymbols],val);
			}
			
			//Setzt das naechst Zeichen fuer die Basiseinhet auf den naechsten Zehner.
			indexSymbols += 2;
			//System.out.printf("%d | %d -> %d: %s\n",indexSymbols, i, val, numberSymbols);
			nummer = numberSymbols+nummer;
		}
	
		
		
		return nummer;
	}
	
	/**
	 * Wiederhohlt ein Zeichen c n mal.
	 * @param s Zeichen das wiederhohlt werden soll.
	 * @param number Anzahl der Wiederholungen.
	 * @return
	 */
	public String mul(char c, int number) {
		String retVal = ""; //Damit der String nicht mit null startet.
		for(int i = 0; i < number; i++) {
			retVal+=c;
		}
		return retVal;
	}
	
//	public String mul(String s, int number) {
//		String retVal = ""; //Damit der String nicht mit null startet.
//		for(int i = 0; i < number; i++) {
//			retVal+=s;
//		}
//		return retVal;
//	}
}
