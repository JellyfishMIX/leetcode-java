package first.leetcode.no309;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * link: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
 *
 * @author JellyfishMIX
 * @date 2021/10/2 17:18
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][3];
        // f[i][0]: 第 i - 1 天，手上持有股票的最大收益
        // f[i][1]: 第 i - 1 天，手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 第 i - 1 天，手上不持有股票，并且不在冷冻期中的累计最大收益
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i - 1]);
            dp[i][1] = dp[i - 1][0] + prices[i - 1];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[prices.length][1], dp[prices.length][2]);
    }
}
