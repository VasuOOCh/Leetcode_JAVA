package Leetocode;

import OOPS4.A;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(9,278621));
    }
    public static String getPermutation(int n, int k) {
        List<String> ans = new ArrayList<>();

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(i+1);
        }


        helper("",str.toString(), ans);
        Collections.sort(ans);
        System.out.println(ans);
        return ans.get(k-1);
    }


//    public static String helper(int n, int k) {
//        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            helper2((i + 1) + "", builder(n, i+1), (i+1 + "").charAt(0), ans);
//        }
//        System.out.println(ans);
//        return ans.get(k-1);
//    }
//
//    public static String builder(int n, int e) {
//        StringBuilder ans = new StringBuilder();
//        //e is the number to be excluded
//        for (int i = 0; i < n; i++) {
//            if((i+1) != e) {
//                ans.append(i+1);
//            }
//        }
//        return ans.toString();
//    }

//    public static void helper2(String p, String un, char m, List<String> ans) {
//
//        if(un.isEmpty()) {
//            ans.add(p);
//            return;
//        }
//
//        for (int i = 0; i <= p.length(); i++) {
//            String temp = p.substring(0,p.length() - i) + un.charAt(0) + p.substring(p.length() - i);
//            if(temp.charAt(0) == m ) {
//                helper2(temp, un.substring(1), m, ans);
//            }
//
//        }
//
//
//
//        }

    public static void helper(String p, String un, List<String> ans) {

        if(un.isEmpty()) {
            ans.add(p);
            return;
        }

        for (int i = 0; i <= p.length(); i++) {
            String temp = p.substring(0,p.length() - i) + un.charAt(0) + p.substring(p.length() - i);
                helper(temp, un.substring(1),ans);
        }
    }

}
