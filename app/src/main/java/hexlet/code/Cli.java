package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greet() {
        System.out.print("May I have your name? ");
        Scanner s = new Scanner(System.in);
        System.out.println("Hello, " + s.next());
    }
}
