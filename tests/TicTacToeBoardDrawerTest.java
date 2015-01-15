import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeBoardDrawerTest {

    private TicTacToeBoardDrawer ticTacToeBoardDrawer;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        ticTacToeBoardDrawer = new TicTacToeBoardDrawer(printStream);
    }

    @Test
    public void shouldConstructEmptyBoard(){
        String[] boardState = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        ticTacToeBoardDrawer.constructBoard(boardState);
        verify(printStream).println("   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n");
    }

    @Test
    public void shouldConstructPlayedBoard(){
        String[] boardState = new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "};
        ticTacToeBoardDrawer.constructBoard(boardState);
        verify(printStream).println(" X |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n");
    }

}