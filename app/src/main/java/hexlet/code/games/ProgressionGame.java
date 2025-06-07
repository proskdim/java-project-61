package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Utils;

public final class ProgressionGame extends Game {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MAX_START = 10;
    private static final int MAX_STEP = 10;
    private static final String HIDDEN_ELEMENT = "..";

    @Override
    protected String getGameDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    protected String[] generateRound() {
        int start = Utils.getRandomNumber(1, MAX_START);
        int step = Utils.getRandomNumber(1, MAX_STEP);
        int hiddenIndex = Utils.getRandomNumber(0, PROGRESSION_LENGTH - 1);

        String[] progression = new String[PROGRESSION_LENGTH];
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            progression[i] = String.valueOf(start + i * step);
        }

        String answer = progression[hiddenIndex];
        progression[hiddenIndex] = HIDDEN_ELEMENT;

        String question = String.join(" ", progression);

        return new String[]{question, answer};
    }
}
