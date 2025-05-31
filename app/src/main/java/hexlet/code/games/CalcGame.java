package hexlet.code.games;

import java.util.Random;

public class CalcGame extends Game {

    private static final int MAX_NUMBER = 49;

    @Override
    protected void printRules() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    public GameRound newRound() {
        var random = new Random();

        var cm = Operations.randOperation();

        var num1 = random.nextInt(1, MAX_NUMBER + 1);
        var num2 = random.nextInt(1, MAX_NUMBER + 1);

        var task = "%d %s %d".formatted(num1, Operations.getSymbol(cm), num2);

        var result = Operations.calculate(cm, num1, num2);

        var rightAnswer = Integer.toString(result);

        return new GameRound(task, rightAnswer);
    }
}
