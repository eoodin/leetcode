package eoodin.p007;

public class ReverseInteger {
    private static final int MIN = Integer.MIN_VALUE / 10;
    private static final int MIN_S = Integer.MIN_VALUE % 10;
    private static final int MAX = Integer.MAX_VALUE / 10;
    private static final int MAX_S  = Integer.MAX_VALUE % 10;

    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int s = x % 10;
            if(x > -10 && x < 0 && (reversed < MIN || (reversed == MIN && x < MIN_S))) {
                return 0;
            }
            else if (x < 10 && x > 0 && (reversed > MAX || (reversed == MAX && x > MAX_S))) {
                return 0;
            }

            reversed = reversed * 10 + s;
            x = x / 10;
        }

        return reversed;
    }
}
