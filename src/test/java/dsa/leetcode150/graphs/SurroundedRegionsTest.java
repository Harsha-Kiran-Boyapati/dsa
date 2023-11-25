package dsa.leetcode150.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegionsTest {

    @Test
    void solve() {
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        char[][] expected = new char[][]{
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','O','X','X'}
        };
        new SurroundedRegions().solve(board);
        for(int i=0; i<board.length; i++){
            assertArrayEquals(expected[i], board[i]);
        }
    }
}