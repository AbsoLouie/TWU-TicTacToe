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
        game = new Game(printStream, board, bufferedReader, player1, player2);
    }

    @Test
    public void shouldPromptPlayer1ToPlay() throws IOException {
        when(board.isGameOver()).thenReturn(false).thenReturn(true);
        game.start();
        verify(player1).promptToPlay();
    }

    @Test
    public void shouldPromptPlayer2ToPlay() throws IOException {
        when(board.isGameOver()).thenReturn(false).thenReturn(false).thenReturn(true);
        game.start();
        verify(player2).promptToPlay();
    }

    @Test
    public void shouldEndGameIfBoardIsFilled() throws IOException {
        when(board.isGameOver()).thenReturn(true);
        game.start();
        verify(printStream).println("The Game Is Over!");
    }

    @Test
    public void shouldLoopUntilGameIsOver() throws IOException {
        for (Integer i = 1; i < 10; i++) {
            when(bufferedReader.readLine()).thenReturn(Integer.toString(i));
            if (i < 9 ) {
                when(board.isGameOver()).thenReturn(false);
            } else {
                when(board.isGameOver()).thenReturn(true);
            }
        }
        game.start();
        verify(printStream).println("The Game Is Over!");
    }

}