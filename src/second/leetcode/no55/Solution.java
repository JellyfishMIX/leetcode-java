package second.leetcode.no55;

/**
 * @author shijie.qian
 * @date 2024/4/6 20:49
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // 不考虑 null 入参
        int maxJumpIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJumpIndex) {
                return false;
            }
            maxJumpIndex = Math.max(maxJumpIndex, i + nums[i]);
        }
        return true;
    }
}
