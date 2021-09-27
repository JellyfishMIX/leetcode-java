package first.leetcode.no26;

/**
 * 26. 删除有序数组中的重复项
 * link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 题解：老婆牛牛
 *
 * @author JellyfishMIX
 * @date 2021/9/27 18:52
 */
public class SolutionFastSlowPtr {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }
}
