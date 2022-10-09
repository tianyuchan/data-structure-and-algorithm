package dichotomy;

/**
 * @Classname : FindMinimumInRotatedSortedArrayII
 * @Description : 154. 寻找旋转排序数组中的最小值 II
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 * @Author : chentianyu
 * @Date 2022/10/10 00:32
 */


public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, min = nums[l + (r - l) / 2];
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == nums[l]) {
                min = Math.min(min, nums[l]);
                l++;
            }
            else if (nums[m] > nums[l]) {
                // 左边是单调区间
                min = Math.min(min, nums[l]);
                l = m + 1;
            } else {
                // 右边是单调区间
                min = Math.min(min, nums[m]);
                r = m - 1;
            }
        }
        return Math.min(min, nums[l]);
    }
}
