package dsa.leetcode150.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInAStringTest {

    @Test
    public void shouldTrimStartAndEndAndIntermediateSpaces(){
        String word = "  hello  world   Harsha  ";
        String res = new ReverseWordsInAString().reverseWords(word);
        assertTrue(res.equals("Harsha world hello"));
    }

}