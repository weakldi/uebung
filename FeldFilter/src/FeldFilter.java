

/**
 * Klasse zur Realisierung verschiedener Filteroperationen
 * auf einem Feld.
 */
public class FeldFilter {
	/**
	 * Inner Klasse Node.
	 * Ein Node objekt repersentiert ein Listen Element.
	 * Ein Nodeobjekt besitzt eine Referenz auf das Naechste Element in der List.
	 * Falls es kein naechstes Element geben sollte ist diese Referenz eine null-Referenz.
	 */
	private class Node{

		Node next = null;
		int val = 0;
		/**
		 * Erstellet ein neues Nodeobjekt.
		 * @param val Initialer Wert des Node-Objekts.
		 */
		Node(int val) {
			this.val = val;
		}		
	}

	private int[] feld;

	/**
	 * Erstellt einen neuen FeldFilter mit den Werten des Feldes Feld.
	 * @param feld
	 */
	public FeldFilter(int[] feld) {
		super();
		this.feld = feld.clone();
	}
	/**
	 * Kopiert die Elemente der Liste in ein Array.
	 * Das erste Element wird nicht kopiert, weil es nur zur
	 * Speicherung der laenge der Liste dient.
	 * @param start Erste element der Liste
	 * @return Referenz auf ein int[] mit den Elementen der Liste.
	 */
	private int[] listToArray(Node start){
		int[] retVal = new int[start.val];

		for(int i = 0;(start = start.next) != null;i++) {
			retVal[i] = start.val;
		}
		
		return retVal;
	}
	
	/**
	 * Gib ein Feld zur&uuml;ck, das nur die Werte aus
	 * dem gespeicherten Feld enth&auml;lt, die echt gr&ouml;&szlig;er
	 * als der &uuml;bergebene Wert sind. Die Reihenfolge der Werte
	 * darf dabei nicht ver&auml;ndert werden.
	 * @param untereSchranke Wert, der als untere Schranke gelten soll.
	 * @return Berechnetes Feld.
	 */
	public int[] filterGroesserAls(int untereSchranke) {

		//Erstes Element der Liste erstellen die die Werte anthalten soll die 
		//großer als untereSchranke sind.
		//Das erste Element speichert die anzahl der groeßeren Elemente.
		Node aktuell = new Node(0),
			 start = aktuell;
		//Schleife sucht jedes element das groeßer als untereSchranke ist.
		for (int val : feld) {
			//Wenn der Wert groeßer ist wird dieser an die Liste angehaengt und
			//der Wert des ersten Listenelements um 1 erhoeht.
			if(val > untereSchranke) {
				aktuell = aktuell.next = new Node(val);
				start.val++;
			}
		}
		
		//Konvertiert die Liste zu einem Array und gibt dies zurück.
		return listToArray(start);
	}
	
	/**
	 * Gib ein Feld zur&uuml;ck, das nur die Werte aus
	 * dem gespeicherten Feld enth&auml;lt, die weder mit
	 * dem minimalen noch mit dem maximalen Element &uuml;bereinstimmen. 
	 * Die Reihenfolge der Werte darf dabei nicht ver&auml;ndert werden.
	 * @return Berechnetes Feld.
	 */
	public int[] eliminiereMinMax() {
		//Falls das Feld weniger als drei Elemente enthaelt wird auf jedem Fall jeder Wert
		//aus dem Feld feld entfaehrnt.
		int[] ausgabe = {}; // Default-Rueckgabe: Leeres Feld.
		if(feld.length<=2) {
			return ausgabe;
		}
		
		int minVal = Integer.MAX_VALUE;
		int maxVal = minVal+1; //Integer overflow => Integer.MIN_VALUE
		int minCount = 0;
		int maxCount = 0;
		
		//Schleife ermittelt den minimalen und den maximalen Wert im Feld feld.
		//Zudem wird die Anzahl dieser Werte gezaehlt damit spaeter die Groeße des
		//neuem Feldes bestimmt werden kann.
		for (int val : feld) {
			if(val < minVal) {
				minCount = 1;
				minVal = val;
			}else if(minVal == val)minCount++;
			if(val > maxVal) {
				maxCount = 1;
				maxVal = val;
			}else if(maxVal == val)maxCount++;
		}
		//Neues feld erstellen.
		//Falls minVal == maxVal muss nur eine der Beiden zaehler (minCount oder maxCount) zur
		//Berechnung der Feldgroeße genutzt werden da beide werte gleich sind.
		if(minVal == maxVal)
			ausgabe = new int[feld.length-maxCount];
		else
			ausgabe = new int[feld.length-minCount-maxCount];
		//Werte in das neue Feld kopieren.
		int i = 0;
		for (int val : feld) {
			if(minVal != val && maxVal != val)
				ausgabe [i++] = val;
		}	
		//Werte zurueckgeben.
		return ausgabe;
	}
}
