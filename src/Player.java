import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lperez on 1/17/15.
 */
public class Player {
    private String playerName;
    private String playerSymbol;
    private Board board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Player(String playerName, String playerSymbol, Board board, PrintStream printStream, BufferedReader bufferedReader) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void promptToPlay() throws IOException {
        printStream.println("Player " + playerName + " please make a move: ");
        Integer cellNumber = convertMove(bufferedReader.readLine());
        if (board.validateMove(cellNumber)) {
            board.placePiece(cellNumber, playerSymbol);
        } else {
            printStream.println("Location already taken");
            promptToPlay();
        }
    }

    private Integer convertMove(String move) {
        return Integer.parseInt(move) - 1;
    }
}
