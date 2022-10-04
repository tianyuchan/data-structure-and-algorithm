package dynamic.stringedit;

/**
 * @Classname : TwoKeysKeyboard
 * @Description : 650. 只有两个键的键盘
 * https://leetcode.cn/problems/2-keys-keyboard/
 * @Author : chentianyu
 * @Date 2022/10/1 23:20
 */


public class TwoKeysKeyboard {
    public int minSteps(int n) {
        // dp[i]：数字为i时的最少操作次数
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;  // 最多操作次数
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                }
            }
        }
        return dp[n];
    }
}
