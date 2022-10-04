package dynamic.basic1d;

/**
 * @Classname : ArithmeticSlices
 * @Description : 413. 等差数列划分
 * https://leetcode.cn/problems/arithmetic-slices/
 * @Author : chentianyu
 * @Date 2022/9/24 21:52
 */


public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        if (n < 3) return ans;

        int[] dp = new int[n];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = 1 + dp[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            ans += dp[i];
        }
        return ans;
    }

    // 空间压缩
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        if (n < 3) return ans;

        int last = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                last++;
                ans += last;
            } else {
                last = 0;
            }
        }
        return ans;
    }
}
