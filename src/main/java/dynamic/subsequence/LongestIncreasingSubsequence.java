package dynamic.subsequence;

import java.util.*;

/**
 * @Classname : longestIncreasingSubsequence
 * @Description : 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * @Author : chentianyu
 * @Date 2022/9/26 23:32
 */


public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i] 表示数组 nums 中以位置i数字结尾最长严格递增子序列的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < n; i++) {
            // 遍历找到小于当前数字的位置
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 二分法优化
     * 数组：10,9,2,5,3,7,101,1,2,3,4,5
     * 策略：若curNum > dp.peekLast(), 则dp.addLast(curNum)；否则curNum替换dp中第一个大于或等于curNum的数字。
     * 过程：
     * 10
     * 9
     * 2
     * 2, 5
     * 2, 3
     * 2, 3, 7
     * 2, 3, 7, 101  // 到达峰值，此时最长序列
     * 1, 3, 7, 101
     * 1, 2, 7, 101
     * 1, 2, 3, 101
     * 1, 2, 3, 4
     * 1, 2, 3, 4, 5  // 到达峰值，此时最长序列
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> dp = new LinkedList<>();
        dp.offerLast(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp.peekLast()) {
                dp.addLast(nums[i]);
            } else {
                insert(dp, nums[i]);
            }
        }
        return dp.size();
    }

    private void insert(LinkedList<Integer> dp, int num) {
        int l = 0, r = dp.size() - 1, pos = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (dp.get(m) == num) {
                pos = m;
                break;
            } else if (dp.get(m) > num) {
                pos = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        dp.set(pos, num);
    }
}
