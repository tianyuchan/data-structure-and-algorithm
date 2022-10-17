package math.dealnumber;

import java.util.Arrays;

/**
 * @Classname : ProductOfArrayExceptSelf
 * @Description : 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/
 * @Author : chentianyu
 * @Date 2022/10/17 23:32
 */


public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, l = 1, r = 1;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 0; i < n; i++) {
            ans[i] *= l;
            l *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= r;
            r *= nums[i];
        }
        return ans;
    }
}
