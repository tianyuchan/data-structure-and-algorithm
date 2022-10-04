package dynamic.subsequence;

/**
 * @Classname : DeleteOperationForTwoStrings
 * @Description : 583. 两个字符串的删除操作
 * https://leetcode.cn/problems/delete-operation-for-two-strings/
 * @Author : chentianyu
 * @Date 2022/10/4 22:48
 */


public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j]：单词1到第i个字符的前缀，单词2到第j个字符的前缀，最大公共子序列长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
