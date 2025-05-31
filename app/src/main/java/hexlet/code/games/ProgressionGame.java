package hexlet.code.games;

import java.util.Random;
import java.util.StringJoiner;

public class ProgressionGame extends Game {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MAX_START = 10;
    private static final int MAX_STEP = 10;

    @Override
    protected GameRound newRound() {
        var random = new Random();

        var start = random.nextInt(1, MAX_START + 1);
        var step = random.nextInt(1, MAX_STEP + 1);
        var hiddenIdx = random.nextInt(PROGRESSION_LENGTH);

        var progression = makeProgression(start, step);
        var correctAnswer = String.valueOf(progression[hiddenIdx]);

        return new GameRound(prepareTask(progression, hiddenIdx), correctAnswer);
    }

    private static int[] makeProgression(int start, int step) {
        var progression = new int[PROGRESSION_LENGTH];

        for (var i = 0; i < progression.length; i++) {
            progression[i] = start + i * step;
        }

        return progression;
    }

    private String prepareTask(int[] progression, int hiddenIdx) {
        var task = new StringJoiner(" ");

        for (int i = 0; i < progression.length; i++) {
            task.add(i == hiddenIdx ? ".." : String.valueOf(progression[i]));
        }

        return task.toString();
    }

    @Override
    protected void printRules() {
        System.out.println("What number is missing in the progression?");
    }
}
