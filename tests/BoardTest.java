import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldPrintEmptyBoard(){
        board.printBoard();
        verify(printStream).println("   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n");
    }

    @Test
    public void shouldPrintPlayedBoard(){
        board.placePiece(0, "X");
        board.placePiece(1, "O");
        board.printBoard();
        verify(printStream).println(" X | O |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n");
    }

    @Test
    public void shouldReturnTrueIfMoveIsLegal() {
        assertTrue(board.validateMove(0));
    }

    @Test
    public void shouldReturnFalseIfMoveIsIllegal() {
        board.placePiece(0, "X");
        assertFalse(board.validateMove(0));
    }

    @Test
    public void shouldReturnFalseIfGameIsIncomplete() {
        assertFalse(board.isGameOver());
    }

    @Test
    public void shouldReturnTrueIfGameIsComplete() {
        board.placePiece(0, "O");
        board.placePiece(1, "X");
        board.placePiece(2, "O");
        board.placePiece(3, "X");
        board.placePiece(4, "X");
        board.placePiece(5, "O");
        board.placePiece(6, "X");
        board.placePiece(7, "O");
        board.placePiece(8, "X");
        assertTrue(board.isGameOver());
    }

}