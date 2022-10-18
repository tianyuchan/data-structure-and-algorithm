package math.dealnumber;

import java.util.Arrays;

/**
 * @Classname : MinimumMovesToEqualArrayElementsII
 * @Description : 462. 最小操作次数使数组元素相等 II
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * @Author : chentianyu
 * @Date 2022/10/18 22:55
 */


public class MinimumMovesToEqualArrayElementsII {

    /**
     * 方法一
     * 思路：排序的数组，到前后数字组成区间的的最近的数字，在所有区间的交集中（即取中值），且距离为区间长度
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            ans += nums[n - 1 - i] - nums[i];
        }
        return ans;
    }


    /**
     * 方法二
     * 思路：由方法一思路可知，通过快速选择找到中值，再计算每个数字与中值的距离即可
     *
     * @param nums
     * @return
     */
    public int minMoves22(int[] nums) {
        int ans = 0, n = nums.length;
        int v = quickSelect(nums, 0, n, n / 2);
        for (int i = 0; i < n; i++) {
            ans += Math.abs(nums[i] - v);
        }
        return ans;
    }

    private int quickSelect(int[] nums, int l, int r, int m) {
        if (l + 1 >= r) return nums[l];

        int p = l, q = r - 1, rand = l + (int) Math.random() * (r - l);
        swap(nums, l, rand);
        while (true) {
            while (p < q && nums[q] >= nums[l]) q--;
            while (p < q && nums[p] <= nums[l]) p++;
            if (p == q) break;
            swap(nums, p, q);
        }
        swap(nums, p, l);

        if (p == m) return nums[p];
        else if (p > m) return quickSelect(nums, l, p, m);
        else return quickSelect(nums, p + 1, r, m);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
