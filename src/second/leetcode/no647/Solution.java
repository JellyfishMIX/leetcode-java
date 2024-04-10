package second.leetcode.no647;

/**
 * @author shijie.qian
 * @date 2024/4/7 18:52
 */
public class Solution {
    public int countSubstrings(String s) {
        // 表示 [i, j] 是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 回文串的个数
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
