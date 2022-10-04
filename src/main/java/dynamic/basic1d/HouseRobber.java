package dynamic.basic1d;

/**
 * @Classname : HouseRobber
 * @Description : 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/
 * @Author : chentianyu
 * @Date 2022/9/22 23:10
 */


public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    // 空间压缩
    public int rob2(int[] nums) {
        int n = nums.length;
        int pre2 = 0, pre1 = nums[0], ans = nums[0];
        for (int i = 2; i <= n; i++) {
            ans = Math.max(pre1, pre2 + nums[i - 1]);
            pre2 = pre1;
            pre1 = ans;
        }
        return ans;
    }
}
