package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Utils;

public final class EvenGame extends Game {
    private static final int MAX_NUMBER = 99;

    @Override
    protected String getGameDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    protected String[] generateRound() {
        int number = Utils.getRandomNumber(1, MAX_NUMBER);
        String question = String.valueOf(number);
        String answer = isEven(number) ? "yes" : "no";

        return new String[]{question, answer};
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
