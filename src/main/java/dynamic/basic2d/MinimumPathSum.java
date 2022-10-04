package dynamic.basic2d;

/**
 * @Classname : MinimumPathSum
 * @Description : 64. 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/
 * @Author : chentianyu
 * @Date 2022/9/24 22:12
 */


public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else if (i == 0) {
                    dp[i][j] = grid[0][j] + dp[0][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][0] + dp[i - 1][0];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //空间压缩
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[0][0];
                } else if (i == 0) {
                    dp[j] = grid[0][j] + dp[j - 1];
                } else if (j == 0) {
                    dp[j] = grid[i][0] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[n - 1];
    }
}
