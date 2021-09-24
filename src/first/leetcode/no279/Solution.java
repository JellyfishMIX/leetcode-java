package first.leetcode.no279;

/**
 * 279. 完全平方数
 * link: https://leetcode-cn.com/problems/perfect-squares/
 * 题解：https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
 *
 * @author JellyfishMIX
 * @date 2021/9/24 14:32
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏情况就是每次都 + 1
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            } 
        }
        return dp[n];
    }
}
