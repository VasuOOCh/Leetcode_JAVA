package Leetocode;

public class CountAndSay {
    public static void main(String[] args) {
//        System.out.println(helper("22343342233", "",0));
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String ans = "1";
        for (int i = 1; i <4 ; i++) {
            ans = helper(ans, "1", 1,1);
        }
        return ans;
    }

    public static String helper(String nums, String p, int index, int count) { // index = 0 init.
        // count will be 1 init.
        //base :
        if(index == nums.length()) {
            return p + nums.charAt(nums.length() -1);
        }

//        if ( index > 0) {
            if(nums.charAt(index) == nums.charAt(index - 1)) {
                count++;
//                String tempSum = Integer.parseInt(p.charAt(p.length() -1) + "") + 1 + "";
                return helper(nums,p.substring(0,p.length() -1) + count, index + 1,count);
            }else {
                return helper(nums, p + nums.charAt(index -1) + "1", index +1,1);
            }
//        }
//        return helper(nums, p + "1", index +1 );


    }
}
