package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.GameRound;
import java.security.SecureRandom;

public final class CalcGame extends Game {
    private static final int MAX_NUMBER = 49;
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    protected String getGameDescription() {
        return "What is the result of the expression?";
    }

    @Override
    protected GameRound generateRound() {
        int num1 = RANDOM.nextInt(1, MAX_NUMBER + 1);
        int num2 = RANDOM.nextInt(1, MAX_NUMBER + 1);
        Operation operation = Operation.getRandom();

        String question = String.format("%d %s %d", num1, operation.getSymbol(), num2);
        String answer = String.valueOf(operation.calculate(num1, num2));

        return new GameRound(question, answer);
    }

    private enum Operation {
        PLUS("+") {
            @Override
            int calculate(int a, int b) {
                return a + b;
            }
        },
        MINUS("-") {
            @Override
            int calculate(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY("*") {
            @Override
            int calculate(int a, int b) {
                return a * b;
            }
        };

        private final String operatorSymbol;
        private static final SecureRandom RANDOM = new SecureRandom();

        Operation(String operatorSymbol) {
            this.operatorSymbol = operatorSymbol;
        }

        public String getSymbol() {
            return operatorSymbol;
        }

        abstract int calculate(int a, int b);

        public static Operation getRandom() {
            Operation[] operations = values();
            return operations[RANDOM.nextInt(operations.length)];
        }
    }
}
