import java.util.Comparator;

public class ComapreNoOfTurns implements Comparator<Player> {
    @Override
    public int  compare(Player firstPlayer, Player secondPlayer) {
        return Integer.compare(firstPlayer.numberOfTurns, secondPlayer.numberOfTurns);
    }
}
