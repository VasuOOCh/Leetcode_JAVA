package Leetocode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombiantionSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{10,1,2,7,6,1,5}, 8).toString());

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> finalAns = new ArrayList<>();
        helper(0,candidates, target, new ArrayList<>() ,0, finalAns);
        return finalAns;
    }

    public static boolean helper(int sum, int[] candidates, int target, List<Integer> ans, int i, List<List<Integer>> finalAns) {

        // "i" is the current index
        // sum is current sum, sum <= target

        //base
        if(sum == target) {
            boolean ok = true;
            for (int j = 0; j < finalAns.size(); j++) {
                if(finalAns.get(j).equals(ans)) {
                    ok = false;
                }
            }
            if(ok) {
                finalAns.add(new ArrayList<>(ans));
            }
        }

        for (int j = i; j < candidates.length; j++) {
            if(sum + candidates[j] <= target) { //checker if it fits
                ans.add(candidates[j]);
                if(helper(sum + candidates[j] ,candidates,target, ans, j+1, finalAns)) {
                    return true;
                } else {
                    ans.removeLast(); // backtracking
                }
            }
        }
        return false; // if the whole loop runs and no one  fits, then return false

    }
}
