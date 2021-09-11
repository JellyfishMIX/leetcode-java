package first.leetcode.no647;

/**
 * 647. 回文子串
 * link: https://leetcode-cn.com/problems/palindromic-substrings/
 * dp 解法
 * 题解：https://leetcode-cn.com/problems/palindromic-substrings/solution/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
 *
 * @author JellyfishMIX
 * @date 2021/9/11 20:31
 */
public class SolutionDP {
    public int countSubstrings(String s) {
        // dp[i][j] 表示 [i, j] 是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 回文字串的个数
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
