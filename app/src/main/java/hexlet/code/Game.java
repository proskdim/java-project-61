package hexlet.code;

public abstract class Game {
    private static final int QUESTIONS_COUNT = 3;

    public final void start() {
        String description = getGameDescription();
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.play(description, questionsAndAnswers);
    }

    private String[][] generateQuestionsAndAnswers() {
        String[][] questions = new String[QUESTIONS_COUNT][2];

        for (int i = 0; i < QUESTIONS_COUNT; i++) {
            GameRound round = generateRound();
            questions[i][0] = round.getQuestion();
            questions[i][1] = round.getAnswer();
        }

        return questions;
    }

    protected abstract String getGameDescription();
    protected abstract GameRound generateRound();
}
