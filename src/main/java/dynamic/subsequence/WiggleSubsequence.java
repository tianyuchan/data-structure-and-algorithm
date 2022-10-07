package dynamic.subsequence;

import java.util.Arrays;

/**
 * @Classname : WiggleSubsequence
 * @Description : 376. 摆动序列
 * https://leetcode.cn/problems/wiggle-subsequence/
 * @Author : chentianyu
 * @Date 2022/10/7 23:45
 */


public class WiggleSubsequence {
    // 贪心算法 0ms 39.5MB
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, preDiff = 0, maxLen = 1;
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            // 由于是子序列，记录所有相邻的上升下降次数即可
            if ((preDiff >= 0 && diff < 0) || (preDiff <= 0 && diff > 0)) {
                maxLen++;
                preDiff = diff;
            }
        }
        return maxLen;
    }

    // 动态规划 4ms 39.5MB
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length, maxLen = 1;
        // up[i]：以位置i数字结尾 且 上升 的最长摆动序列长度；down[i]：以位置i数字结尾 且 下降 的最长摆动序列长度；
        int[] up = new int[n], down = new int[n];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                }
                if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, up[i]);
            maxLen = Math.max(maxLen, down[i]);
        }
        return maxLen;
    }
}
