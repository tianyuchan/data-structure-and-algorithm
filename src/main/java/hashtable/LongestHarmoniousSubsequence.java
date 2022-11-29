package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname : LongestHarmoniousSubsequence
 * @Description : 594. 最长和谐子序列
 * https://leetcode.cn/problems/longest-harmonious-subsequence/
 * @Author : chentianyu
 * @Date 2022/11/30 01:01
 */


public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i], count = 0;
            if (map.containsKey(cur + 1)) {
                count += map.get(cur);
                count += map.get(cur + 1);
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}  // end class
