package dynamic.stringedit;

/**
 * @Classname : EditDistance
 * @Description : 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/
 * @Author : chentianyu
 * @Date 2022/10/1 22:56
 */


public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j]：word1前i个字符串转换成word2前j个字符所用的最少操作数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
