import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by lperez on 1/15/15.
 */
public class Board {

    private PrintStream printStream;
    private String[] cells;
    private final String boardFormat =  " %s | %s | %s \n" +
                                        "-----------\n" +
                                        " %s | %s | %s \n" +
                                        "-----------\n" +
                                        " %s | %s | %s \n";

    public Board(PrintStream printStream, String[] cells) {
        this.printStream = printStream;
        this.cells = cells;
    }

    public void printBoard() {
        printStream.println(String.format(boardFormat, cells));
    }

    public void placePiece(int cellNumber, String gameSymbol) {
        cells[cellNumber] = gameSymbol;
    }

    public boolean isCellEmpty(int cellNumber) {
        return cells[cellNumber] == " ";
    }

    public boolean isFull() {
        return !Arrays.asList(cells).contains(" ");
    }

    public boolean winnerDecided() {
        if (aBoolean()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean aBoolean() {
        return (!isCellEmpty(0) && cells[0] == cells[1] && cells[1] == cells[2] ||
                !isCellEmpty(3) && cells[3] == cells[4] && cells[4] == cells[5] ||
                !isCellEmpty(6) && cells[6] == cells[7] && cells[7] == cells[8]);
    }


}

