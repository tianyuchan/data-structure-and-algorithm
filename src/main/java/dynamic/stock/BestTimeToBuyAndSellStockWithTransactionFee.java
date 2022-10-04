package dynamic.stock;

/**
 * @Classname : BestTimeToBuyAndSellStockWithTransactionFee
 * @Description : 714. 买卖股票的最佳时机含手续费
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @Author : chentianyu
 * @Date 2022/10/3 23:40
 */


public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length, fit = 0, buy = prices[0] + fee;
        for (int i = 1; i < n; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                fit += prices[i] - buy;
                // 记录交易后的价格。若未遇到prices[i] + fee < buy，则下次遇到prices[i] > buy直接计入收益
                buy = prices[i];
            }
        }
        return fit;
    }
}
