package array;

/**
 * @Classname : SearchA2dMatrixII
 * @Description : 240. 搜索二维矩阵 II
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * @Author : chentianyu
 * @Date 2022/11/2 21:31
 */


public class SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
