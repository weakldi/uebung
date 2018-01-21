/**
 * Repr&auml;sentation eines Tic-Tac-Toe-Spielbretts.
 */
public class TicTacToeBrett {

	/**
	 * Seitenl&auml;nge eines Tic-Tac-Toe-Spielbretts.
	 */
	public static final int seitenLaenge = 3;

	private TicTacToeMarke[][] markierungen;

	/**
	 * Erzeugt ein leeres Tic-Tac-Toe-Brett.
	 */
	// Hier Programmtext ergaenzen.

	/**
	 * Erzeugt ein Tic-Tac-Toe-Brett aus einem gegebenen Feld.
	 * Das Feld muss die Gr&ouml;sse 3x3 haben, ansonsten wird
	 * eine Fehlermeldung ausgel&ouml;st.
	 * @param markierungen Das Spielfeld.
	 */
	// Hier Programmtext ergaenzen.
	
	/**
	 * Gibt die Seitenl&auml;nge des Spielbretts an.
	 * @return Seitenl&auml;nge des Spielbretts.
	 */
	// Hier Programmtext ergaenzen.

	/**
	 * Getter f&uuml;r die Marke an einer anzugebenden Adresse.
	 * @param x Spalten-Koordinate.
	 * @param y Zeilen-Koordinate.
	 * @return Marke des Bretts an der gegebenen Adresse.
	 */
	// Hier Programmtext ergaenzen.

	/**
	 * Setzt eine Markierung f&uuml;r das &uuml;ber die Koordinaten angegebene Feld.
	 * @param x Horizontale Koordinate v. l. n. r., beginnend bei 0.
	 * @param y Vertikale Koordinate v. o. n. u., beginnend bei 0.
	 * @param marke Die Markierung, die auf das Feld gesetzt werden soll.
	 */
	// Hier Programmtext ergaenzen.

	/**
	 * Testet, ob das Brett eine Gewinnposition enth&auml;lt
	 * und gibt das Symbol des Gewinners zur&uuml;ck. Falls beide Spieler
	 * Gewinnpositionen haben, soll das Symbol des ersten Spielers (X)
	 * zur&uuml;ckgegeben werden. 
	 * @return Wert des Gewinners. Wenn es keinen gibt, <CODE>null</CODE>.
	 */
	// Hier Programmtext ergaenzen.


	// Die nachfolgenden Methoden dienen dem Testen bzw. der Fehlersuche
	// und sind daher schon ausprogrammiert.
	
	public TicTacToeBrett(TicTacToeMarke[][] ticTacToeMarkes) {
		this.markierungen = ticTacToeMarkes;
	}

	public TicTacToeBrett() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Pr&uuml;ft, ob zwei Bretter "gleich" sind.
	 * Dies ist der Fall, wenn die Spielfelder gleich markiert sind.
	 * @param b Das andere Brett.
	 * @return Wahr genau dann, wenn die zwei Felder "gleich" sind.
	 */
	@Override
	public boolean equals(Object b) {

		// Gar kein Brett: dann nicht "gleich"
		if (! (b instanceof TicTacToeBrett)) {
			return false;
		}

		// Typumwandlung sicher
		TicTacToeBrett brett = (TicTacToeBrett) b;

		// Vergleiche einzeln
		for (int y = 0; y < TicTacToeBrett.seitenLaenge; y++) {
			for (int x = 0; x < TicTacToeBrett.seitenLaenge; x++) {
				if (brett.getFeld(x, y) != getFeld(x, y)) { // null-sicher!
					return false;
				}
			}
		}

		// Dann müssen sie gleich sein!
		return true;
	}

	public TicTacToeMarke getFeld(int x, int y) {
		return markierungen[x][y];
	}

	/**
	 * Erzeugt eine String-Repr&auml;sentation des Feldes.
	 */
	@Override
	public String toString() {
		String output = "Spielfeld:\n";

		// Iteriere über alle Zeilen
		for (int y = 0; y < markierungen.length; y++) {

			// Iteriere über alle Spalten
			for (int x = 0; x < markierungen.length; x++) {
				TicTacToeMarke m = markierungen[y][x];
				if (m == null) {
					output += " ";
				}
				else {
					output += m;
				}
			}

			// Zeile fertig
			output += "\n";
		}

		// Fertig
		return output;
	}

	public int getSeitenLaenge() {
		// TODO Auto-generated method stub
		return seitenLaenge;
	}

	public void setFeld(int i, int j, TicTacToeMarke x) {
		markierungen[i][j] = x;
	}
	public boolean check(int x,int y) {
		System.out.println(x);
		boolean retVal = markierungen[x][y] == markierungen[(x+1)%3][y] && markierungen[x][y] == markierungen[(x+2)%3][y] ||
						 markierungen[x][y] == markierungen[x][(y+1)%3] && markierungen[x][y] == markierungen[x][(y+2)%3];
		if(retVal)return true;
		else {
			if((x == 0 || x == 2) && (y == 0 || y == 2)) {
				return markierungen[x][y] == markierungen[1][1] && markierungen[1][1] == markierungen[(x+2)%3][(y+2)%3];
			}else if(x == 1 && y == 1) {
				return 	markierungen[0][0] == markierungen[1][1] && markierungen[2][2] == markierungen[1][1] ||
						markierungen[2][0] == markierungen[1][1] && markierungen[0][2] == markierungen[1][1];
			}
		}
		return retVal;
	}
	
	public Object enthaeltGewinnposition() {
		for(int i = 0; i < 9; i++){
			if(markierungen[i/3][i%3] != null) {
				int x = i/3;
				int y = i%3;
				System.out.println(x + " " + y + " " + check(x,y));
				if(check(x, y))return markierungen[x][y];
			}
		}
		return null;
	}
}
