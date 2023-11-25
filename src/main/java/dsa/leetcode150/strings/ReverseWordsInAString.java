package dsa.leetcode150.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> words = Arrays.asList(s.split(" ")).stream().filter(Predicate.not(String::isBlank)).collect(Collectors.toList());
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
