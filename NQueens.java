import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println(helper(board,0));
    }

    public static List<List<String>> helper(boolean[][] board,int r) {
        List<List<String>> ans = new ArrayList<>();

        if(r == board.length) { // base condition is => overflow condition
            List<List<String>> a = new ArrayList<>();
            List<String> add = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if(board[i][j]) {
                        s.append("Q");
                    }else {
                        s.append(".");
                    }
                }
                add.add(s.toString());
            }
            a.add(add);
            return a;
        }

        //placing the queen and checking for every row and column
        for (int c = 0; c < board.length; c++) {
            if(isSafe(board,r,c)){
                board[r][c] = true; // setting the position true
                ans.addAll(helper(board, r+1));
                board[r][c] = false; // cleaning up the true value
            }
        }

        return ans;
    }

    static int queens(boolean[][] board,int r) {
        int count = 0;
        if(r == board.length) { // base condition is => overflow condition
            display(board);
            System.out.println();
            return 1;
        }

        //placing the queen and checking for every row and column
        for (int c = 0; c < board.length; c++) {
            if(isSafe(board,r,c)){
                board[r][c] = true; // setting the position true
                count += queens(board, r+1);
                board[r][c] = false; // cleaning up the true value
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int r, int c) {
        for (int i = r-1; i >=0 ; i--) {
            if(board[i][c]) {
                return false;
            }

        }

        for (int i = r-1,j=c-1; i >= 0 && j >=0 ;) {
            if(board[i][j]) {
                return false;
            }

            i--;j--;
        }

        for (int i = r-1,j=c+1; i >= 0 && j < board.length ;) {
            if(board[i][j]) {
                return false;
            }
            i--;j++;
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == true) {
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
