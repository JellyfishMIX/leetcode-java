package no55;

/**
 * 55. 跳跃游戏
 * link: https://leetcode-cn.com/problems/jump-game/
 *
 * @author JellyfishMIX
 * @date 2021/8/25 14:48
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // 当前最远能跳达的位置
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) {
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return true;
    }
}
