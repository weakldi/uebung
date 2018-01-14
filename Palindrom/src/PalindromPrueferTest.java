import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PalindromPrueferTest {
	private String[] satzpalindromArray = {
			//Quelle Wikipedia https://de.wikipedia.org/wiki/Liste_deutscher_Palindrome
			 "Ein Golf flog nie.                            ",
			 "Ein Ledergurt trug Redel nie.                 ",
			 "Ein Neger mit Gazelle zagt im Regen nie.      ",
			 "Ein Neger mit Gazette zagt im Regen nie.      ",
			 "Ein Regal mit Sirup pur ist im Lager nie.     ",
			 "Ein Siamese lese Mais nie.                    ",
			 "Eine Blase salbe nie.                         ",
			 "Eine Gans nage nie.                           ",
			 "Eine güldne, gute Tugend: Lüge nie!           ",
			 "Eine Horde bedrohe nie!                       "

	};
	
	private String[] keinStatzPalindromArray = {
			"Dies ist ein Satzpalindrom Satz.",
			"Das ist ein Test",
	};
	@Test
	public void testIstPalindrom() {
		// Erzeuge ein Objekt zum Testen.
		PalindromPruefer einPalindromPruefer = new PalindromPruefer();

		// Teste die null-Referenz.
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {einPalindromPruefer.istPalindrom(null);});
		assertThat("Null-Referenz wurde nicht korrekt verarbeitet.",
		        ex.getMessage(),
		        is(equalTo("Argument darf nicht null sein.")));

		// Teste Zeichenkette der Laenge 0.
		assertThat("String der Laenge 0 wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom(""),
				is(equalTo(true)));
		assertThat("String \"Radar\" wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("Radar"),
				is(equalTo(true)));
		
		assertThat("String \"OtTo\" wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("OtTo"),
				is(equalTo(true)));
		assertThat("String \"[{\" wurde nicht korrekt verarbeitet.", //Ohne überprüfung des bereiches in lower() wüede hier true zurückgegeben werden weil [ auf Z un { auf z folgt.
				einPalindromPruefer.istPalindrom("[{"),
				is(equalTo(false)));
		assertThat("String \"Palindrom\" wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("Palindrom"),
				is(equalTo(false)));
		
		
		/*
		 * Tests hier ergaenzen.
		 */

	}

	@Test
	void testIstSatzpalindrom() {

		// Erzeuge ein Objekt zum Testen.
		PalindromPruefer einPalindromPruefer = new PalindromPruefer();

		// Teste die null-Referenz.
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {einPalindromPruefer.istSatzPalindrom(null);});
		assertThat("Null-Referenz wurde nicht korrekt verarbeitet.",
		        ex.getMessage(),
		        is(equalTo("Argument darf nicht null sein.")));
		
		for (String satzPalindrom : satzpalindromArray) {
			assertThat(String.format("String \"%s\" wurde nicht korrekt verarbeitet.", satzPalindrom),
					einPalindromPruefer.istSatzPalindrom(satzPalindrom),
					is(equalTo(true)));
		}
		
		for (String satzPalindrom : keinStatzPalindromArray) {
			assertThat(String.format("String \"%s\" wurde nicht korrekt verarbeitet.", satzPalindrom),
					einPalindromPruefer.istSatzPalindrom(satzPalindrom),
					is(equalTo(false)));
		}
	}

}
