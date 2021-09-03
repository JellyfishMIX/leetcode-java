package first.leetcode.no300;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * link: https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 题解：https://mp.weixin.qq.com/s/02o_OPgePjaz3dXnw9TA1w
 *
 * @author JellyfishMIX
 * @date 2021/9/3 15:40
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 以 i 结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 找最大的递增子序列长度
        int maxLength = 1;
        for (int eachLength : dp) {
            maxLength = Math.max(maxLength, eachLength);
        }
        return maxLength;
    }
}
