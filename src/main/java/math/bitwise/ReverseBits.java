package math.bitwise;

/**
 * @Classname : ReverseBits
 * @Description : 190. 颠倒二进制位
 * https://leetcode.cn/problems/reverse-bits/
 * @Author : chentianyu
 * @Date 2022/10/29 22:51
 */


public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        // 注意要颠倒32位
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
}
