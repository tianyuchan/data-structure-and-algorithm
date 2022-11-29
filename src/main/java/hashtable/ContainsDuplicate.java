package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname : ContainsDuplicate
 * @Description : 217. 存在重复元素
 * https://leetcode.cn/problems/contains-duplicate/
 * @Author : chentianyu
 * @Date 2022/11/29 21:54
 */


public class ContainsDuplicate {
    // 排序-牺牲时间节省空间
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // 哈希表-牺牲空间节省时间
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}  // end class
