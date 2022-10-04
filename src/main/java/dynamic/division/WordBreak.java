package dynamic.division;

import java.util.List;

/**
 * @Classname : WordBreak
 * @Description : 139. 单词拆分
 * https://leetcode.cn/problems/word-break/
 * @Author : chentianyu
 * @Date 2022/9/26 23:11
 */


public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word) && dp[i - len]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
