/**
 * Klasse zur Modellierung von Z&uuml;gen in einem Tic-Tac-Toe-Spiel.
 */
public class TicTacToeZug {

	private int x;
	private int y;

	/**
	 * Konstruktor, der absichert, dass die Parameter g&uuml;ltige Koordinaten 
	 * auf dem Spielbrett sind.
	 * @param x
	 * @param y
	 * @see TicTacToeBrett#setFeld(int, int, TicTacToeMarke)
	 */
	public TicTacToeZug(int x, int y) {
		if (x < 0 || x >= TicTacToeBrett.seitenLaenge) {
			throw new IllegalArgumentException("x-Koordinate nicht in [0.." + (TicTacToeBrett.seitenLaenge - 1) + "].");
		}
		if (y < 0 || y >= TicTacToeBrett.seitenLaenge) {
			throw new IllegalArgumentException("y-Koordinate nicht in [0.." + (TicTacToeBrett.seitenLaenge - 1) + "].");
		}
		this.x = x;
		this.y = y;
	}	
	
	/**
	 * Liest die gespeicherte x-Koordinate aus.
	 * @return x-Koordinate.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Liest die gespeicherte y-Koordinate aus.
	 * @return y-Koordinate.
	 */
	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "[" + getX() + "," + getY() + "]";
	}
	
}
