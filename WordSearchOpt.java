package LeetcodeContinued;

public class WordSearchOpt {
    public static void main(String[] args) {
        char[][] board ={
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board,"SEE"));
    }
    public static boolean exist(char[][] board, String word) {
        return helper(board, word,0);
    }

    public static boolean helper(char[][] board, String word,int index) {

        // we will go through each character :

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // board[i][j] -> single char.
                if(board[i][j] == word.charAt(index)) {
//                    p = p + board[i][j];
                    board[i][j] = '.'; // marking that index, to never visit it again
                    if(helper2(board,word,index+1, i, j)){
//                        System.out.println(true);
                        return true;
                    }
                    board[i][j] = word.charAt(index); // backtracking
//                    p = p.substring(0, p.length()- 1);

                }
            }
        }
        return false;
    }

    public static boolean helper2(char[][] board, String word,int index, int r,int c) {

        if(index == word.length()) {
//            System.out.println(p);
            return true;
        }

        // checking top
        if(r-1 >= 0 && board[r-1][c] == word.charAt(index)) {
//            p = p + board[r-1][c];
            board[r-1][c] = '.';
            if(helper2(board, word,index+1,r-1,c)) {
                return true;
            }
//            p = p.substring(0, p.length()- 1);
            board[r-1][c] = word.charAt(index); // backtracking


        }

        // checking bottom
        if(r+1 < board.length && board[r+1][c] == word.charAt(index)) {
//            p = p + board[r+1][c];
            board[r+1][c] = '.';
            if(helper2(board, word,index+1,r+1,c)) {
                return true;
            }
//            p = p.substring(0, p.length()- 1);
            board[r+1][c] = word.charAt(index); // backtracking
        }

        // checking left
        if(c-1 >= 0 && board[r][c-1] == word.charAt(index)) {
//            p = p + board[r][c-1];
            board[r][c-1] = '.';
            if(helper2(board, word,index + 1,r,c-1)) {
                return true;
            }
//            p = p.substring(0, p.length()- 1);
            board[r][c-1] = word.charAt(index); // backtracking
        }

        // checking right
        if(c+1 < board[0].length && board[r][c+1] == word.charAt(index)) {
//            p = p + board[r][c+1];
            board[r][c+1] = '.';
            if(helper2(board, word,index+1,r,c+1)) {
                return true;
            }
//            p = p.substring(0, p.length()- 1);
            board[r][c+1] = word.charAt(index); // backtracking
        }

        return false;
    }
}
