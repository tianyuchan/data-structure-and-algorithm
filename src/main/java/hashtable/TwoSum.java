package hashtable;

import java.util.HashMap;

/**
 * @Classname : TwoSum
 * @Description : 1. 两数之和
 * https://leetcode.cn/problems/two-sum/
 * @Author : chentianyu
 * @Date 2022/11/19 22:10
 */


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(target - cur)) {
                return new int[]{map.get(target - cur), i};
            }
            map.put(cur, i);
        }
        return new int[]{};
    }
}
