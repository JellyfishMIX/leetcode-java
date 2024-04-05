package second.leetcode.no64;

/**
 * @author shijie.qian
 * @date 2024/4/6 02:40
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 第一行
                if (i == 1) {
                    dp[i][j] = grid[i - 1][j - 1] + dp[i][j - 1];
                }
                // 第一列
                else if (j == 1) {
                    dp[i][j] = grid[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
