package second.leetcode.no283;

/**
 * @author shijie.qian
 * @date 2023/11/24 18:34
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        // 不考虑空
        int fast = 0;
        int slow = 0;

        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }
}
