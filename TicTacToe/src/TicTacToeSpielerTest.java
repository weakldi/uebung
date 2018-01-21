import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeSpielerTest {

    @Test
    public void testKonstruktor() {
        TicTacToeSpieler spieler = new TicTacToeSpieler("Domino", TicTacToeMarke.X);
        assertThat("Spielername",
                spieler.getName(), is(equalTo("Domino")));
    }
}
