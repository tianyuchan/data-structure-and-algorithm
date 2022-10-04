package dynamic.division;

/**
 * @Classname : DecodeWays
 * @Description : 91. 解码方法
 * https://leetcode.cn/problems/decode-ways/
 * @Author : chentianyu
 * @Date 2022/9/25 23:39
 */


public class DecodeWays {
    public int numDecodings(String s) {
        int pre = s.charAt(0) - '0';
        // 第一个数字为0，无法解码
        if (pre == 0) return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int cur = s.charAt(i - 1) - '0';
            // 无法解码情况
            if (cur == 0 && (pre == 0 || pre > 2)) {
                return 0;
            } else {
                // 当前数字必须与上一数字组合的情况
                if (cur == 0) {
                    dp[i] = dp[i - 2];
                }
                // 当前数字必须单独组合的情况
                else if (pre > 2 || (cur > 6 && pre == 2) || pre == 0) {
                    dp[i] = dp[i - 1];
                }
                // 当前数字既可以与上一数字组合，又可单独组合的情况
                else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            pre = cur;
        }
        return dp[n];
    }
}
