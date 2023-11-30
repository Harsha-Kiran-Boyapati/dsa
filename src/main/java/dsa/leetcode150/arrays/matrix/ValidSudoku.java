package dsa.leetcode150.arrays.matrix;
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        //check if rows are valid
        //check if a digit from 0 to 9 already exists in the row
        for(int i = 0; i<9; i++){
            boolean[] exists = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')continue;
                if(exists[board[i][j]-'1']) return false;
                else exists[board[i][j]-'1'] = true;
            }
        }

        //check if cols are valid
        //check if a digit from 0 to 9 already exists in the col

        for(int j = 0; j<9; j++){
            boolean[] exists = new boolean[9];
            for(int i=0; i<9; i++){
                if(board[i][j] == '.')continue;
                if(exists[board[i][j]-'1']) return false;
                else exists[board[i][j]-'1'] = true;
            }
        }

        //check grids
        for(int i=0; i<9; i=i+3){
            for(int j=0; j<9; j=j+3){
                //i,j are the start positions of all the 9 grids
                boolean[] exists = new boolean[9];
                for(int x =0; x<=2; x++){
                    for(int y=0; y<=2; y++){
                        if(board[i+x][j+y] == '.') continue;
                        if(exists[board[i+x][j+y]-'1']) return false;
                        else exists[board[i+x][j+y]-'1'] = true;
                    }
                }

            }
        }

        return true;
    }
}