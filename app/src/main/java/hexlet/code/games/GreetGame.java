package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.entities.Player;

public class GreetGame implements Game {
    public Player run(Player player) {
        printWelcome();
        return Cli.greet(player);
    }

    private void printWelcome() {
        System.out.println("Welcome to the Brain Games!");
    }
}
