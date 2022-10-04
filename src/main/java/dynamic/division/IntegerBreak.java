package dynamic.division;

/**
 * @Classname : IntegerBreak
 * @Description : 343. 整数拆分
 * https://leetcode.cn/problems/integer-break/
 * @Author : chentianyu
 * @Date 2022/10/4 22:30
 */


public class IntegerBreak {
    // 动态规划
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 当 j > i / 2 后，会重复计算
            for (int j = 1; j <= i / 2; j++) {
                // 若 i - j > dp[i - j]，则不进行拆分
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    // 贪心算法
    public int integerBreak(int n) {
        if (n < 3) return 1;
        else if (n == 3) return 2;

        if (n % 3 == 0) return (int) Math.pow(3, n / 3);
        else if (n % 3 == 1) return (int) Math.pow(3, n / 3 - 1) * 4;
        else return (int) Math.pow(3, n / 3) * 2;
    }
}
