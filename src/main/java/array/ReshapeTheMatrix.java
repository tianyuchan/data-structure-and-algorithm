package array;

/**
 * @Classname : ReshapeTheMatrix
 * @Description : 566. 重塑矩阵
 * https://leetcode.cn/problems/reshape-the-matrix/
 * @Author : chentianyu
 * @Date 2022/11/27 22:18
 */


public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ans = new int[r][c];
        for (int i= 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = i * n + j;
                ans[num / c][num % c] = mat[i][j];
            }
        }
        return ans;
    }
}
