import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	    TicTacToeBoardDrawer board = new TicTacToeBoardDrawer(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BoardState boardState = new BoardState();
        Game game = new Game(System.out, board, bufferedReader, boardState);
        game.start();
    }
}