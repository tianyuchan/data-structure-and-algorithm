package math.dealnumber;

/**
 * @Classname : PowerOfThree
 * @Description : 326. 3 的幂
 * https://leetcode.cn/problems/power-of-three/
 * @Author : chentianyu
 * @Date 2022/10/14 23:06
 */


public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        // 整型int范围3的最大幂次方 3^19 = 1162261467，可以整除 n， 说明 n 是 3 的幂次方
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree3(int n) {
        // 设 logn3 = m，如果 n 是 3 的整数次方，那么 m 一定是整数
        double m = Math.log(n) / Math.log(3);
        // 由于浮点数存在误差，该方法不可靠
        return m - (int) m == 0;
    }
}
