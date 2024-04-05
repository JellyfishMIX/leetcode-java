package second.leetcode.no121;

/**
 * @author shijie.qian
 * @date 2024/4/5 12:25
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // 不考虑空入参
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            } else {
                maxProfit = Math.max(maxProfit, currentPrice - minPrice);
            }
        }
        return maxProfit;
    }
}
