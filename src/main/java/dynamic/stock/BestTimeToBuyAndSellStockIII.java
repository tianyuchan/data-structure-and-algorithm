package dynamic.stock;

import java.util.Arrays;

/**
 * @Classname : BestTimeToBuyAndSellStockIII
 * @Description : 123. 买卖股票的最佳时机 III
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * @Author : chentianyu
 * @Date 2022/10/3 21:49
 */


public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int k = 2, MIN = -10000, n = prices.length;
        if (n < 2 || k < 1) return 0;
        // 若 k 大于等于天数 n 的一半，则逢涨必交易
        if (k * 2 >= n) return maxProfit2(prices);
        // 若 k 小于天数 n 的一半，则动态规划计算
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, MIN);
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        return sell[k];
    }

    private int maxProfit2(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
        }
        return ans;
    }
}
