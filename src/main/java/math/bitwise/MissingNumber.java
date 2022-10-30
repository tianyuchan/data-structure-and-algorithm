package math.bitwise;

import java.util.Arrays;

/**
 * @Classname : MissingNumber
 * @Description : 268. 丢失的数字
 * @Author : chentianyu
 * @Date 2022/10/30 23:51
 */


public class MissingNumber {
    /**
     * 异或法
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了9.15%的用户
     * 通过测试用例：122 / 122
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int n = nums.length, ans = n;;
        for (int i = 0; i < n; i++) {
            ans ^= i;
            ans ^= nums[i];
        }
        return ans;
    }

    /**
     * 求和取差法
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.1 MB, 在所有 Java 提交中击败了59.70%的用户
     * 通过测试用例：122 / 122
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return (1 + n) * n / 2 - sum;
    }

    /**
     * 排序后位置比较法
     *
     * 执行用时：5 ms, 在所有 Java 提交中击败了40.71%的用户
     * 内存消耗：42.5 MB, 在所有 Java 提交中击败了16.63%的用户通过
     * 测试用例：122 / 122
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        // 注意若 1 ~ n-1 都有，则是 n 缺失
        return n;
    }
}
