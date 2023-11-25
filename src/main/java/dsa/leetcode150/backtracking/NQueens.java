package dsa.leetcode150.backtracking;

import java.util.HashSet;

//hard
//https://leetcode.com/problems/n-queens-ii/?envType=study-plan-v2&envId=top-interview-150
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
//Given an integer n, return the number of distinct solutions to the n-queens puzzle.
public class NQueens {
    int count;

    public int totalNQueens(int n) {
        //each queen will be in a different i
        //number of total queens number of permutations of numbers 0 to 7;
        count = 0;
        int[] cols = new int[n];
        helper(cols ,0);
        return count;
    }
    private void helper(int[] cols, int row){
        for(int j=0; j<cols.length;j++) {
            boolean isjtaken = false;
            for(int k=0; k<row;k++) {
                if((cols[k] == j) || (cols[k]+k == row+j) || (k-cols[k] == row-j)) {
                    isjtaken = true; break;
                }
            }
            if(!isjtaken){
                cols[row] = j;
                if(row == (cols.length-1)){
                    count++;
                }
                else {
                    helper(cols, row+1);
                }
            }
        }
    }

}
