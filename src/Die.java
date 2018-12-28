import java.util.Random;

class Die {
    private Random random;
    Die() {
        random = new Random();
    }
    int getRandomNumber() {
        return random.nextInt(6) + 1;
    }
}
