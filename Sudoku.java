public class Sudoku {
    public static void main(String[] args) {
        char[][] board  =  {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }

    static boolean solveSudoku(char[][] board) {

        //iterating through each cell
        for (int r = 0; r < 9; r++) { //row wise
            for (int c = 0; c < 9; c++) { //column wise
                if(board[r][c] == '.') {
                    for (char num = '1'; num <= '9' ; num++) {
                        if(isValid(board,r,c,num)) { //checking validation
                            board[r][c] = num; //putting the value

                            // now move forward from that cell. So call the solveSudoku again

                            if(solveSudoku(board)) {
                                return true;
                            }

                            //undo when the solveSudoku returns false
                            board[r][c] = '.';
                        }
                    }

                    return false; //no valid number found
                }
            }
        }

        // when all the cells are iterated and filled
        display(board);
        return true;

    }

    static boolean isValid(char[][] board, int row, int col, char num) {
        // Check if 'num' is not already present in the current row, column, and sub-box
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }

        return true;
    }


    private static void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " +  board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
