package first.leetcode.no121;

/**
 * 121. 买卖股票的最佳时机
 * link: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author JellyfishMIX
 * @date 2021/8/10 18:44
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] > minPrice) {
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }
}
