package first.codinginterviews2.no95;

import java.util.Arrays;

/**
 * 剑指 Offer II 095. 最长公共子序列
 * link: https://leetcode-cn.com/problems/qJnOS7/
 * dp 解法
 * 题解：https://mp.weixin.qq.com/s/SUJ35XDpTn5OKU7hud-tPw
 *
 * @author JellyfishMIX
 * @date 2021/9/4 00:54
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int s1Length = text1.length();
        int s2Length = text2.length();
        // dp[i][j] 表示 s1 [0, i - 1] 和 s2 [0, j - 1] 的最长公共子序列
        int[][] dp = new int[s1Length + 1][s2Length + 1];
        // base case
        Arrays.fill(dp[0], 0);
        for (int i = 0; i <= s1Length; i++) {
            dp[i][0] = 0;
        }
        // 迭代求 dp
        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                // 找到一个公共子序列的元素
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 返回 s1 [0, s1Length - 1] 和 s2 [0, s2Length - 1] 的最长公共子序列
        return dp[s1Length][s2Length];
    }
}
