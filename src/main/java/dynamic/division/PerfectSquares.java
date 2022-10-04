package dynamic.division;

import java.util.Arrays;

/**
 * @Classname : PerfectSquares
 * @Description : 279. 完全平方数
 * https://leetcode.cn/problems/perfect-squares/
 * @Author : chentianyu
 * @Date 2022/9/25 22:46
 */


public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}
