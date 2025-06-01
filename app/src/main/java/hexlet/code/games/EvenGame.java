package hexlet.code.games;

import java.security.SecureRandom;

public class EvenGame extends Game {
    private static final int MAX_NUMBER = 99;

    @Override
    public GameRound newRound() {
        var number = new SecureRandom().nextInt(1, MAX_NUMBER + 1);

        return new GameRound(
                Integer.toString(number),
                isRight(number)
        );
    }

    @Override
    protected void printRules() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private String isRight(int number) {
        return isEven(number) ? "yes" : "no";
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
