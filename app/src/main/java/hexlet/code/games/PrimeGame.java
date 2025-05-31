package hexlet.code.games;

import java.util.Random;

public class PrimeGame extends Game {
    private static final int MAX_NUMBER = 101;

    @Override
    protected Object newRound() {
        var rand = new Random();

        var number = rand.nextInt(1, MAX_NUMBER + 1);
        var task = String.valueOf(number);

        return new GameRound(task, prepareAnswer(number));
    }

    @Override
    protected void printRules() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    private String prepareAnswer(int number) {
        return isPrime(number) ? "yes" : "no";
    }

    public static boolean isPrime(int number) {
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

        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
