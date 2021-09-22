package first.leetcode.no322;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * link: https://leetcode-cn.com/problems/coin-change/submissions/
 * 题解：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 *
 * @author JellyfishMIX
 * @date 2021/9/22 17:01
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示 amount 为 i 所需最少的硬币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        // 如果 dp[amount] == 初始化时的 amount + 1，说明未找到解
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
