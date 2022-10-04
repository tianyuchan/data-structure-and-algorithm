package dynamic.stringedit;

/**
 * @Classname : RegularExpressionMatching
 * @Description : 10. 正则表达式匹配
 * https://leetcode.cn/problems/regular-expression-matching/
 * @Author : chentianyu
 * @Date 2022/10/2 22:55
 */


public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 应对用例 s = "aab"; p = "c*a*b";
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);
                // 当前字符与当前正则字符匹配
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 当前字符与当前正则字符不匹配 且 正则字符非*
                else if (pc != '*'){
                    dp[i][j] = false;
                }
                // 当前字符与当前正则字符不匹配 且 正则字符为* 且 当前字符与前一正则字符不匹配
                else if (p.charAt(j - 2) != sc && p.charAt(j - 2) != '.') {
                    dp[i][j] = dp[i][j - 2];  // 相当于把 *及其前一字符消去
                }
                // 当前字符与当前正则字符不匹配 且 正则字符为* 且 当前字符与前一正则字符匹配
                else {
                    // 若 dp[i - 1][j - 1] == true ||  dp[i - 1][j - 2] == true ，则 dp[i - 1][j] = true
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                }
            }
        }
        return dp[m][n];
    }
}
