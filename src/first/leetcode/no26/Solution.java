package first.leetcode.no26;

/**
 * 26. 删除有序数组中的重复项
 * link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author JellyfishMIX
 * @date 2021/9/27 18:52
 */
public class Solution {
    private int length = 0;

    public int removeDuplicates(int[] nums) {
        this.length = nums.length;
        for (int i = 1; i < length; ) {
            if (nums[i] == nums[i - 1]) {
                remove(nums, i);
            } else {
                i++;
            }
        }
        return length;
    }

    private void remove(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        length--;
    }
}
