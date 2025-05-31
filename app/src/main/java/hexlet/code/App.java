package hexlet.code;

import hexlet.code.entities.Player;
import hexlet.code.games.GreetGame;

public class App {
    public static void main(String[] args) {
        var game = Menu.show();

        if (game == null) { return; }

        if (game instanceof GreetGame) {
            game.run(new Player());
            return;
        }

        var player = greet();
        game.run(player);
    }

    private static Player greet() {
        var game = new GreetGame();
        return game.run(new Player());
    }
}
