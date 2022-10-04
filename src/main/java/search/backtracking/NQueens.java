package search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname : NQueens
 * @Description : 51. N 皇后
 * https://leetcode.cn/problems/n-queens/
 * @Author : chentianyu
 * @Date 2022/9/10 20:11
 */


public class NQueens {
    boolean[] columns, lefts, rights;

    public List<List<String>> solveNQueens(int n) {
        columns = new boolean[n];
        lefts = new boolean[2 * n - 1];
        rights = new boolean[2 * n - 1];

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            board[i] = chars;
        }

        backTracking(ans, board, n, 0);
        return ans;
    }

    // 递归行遍历，则不需要对行进行判断
    private void backTracking(List<List<String>> ans, char[][] board, int n, int r) {
        if (r == n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tmp.add(new String(board[i]));
            }
            ans.add(tmp);
        }

        for (int c = 0; c < n; c++) {
            if (columns[c] || lefts[c + r] || rights[n - 1 - c + r]) {
                continue;
            }
            board[r][c] = 'Q';
            columns[c] = lefts[c + r] = rights[n - 1 - c + r] = true;
            backTracking(ans, board, n, r + 1);
            board[r][c] = '.';
            columns[c] = lefts[c + r] = rights[n - 1 - c + r] = false;
        }
    }
}  // end class
