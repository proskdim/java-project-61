package hexlet.code.games;

import hexlet.code.entities.Player;

import java.util.Random;
import java.util.Scanner;

public class CalcGame implements Game {

    private static final int MAX_NUMBER = 49;

    private static final int DEFAULT_ROUNDS = 3;

    public Player run(Player player) {
        System.out.println("What is the result of the expression?");

        for (var round = 0; round < DEFAULT_ROUNDS; round++) {
            var gameRound = newRound();
            var isPlayerWin = runRound(gameRound);

            if (!isPlayerWin) {
                System.out.printf("Let's try again, %s!\n", player.getName());
                return player;
            }
        }

        System.out.printf("Congratulations, %s!\n", player.getName());
        return player;
    }

    private boolean runRound(EvenRound round) {
        var question = "Question: %s".formatted(round.getTask());
        System.out.println(question);

        var playerAnswer = new Scanner(System.in).nextLine();
        var rightAnswer = round.getRightAnswer();

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