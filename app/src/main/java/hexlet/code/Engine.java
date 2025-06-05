package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private static final int ROUNDS_COUNT = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String CORRECT_MESSAGE = "Correct!";
    private static final String WRONG_ANSWER_FORMAT =
            "'%s' is wrong answer ;(. Correct answer was '%s'%n";
    private static final String CONGRATULATIONS_FORMAT = "Congratulations, %s!%n";
    private static final String TRY_AGAIN_FORMAT = "Let's try again, %s!%n";

    public static void play(String gameDescription, String[][] questionsAndAnswers) {
        String playerName = greetPlayer();

        System.out.println(gameDescription);

        for (int round = 0; round < ROUNDS_COUNT; round++) {
            String question = questionsAndAnswers[round][0];
            String correctAnswer = questionsAndAnswers[round][1];

            if (!playRound(question, correctAnswer)) {
                System.out.printf(TRY_AGAIN_FORMAT, playerName);
                return;
            }
        }

        System.out.printf(CONGRATULATIONS_FORMAT, playerName);
    }

    public static void greetOnly() {
        greetPlayer();
    }

    private static String greetPlayer() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String name = SCANNER.nextLine();
        System.out.println("Hello, " + name + "!");

        return name;
    }

    private static boolean playRound(String question, String correctAnswer) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");

        String playerAnswer = SCANNER.nextLine().trim();

        if (playerAnswer.equals(correctAnswer)) {
            System.out.println(CORRECT_MESSAGE);
            return true;
        } else {
            System.out.printf(WRONG_ANSWER_FORMAT, playerAnswer, correctAnswer);
            return false;
        }
    }
}
