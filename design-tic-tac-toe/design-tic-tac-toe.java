class TicTacToe {
    int[][] matrix;
    public TicTacToe(int n) {
        matrix = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = -1;
            }
        }
    }
    public int move(int row, int col, int player) {
        if(isOccupied(row, col)) {
            return -1;
        }
        matrix[row][col] = player;
        if(isWin(row, col, player) == true) return player;
        return 0;
    }
    
    public boolean isOccupied(int row, int col) {
        if(matrix[row][col] != -1) return true;
        return false;
    }

    public boolean isWin(int row, int col, int player) {
        //1. horizontal
        boolean find = true;
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][col] != player) {
                find=false;
                break;
            }
        }
        if(find == true) return true;
        
        //2. vertical
        find = true;
        for(int i=0; i<matrix.length; i++) {
            if(matrix[row][i] != player) {
                find=false;
                break;
            }
        }
        if(find == true) return true;
        
        //3. diagonal -> left->right (if row==col)
        if(row == col) {
            find = true;
            for(int i=0; i<matrix.length; i++) {
                if(matrix[i][i] != player) {
                    find=false;
                    break;
                }
            }
            if(find == true) return true;
        }
        
        //4. diagonal -> right->left (if col+row==matrix.length-1)
        if(row + col == matrix.length -1) {
            find = true;
            for(int i=0; i<matrix.length; i++) {
                 if(matrix[i][matrix.length - 1 - i] != player) {
                    find=false;
                    break;
                }
            }
            if(find == true) return true;
        }

        return false;
    }
}