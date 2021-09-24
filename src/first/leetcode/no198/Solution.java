package first.leetcode.no198;

/**
 * 198. 打家劫舍
 * link: https://leetcode-cn.com/problems/house-robber/
 * 题解：https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
 *
 * @author JellyfishMIX
 * @date 2021/9/24 23:27
 */
public class Solution {
    public int rob(int[] nums) {
        // dp[i] 定义：前 i 个房子最大收益，i 从 1 开始有效
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[nums.length];
    }
}
