package hashtable;

import java.util.HashSet;

/**
 * @Classname : LongestConsecutiveSequence
 * @Description : 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 * @Author : chentianyu
 * @Date 2022/11/20 22:08
 */


public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i], count = 1;
            // 减枝：保证每个连续序列，只从其最小值统计长度
            if (set.contains(cur - 1)) continue;
            while (set.contains(cur + 1)) {
                cur++;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}  // end class
