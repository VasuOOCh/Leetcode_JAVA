package Leetocode;

import java.util.ArrayList;
import java.util.List;

public class ValidString {
    public static void main(String[] args) {
        System.out.println(validStrings(3).toString());
    }

    public static List<String> validStrings(int n) {
        return helper(n, "");
    }


    public static List<String> helper(int n , String p) {
        List<String> ans = new ArrayList<>();

        if(n == 0) {
            List<String> temp = new ArrayList<>();
            if(checker(p)) {
                temp.add(p);
                return temp;
            }
            return temp ;
        }

        p += "0";
        if(checker(p)) {
            ans.addAll(helper(n-1,p));
        }
        p = p.substring(0,p.length()-1); // backtrack
        // since we have explicitly modified p , we should revert the changes to make the 'p' same as before for the
        // below calls

        p += "1";
        if(checker(p)) {
            ans.addAll(helper(n-1,p));
        }
        //
        return ans;

    }

    public static boolean checker(String s) {
        int len = s.length();
        // Check the last two characters
        if (len >= 2 && s.charAt(len - 1) == '0' && s.charAt(len - 2) == '0') {
            return false;
        }
        return true;
    }
}
