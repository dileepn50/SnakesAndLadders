

class Player {
    private String name;
    private Die die = new Die();
    int numberOfTurns = 0;

    Player(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    int getNumber() {
        int randomNumber = die.getRandomNumber();
        this.numberOfTurns++;
        return randomNumber;

    }

    public String toString() {
        return "\t" + this.name + "\t\t\t\t" +this.numberOfTurns;
    }
}
