package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.GameRound;
import java.security.SecureRandom;

public final class EvenGame extends Game {
    private static final int MAX_NUMBER = 99;
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    protected String getGameDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    protected GameRound generateRound() {
        int number = RANDOM.nextInt(1, MAX_NUMBER + 1);
        String question = String.valueOf(number);
        String answer = isEven(number) ? "yes" : "no";

        return new GameRound(question, answer);
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
