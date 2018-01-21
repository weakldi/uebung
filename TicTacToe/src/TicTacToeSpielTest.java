import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Test;

class TicTacToeSpielTest {

	@Test
	void testSimuliereSpiel1() {
		
		// Erzeuge neues Spiel.
		TicTacToeSpiel spiel = new TicTacToeSpiel("Trick", "Track");

		// Beispiel 1 aus https://de.wikipedia.org/wiki/Tic-Tac-Toe
		TicTacToeZug[] spielzuege = new TicTacToeZug[7];
		
		spielzuege[0] = new TicTacToeZug(0,2);
		spielzuege[1] = new TicTacToeZug(0,0);
		spielzuege[2] = new TicTacToeZug(2,0);
		spielzuege[3] = new TicTacToeZug(1,1);
		spielzuege[4] = new TicTacToeZug(2,2);
		spielzuege[5] = new TicTacToeZug(1,2);
		spielzuege[6] = new TicTacToeZug(2,1);
		
		assertThat("Erstes Beispiel nicht korrekt.",
				spiel.bestimmeSieger(spielzuege),
				is(equalTo("Trick")));
		
		cleanup(spielzuege);
				
	}
	
	@Test
	void testSimuliereSpiel2() {
		
		// Erzeuge neues Spiel.
		TicTacToeSpiel spiel = new TicTacToeSpiel("Trick", "Track");

		// Beispiel 2 aus https://de.wikipedia.org/wiki/Tic-Tac-Toe
		TicTacToeZug[] spielzuege = new TicTacToeZug[7];
		
		spielzuege[0] = new TicTacToeZug(1,1);
		spielzuege[1] = new TicTacToeZug(0,1);
		spielzuege[2] = new TicTacToeZug(0,0);
		spielzuege[3] = new TicTacToeZug(2,2);
		spielzuege[4] = new TicTacToeZug(1,0);
		spielzuege[5] = new TicTacToeZug(2,0);
		spielzuege[6] = new TicTacToeZug(1,2);
		
		assertThat("Zweites Beispiel nicht korrekt.",
				spiel.bestimmeSieger(spielzuege),
				is(equalTo("Trick")));
		
		cleanup(spielzuege);
				
	}
	
	@Test
	void testSimuliereSpiel3() {
		
		// Erzeuge neues Spiel.
		TicTacToeSpiel spiel = new TicTacToeSpiel("Trick", "Track");

		// Beispiel 2 aus https://de.wikipedia.org/wiki/Tic-Tac-Toe
		TicTacToeZug[] spielzuege = new TicTacToeZug[8];
		
		spielzuege[0] = new TicTacToeZug(0,1);
		spielzuege[1] = new TicTacToeZug(1,1);
		spielzuege[2] = new TicTacToeZug(2,1);
		spielzuege[3] = new TicTacToeZug(2,0);
		spielzuege[4] = new TicTacToeZug(0,2);
		spielzuege[5] = new TicTacToeZug(0,0);
		spielzuege[6] = new TicTacToeZug(2,2);
		spielzuege[7] = new TicTacToeZug(1,0);
		
		assertThat("Drittes Beispiel nicht korrekt.",
				spiel.bestimmeSieger(spielzuege),
				is(equalTo("Track")));
		
		cleanup(spielzuege);
				
	}
	
	@Test
	void testSimuliereSpiel4() {
		
		// Erzeuge neues Spiel.
		TicTacToeSpiel spiel = new TicTacToeSpiel("Trick", "Track");

		// Beispiel 4 aus https://de.wikipedia.org/wiki/Tic-Tac-Toe
		TicTacToeZug[] spielzuege = new TicTacToeZug[9];
		
		spielzuege[0] = new TicTacToeZug(0,1);
		spielzuege[1] = new TicTacToeZug(1,1);
		spielzuege[2] = new TicTacToeZug(0,2);
		spielzuege[3] = new TicTacToeZug(0,0);
		spielzuege[4] = new TicTacToeZug(2,2);
		spielzuege[5] = new TicTacToeZug(1,2);
		spielzuege[6] = new TicTacToeZug(1,0);
		spielzuege[7] = new TicTacToeZug(2,0);
		spielzuege[8] = new TicTacToeZug(2,1);
		/**
		 * 
		 */
		assertThat("Viertes Beispiel nicht korrekt.",
				spiel.bestimmeSieger(spielzuege),
				is(equalTo("niemand")));
		
		cleanup(spielzuege);
				
	}
	
	private void cleanup(TicTacToeZug[] spielzuege) {
		if (spielzuege != null) {
			for (int i = 0; i < spielzuege.length; i++) {
				spielzuege[i] = null;
			}
		}
	}

}
