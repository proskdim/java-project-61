package hexlet.code;

public abstract class Game {
    public final void start() {
        String description = getGameDescription();
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.play(description, questionsAndAnswers);
    }

    private String[][] generateQuestionsAndAnswers() {
        String[][] questions = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            String[] round = generateRound();
            questions[i][0] = round[0];
            questions[i][1] = round[1];
        }

        return questions;
    }

    protected abstract String getGameDescription();
    protected abstract String[] generateRound();
}
