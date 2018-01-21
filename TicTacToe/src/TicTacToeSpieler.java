/**
 * Repr&auml;sentation eines Tic-Tac-Toe-Spielers
 */
public class TicTacToeSpieler {

    private String name;
	private TicTacToeMarke marke;

    /**
     * Erzeugt einen Tic-Tac-Toe-Spieler mit einem Namen.
     * @param name  Name des Spielers (read only)
     * @param marke Marke des Spielers (read only)
     */
    public TicTacToeSpieler(String name, TicTacToeMarke marke) {
    		if (name.equals("niemand")) {
    			throw new IllegalArgumentException("Netter Versuch, aber wir sind nicht in der Odyssee.");
    		}
        this.name = name;
        this.marke = marke;
    }

    /**
     * Getter f&uuml;r den Namen des Spielers.
     * @return Name des Spielers
     */
    public String getName() {
        return name;
    }

    /**
     * Getter f&uuml;r die Marke des Spielers.
     * @return Marke des Spielers
     */
    public TicTacToeMarke getMarke() {
        return marke;
    }

    @Override
    public String toString() {
    		return getName() + " (" + (getMarke() == TicTacToeMarke.X ? "X" : "O") + ")";
    }
    
}
