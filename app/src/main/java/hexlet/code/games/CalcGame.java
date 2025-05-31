package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class CalcGame extends Game {

    private static final int MAX_NUMBER = 49;

    @Override
    protected boolean runRound(Object round) {
        var evenRound = (EvenRound) round;
        var question = "Question: %s".formatted(evenRound.getTask());

        System.out.println(question);

        var playerAnswer = new Scanner(System.in).nextLine();
        var rightAnswer = evenRound.getRightAnswer();

        if (playerAnswer.equals(rightAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf(
                    "'%s' is wrong answer ;(. Correct answer was '%s'\n",
                    playerAnswer,
                    rightAnswer
            );
            return false;
        }
    }

    @Override
    protected void printRules() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    public EvenRound newRound() {
        var random = new Random();

        var cm = Operations.randOperation();

        var num1 = random.nextInt(1, MAX_NUMBER + 1);
        var num2 = random.nextInt(1, MAX_NUMBER + 1);

        var task = "%d %s %d".formatted(num1, Operations.getSymbol(cm), num2);

        var result = Operations.calculate(cm, num1, num2);

        var rightAnswer = Integer.toString(result);

        return new EvenRound(task, rightAnswer);
    }
}