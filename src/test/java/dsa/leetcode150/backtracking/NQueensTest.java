package dsa.leetcode150.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueensTest {

    @Test
    void test() {
        assertEquals(2, new NQueens().totalNQueens(4));
    }
}