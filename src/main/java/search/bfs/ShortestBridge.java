package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname : ShortestBridge
 * @Description : 934. 最短的桥
 * https://leetcode.cn/problems/shortest-bridge/
 * @Author : chentianyu
 * @Date 2022/9/10 21:04
 */


public class ShortestBridge {
    private int[] directions = {-1, 0, 1, 0, -1};

    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean flipped = false;
        for (int i = 0; i < grid.length; i++) {
            if (flipped) break;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(queue, grid, i, j);
                    // 使用标识跳出外层for循环
                    flipped = true;
                    // 只能跳出最里层for循环
                    break;
                }
            }
        }

        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + directions[k], y = cur[1] + directions[k + 1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return level;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return level;
    }

    private void dfs(Queue<int[]> queue, int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 2) {
            return;
        }

        if (grid[i][j] == 0) {
            queue.offer(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        dfs(queue, grid, i + 1, j);
        dfs(queue, grid, i - 1, j);
        dfs(queue, grid, i, j + 1);
        dfs(queue, grid, i, j - 1);
    }
}
