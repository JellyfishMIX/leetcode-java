package first.no136;

/**
 * 136. 只出现一次的数字
 * link: https://leetcode-cn.com/problems/single-number/
 *
 * @author JellyfishMIX
 * @date 2021/8/28 00:49
 */
public class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
