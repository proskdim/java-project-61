package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;
import hexlet.code.games.GreetGame;

import java.util.Scanner;

public class Menu {
    public static final String GAMES = """
            1 - Greet
            2 - Even
            3 - Calc
            0 - Exit\
            """;

    public static Game show() {
        var choice = choiceGame();

        if (choice.equals("0")) { return null; }

        var game = selectGame(choice);

        if (game == null) { return null; }

        System.out.printf("Your choice: %s\n\n", choice);

        return game;
    }

    private static Game selectGame(String choice) {
        return switch (choice) {
            case "1" -> new GreetGame();
            case "2" -> new EvenGame();
            case "3" -> new CalcGame();
            default ->  null;
        };
    }

    private static String choiceGame() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GAMES);
        return new Scanner(System.in).nextLine();
    }
}