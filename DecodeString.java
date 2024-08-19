package Leetocode;

public class DecodeString {
    public static void main(String[] args) {
//        System.out.println();
        helper("220[ab]12[c]", "");
    }
//    public static String decodeString(String s) {
//
//    }

    public static String helper(String s,String p) {
        int num =0;
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < s.length(); i++) {
            boolean yes = false;

            for (int j = 0; j < nums.length; j++) {
                if((s.charAt(i) + "").equals(nums[j] + "")) {
                    yes = true;
                    break;
                }
            }
            if(yes) {
                num = Integer.parseInt(num + "" + s.charAt(i));
//                System.out.println(num);

            }else {
                // when the character is not a number :-
                for (int j = 0; j < num; j++) {
//                    p +=
                }
                System.out.println(num);
                num = 0;
            }

        }

        return "ok";
    }
}
