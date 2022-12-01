package doublepointer;

import java.util.Arrays;

/**
 * @Classname : SuperUglyNumber
 * @Description : 313. 超级丑数
 * https://leetcode.cn/problems/super-ugly-number/
 * @Author : chentianyu
 * @Date 2022/12/2 00:01
 */


public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int pn = primes.length;
        // 定义多指针，points[i] 表示第 i 个超级丑数还未乘以 primes[i]
        int[] points = new int[pn];
        // 初始多指针指向第一个丑数 1
        Arrays.fill(points, 1);

        // 定义dp数组，dp[i] 表示第 i 个超级丑数
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 多指针指向的位置分别乘以对应质数，找出下一个超级丑数
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < pn; j++) {
                int next = dp[points[j]] * primes[j];
                min = Math.min(min, next);
            }
            dp[i] = min;
            // 可能有多个都等于min，因此需要遍历
            for (int j = 0; j < pn; j++) {
                int next = dp[points[j]] * primes[j];
                if (next == min) points[j]++;
            }
        }
        return dp[n];
    }
}  // end class
