package search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname : PacificAtlanticWaterFlow
 * @Description : 417. 太平洋大西洋水流问题
 * https://leetcode.cn/problems/pacific-atlantic-water-flow/
 * @Author : chentianyu
 * @Date 2022/8/27 20:39
 */


public class PacificAtlanticWaterFlow {
    private int[] directions = {-1, 0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // 记录太平洋可达单元格
        boolean[][] canReachP = new boolean[m][n];
        // 记录大西洋可达单元格
        boolean[][] canReachA = new boolean[m][n];

        // 从4个边开始判断
        for (int i = 0; i < m; i++) {
            // 太平洋-左边开始
            dfs(heights, i, 0, canReachP);
            // 大西洋-右边开始
            dfs(heights, i, n-1, canReachA);
        }
        for (int j = 0; j < n; j++) {
            // 太平洋-上边开始
            dfs(heights, 0, j, canReachP);
            // 大西洋-下边开始
            dfs(heights, m-1, j, canReachA);
        }

        // 找出太平洋和大西洋共同可达单元格
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }  // end pacificAtlantic()

    private void dfs(int[][] heights, int i, int j, boolean[][] canReach) {
        canReach[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + directions[k];
            int y = j + directions[k + 1];
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length &&
                    heights[x][y] >= heights[i][j] && !canReach[x][y]) {
                dfs(heights, x, y, canReach);
            }
        }
    }  // end dfs()
}
