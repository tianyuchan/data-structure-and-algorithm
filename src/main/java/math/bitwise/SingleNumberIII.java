package math.bitwise;

/**
 * @Classname : SingleNumberIII
 * @Description : 260. 只出现一次的数字 III
 * https://leetcode.cn/problems/single-number-iii/
 * @Author : chentianyu
 * @Date 2022/10/31 23:10
 */


public class SingleNumberIII {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了97.60%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了34.73%的用户
     * 通过测试用例：32 / 32
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        // 获取只出现一次的两个元素的异或值
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 获取只出现一次的两个元素的异或值的最低位
        int low = xor & (-xor);
        // 根据low值分类异或获取两个元素
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & low) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
