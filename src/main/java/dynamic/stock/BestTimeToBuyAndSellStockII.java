package dynamic.stock;

/**
 * @Classname : BestTimeToBuyAndSellStockII
 * @Description : 122. 买卖股票的最佳时机 II
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * @Author : chentianyu
 * @Date 2022/10/3 21:39
 */


public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            // 所有相邻股票上涨均进行一次交易
            if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
        }
        return ans;
    }
}
