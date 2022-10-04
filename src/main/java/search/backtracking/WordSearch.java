package search.backtracking;

/**
 * @Classname : WordSearch
 * @Description : 79. 单词搜索
 * https://leetcode.cn/problems/word-search/
 * @Author : chentianyu
 * @Date 2022/8/31 23:26
 */


public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTracking(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }  // end exist()

    private boolean backTracking(char[][] board, String word, int i, int j, int cur) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || cur >= word.length() ||
                board[i][j] == '#' || board[i][j] != word.charAt(cur)) {
            return false;
        }
        if (cur == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean flag = backTracking(board, word, i + 1, j, cur + 1) ||
                backTracking(board, word, i - 1, j, cur + 1) ||
                backTracking(board, word, i, j + 1, cur + 1) ||
                backTracking(board, word, i, j - 1, cur + 1);
        if (!flag) {
            board[i][j] = temp;
            return false;
        }
        return true;
    }  // end backTracking()
}  // end class
