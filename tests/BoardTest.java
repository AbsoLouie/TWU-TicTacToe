import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;
    private PrintStream printStream;
    private String[] cells;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        cells = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, cells);
    }

    @Test
    public void shouldPrintBoard(){
        board.printBoard();
        verify(printStream).println("   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n");
    }

    @Test
    public void shouldPrintPlayedBoard(){
        cells[0] = "*";
        cells[1] = "#";
        board.printBoard();
        verify(printStream).println(" * | # |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n" +
                                    "-----------" + "\n" +
                                    "   |   |   " + "\n");
    }

    @Test
    public void shouldReturnTrueIfCellIsEmpty() {
        assertTrue(board.isCellEmpty(0));
    }

    @Test
    public void shouldReturnFalseIfCellIsNotEmpty() {
        cells[0] = "*";
        assertFalse(board.isCellEmpty(0));
    }

    @Test
    public void shouldReturnFalseIfBoardHasUnfilledSpaces() {
        assertFalse(board.isFull());
    }

    @Test
    public void shouldReturnTrueIfBoardIsFull() {
        for(Integer i = 0; i < 9; i++) {
            cells[i] = "*";
        }
        assertTrue(board.isFull());
    }

    @Test
    public void shouldReturnFalseWhenWinnerIsNotDecided() {
        assertFalse(board.winnerDecided());
    }

    @Test
    public void shouldReturnTrueWhenTopRowWinIsAchieved() {
        cells[0] = "*";
        cells[1] = "*";
        cells[2] = "*";
        assertTrue(board.winnerDecided());
    }

    @Test
    public void shouldReturnTrueWhenMiddleRowWinIsAchieved() {
        cells[3] = "*";
        cells[4] = "*";
        cells[5] = "*";
        assertTrue(board.winnerDecided());
    }

    @Test
    public void shouldReturnTrueWhenBottomRowWinIsAchieved() {
        cells[6] = "*";
        cells[7] = "*";
        cells[8] = "*";
        assertTrue(board.winnerDecided());
    }



}