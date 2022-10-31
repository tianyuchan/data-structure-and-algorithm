package math.bitwise;

/**
 * @Classname : NumberComplement
 * @Description : 476. 数字的补数
 * https://leetcode.cn/problems/number-complement/
 * @Author : chentianyu
 * @Date 2022/10/31 22:52
 */


public class NumberComplement {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了5.61%的用户
     * 通过测试用例：149 / 149
     *
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bit = ((num & 1) ^ 1);
            ans += (bit << i);
            num >>= 1;
            if (num <= 0) break;
        }
        return ans;
    }
}
