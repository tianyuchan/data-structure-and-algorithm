package dynamic.basic1d;

/**
 * @Classname : ClimbingStairs
 * @Description : 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 * @Author : chentianyu
 * @Date 2022/9/22 22:53
 */


public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 空间压缩
    public int climbStairs2(int n) {
        if (n < 3) return n;
        int pre2 = 1, pre1 = 2, ans = 2;
        for (int i = 3; i <= n; i++) {
            ans = pre1 + pre2;
            pre2 = pre1;
            pre1 = ans;
        }
        return ans;
    }
}
