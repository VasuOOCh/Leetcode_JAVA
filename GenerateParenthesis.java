package Leetocode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1).toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ansList = new ArrayList<>();
        return helper("(", n-1,n, ansList);
    }

    public static List<String> helper(String ans, int l ,int r, List<String> ansList) {
        // ans : "("


        //Base condition
        if(l == 0 && r == 0) {
            ansList.add(ans);
        }

        //restriction condition
        if(r < l) {
            List<String> temp = new ArrayList<>();
            return temp;
        }

        if( l > 0) {
            helper(ans + "(",l-1,r ,ansList);
        }
        if(r > 0) {
            helper(ans + ")",l,r-1,ansList);
        }

        return ansList;

    }
}
