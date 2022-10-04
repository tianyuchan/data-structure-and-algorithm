package search.dfs;

import java.util.*;

/**
 * @Classname : SurroundedRegions
 * @Description : 130. 被围绕的区域
 * https://leetcode.cn/problems/surrounded-regions/
 * @Author : chentianyu
 * @Date 2022/9/19 22:45
 */


public class SurroundedRegions {

    int[] direction = {-1, 0, 1, 0, -1};

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Set<String> boundO = new HashSet<>();

        for(int i = 0; i < m; i++) {
            bfs(board, boundO, i, 0);
            bfs(board, boundO, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            bfs(board, boundO, 0, j);
            bfs(board, boundO, m-1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !boundO.contains(i + "-" + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }  // end solve()

    // 递归实现深度优先搜索
    private void dfs(char[][] board, Set<String> boundO, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || boundO.contains(i + "-" + j)) return;
        boundO.add(i + "-" + j);
        dfs(board, boundO, i+1, j);
        dfs(board, boundO, i-1, j);
        dfs(board, boundO, i, j+1);
        dfs(board, boundO, i, j-1);
    }  // end dfs()

    // 队列实现广度优先搜索
    private void bfs(char[][] board, Set<String> boundO, int i, int j) {
        if (board[i][j] == 'X' || boundO.contains(i + "-" + j)) return;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        boundO.add(i + "-" + j);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int d = 0; d < 4; d++) {
                    int p = x + direction[d], q = y + direction[d + 1];
                    if (p > 0 && p < board.length && q > 0 && q < board[0].length && board[p][q] == 'O' && !boundO.contains(p + "-" + q)) {
                        queue.offer(new int[]{p, q});
                        boundO.add(p + "-" + q);
                    }
                }
            }
        }
    }  // end bfs()
}
