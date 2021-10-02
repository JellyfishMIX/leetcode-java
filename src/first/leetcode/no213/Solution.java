package first.leetcode.no213;

/**
 * 213. 打家劫舍 II
 * link: https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author JellyfishMIX
 * @date 2021/10/1 11:12
 */
public class Solution {
    public int rob(int[] nums) {
        // 特殊判断
        if (nums.length == 1) {
            return nums[0];
        }
        int result;
        result = Math.max(calculateDp(nums, 2, nums.length - 1),
                calculateDp(nums, 3, nums.length));
        return result;
    }

    private int calculateDp(int[] nums, int start, int end) {
        // 表示前 i 家的收益
        int[] dp = new int[end + 1];
        dp[0] = 0;
        if (start == 2) {
            dp[1] = nums[0];
        } else {
            dp[2] = nums[1];
        }
        for (int i = start; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[end];
    }
}
