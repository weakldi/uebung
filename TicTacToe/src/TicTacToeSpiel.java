/**
 * Ein Tic-Tac-Toe-Spiel
 */
public class TicTacToeSpiel {

    private TicTacToeBrett      brett;
    private TicTacToeSpieler    spieler1;
    private TicTacToeSpieler    spieler2;
    private int[] zm = {
    		0b1 | 0b1000 | 0b1000000,
			0b1 | 0b10 | 0b100,
			0b1 | 0b10000 | 0b10000000,
		    0b10 | 0b10000 | 0b10000000,
	    	0b1000000 | 0b10000 | 0b100,
	    	0b100000000 | 0b100000 | 0b100,
    	    0b1000| 0b10000 | 0b100000,
    	    0b1000| 0b10000 | 0b100000,
    	    0b1000000|0b10000000|0b100000000
    	};
  
    /**
     * Erzeugung eines Standard-Tic-Tac-Toe-Spiels mit zwei Spielern.
     * @param spielerName1 Der Name des ersten Spielers
     * @param spielerName2 Der Name des zweiten Spielers
     */
    public TicTacToeSpiel(String spielerName1, String spielerName2) {

        // Initialisierung der Spieler mit fester Vorgabe ihrer Markierungen
    		spieler1 = new TicTacToeSpieler(spielerName1, TicTacToeMarke.X);
    		spieler2 = new TicTacToeSpieler(spielerName2, TicTacToeMarke.O);
    		
    		brett = new TicTacToeBrett();
    }
    
    /**
     * Bestimmt f&uuml;r eine gegebene Folge von Spielz&uuml;gen den Namen des Spielers,
     * der als erstes eine Gewinnposition erzielt oder "niemand", wenn dies niemandem gelingt.
     * Bei einer ung&uuml;ltigen Folge von Spielz&uuml;gen (null-Referenz, mehrfaches 
     * Setzen eines Felds) wird eine entsprechende Fehlermeldung ausgegeben.
     * @param spielzuege Folge der Spielz&uuml;ge, beginnend mit dem ersten Zug von Spieler 1.
     * @return Name des Siegers bzw. "niemand".
     */
    public String bestimmeSieger(TicTacToeZug[] spielzuege) {

		String sieger = "niemand";
    	if(spielzuege.length < 5) return sieger;
     	int zuege[] = {0,0};
    	for(int i = 0; i < spielzuege.length; i++) {
    		zuege[i & 1] += 1 << (spielzuege[i].getX()*3+spielzuege[i].getY());
    		for(int j = 0; j < zm.length; j++) {
	    		if ((zuege[i & 1] & zm[j]) == zm[j]) 
	    			return (i & 1) == 0 ? spieler1.getName() : spieler2.getName();
	    			
	    	}
    	}
    	return sieger;
    }
        
    /**
     * String-Repr&auml;sentation des Spiels inkl. Brett und Spieler.
     * @return String-Repr&auml;sentation des Spiels
     */
    @Override
    public String toString() {
        return "Spiel zwischen " + spieler1 + " und " + spieler2 + ":\n" + brett;
    }
}
