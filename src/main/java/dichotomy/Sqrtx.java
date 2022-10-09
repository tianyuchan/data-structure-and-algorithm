package dichotomy;

/**
 * @Classname : Sqrtx
 * @Description : 69. x 的平方根
 * https://leetcode.cn/problems/sqrtx/
 * @Author : chentianyu
 * @Date 2022/10/9 23:17
 */


public class Sqrtx {
    public int mySqrt(int x) {
        int l = 1, r = x, ans = 0;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            int sqrt = x / m;
            if (sqrt >= m) {
                ans = m;
                l = m + 1;
            }
            else r = m - 1;
        }
        return ans;
    }
}
