import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lperez on 1/15/15.
 */
public class Game {

    private PrintStream printStream;
    private TicTacToeBoardDrawer board;
    private BufferedReader bufferedReader;
    private BoardState boardState;

    public Game(PrintStream printStream, TicTacToeBoardDrawer board, BufferedReader bufferedReader, BoardState boardState) {
        this.printStream = printStream;
        this.board = board;
        this.bufferedReader = bufferedReader;
        this.boardState = boardState;
    }

    public void start() throws IOException {
        board.constructBoard(boardState.getState());
        processPlayer1Move();
        processPlayer2Move();
    }

    private void processPlayer1Move() throws IOException {
        printStream.println("Player 1 - Please make a move: ");
        String move = bufferedReader.readLine();
        boardState.makePlay(convertMove(move), "X");
        board.constructBoard(boardState.getState());
    }

    private void processPlayer2Move() throws IOException {
        printStream.println("Player 2 - Please make a move: ");
        String move = bufferedReader.readLine();
        boardState.makePlay(convertMove(move), "O");
        board.constructBoard(boardState.getState());
    }

    private Integer convertMove(String move) {
        return Integer.parseInt(move) - 1;
    }

}
