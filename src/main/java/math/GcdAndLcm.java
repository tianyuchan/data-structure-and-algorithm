package math;

/**
 * @Classname : GcdAndLcm
 * @Description :
 * 最大公因数 greatest common divisor，gcd
 * 最小公倍数 least common multiple, lcm
 * @Author : chentianyu
 * @Date 2022/10/13 23:04
 */


public class GcdAndLcm {
    public static void main(String[] args) {
        // 最大公约数
        System.out.println(gcm(12, 18));
        // 最小公倍数
        System.out.println(lcm(12, 18));
    }

    /**
     * 辗转相除法计算最大公因数
     * 当 a < b 时，由于 a % b = a，下次递归调用函数入参为 (b, a)，相等于入参 a 和 b 交换了位置；
     * 当 a > b 时，下次递归调用函数入参为 (b, a % b)，假设 a 和 b 的最小公倍数为 g，由于 a 和 b 都是 g 的倍数，则 a % b 也是 g 的倍数；
     * 当 a = b 时，下次递归调用函数入参为 (b, 0)，则下下次递归调用函数时直接将 b 作为结果返回。
     * 示例：gcm(12, 18) -> gcm(18, 12) -> gcm(12, 6) -> gcm(6, 0) = 6
     *
     * @param a
     * @param b
     * @return
     */
    static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    /**
     * 计算最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    static int lcm(int a, int b) {
        return a * b / gcm(a, b);
    }

}
