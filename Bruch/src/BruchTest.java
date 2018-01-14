import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BruchTest {
	
	Bruch einBruch = new Bruch();
	Bruch einBruch2 = new Bruch(7);
	Bruch einBruch3 = new Bruch(7,7);
	Bruch einBruch4 = new Bruch(3,4);
	Bruch einBruch5 = new Bruch(4,3);
	Bruch einBruch6 = new Bruch(2,4);
	
	Bruch b1PlusB2 = einBruch.add(einBruch2);
	Bruch b3PlusB4 = einBruch3.add(einBruch4);
	Bruch b4PlusB5 = einBruch4.add(einBruch5);
	
	Bruch b1SubB2 = einBruch.sub(einBruch2);
	Bruch b3SubB4 = einBruch3.sub(einBruch4);
	Bruch b4SubB5 = einBruch4.sub(einBruch5);
	Bruch b4SubB6 = einBruch4.sub(einBruch6);
	
	Bruch b1MulB2 = einBruch .mul(einBruch2);
	Bruch b3MulB4 = einBruch3.mul(einBruch4);
	Bruch b4MulB5 = einBruch4.mul(einBruch5);
	Bruch b4MulB6 = einBruch4.mul(einBruch6);
	
	Bruch b1DivB2 = einBruch .div(einBruch2);
	Bruch b3DivB4 = einBruch3.div(einBruch4);
	Bruch b4DivB5 = einBruch4.div(einBruch5);
	Bruch b4DivB6 = einBruch4.div(einBruch6);

    /* Ein beispielhafter Test einer Ausnahmebehandlung: */
	@Test
	public void testKonstruktor() {

		// Teste das Ausloesen einer Ausnahme bei Null als Nenner. Da der Konstruktor setNenner aufruhft muss setNenner nichtmehr getestet werden.
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {new Bruch(42, 0);});
		assertThat("Inkorrekte Ausnahme geworfen.",
		        ex.getMessage(),
		        is(equalTo("Nenner muss von Null verschieden sein.")));
		assertThat("Konstruktor arbeitet nicht korrekt.",
				einBruch,
				is(equalTo(new Bruch(1,1))));
		assertThat("Konstruktor arbeitet nicht korrekt.",
				einBruch2,
				is(equalTo(new Bruch(7, 1))));
		assertThat("Konstruktor arbeitet nicht korrekt.",
				einBruch3,
				is(equalTo(einBruch)));
	}
	
	/* Ein beispielhafter Test: */
	@Test
	public void testGetZaehler() {
		// Erzeuge einen Bruch zum Testen.
		// Teste den Zaehler des Bruchs.
		assertThat("getZahler arbeitet nicht korrekt.",
				einBruch.getZaehler(),
				is(equalTo(1)));
		assertThat("getZahler arbeitet nicht korrekt.",
				einBruch2.getZaehler(),
				is(equalTo(7)));
		assertThat("kuerze arbeitet nicht korrekt",
				einBruch3.getZaehler(),
				is(equalTo(1)));
		assertThat("getZahler arbeitet nicht korrekt.",
				einBruch4.getZaehler(),
				is(equalTo(3)));
		assertThat("getNenner arbeitet nicht korrekt.",
				einBruch4.getZaehler(),
				is(equalTo(3)));
		
	}
	@Test
	public void testGetNenner() {
		// Erzeuge einen Bruch zum Testen.

		// Teste den Zaehler des Bruchs.
		assertThat("getZahler arbeitet nicht korrekt.",
				einBruch.getNenner(),
				is(equalTo(1)));
		
	}
	
	@Test
	public void testAdd() {
		// Erzeuge einen Bruch zum Testen.
		
		
		// Teste den Zaehler des Bruchs.
		assertThat("add arbeitet nicht korrekt.",
				b1PlusB2,
				is(equalTo(new Bruch(8, 1))));
		assertThat("add arbeitet nicht korrekt.",
				b3PlusB4,
				is(equalTo(new Bruch(7, 4))));
		assertThat("add arbeitet nicht korrekt.",
				b4PlusB5,
				is(equalTo(new Bruch(25, 12))));
		
	}
	@Test
	public void testSub() {
		// Erzeuge einen Bruch zum Testen.
		
		
		// Teste den Zaehler des Bruchs.
		assertThat("sub arbeitet nicht korrekt.",
				b1SubB2,
				is(equalTo(new Bruch(-6, 1))));
		assertThat("sub arbeitet nicht korrekt.",
				b3SubB4,
				is(equalTo(new Bruch(1, 4))));
		assertThat("sub arbeitet nicht korrekt.",
				b4SubB5,
				is(equalTo(new Bruch(-7, 12))));
		assertThat("sub arbeitet nicht korrekt.",
				b4SubB6,
				is(equalTo(new Bruch(1, 4))));
		
	}
	
	@Test
	public void testMul() {
		// Erzeuge einen Bruch zum Testen.
		
		
		// Teste den Zaehler des Bruchs.
		assertThat("mul arbeitet nicht korrekt.",
				b1MulB2,
				is(equalTo(new Bruch(7, 1))));
		assertThat("mul arbeitet nicht korrekt.",
				b3MulB4,
				is(equalTo(new Bruch(3, 4))));
		assertThat("mul arbeitet nicht korrekt.",
				b4MulB5,
				is(equalTo(new Bruch(1, 1))));
		assertThat("mul arbeitet nicht korrekt.",
				b4MulB6,
				is(equalTo(new Bruch(3, 8))));
		
	}
	
	@Test
	public void testDiv() {
		// Erzeuge einen Bruch zum Testen.
		
		
		// Teste den Zaehler des Bruchs.
		assertThat("mul arbeitet nicht korrekt.",
				b1DivB2,
				is(equalTo(new Bruch(1, 7))));
		assertThat("mul arbeitet nicht korrekt.",
				b3DivB4,
				is(equalTo(new Bruch(4, 3))));
		assertThat("mul arbeitet nicht korrekt.",
				b4DivB5,
				is(equalTo(new Bruch(9, 16))));
		assertThat("mul arbeitet nicht korrekt.",
				b4DivB6,
				is(equalTo(new Bruch(3, 2))));
		
	}
}
