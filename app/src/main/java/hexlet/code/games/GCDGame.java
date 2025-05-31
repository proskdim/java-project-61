package hexlet.code.games;

import java.util.Random;

public class GCDGame extends Game {
    private static final int MAX_NUMBER = 10;

    @Override
    protected void printRules() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    public GameRound newRound() {
        var num1 = generateNumber();
        var num2 = generateNumber();

        var task = "%d %d".formatted(num1, num2);
        var correctAnswer = Integer.toString(gcd(num1, num2));

        return new GameRound(task, correctAnswer);
    }

    private static int generateNumber() {
        var random = new Random();
        var gcdProtector = random.nextInt(1, MAX_NUMBER + 1);
        return gcdProtector * random.nextInt(1, MAX_NUMBER + 1);
    }

    private static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
}
