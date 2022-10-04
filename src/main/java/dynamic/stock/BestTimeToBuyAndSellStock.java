package dynamic.stock;

/**
 * @Classname : stock
 * @Description : 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @Author : chentianyu
 * @Date 2022/10/2 23:10
 */


public class BestTimeToBuyAndSellStock {
    public int maxProfit2(int[] prices) {
        int n = prices.length, min = prices[0];
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - min);
            min = Math.min(min, prices[i - 1]);
        }
        return dp[n];
    }

    // 空间压缩
    public int maxProfit(int[] prices) {
        int n = prices.length, min = prices[0], ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = Math.max(ans, prices[i - 1] - min);
            min = Math.min(min, prices[i - 1]);
        }
        return ans;
    }
}
