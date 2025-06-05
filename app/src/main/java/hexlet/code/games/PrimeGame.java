package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.GameRound;
import java.security.SecureRandom;

public final class PrimeGame extends Game {
    private static final int MAX_NUMBER = 101;
    private static final int FIRST_ODD = 3;
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    protected String getGameDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    protected GameRound generateRound() {
        int number = RANDOM.nextInt(1, MAX_NUMBER + 1);
        String question = String.valueOf(number);
        String answer = isPrime(number) ? "yes" : "no";

        return new GameRound(question, answer);
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
