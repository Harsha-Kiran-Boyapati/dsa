package dsa.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitNumStringTest {

    @Test
    void numArrays() {
        assertEquals(2, new SplitNumString().numArrays("11",1000));
        assertEquals(1, new SplitNumString().numArrays("1",1000));
        assertEquals(1, new SplitNumString().numArrays("10001",1000));
        assertEquals(1, new SplitNumString().numArrays("1001",1000));
        assertEquals(2, new SplitNumString().numArrays("101",1000));
    }

    @Test
    void test2() {
        assertEquals(2, new SplitNumString().numArrays("10101",1000));
        assertEquals(3, new SplitNumString().numArrays("10101",10000));
    }

    @Test
    void test3() {
        assertEquals(2, new SplitNumString().numArrays("1100",10000));
    }
}