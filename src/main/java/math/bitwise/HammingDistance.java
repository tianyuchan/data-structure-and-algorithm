package math.bitwise;

/**
 * @Classname : HammingDistance
 * @Description : 461. 汉明距离
 * https://leetcode.cn/problems/hamming-distance/
 * 【常用位运算】
 * 获取最低位数字：x & 1
 * 除以2：x >> 1
 * 乘以2：x << 1
 * 获取最低位的1：x & (-x)
 * 消去最低位的1：x & (x - 1)
 *
 * @Author : chentianyu
 * @Date 2022/10/29 22:30
 */


public class HammingDistance {
    /**
     * 法一：先异或，再统计1的个数
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int ans = 0, z = x ^ y;
        while (z > 0) {
            ans += z & 1;
            z = z >> 1;
        }
        return ans;
    }


    /**
     * 法二：循环取余比较
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {
        int ans = 0;
        while (x > 0 || y > 0) {
            ans += ((x & 1) == (y & 1) ? 0 : 1);
            x = x >> 1;
            y = y >> 1;
        }
        return ans;
    }
}
