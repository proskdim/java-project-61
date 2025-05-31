package hexlet.code.games;

import hexlet.code.entities.Player;

public abstract class Game {
    private static final int DEFAULT_ROUNDS = 3;

    public Player run(Player player) {
        printRules();

        for (var round = 0; round < DEFAULT_ROUNDS; round++) {
            var gameRound = newRound();
            var isPlayerWin = runRound(gameRound);

            if (!isPlayerWin) {
                System.out.printf("Let's try again, %s!\n", player.getName());
                return player;
            }
        }

        System.out.printf("Congratulations, %s!\n", player.getName());

        return player;
    }

    protected abstract boolean runRound(Object round);
    protected abstract Object newRound();
    protected abstract void printRules();
}
