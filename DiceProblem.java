public class DiceProblem {
    public static void main(String[] args) {
        dice(0,8);
    }

    static void dice(int p, int un) {
        if(un == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i<=un; i++) {
            dice( Integer.parseInt(p + String.valueOf(i)) ,un-i);
        }
    }
}
