package first.leetcode.no139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * link: https://leetcode-cn.com/problems/word-break/
 * 题解：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
 *
 * @author JellyfishMIX
 * @date 2021/9/23 15:04
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 使用 Hash 表增加查询效率
        Set<String> wordSet = new HashSet<>(wordDict);
        // dp[i] 表示前 i 个数是否可以被分割为 wordDict 中的单词。i 从 1 开始有效。
        boolean[] dp = new boolean[s.length() + 1];
        // 为了配合运算，dp[0] 初始值置为 true
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
