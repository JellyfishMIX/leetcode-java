package second.leetcode.lcr103;

import java.util.Arrays;

/**
 * @author shijie.qian
 * @date 2024/4/16 21:38
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑成金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
