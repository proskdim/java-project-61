package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Utils;

public final class CalcGame extends Game {
    private static final int MAX_NUMBER = 49;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    @Override
    protected String getGameDescription() {
        return "What is the result of the expression?";
    }

    @Override
    protected String[] generateRound() {
        int num1 = Utils.getRandomNumber(1, MAX_NUMBER);
        int num2 = Utils.getRandomNumber(1, MAX_NUMBER);
        String operation = OPERATIONS[Utils.getRandomNumber(0, OPERATIONS.length - 1)];

        String question = String.format("%d %s %d", num1, operation, num2);
        String answer = String.valueOf(calculate(num1, num2, operation));

        return new String[]{question, answer};
    }

    private int calculate(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
}
