package eoodin.p762;

public class Solution {
    public int countPrimeSetBits(int min, int max) {
        int count = 0;
        for (int i = min; i <= max; i++) {
            int n = countSetBits(i);
            if (isPrime(n)) {
                count++;
            }
        }
        return count;
    }

    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2, to = (int) Math.sqrt(n); i <= to; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
