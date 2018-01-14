import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ZahlumwandlungTest {

	@Test
	public void testWandeleZahlUm() {
		
		// Erzeuge ein Objekt der Klasse Zahlumwandlung.
		Zahlumwandlung eineZahlumwandlung = new Zahlumwandlung();
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {eineZahlumwandlung.wandeleZahlUm(0);});
		assertThat("Zahl kleiner als 1 wurde nicht korrekt verarbeitet.",
		        ex.getMessage(),
		        is(equalTo(String.format("Die Nummer n=%d liegt nicht im Interval [1, 3000] liegen. ", 0))));
		ex = assertThrows(IllegalArgumentException.class, () -> {eineZahlumwandlung.wandeleZahlUm(3001);});
		assertThat("Zahl groeßer als 3000 wurde nicht korrekt verarbeitet.",
		        ex.getMessage(),
		        is(equalTo(String.format("Die Nummer n=%d liegt nicht im Interval [1, 3000] liegen. ", 3001))));
		assertThat("Zahl 1 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(1),
				is(equalTo("I")));
		assertThat("Zahl 5 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(5),
				is(equalTo("V")));
		assertThat("Zahl 4 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(4),
				is(equalTo("IV")));
		
		assertThat("Zahl 7 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(7),
				is(equalTo("VII")));
		assertThat("Zahl 9 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(9),
				is(equalTo("IX")));
		assertThat("Zahl 10 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(10),
				is(equalTo("X")));
		assertThat("Zahl 11 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(11),
				is(equalTo("XI")));
		assertThat("Zahl 13 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(13),
				is(equalTo("XIII")));
		assertThat("Zahl 14 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(14),
				is(equalTo("XIV")));
		assertThat("Zahl 15 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(15),
				is(equalTo("XV")));
		assertThat("Zahl 21 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(21),
				is(equalTo("XXI")));
		assertThat("Zahl 34 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(34),
				is(equalTo("XXXIV")));
		
		assertThat("Zahl 99 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(99),
				is(equalTo("XCIX")));
		assertThat("Zahl 10 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(10),
				is(equalTo("X")));
		assertThat("Zahl 3000 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(3000),
				is(equalTo("MMM")));
		assertThat("Zahl 2500 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(2500),
				is(equalTo("MMD")));
		assertThat("Zahl 1500 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(1500),
				is(equalTo("MD")));

		/*
		 * Tests hier ergaenzen.
		 */

	}
}
