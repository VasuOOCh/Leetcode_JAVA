import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(Arrays.toString(arr));
    }

    static int[] plusOne(int[] digits) {
        boolean allNine = true;
        for(int k =0;k< digits.length;k++) {
            if(digits[k] != 9) {
                allNine = false;
                break;
            }
        }
        if(allNine) {
            int[] ans = new int[digits.length + 1];
            ans[0] =1;
            for(int i=1;i< digits.length;i++) {
                ans[i] =0;
            }
            return ans;
        }
        for (int i = 0; i < digits.length; i++) {
            int value = digits[digits.length -1 -i] +1;
            System.out.println(value);
            digits[digits.length -1 -i] = value%10;
            if(value < 10) {
                return digits;
            }

        }

        return new int[]{-1};

    }
}
