package math.bitwise;

/**
 * @Classname : SingleNumber
 * @Description : 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 * @Author : chentianyu
 * @Date 2022/10/29 22:57
 */


public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
