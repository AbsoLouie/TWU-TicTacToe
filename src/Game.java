import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lperez on 1/15/15.
 */
public class Game {

    private PrintStream printStream;
    private Board board;
    private BufferedReader bufferedReader;
    private Player player1;
    private Player player2;

    public Game(PrintStream printStream, Board board, BufferedReader bufferedReader, Player player1, Player player2) {
        this.printStream = printStream;
        this.board = board;
        this.bufferedReader = bufferedReader;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() throws IOException {
        board.printBoard();
        while (!board.isGameOver()) {
            player1.promptToPlay();
            board.printBoard();
            if (board.isGameOver()) {break;}
            player2.promptToPlay();
            board.printBoard();
        }
        printStream.println("The Game Is Over!");
    }

}
