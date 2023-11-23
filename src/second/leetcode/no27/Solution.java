package second.leetcode.no27;

/**
 * @author shijie.qian
 * @date 2023/11/24 00:49
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        // 不考虑空
        int slow = 0;
        int fast = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
