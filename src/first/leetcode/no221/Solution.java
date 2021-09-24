package first.leetcode.no221;

/**
 * 221. 最大正方形
 * link: https://leetcode-cn.com/problems/maximal-square/
 * 题解：https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
 *
 * @author JellyfishMIX
 * @date 2021/9/24 21:44
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int weight = matrix[0].length;
        int height = matrix.length;
        // dp[i + 1][j + 1] 定义为以 [i][j] 为右下角的正方形的最大边长
        int[][] dp = new int[height + 1][weight + 1];
        int maxSideLength = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = min(dp[i][j], dp[i + 1][j], dp[i][j + 1]) + 1;

                    maxSideLength = Math.max(maxSideLength, dp[i + 1][j + 1]);
                }
            }
        }
        // 最大面积 = 最大边长 * 最大边长
        return maxSideLength * maxSideLength;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
