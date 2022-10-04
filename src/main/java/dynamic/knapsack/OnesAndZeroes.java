package dynamic.knapsack;

/**
 * @Classname : OnesAndZeroes
 * @Description : 474. 一和零
 * https://leetcode.cn/problems/ones-and-zeroes/
 * @Author : chentianyu
 * @Date 2022/10/1 00:08
 */


public class OnesAndZeroes {
    // 0-1背包，压缩空间
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = count(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int count0 = 0, count1 = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
        }
        return new int[]{count0, count1};
    }
}
