import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class PlayerTest {
    private Board board;
    private Player player1;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player1 = new Player("1", "X", board, printStream, bufferedReader);
        player2 = new Player("2", "O", board, printStream, bufferedReader);
    }

    @Test
    public void shouldPromptPlayer1ToMakeAMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.validateMove(0)).thenReturn(true);
        player1.promptToPlay();
        verify(printStream).println("Player 1 please make a move: ");
    }

    @Test
    public void shouldPlacePlayer1PieceOnBoard() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.validateMove(0)).thenReturn(true);
        player1.promptToPlay();
        verify(board).placePiece(0, "X");
    }

    @Test
    public void shouldPromptPlayer2ToMakeAMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.validateMove(0)).thenReturn(true);
        player2.promptToPlay();
        verify(printStream).println("Player 2 please make a move: ");
    }

    @Test
    public void shouldPlacePlayer2PieceOnBoard() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.validateMove(0)).thenReturn(true);
        player2.promptToPlay();
        verify(board).placePiece(0, "O");
    }

    @Test
    public void shouldPromptPlayerForAnotherMoveIfMoveIsIllegal() throws IOException {
        when(board.validateMove(0)).thenReturn(false).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("1");
        player1.promptToPlay();
        verify(printStream).println("Location already taken");
        verify(printStream, times(2)).println("Player 1 please make a move: ");
    }
}