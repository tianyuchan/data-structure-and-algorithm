package dynamic.basic2d;

import java.util.Arrays;

/**
 * @Classname : Matrix01
 * @Description : 542. 01 矩阵
 * https://leetcode.cn/problems/01-matrix/
 * @Author : chentianyu
 * @Date 2022/9/24 23:17
 */


public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE - m - n);
        // 左上往右下遍历
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                    }
                }
            }
        }
        // 右下往左上遍历
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    if (i < m - 1) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);
                    }
                    if (j < n - 1) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + 1]);
                    }
                }
            }
        }
        return dp;
    }
}
