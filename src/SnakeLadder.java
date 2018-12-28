import java.util.*;

public class SnakeLadder {
    public static void main(String[] args) {

        //print welcome message
        System.out.println("\nWelcome to snakes and ladders game! \n");

        System.out.print("Please enter number of players \n");
        Scanner scanner = new Scanner(System.in);
        int noOfPlayers = scanner.nextInt();

        while (noOfPlayers <= 0) {
            System.out.println("Minimum number of players should be at least 1");
            noOfPlayers = scanner.nextInt();
        }
        System.out.println();

        List<Player> players = new ArrayList<>();
        for (int id = 0; id < noOfPlayers; id++) {
            Player player = new Player("p" + id);
            players.add(player);
        }

        //Creating the board
        Board board = new Board(players);

        int playerIndex = 0;
        boolean completed = false;
        boolean status;
        int completedPlayersCount = 0;
        List<Player> alreadyCompletedPlayers = new ArrayList<>(); //game completed players list
        while (!completed) {
            Player currentPlayer = players.get(playerIndex);

            if (alreadyCompletedPlayers.contains(currentPlayer))
                status = false;
            else {
                int roll = currentPlayer.getNumber();
                status = board.movePlayer(currentPlayer, roll);
            }

            //If player reaches 100 then game completed players count will be incremented
            if (status) {
                alreadyCompletedPlayers.add(currentPlayer);
                completedPlayersCount++;
                if (completedPlayersCount == noOfPlayers) {
                    completed = true;
                }
            }
            playerIndex++;
            if (playerIndex == noOfPlayers) {
                playerIndex = 0;
            }

        }

        Collections.sort(players, new ComapreNoOfTurns());

        System.out.println("\n\n\nRANKING BASED ON PLAYERS WHO TOOK LESS NUMBER OF TURNS ");
        System.out.println("Rank       Player id       Number of turns");
        int rank = 1;
        for (Player player : players) {
            System.out.println(rank + "       " + player);
            rank++;
        }

    }
}
