import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lperez on 1/15/15.
 */
public class Board {

    private PrintStream printStream;
    private String[] boardState = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
    private final String boardFormat =  " %s | %s | %s \n" +
                                        "-----------\n" +
                                        " %s | %s | %s \n" +
                                        "-----------\n" +
                                        " %s | %s | %s \n";

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printBoard() {
        printStream.println(String.format(boardFormat, boardState));
    }

    public void placePiece(int cellNumber, String gameSymbol) {
        boardState[cellNumber] = gameSymbol;
    }

    public boolean validateMove(int cellNumber) {
        if (boardState[cellNumber] == " ") {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        if (boardIsFilled()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean boardIsFilled() {
        return !Arrays.asList(boardState).contains(" ");
    }
}

