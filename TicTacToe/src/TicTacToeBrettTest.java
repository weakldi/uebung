import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeBrettTest {

    @Test
    public void testLeereKonstruktoren() {

        // Konstruktor für leeres Brett mit Standardgröße
        TicTacToeBrett brett = new TicTacToeBrett();
        assertThat("Standard-Brettgröße",
                brett.getSeitenLaenge(), is(TicTacToeBrett.seitenLaenge));

    }

    @Test
    public void testInhaltskonstruktor() {

        // Felder setzen
        TicTacToeBrett brett = new TicTacToeBrett(new TicTacToeMarke[][] {
            {null,              TicTacToeMarke.X,   null},
            {TicTacToeMarke.O,  null,               TicTacToeMarke.X},
            {TicTacToeMarke.X,  TicTacToeMarke.O,   TicTacToeMarke.O}
        });

        // Felder direkt lesen
        assertThat("Feldmarkierung(0,0)", brett.getFeld(0, 0), is(equalTo(null)));
        assertThat("Feldmarkierung(0,1)", brett.getFeld(0, 1), is(equalTo(TicTacToeMarke.X)));
        assertThat("Feldmarkierung(0,2)", brett.getFeld(0, 2), is(equalTo(null)));
        assertThat("Feldmarkierung(1,0)", brett.getFeld(1, 0), is(equalTo(TicTacToeMarke.O)));
        assertThat("Feldmarkierung(1,1)", brett.getFeld(1, 1), is(equalTo(null)));
        assertThat("Feldmarkierung(1,2)", brett.getFeld(1, 2), is(equalTo(TicTacToeMarke.X)));
        assertThat("Feldmarkierung(2,0)", brett.getFeld(2, 0), is(equalTo(TicTacToeMarke.X)));
        assertThat("Feldmarkierung(2,1)", brett.getFeld(2, 1), is(equalTo(TicTacToeMarke.O)));
        assertThat("Feldmarkierung(2,2)", brett.getFeld(2, 2), is(equalTo(TicTacToeMarke.O)));

        // Felder als Stringrepräsentation lesen
        assertThat("Feldmarkierungen als String-Repräsentation",
                brett.toString(), is(equalTo("Spielfeld:\n"
                        + " X \n"
                        + "O X\n"
                        + "XOO\n")));
    }

    @Test
    public void testSetGetAndGleichheit() {

        // Felder setzen
        TicTacToeMarke[][] feld1 = new TicTacToeMarke[][] {
            {null,              TicTacToeMarke.X,   null},
            {TicTacToeMarke.O,  null,               TicTacToeMarke.X},
            {TicTacToeMarke.X,  TicTacToeMarke.O,   TicTacToeMarke.O}
        };
        TicTacToeMarke[][] feld2 = new TicTacToeMarke[][] {
            {null,              TicTacToeMarke.X,   null},
            {TicTacToeMarke.O,  null,               TicTacToeMarke.X},
            {TicTacToeMarke.X,  TicTacToeMarke.O,   TicTacToeMarke.O}
        };
        assertThat("Verschiedene Felder", feld1 == feld2, is(false));
        assertThat("Gleicher Inhalt", feld1, is(feld2));

        // Bretter bauen
        TicTacToeBrett brett1 = new TicTacToeBrett(feld1);
        TicTacToeBrett brett2 = new TicTacToeBrett(feld2);
        assertThat("Verschiedene Bretter", brett1 == brett2, is(false));

        // Gleichheit
        assertThat("'Gleiche' Bretter", brett1, is(equalTo(brett2)));
        assertThat("Gleich aussehende Bretter",
                brett1.toString(), is(equalTo(brett2.toString())));

        // Ein Feld ändern
        brett2.setFeld(0, 2, TicTacToeMarke.X);
        assertThat("Nicht mehr 'Gleiche' Bretter", brett1, is(not(equalTo(brett2))));
        assertThat("Nicht mehr gleich aussehende Bretter",
                brett1.toString(), is(not(equalTo(brett2.toString()))));

        // Das gleiche Feld beim anderen ändern
        brett1.setFeld(0, 2, TicTacToeMarke.X);
        assertThat("'Gleiche' Bretter", brett1, is(equalTo(brett2)));
        assertThat("Gleich aussehende Bretter",
                brett1.toString(), is(equalTo(brett2.toString())));
    }

    @Test
    public void testGewinnposition() {

        // Ein Feld ohne Gewinnposition
        TicTacToeMarke[][] feld = new TicTacToeMarke[][] {
            {null,              TicTacToeMarke.X,   null},
            {TicTacToeMarke.O,  null,               TicTacToeMarke.X},
            {TicTacToeMarke.X,  TicTacToeMarke.O,   TicTacToeMarke.O}
        };
        assertThat("Keine Gewinnposition",
                new TicTacToeBrett(feld).enthaeltGewinnposition(),
                is(equalTo(null)));

        // Horizontale Gewinnposition für X
        feld = new TicTacToeMarke[][] {
            {null,              TicTacToeMarke.O,   null},
            {TicTacToeMarke.O,  null,               TicTacToeMarke.O},
            {TicTacToeMarke.X,  TicTacToeMarke.X,   TicTacToeMarke.X}
        };
        assertThat("Horizontale Gewinnposition für X",
                new TicTacToeBrett(feld).enthaeltGewinnposition(),
                is(equalTo(TicTacToeMarke.X)));

        // Vertikale Gewinnposition für O
        feld = new TicTacToeMarke[][] {
            {null,              TicTacToeMarke.O,   null},
            {TicTacToeMarke.X,  TicTacToeMarke.O,   null},
            {TicTacToeMarke.X,  TicTacToeMarke.O,   TicTacToeMarke.X}
        };
        assertThat("Vertikale Gewinnposition für O",
                new TicTacToeBrett(feld).enthaeltGewinnposition(),
                is(equalTo(TicTacToeMarke.O)));

        // Hauptdiagonale Gewinnposition für X
        feld = new TicTacToeMarke[][] {
            {TicTacToeMarke.X,  TicTacToeMarke.O,   null},
            {null,              TicTacToeMarke.X,   null},
            {TicTacToeMarke.O,  TicTacToeMarke.O,   TicTacToeMarke.X}
        };
        assertThat("Hauptdiagonale Gewinnposition für X",
                new TicTacToeBrett(feld).enthaeltGewinnposition(),
                is(equalTo(TicTacToeMarke.X)));

        // Gegendiagonale Gewinnposition für O
        feld = new TicTacToeMarke[][] {
            {TicTacToeMarke.X,  TicTacToeMarke.X,   TicTacToeMarke.O},
            {null,              TicTacToeMarke.O,   null},
            {TicTacToeMarke.O,  null,               TicTacToeMarke.X}
        };
        assertThat("Hauptdiagonale Gewinnposition für X",
                new TicTacToeBrett(feld).enthaeltGewinnposition(),
                is(equalTo(TicTacToeMarke.O)));

        // Horizontale Gewinnposition für beide: X first
        feld = new TicTacToeMarke[][] {
            {TicTacToeMarke.O,  TicTacToeMarke.O,   TicTacToeMarke.O},
            {null,              null,               null},
            {TicTacToeMarke.X,  TicTacToeMarke.X,   TicTacToeMarke.X}
        };
        assertThat("Horizontale Gewinnposition für X",
                new TicTacToeBrett(feld).enthaeltGewinnposition(),
                is(equalTo(TicTacToeMarke.X)));
    }
}
