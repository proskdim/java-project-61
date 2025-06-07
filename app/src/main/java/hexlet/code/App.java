package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String MENU_TEXT = """
            Please enter the game number and press Enter.
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            5 - Progression
            6 - Prime
            0 - Exit""";

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        System.out.println(MENU_TEXT);
        String choice = SCANNER.nextLine();

        switch (choice) {
            case "1" -> {
                System.out.println("Your choice: 1\n");
                Cli.greet();
            }
            case "2" -> {
                System.out.println("Your choice: 2\n");
                new EvenGame().start();
            }
            case "3" -> {
                System.out.println("Your choice: 3\n");
                new CalcGame().start();
            }
            case "4" -> {
                System.out.println("Your choice: 4\n");
                new GCDGame().start();
            }
            case "5" -> {
                System.out.println("Your choice: 5\n");
                new ProgressionGame().start();
            }
            case "6" -> {
                System.out.println("Your choice: 6\n");
                new PrimeGame().start();
            }
            case "0" -> {
                System.out.println("Goodbye!");
            }
            default -> {
                System.out.println("Invalid choice: '" + choice + "'. Please enter a number from 0 to 6. Goodbye!");
            }
        }
    }
}
