public class NKnights {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        knights(board,0,0,4);
    }

    static void knights(boolean[][] board,int r,int c,int knights){
        if(knights == 0) {
            display(board);
            System.out.println();
        }

        if(c == board.length && r == board.length-1) { //final out of bound condition
            return;
        }

        if(c == board.length) { //col is out of bound
            knights(board,r+1,0,knights);
        }



        if(isSafe(board,r,c)) {
            board[r][c] = true;
            knights(board,r,c + 1,knights-1);
            board[r][c] = false;
        }
        knights(board,r,c + 1,knights); // when not safe, just inc the col no. !
    }

    static boolean isSafe(boolean[][] board, int r, int c) {
            if(isValid(board,r-2,c-1)) {
                if(board[r-2][c-1]) return false;
            }
        if(isValid(board,r-2,c+1)) {
            if(board[r-2][c+1]) return false;
        }
        if(isValid(board,r-1,c-2)) {
            if(board[r-1][c-2]) return false;
        }
        if(isValid(board,r-1,c-2)) {
            if(board[r-1][c-2]) return false;
        }
        return true;

    }

    static boolean isValid(boolean[][] board, int r,int c) {
        if(r >= 0 && r < board.length && c>=0 && c< board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == true) {
                    System.out.print("K ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
