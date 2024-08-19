package Leetocode;

import OOPS4.A;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaining(16));;
    }

    public static int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        return helper(list,true);

    }

    static int helper(List<Integer> list, boolean start) {
        List<Integer> tempList = new ArrayList<>();

        if(list.size() == 1) {
//            System.out.println("final ans is ");
//            System.out.println(list.toString());
            return list.getFirst();
        }

        if(start) {
            for (int i = 0; i < list.size(); i = i + 2) { // i is the index, i + 1 is the current value
                if(i+1 < list.size()) {
                    tempList.add(list.get(i+1));
                }
            }
//            System.out.println(tempList.toString());
            return helper(tempList, false);

        }else {
            for (int i = list.size()-1; i >= 0; i = i-2) {
                if(!(i-1 < 0)) {
                    tempList.addFirst(list.get(i-1));
                }
            }
//            System.out.println(tempList.toString());
            return helper(tempList, true);
        }


    }
}
