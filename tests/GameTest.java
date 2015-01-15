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
    private TicTacToeBoardDrawer board;
    private BoardState boardState;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(TicTacToeBoardDrawer.class);
        boardState = mock(BoardState.class);
        bufferedReader = mock(BufferedReader.class);
        game = new Game(printStream, board, bufferedReader, boardState);
    }

    @Test
    public void shouldPassOnPlayerOneMoveToBoardState() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        game.start();
        verify(boardState).makePlay(0, "X");
    }

    @Test
    public void shouldPassOnPlayerTwoMoveToBoardState() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
        game.start();
        verify(boardState).makePlay(1, "O");
    }

    @Test
    public void shouldPassOnBoardStateAfterMoveIsMade() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        game.start();
        verify(board, times(3)).constructBoard(boardState.getState());
    }

//    @Test
//    public void shouldPromptUserForMoveIfInvalidOneIsSelected() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("2");
//        game.start();
//        verify(printStream).println("Invalid Move!");
//    }

}