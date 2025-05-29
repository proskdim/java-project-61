package hexlet.code;

import hexlet.code.entities.Player;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;
import hexlet.code.games.GreetGame;

import java.util.Scanner;

public class App {
    public static final String CHOICES = """
            1 - Greet
            2 - Even
            0 - Exit\
            """;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        var choice = choice();

        if (choice.equals("0")) {
            return;
        }

        var game = selectGame(choice);
        var greetGame = new GreetGame();
        var player = new Player();

        if (game == null) {
            return;
        }

        System.out.printf("Your choice: %s\n\n", choice);

        if (choice.equals("1")) {
            greetGame.run(player);
            return;
        }

        var gamer = greetGame.run(player);
        game.run(gamer);
    }

    private static Game selectGame(String choice) {
        return switch (choice) {
            case "1" -> new GreetGame();
            case "2" -> new EvenGame();
            default ->  null;
        };
    }

    private static String choice() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(CHOICES);
        return new Scanner(System.in).nextLine();
    }
}
