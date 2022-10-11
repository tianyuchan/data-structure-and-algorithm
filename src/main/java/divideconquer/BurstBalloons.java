package divideconquer;

import java.util.*;

/**
 * @Classname : BurstBalloons
 * @Description : 312. 戳气球
 * https://leetcode.cn/problems/burst-balloons/
 * @Author : chentianyu
 * @Date 2022/10/11 23:29
 */


public class BurstBalloons {
    private int[][] memorization;
    /**
     * 分治法 + memorization 优化
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 构建 memorization
        memorization = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            memorization[i] = new int[n + 2];
            Arrays.fill(memorization[i], -1);
        }
        // 构建新数组，相当于数组nums两边加了数字1
        int[] array = new int[n + 2];
        array[0] = array[n + 1] = 1;
        for (int i = 1; i <= n; i++) array[i] = nums[i - 1];

        return f(array, 0, n + 1);
    }

    private int f(int[] array, int l, int r) {
        // l 和 r 之间至少有一个数字
        if (l + 2 > r) return 0;
        if (memorization[l][r] != -1) return memorization[l][r];

        for (int i = l + 1; i < r; i++) {
            int val = array[l] * array[i] * array[r];
            val += f(array, l, i) + f(array, i, r);
            memorization[l][r] = Math.max(memorization[l][r], val);
        }
        return memorization[l][r];
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxCoins2(int[] nums) {
        int n = nums.length;

        int[] array = new int[n + 2];
        array[0] = array[n + 1] = 1;
        for (int i = 1; i <= n; i++) array[i] = nums[i - 1];

        // dp[i][j]：从位置i到j之间获得硬币的最大数量
        int[][] dp = new int[n + 2][n + 2];
        for (int j = 0; j < n + 2; j++) {
            // 状态转移方程使用的 dp[k][j] 在 dp[i][j] 右边，所以从右往左遍历
            for (int i = j; i >= 0; i--) {
                if (i + 1 <= j) {
                    for (int k = i + 1; k < j; k++) {
                        int val = array[i] * array[k] * array[j] + dp[i][k] + dp[k][j];
                        dp[i][j] = Math.max(dp[i][j], val);
                    }
                }
            }
        }
        return dp[0][n + 1];
    }
}
