public class VaildSukoku {
    public static void main(String[] args) {
        char[][] sudokuBoard = {
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
        System.out.println(isValidSudoku(sudokuBoard));
    }

    static boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) { //row wise
            for (int c = 0; c < 9; c++) { //column wise
                if(board[r][c] != '.') {
                    if(!isValid(board,r,c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    static boolean isValid(char[][] board, int row, int col) {
        // Check if 'num' is not already present in the current row, column, and sub-box
        for (int i = 0; i < 9; i++) {
            if (i != row && board[row][i] == board[row][col]) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i!= col && board[i][col] == board[row][col]) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if ((3 * (row / 3) + i / 3) != row && (3 * (col / 3) + i % 3) != col && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == board[row][col]) {
                return false;
            }
        }

        return true;
    }

}
