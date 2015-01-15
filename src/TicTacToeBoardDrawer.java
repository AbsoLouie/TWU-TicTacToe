import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lperez on 1/15/15.
 */
public class TicTacToeBoardDrawer {

    private final String boardFormat =  " %s | %s | %s \n" +
                                        "-----------\n" +
                                        " %s | %s | %s \n" +
                                        "-----------\n" +
                                        " %s | %s | %s \n";
    private PrintStream printStream;

    public TicTacToeBoardDrawer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void constructBoard(String[] boardState) {
        printStream.println(String.format(boardFormat, boardState));
    }

}

