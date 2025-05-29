package hexlet.code.games;

public class EvenRound {
    private final String task;
    private final String rightAnswer;

    EvenRound(String taskValue, String rightAnswerValue) {
        this.task = taskValue;
        this.rightAnswer = rightAnswerValue;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getTask() {
        return task;
    }
}