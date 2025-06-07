package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Utils;

public final class PrimeGame extends Game {
    private static final int MAX_NUMBER = 101;
    private static final int FIRST_ODD = 3;

    @Override
    protected String getGameDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    protected String[] generateRound() {
        int number = Utils.getRandomNumber(1, MAX_NUMBER);
        String question = String.valueOf(number);
        String answer = isPrime(number) ? "yes" : "no";

        return new String[]{question, answer};
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);
        for (int i = FIRST_ODD; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
