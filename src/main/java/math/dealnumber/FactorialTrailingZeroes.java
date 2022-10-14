package math.dealnumber;

/**
 * @Classname : FactorialTrailingZeroes
 * @Description : 172. 阶乘后的零
 * https://leetcode.cn/problems/factorial-trailing-zeroes/
 * 问题分析：
 *  每含有一个质因数2和一个质因数5时，阶乘的尾随的零会加一；
 *  又质因数5的个数一定小于质因数2的个数，因此只看质因数5的个数。
 * 递归过程：
 *  第一次调用函数：统计至少含有一个质因数5的数字个数
 *  第二次调用函数：统计至少含有两个质因数5的数字个数
 *  ...
 * @Author : chentianyu
 * @Date 2022/10/14 22:21
 */


public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
