package dynamic.knapsack;

/**
 * @Classname : CoinChange
 * @Description : 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 * @Author : chentianyu
 * @Date 2022/10/1 22:15
 */


public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int N = coins.length, W = amount;
        // dp[i][j] 表示可使用i个硬币时，凑成金额j所需要的最少硬币个数（维度i被空间压缩）
        int[] dp = new int[W + 1];
        // 由于获取最少硬币数，需要将除0位置外的其他位置初始化为至大值
        for (int i = 1; i <= W; i++) {
            dp[i] = Integer.MAX_VALUE / 2;
        }

        for (int i = 1; i <= N; i++) {
            // 背包问题抽象：体积w——金额，价值v——硬币个数
            int w = coins[i - 1], v = 1;
            for (int j = w; j <= W; j++) {
                dp[j] = Math.min(dp[j], dp[j - w] + v);
            }
        }
        // 考虑逆向情况
        return dp[W] > 10000 ? -1 : dp[W];
    }
}
