package LeetcodeContinued;

import java.util.ArrayList;
import java.util.List;

public class IPAddresses {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135").toString());
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper("", s,0, ans);
        return ans;
    }

    public static void helper(String p, String un, int count, List<String> ans) {
        // initially count is 0
        // we will inc count if a dot is added
        // when count is 3 , i.e. 3 dots have been placed

        // we will put the dot three times :
        // 1) after a single digit
        // 2) after a double-digit
        // 3) after a triple digit

        //restriction :
        if(un.isEmpty()) {
            return;
        }

        // more restrictions :
        if(un.length() > 12) {
            return;
        }

        //base condition :
        if(count == 3) {
//            System.out.println(p + un);
            if(un.length() > 3) {
                return;
            }
            if(checker(un)) {
//                System.out.println(p +  un);
                ans.add(p+un);
                return;
            }
            return;
        }

        if(un.length() < 1) {
            return;
        }
        String s1 = un.substring(0,1);
//        System.out.println("S1 is " + s1);
        if(!checker(s1)) {
            return;
        }
        helper(p+ s1 + ".", un.substring(1), count + 1,ans);

        if(un.length() < 2) {
            return;
        }
        String s2 = un.substring(0,2);
//        System.out.println("S2 is " + s2);
        if(!checker(s2)) {
            return;
        }
        helper(p+ s2 + ".", un.substring(2), count + 1,ans);

        if(un.length() < 3) {
            return;
        }
        String s3 = un.substring(0,3);
//        System.out.println("S3 is " + s3);
        if(!checker(s3)) {
            return;
        }
        helper(p + s3 + ".", un.substring(3), count + 1,ans);


    }

    public static boolean checker(String s) {
        // basic checking system
        if(Integer.parseInt(s) < 0 || Integer.parseInt(s)>255) {
            return false;
        }
        if(s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        return true;
    }
}
