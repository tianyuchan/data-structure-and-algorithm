package dichotomy;

/**
 * @Classname : SearchInRotatedSortedArrayII
 * @Description : 81. 搜索旋转排序数组 II
 * https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
 * @Author : chentianyu
 * @Date 2022/10/10 00:26
 */


public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            else if (nums[m] == nums[l]) l++;
            else if (nums[m] > nums[l]) {
                // 左区间递增
                if (target >= nums[l] && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else {
                // 右区间递增
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return false;
    }
}
