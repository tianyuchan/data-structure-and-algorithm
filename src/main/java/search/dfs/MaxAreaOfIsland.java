package search.dfs;

import java.util.Stack;

/**
 * @Classname : MaxAreaOfIsland
 * @Description : 695. 岛屿的最大面积
 * https://leetcode.cn/problems/max-area-of-island/
 * @Author : chentianyu
 * @Date 2022/8/23 22:30
 */


public class MaxAreaOfIsland {
    private int[] direction = {-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0, maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                maxArea = Math.max(maxArea, getArea(grid, i, j));  // 栈实现
                maxArea = Math.max(maxArea, getArea2(grid, i, j));  // 递归实现
            }
        }
        return maxArea;
    }

    // 栈实现
    private int getArea(int[][] grid, int i, int j) {
        int area = 0;
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            area++;
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{i, j});
            while (!stack.isEmpty()) {
                int[] cur = stack.pop();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + direction[k], y = cur[1] + direction[k + 1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 0;
                        area++;
                        stack.push(new int[]{x, y});
                    }
                }
            }
        }
        return area;
    }

    // 递归实现
    private int getArea2(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + getArea2(grid, i + 1, j)
                + getArea2(grid, i - 1, j)
                + getArea2(grid, i, j + 1)
                + getArea2(grid, i, j - 1);
    }
}
