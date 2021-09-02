package first.leetcode.no53;

/**
 * 53. 最大子序和
 * link: https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author JellyfishMIX
 * @date 2021/9/1 20:37
 */
public class SolutionSecond {
    public int maxSubArray(int[] nums) {
        // dp[i] 定义：以 i 为结尾的字数组最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // base case
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        // 找到最大的
        int maxResult = Integer.MIN_VALUE;
        for (int integer : dp) {
            maxResult = Math.max(maxResult, integer);
        }
        return maxResult;
    }
}
