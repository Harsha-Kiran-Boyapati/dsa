package dsa.leetcode150.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    public void test(){
        assertTrue(new ValidPalindrome().isPalindrome("abcdcba"));
        assertTrue(new ValidPalindrome().isPalindrome(""));
        assertTrue(new ValidPalindrome().isPalindrome("a"));
        assertFalse(new ValidPalindrome().isPalindrome("ab"));
    }

}