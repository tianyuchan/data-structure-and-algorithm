package sort.quickSelect;

/**
 * @Classname : KthLargestElementInAnArray
 * @Description : 215. 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * @Author : chentianyu
 * @Date 2022/10/4 23:02
 */


public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }

        int l = 0, r = nums.length - 1, target = nums.length - k;
        while (l <= r) {
            int m = quickSelect(nums, l, r);
            if (m == target) {
                return nums[m];
            } else if (m > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    private int quickSelect(int[] nums, int l, int r) {
        int p = l, q = r;
        while (true) {
            while (p < q && nums[q] >= nums[l]) {
                q--;
            }
            while (p < q && nums[p] <= nums[l]) {
                p++;
            }
            if (p >= q) {
                break;
            }
            swap(nums, p, q);
        }
        swap(nums, p, l);
        return p;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
