package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.GameRound;
import java.security.SecureRandom;

public final class GCDGame extends Game {
    private static final int MAX_NUMBER = 10;
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    protected String getGameDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    protected GameRound generateRound() {
        int num1 = generateNumber();
        int num2 = generateNumber();

        String question = String.format("%d %d", num1, num2);
        String answer = String.valueOf(gcd(num1, num2));

        return new GameRound(question, answer);
    }

    private int generateNumber() {
        int multiplier = RANDOM.nextInt(1, MAX_NUMBER + 1);
        int factor = RANDOM.nextInt(1, MAX_NUMBER + 1);
        return multiplier * factor;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
