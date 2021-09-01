package first.leetcode.no64;

/**
 * 64. 最小路径和
 * link: https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @author JellyfishMIX
 * @date 2021/8/26 13:16
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // 左边和上边都是边界，即起点
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    // 上边是边界
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                    // 左边是边界
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
