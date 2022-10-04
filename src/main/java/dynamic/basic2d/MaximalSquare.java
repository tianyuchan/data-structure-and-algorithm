package dynamic.basic2d;

/**
 * @Classname : MaximalSquare
 * @Description : 221. 最大正方形
 * https://leetcode.cn/problems/maximal-square/
 * @Author : chentianyu
 * @Date 2022/9/25 22:32
 */


public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        // 遍历将字符数组转化为数字
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    max = 1;
                }
            }
        }
        // 动态规划搜索获取最大边
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
