import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Board {
    private final int ROWS = 10;
    private final int COLS = 10;
    private final int[][] snakes = new int[8][2];
    private final int[][] ladders = new int[8][2];
    private final int NUM_SNAKES = 8;
    private final int NUM_LADDERS = 8;
    private int[][] gameBoard = new int[ROWS][COLS];
    private Map<Player, Integer> playersPositionMap = new HashMap<Player, Integer>();

    Board(List<Player> players) {
        setGameBoard(players);
        setSnakes();
        setLadders();
    }

    //Set up ROWS * COLS board
    private void setGameBoard(List<Player> players) {
        int count = 1;
        boolean flag = true;
        for (int i = 0; i < ROWS; i++) {

            if (flag) {
                for (int j = 0; j < COLS; j++) {
                    gameBoard[i][j] = count++;
                    flag = false;
                }
            }
            else {
                for (int j = COLS-1; j >= 0; j--) {
                    gameBoard[i][j] = count++;
                    flag = true;
                }
            }
        }

        //Setting players initial position
        for (Player player : players) {
            playersPositionMap.put(player, 0);
        }
    }

    private void setSnakes() {
        snakes[0][0] = 17;
        snakes[0][1] = 7;
        snakes[1][0] = 54;
        snakes[1][1] = 34;
        snakes[2][0] = 62;
        snakes[2][1] = 19;
        snakes[3][0] = 64;
        snakes[3][1] = 60;
        snakes[4][0] = 87;
        snakes[4][1] = 24;
        snakes[5][0] = 93;
        snakes[5][1] = 73;
        snakes[6][0] = 95;
        snakes[6][1] = 75;
        snakes[7][0] = 99;
        snakes[7][1] = 78;
    }

    private void setLadders() {
        ladders[0][0] = 4;
        ladders[0][1] = 14;
        ladders[1][0] = 9;
        ladders[1][1] = 31;
        ladders[2][0] = 20;
        ladders[2][1] = 38;
        ladders[3][0] = 28;
        ladders[3][1] = 84;
        ladders[4][0] = 40;
        ladders[4][1] = 59;
        ladders[5][0] = 51;
        ladders[5][1] = 67;
        ladders[6][0] = 63;
        ladders[6][1] = 81;
        ladders[7][0] = 71;
        ladders[7][1] = 91;
    }

    boolean movePlayer(Player player,  int randomNumber) {
        int position = playersPositionMap.get(player);
        position += randomNumber;
        //If position value is 100 or above then player completed his game
        if (position >= 100) {
            position = 100;
            playersPositionMap.put(player, position);
            System.out.println("=================");
            System.out.println("player id - " + player.getName() + ", " + "no of turns = " + player.numberOfTurns + ", random number = " + randomNumber + ", total score is = " + position);
            System.out.println("=================");
            return true;
        }
        else {
            //Checking if the new position is head of the snake then position will be moved to tail of the snake
            for (int id = 0; id < NUM_SNAKES; id++) {
                if (snakes[id][0] == position) {
                    position = snakes[id][1];
                    playersPositionMap.put(player, position);
                    System.out.println("player id - " + player.getName() + ", " + "no of turns = " + player.numberOfTurns + ", random number = " + randomNumber + ", total score is = " + position);
                    return false;
                }
            }

            //Check if the new position is starting point of ladder then position will be moved to end part of the ladder
            for (int id = 0; id < NUM_LADDERS; id++) {
                if (ladders[id][0] == position) {
                    position = ladders[id][1];
                    playersPositionMap.put(player, position);
                    System.out.println("player id - " + player.getName() + ", " + "no of turns = " + player.numberOfTurns + ", random number = " + randomNumber + ", total score is = " + position);
                    return false;
                }
            }

            //If player is not on snake or ladder, then update is posiotn value normally
            playersPositionMap.put(player, position);
            System.out.println("player id - " + player.getName() + ", " + "no of turns = " + player.numberOfTurns + ", random number = " + randomNumber + ", total score is = " + position);
            return false;

        }

    }
}
