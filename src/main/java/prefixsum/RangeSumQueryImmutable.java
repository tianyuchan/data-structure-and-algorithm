package prefixsum;

/**
 * @Classname : RangeSumQueryImmutable
 * @Description : 303. 区域和检索 - 数组不可变
 * https://leetcode.cn/problems/range-sum-query-immutable/
 * @Author : chentianyu
 * @Date 2022/11/21 23:02
 */


public class RangeSumQueryImmutable {
    private int[] sums;
    private int n;

    public RangeSumQueryImmutable(int[] nums) {
        n = nums.length;
        sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left > 0 ? sums[right] - sums[left - 1] : sums[right];
    }
}  // end class
