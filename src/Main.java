import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	    Board board = new Board(System.out, new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "});
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player player1 = new Player("1", "X", board, System.out, bufferedReader);
        Player player2 = new Player("2", "O", board, System.out, bufferedReader);
        Game game = new Game(System.out, board, player1, player2);
        game.start();
    }
}