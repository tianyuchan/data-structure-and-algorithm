package math.bitwise;

/**
 * @Classname : CountingBits
 * @Description : 338. 比特位计数
 * https://leetcode.cn/problems/counting-bits/
 * @Author : chentianyu
 * @Date 2022/10/30 23:42
 */


public class CountingBits {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.95%的用户
     * 内存消耗：45.3 MB, 在所有 Java 提交中击败了77.10%的用户
     * 通过测试用例：15 / 15
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // 当i二进制标识末尾是1时，二进制表示1的个数等于 i-1 的个数加1
            // 当i二进制标识末尾是0时，二进制表示1的个数等于 i>>1 的个数
            dp[i] = (i & 1) == 1 ? dp[i - 1] + 1 : dp[i >> 1];
        }
        return dp;
    }
}
