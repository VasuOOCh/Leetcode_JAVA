package Leetocode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4,2,new ArrayList<>(), 0).toString());
    }

    public static List<List<Integer>> combine(int n, int k, List<Integer> ans, int index) {

        List<List<Integer>> ansList = new ArrayList<>();

        if(ans.size() == k ) {
//            System.out.println(ans);
            List<List<Integer>> temp = new ArrayList<>();
//            System.out.println(ans.toString());
            temp.add(new ArrayList<>(ans));
            return temp;
        }

        for (int i = index; i < n; i++) {
            ans.add(i+1);
            ansList.addAll(combine(n,k,ans,index + 1 + i));
//            index++;
            ans.removeLast(); // removing the last value for welcoming the next value;
        }

        return ansList;
    }
}
