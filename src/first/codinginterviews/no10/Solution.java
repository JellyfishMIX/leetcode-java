package first.codinginterviews.no10;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * link: https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * dp 解法
 * 题解：https://mp.weixin.qq.com/s/Cw39C9MY9Wr2JlcvBQZMcA
 *
 * @author JellyfishMIX
 * @date 2021/9/1 15:22
 */
public class Solution {
    public int fib(int n) {
        // 特判
        if (n == 0) {
            return 0;
        }
        // 初始化 dp[]
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 迭代求 dp，每次迭代是一个子问题
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
