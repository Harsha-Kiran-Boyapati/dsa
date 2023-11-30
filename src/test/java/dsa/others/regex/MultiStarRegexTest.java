package dsa.others.regex;

import dsa.others.regex.MultiStarRegex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiStarRegexTest {

    @Test
    void match() {
        assertTrue(MultiStarRegex.match("", ""));
        assertTrue(MultiStarRegex.match("", "*"));
        assertTrue(MultiStarRegex.match("ab", "*"));
        assertTrue(MultiStarRegex.match("ab", "*b"));
        assertTrue(MultiStarRegex.match("ab", "*b*"));
        assertTrue(MultiStarRegex.match("ab", "*b**"));
        assertTrue(MultiStarRegex.match("ab", "ab**"));

        assertFalse(MultiStarRegex.match("a", ""));
        assertFalse(MultiStarRegex.match("a", "*b"));
        assertFalse(MultiStarRegex.match("a", "b"));
        assertFalse(MultiStarRegex.match("a", "ab"));
        assertFalse(MultiStarRegex.match("a", "b*"));

    };

    @Test
    void falingTest(){
        assertTrue(MultiStarRegex.match("ab", "*b*"));
    }
}