package math.random;

import java.util.Random;

/**
 * @Classname : ShuffleAnArray
 * @Description : 384. 打乱数组
 * https://leetcode.cn/problems/shuffle-an-array/
 * Fisher-Yates 洗牌算法：通过随机交换位置来实现随机打乱，有正向和反向两种写法。
 * @Author : chentianyu
 * @Date 2022/10/16 22:47
 */


public class ShuffleAnArray {
    private int[] origins;
    private int[] nums;
    private int n;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.n = nums.length;
        this.origins = new int[n];
        this.nums = new int[n];
        System.arraycopy(nums, 0, origins, 0, n);
        System.arraycopy(nums, 0, this.nums, 0, n);
        random = new Random();
    }

    public int[] reset() {
        System.arraycopy(origins, 0, nums, 0, n);
        return nums;
    }

    public int[] shuffle() {
        // 反向
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i + 1));
        }
        // 正向
        // for (int i = 0; i < n; i++) {
        //     swap(nums, i, i + random.nextInt(n - i));
        // }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
