package hexlet.code.games;

import hexlet.code.entities.Player;

import java.util.Random;
import java.util.Scanner;

public class EvenGame implements Game {
    private static final int MAX_NUMBER = 99;
    private static final int DEFAULT_ROUNDS = 3;

    public Player run(Player player) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

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
        var number = new Random().nextInt(1, MAX_NUMBER + 1);

        return new EvenRound(
                Integer.toString(number),
                isRight(number)
        );
    }

    private String isRight(int number) {
        return isEven(number) ? "yes" : "no";
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}