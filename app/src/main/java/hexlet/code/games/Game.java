package hexlet.code.games;

import hexlet.code.entities.Player;

import java.util.Scanner;

public abstract class Game {
    private static final int DEFAULT_ROUNDS = 3;

    public Player run(Player player) {
        printRules();

        for (var round = 0; round < DEFAULT_ROUNDS; round++) {
            var gameRound = newRound();
            var isWin = runRound(gameRound);

            if (!isWin) {
                player.setWon(false);
                return player;
            }
        }

        player.setWon(true);
        return player;
    }


    protected boolean runRound(Object round) {
        var gameRound = (GameRound) round;

        System.out.printf("Question: %s%n", gameRound.getTask());

        var playerAnswer  = new Scanner(System.in).nextLine();
        var correctAnswer = gameRound.getRightAnswer();

        if (playerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf(
                    "'%s' is wrong answer ;(. Correct answer was '%s'\n",
                    playerAnswer,
                    correctAnswer
            );
            return false;
        }
    }

    protected abstract Object newRound();
    protected abstract void printRules();
}
