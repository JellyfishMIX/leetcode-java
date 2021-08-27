package no62;

import java.util.Arrays;

/**
 * 62. 不同路径
 * link: https://leetcode-cn.com/problems/unique-paths/
 *
 * @author JellyfishMIX
 * @date 2021/8/27 10:26
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 填充上边界
        Arrays.fill(dp[0], 1);
        // 填充左边界
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        // dp
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
