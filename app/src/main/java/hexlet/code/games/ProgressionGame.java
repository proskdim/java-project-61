package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.GameRound;
import java.security.SecureRandom;
import java.util.StringJoiner;

public final class ProgressionGame extends Game {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MAX_START = 10;
    private static final int MAX_STEP = 10;
    private static final String HIDDEN_ELEMENT = "..";

    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    protected String getGameDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    protected GameRound generateRound() {
        int start = RANDOM.nextInt(1, MAX_START + 1);
        int step = RANDOM.nextInt(1, MAX_STEP + 1);
        int hiddenIndex = RANDOM.nextInt(PROGRESSION_LENGTH);

        int[] progression = generateProgression(start, step);
        String question = createQuestionString(progression, hiddenIndex);
        String answer = String.valueOf(progression[hiddenIndex]);

        return new GameRound(question, answer);
    }

    private int[] generateProgression(int start, int step) {
        int[] progression = new int[PROGRESSION_LENGTH];
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

    private String createQuestionString(int[] progression, int hiddenIndex) {
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                joiner.add(HIDDEN_ELEMENT);
            } else {
                joiner.add(String.valueOf(progression[i]));
            }
        }
        return joiner.toString();
    }
}
