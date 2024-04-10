package second.leetcode.no53;

/**
 * @author shijie.qian
 * @date 2024/4/11 00:04
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] 表示以 nums[i] 结尾的子数组最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }
}
