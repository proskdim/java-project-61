package hexlet.code;

import hexlet.code.entities.Player;
import hexlet.code.games.GreetGame;

public class Engine {
    public static void start() {
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
        return new GreetGame().run(new Player());
    }
}