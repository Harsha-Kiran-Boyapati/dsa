package dsa.leetcode150.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstSubStringTest {
    @Test
    public void test(){
        assertEquals(0, new FindFirstSubString().strStr("haystack", "hay"));
        assertEquals(2, new FindFirstSubString().strStr("haystack", "yst"));
        assertEquals(-1, new FindFirstSubString().strStr("haystack", "needle"));
    }

}