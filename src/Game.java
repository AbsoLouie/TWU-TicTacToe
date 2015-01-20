import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lperez on 1/15/15.
 */
public class Game {

    private PrintStream printStream;
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player waitingPlayer;
    private String endGameMessage;

    public Game(PrintStream printStream, Board board, Player player1, Player player2) {
        this.printStream = printStream;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = this.player1;
        this.waitingPlayer = this.player2;
    }

    public void start() throws IOException {
        board.printBoard();
        do {
            currentPlayerTakesTurn();
        } while (gameIsActive());
        printStream.println(endGameMessage);
    }

    private boolean gameIsActive() {
        if (board.winnerDecided()) {
            endGameMessage = currentPlayer.winMessage();
            return false;
        } else if (board.isFull()) {
            endGameMessage = "Game is a draw.";
            return false;
        } else {
            changeCurrentPlayer();
            return true;
        }
    }

    // separate gameIsActive and changeCurrentPlayer and setting the endGameMessage.

    private void currentPlayerTakesTurn() throws IOException {
        currentPlayer.promptToPlay();

        board.printBoard();
    }

    private void changeCurrentPlayer() {
        Player temp = currentPlayer;
        currentPlayer = waitingPlayer;
        waitingPlayer = temp;
    }
}
