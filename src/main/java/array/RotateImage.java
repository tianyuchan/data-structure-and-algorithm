package array;

/**
 * @Classname : RotateImage
 * @Description : 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image/
 * @Author : chentianyu
 * @Date 2022/11/1 23:57
 */


public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        // src/main/doc/旋转图像每层选择的起始像素.png
        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                int v = matrix[i][j], x = i, y = j;
                do {
                    // 顺时针映射 x2 = y1, y2 = n - x1
                    int x_bak = x;
                    x = y;
                    y = n - x_bak;
                    int tmp = matrix[x][y];
                    matrix[x][y] = v;
                    v = tmp;
                } while (x != i || y != j);
            }
        }
    }
}
