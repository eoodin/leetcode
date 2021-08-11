package eoodin.lintcode;

import java.util.ArrayList;
import java.util.List;

public class P1915 {


    public int weightCapacity(int[] weights, int maxCapacity) {
        boolean[] dp = new boolean[maxCapacity + 1];
        dp[0] = true;
        int answer = 0;

        for (int weight : weights) {
            for (int j = maxCapacity; j >= weight; j--) {
                if (dp[j - weight]) {
                    dp[j] = true;
                    answer = Math.max(answer, j);
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        List<Object> numList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numList.add(String.valueOf(i));
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
