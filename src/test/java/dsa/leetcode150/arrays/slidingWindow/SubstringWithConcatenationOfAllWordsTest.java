package dsa.leetcode150.arrays.slidingWindow;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubstringWithConcatenationOfAllWordsTest {
    @Test
    void test() {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> output = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        assertArrayEquals(new int[]{0,9}, output.stream().mapToInt(x -> x).toArray());
    }
}