package hexlet.code;

import java.security.SecureRandom;

public final class Utils {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static int getRandomNumber(int min, int max) {
        return RANDOM.nextInt(min, max + 1);
    }
}
