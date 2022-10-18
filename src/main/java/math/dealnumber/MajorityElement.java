package math.dealnumber;

import java.util.*;

/**
 * @Classname : MajorityElement
 * @Description : 169. 多数元素
 * https://leetcode.cn/problems/majority-element/
 * @Author : chentianyu
 * @Date 2022/10/18 23:47
 */


public class MajorityElement {

    /**
     * 方法1：map
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            if (count > n / 2) return nums[i];
            map.put(nums[i], count);
        }
        return 0;
    }


    /**
     * 方法2：排序取中值
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 方法3：【Boyer-Moore Majority Vote 算法】
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int ans = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) ans = nums[i];
            count += (nums[i] == ans ? 1 : -1);
        }
        return ans;
    }
}
