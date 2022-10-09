package dichotomy;

/**
 * @Classname : MedianOfTwoSortedArrays
 * @Description : 4. 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * @Author : chentianyu
 * @Date 2022/10/10 00:37
 */


public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKthNum(nums1, nums2, len/2 + 1)*1.0;
        } else {
            return (findKthNum(nums1, nums2, len/2) + findKthNum(nums1, nums2, len/2 + 1)) * 0.5;
        }
    }

    private int findKthNum(int[] nums1, int[] nums2, int k) {
        int l1 = 0, l2 = 0, r1 = nums1.length - 1, r2 = nums2.length - 1;
        while (true) {
            if (l1 > r1) return nums2[l2 + (k - 1)];
            if (l2 > r2) return nums1[l1 + (k - 1)];
            if (k == 1) return Math.min(nums1[l1], nums2[l2]);

            int m1 = Math.min(l1 + (k/2 - 1), r1), m2 = Math.min(l2 + (k/2 - 1), r2);
            if (nums1[m1] <= nums2[m2]) {
                k -= (m1 - l1 + 1);
                l1 = m1 + 1;
            } else {
                k -= (m2 - l2 + 1);
                l2 = m2 + 1;
            }
        }
    }
}
