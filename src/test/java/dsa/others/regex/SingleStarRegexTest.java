package dsa.others.regex;

import dsa.others.regex.SingleStarRegex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleStarRegexTest {

    @Test
    public void testMatch(){
        assertTrue(SingleStarRegex.match("", ""));
        assertTrue(SingleStarRegex.match("ab", "ab"));
        assertTrue(SingleStarRegex.match("abc", "*"));
        assertTrue(SingleStarRegex.match("", "*"));

        assertFalse(SingleStarRegex.match("a", ""));
        assertFalse(SingleStarRegex.match("a", "*b"));
        assertFalse(SingleStarRegex.match("ba", "*b"));
        assertFalse(SingleStarRegex.match("ba", "b"));
    }

    @Test
    public void failingTest(){
        assertFalse(SingleStarRegex.match("a", "*b"));
    }

}