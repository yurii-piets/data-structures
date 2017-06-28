package collections.list.array.allinplace;

import collections.list.List;

import java.util.Random;

public class ArrayListTestHelper {
    public static int randomInt(){
        Random random = new Random();
        return random.nextInt();
    }

    public static String randomString(){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < 25; ++i) {
            char c = (char) (random.nextInt(92) + 33);
            builder.append(c);
        }

        return builder.toString();
    }

}
