package hexlet.code;

public final class GameRound {
    private final String question;
    private final String answer;

    public GameRound(String questionText, String answerText) {
        this.question = questionText;
        this.answer = answerText;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
