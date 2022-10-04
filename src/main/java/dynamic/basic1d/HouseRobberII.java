package dynamic.basic1d;

/**
 * @Classname : HouseRobberII
 * @Description : 213. 打家劫舍 II
 * https://leetcode.cn/problems/house-robber-ii/
 * @Author : chentianyu
 * @Date 2022/10/4 21:49
 */


public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        else if (n == 1) return nums[0];
        else if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
    }

    private int rob(int[] nums, int l, int r) {
        int pre2 = 0, pre1 = nums[l], max = nums[l];
        for (int i = l + 1; i < r; i++) {
            max = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = max;
        }
        return max;
    }
}
