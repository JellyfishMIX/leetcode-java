package first.codinginterviews2;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer II 103. 最少的硬币数目
 * link: https://leetcode-cn.com/problems/gaM7Ch/
 * dp 解法
 * 题解：https://mp.weixin.qq.com/s/Cw39C9MY9Wr2JlcvBQZMcA
 *
 * @author JellyfishMIX
 * @date 2021/9/1 14:50
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示金额为 i 的时候，最少需要几枚硬币
        int[] dp = new int[amount + 1];
        // 初始化 dp[i] 中均为无穷大
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 迭代求 dp，每次迭代是一个子问题
        for (int i = 1; i < dp.length; i++) {
            // 内层求当前子问题 dp[i] 的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    @Test
    public void test() {
        int minCoinNum = coinChange(new int[]{2}, 3);
        System.out.println(minCoinNum);
    }
}
