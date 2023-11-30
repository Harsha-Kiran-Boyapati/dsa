package dsa.leetcode150.arrays.matrix;

import java.util.LinkedList;
import java.util.List;

public class SudokuSolver {
    private char[][] charBoard;
    private int[][] intBoard = new int[9][9];

    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] grids = new boolean[9][10];

    private LinkedList<int[]> stack = new LinkedList<>();
    public void solveSudoku(char[][] board) {
        this.charBoard = board;
        fillIntBoard();
        populateColsRowsGrids();
        solve();
        fillCharBoard();
    }

    private void solve(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                //if the current cell is already filled don't need to do anything
                if(intBoard[i][j] != 0) continue;
                boolean isValid = false;
                for(int k=1; k<=9; k++){
                     isValid = verify(i, j, k);
                    if(isValid) {
                        setVal(i, j, k);
                        stack.addLast(new int[]{i, j});
                        break;
                    }
                    // if no val is found
                    //if k==9 and stack is empty then board is not solvable;
                    if(k==9){
                        int[] pair = stack.removeLast();
                        i=pair[0]; j=pair[1]; k = intBoard[i][j];
                        unSetVal(i, j);
                        while(k==9){
                            pair = stack.removeLast();
                            i=pair[0]; j=pair[1]; k = intBoard[i][j];
                            unSetVal(i, j);
                        }

                    }
                }

            }
        }

    }

    private void setVal(int i, int j, int val){
        intBoard[i][j] = val;
        rows[i][val] = true;
        cols[j][val] = true;
        grids[gridIdx(i, j)][val] = true;
    }

    //should not be called on cells with val equal to zero
    private void unSetVal(int i, int j){
        int val = intBoard[i][j];
        rows[i][val] = false;
        cols[j][val] = false;
        grids[gridIdx(i, j)][val] = false;
        intBoard[i][j] = 0;
    }

    //set a value at i and j and verify
    private boolean verify(int i, int j, int val){
        return !(rows[i][val] == true || cols[j][val] == true || grids[gridIdx(i, j)][val] == true);
    }

    public int gridIdx(int i, int j){
        return 3*(i/3)+(j/3);
    }
    private void fillCharBoard(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                charBoard[i][j] = intBoard[i][j] == 0 ? '.' : (char)('0'+intBoard[i][j]);
            }
        }
    }

    private void fillIntBoard(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                intBoard[i][j] = charBoard[i][j] == '.' ? 0 : charBoard[i][j]-'0';
            }
        }
    }

    private void populateColsRowsGrids(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                rows[i][intBoard[i][j]] = true;
                cols[j][intBoard[i][j]] = true;
                grids[gridIdx(i,j)][intBoard[i][j]] = true;
            }
        }
    }

    private boolean isSolved(){
        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                if (intBoard[i][j] == 0) return false;
            }
        }
        return true;
    }
}
