package math;

import java.util.Arrays;

/**
 * @Classname : CountPrimes
 * @Description : 204. 计数质数
 * https://leetcode.cn/problems/count-primes/
 * 质数：除了本身和1以外没有其他因数的自然数（不包括1，每一个数都可以分解成质数的乘积）
 * 合数：除了本身和1以外还有其他因数的自然数
 * @Author : chentianyu
 * @Date 2022/10/14 00:11
 */


public class CountPrimes {

    /**
     * 埃拉托斯特尼筛法（Sieve of Eratosthenes，简称埃氏筛法）
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 3) return 0;
        // 标识是否已经被标记为合数
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        // 排除 1 和 n
        int ans = n - 2;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                // 把所有小于 n 的且是 i 的倍数的整数标为合数
                for (int j = 2 * i; j < n; j += i) {
                    if (primes[j]) {
                        primes[j] = false;
                        ans--;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 质数性质优化
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        if (n < 3) return 0;

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int i = 3, sqrtn = (int) Math.sqrt(n), ans = n / 2;  // 偶数一定不是质数
        while (i <= sqrtn) {  // 最小质因子一定小于等于开方数
            for (int j = i * i; j < n; j += 2 * i) {  // 避免偶数遍历
                if (primes[j]) {  // 避免重复遍历
                    primes[j] = false;
                    ans--;
                }
            }
            do {
                i += 2;
            } while(i <= sqrtn && !primes[i]);  // 避免偶数和重复遍历
        }
        return ans;
    }
}
