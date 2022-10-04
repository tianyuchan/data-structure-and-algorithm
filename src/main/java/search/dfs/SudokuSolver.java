package search.dfs;

import java.util.*;

/**
 * @Classname : SudokuSolver
 * @Description : 37. 解数独
 * https://leetcode.cn/problems/sudoku-solver/
 * @Author : chentianyu
 * @Date 2022/9/21 22:21
 */


public class SudokuSolver {
    private final int N = 9;
    private boolean[][] row = new boolean[N][N];
    private boolean[][] col = new boolean[N][N];
    private boolean[][][] blocks = new boolean[3][3][N];
    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        List<int[]> space = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    // 降维：将二维降为一维处理
                    space.add(new int[]{i, j});
                } else {
                    int n = board[i][j] - '0' - 1;
                    row[i][n] = col[j][n] = blocks[i/3][j/3][n] = true;
                }
            }
        }
        dfs(board, space, space.size(), 0);
    }

    private void dfs(char[][] board, List<int[]> space, int size, int pos) {
        if (pos == size) {
            valid = true;
            return;
        }
        int[] cur = space.get(pos);
        int i = cur[0], j = cur[1];
        for (int n = 0; n < N; n++) {
            if (valid || row[i][n] || col[j][n] || blocks[i/3][j/3][n]) continue;
            row[i][n] = col[j][n] = blocks[i/3][j/3][n] = true;
            board[i][j] = (char) ('1' + n);
            dfs(board, space, size, pos+1);
            row[i][n] = col[j][n] = blocks[i/3][j/3][n] = false;
        }
    }
}
