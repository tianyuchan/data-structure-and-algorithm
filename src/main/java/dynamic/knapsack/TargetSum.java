package dynamic.knapsack;

/**
 * @Classname : TargetSum
 * @Description : 494. 目标和
 * https://leetcode.cn/problems/target-sum/
 * @Author : chentianyu
 * @Date 2022/10/9 21:36
 */


public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        int diff = (sum - target);
        if (diff < 0 || diff % 2 == 1) return 0;

        // 转换为0-1背包问题，n-整数个数；w-整数值；v-表达式个数
        // dp[j]：前某个整数时，和为j的组合个数
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}
