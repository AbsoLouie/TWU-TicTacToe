import org.junit.Test;

import static org.junit.Assert.*;

public class BoardStateTest {

    @Test
    public void shouldChangeBoardStateWhenPlayIsMade() {
        BoardState boardState = new BoardState();
        boardState.makePlay(1, "X");
        String[] expectedState = new String[]{" ", "X", " ", " ", " ", " ", " ", " ", " "};
        assertArrayEquals(expectedState, boardState.getState());
    }

    @Test
    public void shouldReturnTrueIfMoveIsValid() {
        BoardState boardState = new BoardState();
        boardState.makePlay(1, "X");
        assertTrue(boardState.validMove(2));
    }

    @Test
    public void shouldReturnFalseIfMoveIsInvalid() {
        BoardState boardState = new BoardState();
        boardState.makePlay(1, "X");
        assertFalse(boardState.validMove(1));
    }

}