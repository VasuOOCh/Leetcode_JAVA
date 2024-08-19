public class CountOpr {
    public static void main(String[] args) {
//        System.out.println(countOperations(10,10));
        System.out.println(countOprWithHelper(10,0));
    }

    static int countOperations(int num1, int num2) {
        // return value represents count !
        if(num1 == num2)  {
            return 1;
        }
        return 1 + (num1 > num2 ? countOperations(num1-num2, num2) : countOperations(num1, num2-num1));
    }

    static int countOprWithHelper(int num1,int num2) {
        if(num1*num2 == 0) {
            return 0;
        }
        return helper(num1,num2,0);
    }

    static int helper(int num1,int num2, int count) {
        if(num1 == num2) {
            return count + 1;
        }
        if(num1 > num2) {
            return helper(num1-num2,num2,count + 1);
        }else{
            return helper(num1,num2-num1,count + 1);
        }
    }
}
