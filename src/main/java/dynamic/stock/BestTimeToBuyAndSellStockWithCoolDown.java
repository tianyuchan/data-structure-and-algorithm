package dynamic.stock;

/**
 * @Classname : BestTimeToBuyAndSellStockWithCooldown
 * @Description : 309. 最佳买卖股票时机含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @Author : chentianyu
 * @Date 2022/10/3 22:46
 */


public class BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // fit[i][0]-持有股票；fit[i][1]-冷冻期；fit[i][2]-不持有股票
        int[][] fit = new int[n][3];
        fit[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            fit[i][0] = Math.max(fit[i - 1][0], fit[i - 1][2] - prices[i]);
            fit[i][1] = fit[i - 1][0] + prices[i];
            fit[i][2] = Math.max(fit[i - 1][2], fit[i - 1][1]);
        }
        return Math.max(fit[n - 1][1], fit[n -1][2]);
    }
}
