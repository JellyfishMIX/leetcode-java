package second.leetcode.no338;

/**
 * @author shijie.qian
 * @date 2024/4/11 00:16
 */
public class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 偶数 dp = 1/2 偶数 1 的个数
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                // 奇数 dp = 上一个偶数 1 的个数 + 1
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
