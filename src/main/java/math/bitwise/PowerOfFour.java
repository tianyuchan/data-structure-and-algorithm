package math.bitwise;

/**
 * @Classname : PowerOfFour
 * @Description : 342. 4的幂
 * https://leetcode.cn/problems/power-of-four/
 * @Author : chentianyu
 * @Date 2022/10/29 23:25
 */


public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        // 大于0 且 只有一位是1 且 是1的位置在奇数位上
        return n > 0 && ((n & (n - 1)) == 0) && ((n & 0b01010101010101010101010101010101) != 0);
    }
}
