package dsa.leetcode150.arrays.matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {

    @Test
    void gridIdxTest() {
        SudokuSolver solver = new SudokuSolver();
        assertEquals(0, solver.gridIdx(2,2));
        assertEquals(4, solver.gridIdx(5,5));
        assertEquals(8, solver.gridIdx(8,8));
    }

    @Test
    void solve() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] expected = {
                {'5','3','4','6','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},
                {'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},
                {'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},
                {'3','4','5','2','8','6','1','7','9'}
        };

        new SudokuSolver().solveSudoku(board);

        for(int i=0; i<9; i++){
            assertArrayEquals(expected[i], board[i], i + " failed");
        }

    }

    @Test
    void test2() {
        char[][] board = {
                {'.','.','.','2','.','.','.','6','3'},
                {'3','.','.','.','.','5','4','.','1'},
                {'.','.','1','.','.','3','9','8','.'},
                {'.','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','3','8','.','.','.'},
                {'.','3','.','.','.','.','.','.','.'},
                {'.','2','6','3','.','.','5','.','.'},
                {'5','.','3','7','.','.','.','.','8'},
                {'4','7','.','.','.','1','.','.','.'}
        };

        char[][] expected = {
                {'8','5','4','2','1','9','7','6','3'},
                {'3','9','7','8','6','5','4','2','1'},
                {'2','6','1','4','7','3','9','8','5'},
                {'7','8','5','1','2','6','3','9','4'},
                {'6','4','9','5','3','8','1','7','2'},
                {'1','3','2','9','4','7','8','5','6'},
                {'9','2','6','3','8','4','5','1','7'},
                {'5','1','3','7','9','2','6','4','8'},
                {'4','7','8','6','5','1','2','3','9'}
        };

        new SudokuSolver().solveSudoku(board);

        Arrays.stream(board).forEach((x) -> System.out.println(Arrays.toString(x)));

        for(int i=0; i<9; i++){
            assertArrayEquals(expected[i], board[i], i + " failed");
        }

    }
}