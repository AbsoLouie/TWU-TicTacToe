/**
 * Created by lperez on 1/15/15.
 */
public class BoardState {

    private String[] state = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

    public String[] getState() {
        return state;
    }

    public void makePlay(int location, String piecePlayed) {
            state[location] = piecePlayed;
    }

    public boolean validMove(int location) {
        if (state[location] == " ") {
            return true;
        } else {
            return false;
        }
    }
}
