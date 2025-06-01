package hexlet.code.games;

import java.security.SecureRandom;

public class Operations {
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MULTIPLY = 2;

    private static final String[] SYMBOLS = {"+", "-", "*"};

    public static int calculate(int operation, int num1, int num2) {
        return switch (operation) {
            case PLUS -> num1 + num2;
            case MINUS -> num1 - num2;
            case MULTIPLY -> num1 * num2;
            default -> 0;
        };
    }

    public static int randOperation() {
        var random = new SecureRandom();
        return random.nextInt(3);
    }

    public static String getSymbol(int operation) {
        if (operation >= 0 && operation < SYMBOLS.length) {
            return SYMBOLS[operation];
        }
        return "?";
    }
}
