package prefixsum;

/**
 * @Classname : RangeSumQuery2dImmutable
 * @Description : 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode.cn/problems/range-sum-query-2d-immutable/
 * @Author : chentianyu
 * @Date 2022/11/24 22:11
 */


public class RangeSumQuery2dImmutable {
    private int[][] sums;
    private int m;
    private int n;

    public RangeSumQuery2dImmutable(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        sums = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row2++;
        col2++;
        return sums[row2][col2] - sums[row2][col1] - sums[row1][col2] + sums[row1][col1];
    }
}
