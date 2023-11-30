package syntax.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMaxTest {
    @Test
    void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(10, new FindMax().concurrentMax(nums));
    }
}