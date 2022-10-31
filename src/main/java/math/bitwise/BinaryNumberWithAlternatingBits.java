package math.bitwise;

/**
 * @Classname : BinaryNumberWithAlternatingBits
 * @Description : 693. 交替位二进制数
 * https://leetcode.cn/problems/binary-number-with-alternating-bits/
 * @Author : chentianyu
 * @Date 2022/10/31 22:24
 */


public class BinaryNumberWithAlternatingBits {
    /**
     * 错位异或法
     *
     * @param n
     * @return
     */
    public boolean hasAlternatingBits2(int n) {
        // n      = 10101010
        // n >> 1 =  1010101
        // a      = 11111111
        int a = n ^ (n >> 1);
        // a + 1  =100000000
        return (a & (a + 1)) == 0;
    }

    /**
     * 循环比较法
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了61.61%的用户
     * 通过测试用例：204 / 204
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        int last = -1;
        while (n > 0) {
            int cur = n & 1;
            if (last == cur) return false;
            last = cur;
            n >>= 1;
        }
        return true;
    }
}
