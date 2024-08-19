public class TruncateSentence {
    public static void main(String[] args) {
        System.out.println(truncateSentence("What is the solution to this problem", 4));
    }
    static String truncateSentence(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                count++;
            }
//            if(count == k-1) {
//                int endVal =
//                return s.substring(0,i);
//            }
        }
        return "";

    }
}
