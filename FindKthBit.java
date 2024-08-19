public class FindKthBit {
    public static void main(String[] args) {
        System.out.println(bit(7, 3));
    }

    private static int bit(int num, int target) {
        int mask = 1 << target -1;
        return (num & mask);
    }
}
