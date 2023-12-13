package syntax;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {
    @Test
    void generateRandomInt() {
        Random random = new Random();
        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100, 200));
        System.out.println(random.ints().limit(5).sum());
        System.out.println(random.ints(100).limit(5).sum());
        System.out.println(random.ints(10, 10, 20).sum());
    }
}
