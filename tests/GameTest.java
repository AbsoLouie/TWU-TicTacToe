import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Board board;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(printStream, board, player1, player2);
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        when(board.winnerDecided()).thenReturn(false);
    }

    @Test
    public void shouldPromptPlayer1ToPlay() throws IOException {
        game.start();
        verify(player1, atLeastOnce()).promptToPlay();
    }

    @Test
    public void shouldPromptPlayer2ToPlay() throws IOException {
        game.start();
        verify(player2, atLeastOnce()).promptToPlay();
    }

    @Test
    public void shouldEndGameInADrawIfBoardIsFilled() throws IOException {
        game.start();
        verify(printStream).println("Game is a draw.");
    }

    @Test
    public void shouldLoopUntilGameIsOver() throws IOException {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        when(board.winnerDecided()).thenReturn(false);
        game.start();
        verify(player1, atLeast(2)).promptToPlay();
    }

    @Test
    public void shouldCheckForWinAfterEveryMove() throws IOException {
        game.start();
        verify(board, atLeastOnce()).winnerDecided();
    }

    @Test
    public void shouldAnnounceWhenWinnerIsDecided() throws IOException {
        when(board.winnerDecided()).thenReturn(true);
        game.start();
        verify(player1).winMessage();
    }

    @Test
    public void shouldNotAnnounceWhenWinnerIsNotDecided() throws IOException {
        game.start();
        verify(printStream).println("Game is a draw.");
    }

}