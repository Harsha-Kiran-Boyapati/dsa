package dsa.leetcode150.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextJustificationTest {

    @Test
    public void test1(){
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> expected = List.of(
                "This    is    an",
                "example  of text",
                "justification.  "
        );
        assertEquals(expected, new TextJustification().fullJustify(words, 16));
    }

    @Test
    public void test2(){
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        List<String> expected = List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "
        );
        assertEquals(expected, new TextJustification().fullJustify(words, 16));
    }

    @Test
    public void test3(){
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> expected = List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        );
        assertEquals(expected, new TextJustification().fullJustify(words, 16));
    }

}