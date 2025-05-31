package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.entities.Player;

public class GreetGame extends Game {

    @Override
    public Player run(Player player) {
        System.out.println("Welcome to the Brain Games!");
        return Cli.greet(player);
    }

    @Override
    protected boolean runRound(Object round) {
        return false;
    }

    @Override
    protected Object newRound() {
        return null;
    }

    @Override
    protected void printRules() {
    }
}
