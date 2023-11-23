package second.leetcode.no26;

/**
 * @author shijie.qian
 * @date 2023/11/22 16:29
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        // 不考虑空
        int fast = 0;
        int slow = 0;
        if (nums.length == 1) {
            return 1;
        }
        for (fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
