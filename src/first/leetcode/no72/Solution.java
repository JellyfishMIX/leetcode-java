package first.leetcode.no72;

/**
 * 72. 编辑距离
 * link: https://leetcode-cn.com/problems/edit-distance/
 * dp 解法
 * 题解：https://mp.weixin.qq.com/s/uWzSvWWI-bWAV3UANBtyOw
 *
 * @author JellyfishMIX
 * @date 2021/9/3 11:52
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int s1Length = word1.length();
        int s2Length = word2.length();

        // dp[i][j] 定义：存储 s1[0...(i - 1)] 和 s2[0...(j - 1)] 的最小编辑距离
        int[][] dp = new int[s1Length + 1][s2Length + 1];
        // base case
        for (int i = 1; i <= s1Length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= s2Length; j++) {
            dp[0][j] = j;
        }
        // dp
        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            // 插入
                            dp[i][j - 1] + 1,
                            // 删除
                            dp[i - 1][j] + 1,
                            // 替换
                            dp[i - 1][j - 1] + 1
                            );
                }
            }
        }
        // 存储着整个 s1 和 s2 的最小编辑距离
        return dp[s1Length][s2Length];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
