package math.random;

import java.util.Random;

/**
 * @Classname : RandomPickWithWeight
 * @Description : 528. 按权重随机选择
 * https://leetcode.cn/problems/random-pick-with-weight/
 * @Author : chentianyu
 * @Date 2022/10/16 23:34
 */


public class RandomPickWithWeight {
    private int[] predixs;
    private int n;
    private Random random;

    public RandomPickWithWeight(int[] w) {
        n = w.length;
        // 获取前缀和数组（单调递增）
        predixs = new int[n];
        predixs[0] = w[0];
        for (int i = 1; i < n; i++) {
            predixs[i] = predixs[i - 1] + w[i];
        }
        // 获取随机数生成器
        random = new Random();
    }

    public int pickIndex() {
        // 获取随机值 ran ∈ [1, sum]
        // int ran = 1 + (int) (Math.random() * predixs[n - 1]);
        int ran = 1 + random.nextInt(predixs[n - 1]);
        // 二分法查找前缀和数组中第一个大于或等于随机值的数的位置
        return find(predixs, ran);
    }

    private int find(int[] nums, int v) {
        int ans = 0, l = 0, r = nums.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == v) {
                return m;
            } else if (nums[m] > v) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
