public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    static boolean isPalindrome(int n) {
      int revNum = reverse(n);
      return  n == revNum;
    }

    static int reverse(int n) {
        if(n == n%10){
            return n;
        }
        return Integer.parseInt(String.valueOf(n%10) + reverse(n/10));
    }
}
