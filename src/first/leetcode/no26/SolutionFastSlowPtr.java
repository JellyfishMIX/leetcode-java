package first.leetcode.no26;

/**
 * 26. 删除有序数组中的重复项
 * link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 题解：快慢指针 -- 老婆牛牛亲自讲解
 *
 * @author JellyfishMIX
 * @date 2021/9/27 18:52
 */
public class SolutionFastSlowPtr {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}
