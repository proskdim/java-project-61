package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class EvenGame extends Game {
    private static final int MAX_NUMBER = 99;

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
    public EvenRound newRound() {
        var number = new Random().nextInt(1, MAX_NUMBER + 1);

        return new EvenRound(
                Integer.toString(number),
                isRight(number)
        );
    }

    @Override
    protected void printRules() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private String isRight(int number) {
        return isEven(number) ? "yes" : "no";
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
