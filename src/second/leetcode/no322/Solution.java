package second.leetcode.no322;

import java.util.Arrays;

/**
 * @author shijie.qian
 * @date 2024/4/10 23:23
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 定义为凑成金额 i 所需最少的硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
