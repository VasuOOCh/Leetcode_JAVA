public class FancyString {
    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
    }

    static String makeFancyString(String s) {
//       return helper(s,0);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if(i == 0 || i == s.length() - 1 || s.charAt(i) != s.charAt(i-1) || s.charAt(i) != s.charAt(i+1)) {
                ans.append(s.charAt(i));
            }
            i++;
        }
        return ans.toString();
    }

    static String helper(String s,int i) {
        //base condition
        if(i == s.length()) {
            return "";
        }

        if(i == 0 || i == s.length()-1) {
            return String.valueOf(s.charAt(i)) + helper(s,i+1);
        }

        if((s.charAt(i) != s.charAt(i-1)) || (s.charAt(i) != s.charAt(i+1))) {
            return String.valueOf(s.charAt(i)) + helper(s,i+1);
        }else{
            return helper(s,i+1);
        }
    }
}
