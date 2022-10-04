package dynamic.basic1d;

/**
 * @Classname : MaximumSubarray
 * @Description : 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 * @Author : chentianyu
 * @Date 2022/10/4 22:08
 */


public class MaximumSubarray {
    public int maxSubArray2(int[] nums) {
        int n = nums.length, max = -10000;
        // dp[i]：以第i个数字结尾最大连续子数组的和
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i - 1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 空间压缩
    public int maxSubArray(int[] nums) {
        int n = nums.length, max = -10000, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = Math.max(0, sum) + nums[i - 1];
            max = Math.max(max, sum);
        }
        return max;
    }
}
