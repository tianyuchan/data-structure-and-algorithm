package dynamic.knapsack;

/**
 * @Classname : PartitionEqualSubsetSum
 * @Description : 416. 分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * @Author : chentianyu
 * @Date 2022/9/29 23:10
 */


public class PartitionEqualSubsetSum {
    public boolean canPartition2(int[] nums) {
        int sum = 0, N = nums.length;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        // 和为奇数，不可能等分
        if (sum % 2 == 1) return false;

        // 转化为0-1背包问题：N个物品，物品i的体积为num[i]，背包容量为W，判断能否挑选物品使得背包装满
        int W = sum / 2;
        boolean[][] dp = new boolean[N + 1][W + 1];
        for (int i = 0; i <= N; i++) dp[i][0] = true;

        for (int i = 1; i <= N; i++) {
            int w = nums[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - w];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            if (dp[i][W]) return true;
        }
        return dp[N][W];
    }

    // 空间优化
    public boolean canPartition(int[] nums) {
        int sum = 0, N = nums.length;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        // 和为奇数，不可能等分
        if (sum % 2 == 1) return false;

        // 转化为0-1背包问题：N个物品，物品i的体积为num[i]，背包容量为W，判断能否挑选物品使得背包装满
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;

        for (int i = 1; i <= N; i++) {
            int w = nums[i - 1];
            for (int j = W; j >= w; j--) {
                dp[j] = dp[j] || dp[j - w];
            }
            if (dp[W]) return true;
        }
        return dp[W];
    }
}
