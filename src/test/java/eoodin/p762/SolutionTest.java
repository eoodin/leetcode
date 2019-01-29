package eoodin.p762;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void examplesTest() {
        Solution solution = new Solution();
        assertEquals(4, solution.countPrimeSetBits(6, 10));
        assertEquals(5, solution.countPrimeSetBits(10, 15));
    }

    @Test
    @Ignore
    public void testPrime() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        Solution solution = new Solution();
        for (int i = 1; i < 30; i++) {
            System.out.println("Testing " + i);
            assertEquals(primes.contains(i), solution.isPrime(i));
        }
    }
}
