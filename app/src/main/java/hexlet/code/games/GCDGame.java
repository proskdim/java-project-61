package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Utils;

public final class GCDGame extends Game {
    private static final int MAX_NUMBER = 10;

    @Override
    protected String getGameDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    protected String[] generateRound() {
        int num1 = generateNumber();
        int num2 = generateNumber();

        String question = String.format("%d %d", num1, num2);
        String answer = String.valueOf(gcd(num1, num2));

        return new String[]{question, answer};
    }

    private int generateNumber() {
        int multiplier = Utils.getRandomNumber(1, MAX_NUMBER);
        int factor = Utils.getRandomNumber(1, MAX_NUMBER);
        return multiplier * factor;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
