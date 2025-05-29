package hexlet.code;

import java.util.Scanner;

import hexlet.code.entities.Player;

public class Cli {
    public static Player greet(Player p) {
        System.out.print("May I have your name? ");
        Scanner s = new Scanner(System.in);

        p.setName(s.next());
        printHello(p.getName());

        return p;
    }

    private static void printHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
