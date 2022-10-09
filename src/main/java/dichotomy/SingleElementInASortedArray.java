package dichotomy;

/**
 * @Classname : SingleElementInASortedArray
 * @Description : 540. 有序数组中的单一元素
 * https://leetcode.cn/problems/single-element-in-a-sorted-array/
 * @Author : chentianyu
 * @Date 2022/10/10 00:34
 */


public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m % 2 == 1) m--;
            if (nums[m] == nums[m+1]) l = m + 2;
            else r = m;
        }
        return nums[l];
    }
}
