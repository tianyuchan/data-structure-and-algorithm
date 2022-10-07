package dynamic.subsequence;

import java.util.Arrays;

/**
 * @Classname : MaximumLengthOfPairChain
 * @Description : 646. 最长数对链
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 * 与【300. 最长递增子序列】类似
 * @Author : chentianyu
 * @Date 2022/10/7 23:04
 */


public class MaximumLengthOfPairChain {
    // 贪心算法 8ms 41.4MB
    public int findLongestChain2(int[][] pairs) {
        int n = pairs.length, maxLen = 1;
        if (n < 2) return maxLen;

        Arrays.sort(pairs, (o1, o2)->Integer.compare(o1[1], o2[1]));
        int preR = pairs[0][1];
        for (int[] pair : pairs) {
            if (pair[0] > preR) {
                preR = pair[1];
                maxLen++;
            }
        }
        return maxLen;
    }

    // 动态规划 30ms 41.1MB
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length, maxLen = 1;
        if (n < 2) return maxLen;

        // 以数对第二个数字排序
        Arrays.sort(pairs, (o1, o2)->Integer.compare(o1[1], o2[1]));
        // dp[i]表示前i+1个数对，以位置i的数对结尾，可以组成的最长数对链长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);


        for (int i = 1; i < n; i++) {
            // 从位置i往前遍历所有满足数对链的位置，找到最长数对链
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
