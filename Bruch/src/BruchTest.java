import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BruchTest {

    /* Ein beispielhafter Test einer Ausnahmebehandlung: */
	@Test
	public void testKonstruktor() {

		// Teste das Ausloesen einer Ausnahme bei Null als Nenner
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {new Bruch(42, 0);});
		assertThat("Inkorrekte Ausnahme geworfen.",
		        ex.getMessage(),
		        is(equalTo("Nenner muss von Null verschieden sein.")));

		/*
		 * Hier Tests ergaenzen.
		 */
	}
	
	/* Ein beispielhafter Test: */
	@Test
	public void testGetZaehler() {
		// Erzeuge einen Bruch zum Testen.
		Bruch einBruch = new Bruch();

		// Teste den Zaehler des Bruchs.
		assertThat("getZahler arbeitet nicht korrekt.",
				einBruch.getZaehler(),
				is(equalTo(1)));

	}

	/*
	 * Hier Tests ergaenzen.
	 */

}
